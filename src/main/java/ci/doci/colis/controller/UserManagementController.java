package ci.doci.colis.controller;


import ci.doci.colis.domaine.*;
import ci.doci.colis.repository.*;
import ci.doci.colis.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Controller
@Slf4j
@RequestMapping("/admin")
public class UserManagementController {

    private final CustomUserDetailsService userDetailsService;
    private final RoleService roleService;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final UserRepository userRepository;
//    private final PompeRepository agenceRepository;
    private final UtilisateurService utilisateurService;
    private final InterimRepository interimRepository;
    private final AgenceRepository agenceRepository;



    @Autowired
    HttpServletRequest request;

    @Autowired
    public UserManagementController(CustomUserDetailsService userDetailsService,
                                    RoleService roleService, PasswordEncoder passwordEncoder, UserService userService, UserRepository userRepository, UtilisateurService utilisateurService, InterimRepository interimRepository,AgenceRepository agenceRepository) {
        this.userDetailsService = userDetailsService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.userRepository = userRepository;
        this.utilisateurService = utilisateurService;
        this.interimRepository = interimRepository;
        this.agenceRepository = agenceRepository;


    }


    @GetMapping("/newuser")
    public String adminUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("agenceList", agenceRepository.findAll());
        model.addAttribute("roles", roleService.findAllRoles());
        return "userform";
    }

    @PostMapping("/newuser")
    public String createUser(@ModelAttribute("user") User user, Model model) {
        if(userRepository.findByLogin(user.getLogin()).isPresent()){
            model.addAttribute("message", "Un utilisateur existe déjà avec ce login");
            return "errors";
        }
        user.setPassword(passwordEncoder.encode("123456"));
        user.setFirstConnection(true);
        userService.createUser(user);


        return "redirect:/admin/users";
    }

    @GetMapping("/users")
    public String getAllUsers(Model model,
                              @AuthenticationPrincipal User user) {
        /*List<Role> roles = user.getRoles();
        Role role_chefcaisse = roleService.findByName("ROLE_CHEFCAISSE");
        Role role_caissier = roleService.findByName("ROLE_CAISSIER");
        Role role_ra = roleService.findByName("ROLE_RA");
        if (roles.contains(role_ra)) {
            List<User> users = userRepository.findByRoles(role_ra);
            model.addAttribute("users", users);
            model.addAttribute("role",role_ra);
        }if(roles.contains(role_caissier)) {
            List<User> users = userRepository.findByRoles(role_caissier);
            model.addAttribute("users", users);
            model.addAttribute("role",role_caissier);
        }
        else {*/
            Set<User> users = userService.getUsers();
            model.addAttribute("users", users);
        //}
        return "users";
    }
   /* @GetMapping("/user/{id}/reset-password")
    public String resetPassword(@PathVariable("id") long id, Model model){
      *//*
        1- Verifier l'existance de l'utilisateur
        2-Reset le mot de passe en lui attribuant un nouveau
        3- Flaguer le champ firstconnexion dans la table user
       *//*

        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()){
            User user1 = user.get();
            user1.setPassword(passwordEncoder.encode(user1.getLogin()+ "@"+ LocalDate.now().getYear()+"!"));
            user1.setFirstConnection(true);
            user1.setOldPassword("");
            userRepository.save(user1);
            String message= "Bonjour " + user1.getUsername() + " Merci de bien vouloir vous connecter sur le lien suivant: https://doci.schiba-holding.com"  +
                    " Login : " + user1.getLogin()  + " Password:  " + user1.getLogin()+ "@"+ LocalDate.now().getYear()+ "!";
            EmailDetails mail = new EmailDetails(user1.getEmail(),message,"PARAMETRES DE CONNEXIONS",null);
            emailService.sendSimpleMail(mail);
            model.addAttribute("succesMessage", "Le mot de passe a été renitialisé avec succes");
            Set<User> users = userService.getUsers();
            model.addAttribute("users", users);
            return "users";

        }else {
            return "users";
        }
    }*/

    @GetMapping("/user/{id}")
    public String userAdminDetail(Model model, @PathVariable String id) {
        User user = userRepository.findById(Long.parseLong(id)).orElse(null);
        model.addAttribute("user", user);
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("agences", agenceRepository.findAll());
        return "userdetails";
    }


    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Errors errors, @AuthenticationPrincipal User userAppli,Model model,
                           RedirectAttributes redirectAttributes) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userConnecte = (User) authentication.getPrincipal();

        if(userRepository.findByLogin(user.getLogin()).get() != null){
            model.addAttribute("message", "Un utilisateur existe déjà avec ce login");
            return "errors";
        }

        log.info("Debut méthode enregistrement d'un utilisateur");
        log.info("Machine connectée : " + request.getRemoteAddr());
        log.info("Utilisateur connecté : " + userConnecte.getUsername());


        if (errors.hasErrors()) {
            redirectAttributes.addFlashAttribute("errorFlash", "Echec de création de l'utilisateur");
            return "admin/newuser";
        }
        user.setPassword(user.getPassword());
        user.setActivated(true);
        user.setFirstConnection(true);

        userDetailsService.register(user);

        log.info("Fin création d'un utilisateur");
        log.info("Machine connectée : " + request.getRemoteAddr());
        log.info("Utilisateur connecté : " + userConnecte.getUsername());


        redirectAttributes.addFlashAttribute("successFlash", "Utilisateur crée avec succès");

        return "redirect:/admin/users";
    }


    @PostMapping("/updateuser")
    public String update(@RequestParam("id") String id,
                         @RequestParam("login") String login,
                         @RequestParam("username") String username,
                         @RequestParam("email")  String email,
                         @RequestParam("contact") String contact,
                         @RequestParam("roles") List<String> roles,
                         @RequestParam("site") String site,
                         @ModelAttribute("user") User us, Errors errors, @AuthenticationPrincipal User userAppli) {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User userConnecte = (User) authentication.getPrincipal();

        User user = userService.findById(Long.parseLong(id));

        log.info("Méthode modification d'un utilisateur");
        log.info("Machine connectée : " + request.getRemoteAddr());
        log.info("Utilisateur connecté : " + userConnecte.getUsername());


        user.setLogin(login);
        user.setUsername(username);
        user.setLogin(login);
        user.setUsername(username);
        user.setEmail(email);
        user.setContact(contact);

        List<Role> userRole = new ArrayList<>();
        roles.forEach(roleName -> {
            userRole.add(roleService.getRoleByName(roleName));
        });
        user.setRoles(userRole);
        user.setAgence(us.getAgence());
        userService.createUser(user);

        log.info("Fin méthode modification d'un utilisateur");
        log.info("Machine connectée : " + request.getRemoteAddr());
        log.info("Utilisateur connecté : " + userConnecte.getUsername());

        return "redirect:/admin/users";
    }




    @RequestMapping(path = "/update", method = RequestMethod.POST)
    public String updateTaskWithModal(@ModelAttribute("user") User user) {
        utilisateurService.update(user.getId(), user);
        return "redirect:/admin/users";
    }

    @GetMapping("/user/{id}/delete")
    public String deleteUser(@PathVariable Long id, @AuthenticationPrincipal User user) {
        log.debug("request to delete user : {}", id);

        userService.deleteUser(id);
        return "redirect:/admin/users";
    }


    //*************************** GESTION D'INTERIM*********************************
    @GetMapping("/interim")
    public  String interim(@AuthenticationPrincipal User user){
        return "redirect:/admin/newuserInterim";
    }

    @GetMapping("/newuserInterim")
    public String adminUserInterim(Model model, @AuthenticationPrincipal User user) {
        model.addAttribute("user", new User());
       // model.addAttribute("agenceList", agenceRepository.findAll());
        model.addAttribute("roles", roleService.findAllRoles());
        model.addAttribute("connecte", user);
        return "userform-interim";
    }

    @PostMapping("/newuserInterim")
    public String createUserInterim(@ModelAttribute("user") User user,
                                    @RequestParam("password") String password,
                                    @RequestParam("dateDebut") String dateDebut,
                                    @RequestParam("dateFin") String dateFin,
                                    @AuthenticationPrincipal User use) {
        user.setPassword(passwordEncoder.encode(password));
        List<Role> roles = use.getRoles();
        //List<Role> roleList = use.getRoles().get();
        user.setAgence(use.getAgence());
        user.setRoles(use.getRoles());
        user.setActivated(true);
        userRepository.save(use);
        Interim interim = new Interim();
        interim.setInterimaire(user.getUsername());
        interim.setTitulaire(use.getUsername());
        interim.setDebut(dateDebut);
        interim.setFin(dateFin);
        interimRepository.save(interim);
        use.setActivated(false);
        use.setRoles(user.getRoles());
        userService.createUser(user);


        return "redirect:/home";
    }



}
