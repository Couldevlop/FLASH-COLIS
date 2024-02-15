package ci.doci.colis.controller;

import ci.doci.colis.domaine.Agence;
import ci.doci.colis.domaine.dto.AgenceDto;
import ci.doci.colis.service.AgenceService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/admin")
public class AgenceController {
    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping("/save-agence")
    public String saveAgence(@ModelAttribute AgenceDto dto, RedirectAttributes redirectAttributes){
        AgenceDto agence = agenceService.saveAgence(dto);
        return "redirect:/listAgence";
    }

    @GetMapping("/newagence")
    public String showAgenceForm(Model model){
        model.addAttribute("Agence", new Agence());
        model.addAttribute("agenceList", agenceService.getAllAgence());
        return "agenceForm";
    }


    @GetMapping
    public String listAgence(Model model){
        model.addAttribute("agenceList", agenceService.getAllAgence());
        return "newagence";
    }
}
