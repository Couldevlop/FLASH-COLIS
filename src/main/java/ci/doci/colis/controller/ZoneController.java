package ci.doci.colis.controller;

import ci.doci.colis.domaine.User;
import ci.doci.colis.domaine.Zone;
//import ci.doci.sygescom.repository.PompeRepository;
import ci.doci.colis.repository.ZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/admin")
public class ZoneController {
    @Autowired
    private ZoneRepository zoneRepository;


    @RequestMapping("/zone")
    public String getAllZone(Model model){
        model.addAttribute("zones", zoneRepository.findAll());
        return "zones";
    }

    @GetMapping("/newzone")
    public String createZone(Model model){
        model.addAttribute("Zone", new Zone());
        return "zoneform";
    }

    @PostMapping("/newzone")
    public String newZoneAgence(@ModelAttribute("Zone") Zone zone, Errors errors, @AuthenticationPrincipal User user){
        if(null!= errors && errors.getErrorCount()>0) {
            return "zoneform";
        }else{
          //  List<Agences> agences = zone.getAgences();

            zone.setCreateBy(user.getUsername());
           // zone.setAgences(agences);
            zoneRepository.save(zone);

            return "redirect:/admin/zone";
        }

    }

    @GetMapping("/zone-details/{id}")
    public String voirZone(Model model, @PathVariable String id) {
        Zone  zone = zoneRepository.findById(Long.parseLong(id)).orElse(null);
        model.addAttribute("zone", zone);
        return "zone-details";
    }

    @PostMapping("/updatezone")
    public String updateZone(@RequestParam("nomZone") String nomZone,
                             @RequestParam("id") String id, Model model,
                             @AuthenticationPrincipal User user){
        Zone zone = zoneRepository.findById(Long.parseLong(id)).orElse(null);
        zone.setNom(nomZone);
        zoneRepository.save(zone);
        model.addAttribute("zone", zone);

        return "redirect:/admin/zone";
    }

    @GetMapping("/zone/{id}/delete" )
    public String deleteZone(@PathVariable("id") String id, @AuthenticationPrincipal User user){
        zoneRepository.deleteById(Long.parseLong(id));

        return "redirect:/admin/zone";
    }


}
