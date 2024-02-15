package ci.doci.colis.controller;

import ci.doci.colis.domaine.Role;
import ci.doci.colis.domaine.User;
import ci.doci.colis.repository.RoleRepository;
import ci.doci.colis.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@Slf4j
@RequestMapping("/admin")
public class RoleController {

    private final RoleService roleService;
    private final RoleRepository roleRepository;


    public RoleController(RoleService roleService, RoleRepository roleRepository) {
        this.roleService = roleService;
        this.roleRepository = roleRepository;

    }

    @GetMapping("/newRole")
    public String newRole(Model model) {
        model.addAttribute("role", new Role());
        return "roleform";
    }

    @PostMapping("/newRole")
    public String newRole(@ModelAttribute("role") Role role) {
        Role roleSaved = roleService.createRole(role);
        return "redirect:/admin/roles";
    }

    @PostMapping("/updateRole")
    public String updateRole(@RequestParam("identifiant") String id,
                             @RequestParam("nom") String nom,
                             @RequestParam("description") String description) {
        Role role = roleService.findById(Long.parseLong(id));
        role.setName(nom);
        role.setDescription(description);
        roleService.createRole(role);
        return "redirect:/admin/roles";
    }

    @GetMapping("/roles")
    public String getRoles(Model model) {
        model.addAttribute("roles", roleService.findAllRoles());
        return "roles";
    }

    @GetMapping("/role/{id}")
    public String getRole(@PathVariable String id, Model model) {
        Role role = roleService.findById(Long.parseLong(id));
        model.addAttribute("role", role);
        return "roledetails";
    }

    @GetMapping("/role/{id}/delete")
    public String delete(@PathVariable String id, @AuthenticationPrincipal User user) {
        roleRepository.deleteById(Long.parseLong(id));
        return "redirect:/admin/roles";
    }
}
