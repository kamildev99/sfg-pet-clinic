package kd.springframework.sfgpetclinic.controllers;


import kd.springframework.sfgpetclinic.model.Pet;
import kd.springframework.sfgpetclinic.model.Visit;
import kd.springframework.sfgpetclinic.repositories.PetRepository;
import kd.springframework.sfgpetclinic.repositories.VisitRepository;
import kd.springframework.sfgpetclinic.services.PetService;
import kd.springframework.sfgpetclinic.services.VisitService;
import org.springframework.aot.generate.GeneratedTypeReference;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
public class VisitController {

    private final VisitService visitService;
    private final PetService petService;

    public VisitController(VisitService visitService, PetService petService) {
        this.visitService = visitService;
        this.petService = petService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder){
        dataBinder.setDisallowedFields("id");
    }


    @ModelAttribute("visit")
    public Visit loadPetWithVisit(@PathVariable("petId")  Long petId, Map<String, Object> model){
        Pet pet = petService.findById(petId);
        model.put("pet", pet);
        Visit visit = new Visit();
        pet.getVisits().add(visit);
        visit.setPet(pet);

        return visit;
    }

    @GetMapping("/owners/*/pets/{petId}/visits/new")
    public String initNewVisitForm(@PathVariable Long petId, Model model){
        return "pets/createOrUpdateVisitForm";
    }


    @PostMapping("/owners/{ownerId}/pets/{petId}/visits/new")
    public String processNewVisitForm(Visit visit, BindingResult result){
        if(result.hasErrors()){
            return "pets/createOrUpdateVisitForm";
        } else {
            visitService.save(visit);
            return "redirect:/owners/{ownerId}";
        }
    }
}
