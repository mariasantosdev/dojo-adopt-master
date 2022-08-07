package br.com.alura.dojoadopt.adaption;

import br.com.alura.dojoadopt.pet.Pet;
import br.com.alura.dojoadopt.pet.PetRepository;
import br.com.alura.dojoadopt.tutor.Tutor;
import br.com.alura.dojoadopt.tutor.TutorRepository;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Controller
public class AdoptionController {
    private final PetRepository petRepository;
    private final TutorRepository tutorRepository;
    private final AdoptionRepository adoptionRepository;

    public AdoptionController(PetRepository petRepository, TutorRepository tutorRepository, AdoptionRepository adoptionRepository) {
        this.petRepository = petRepository;
        this.tutorRepository = tutorRepository;
        this.adoptionRepository = adoptionRepository;
    }

    @PostMapping("/create/adoption")
    @Transactional
    //TODO mensagens de sucesso e erro não estao funcionando
    //TODO setar o animal como adotado
    String newAdoption(AdoptionNewForm adoptionNewForm, RedirectAttributes redirectAttributes) {
        Pet pet = petRepository.findById(adoptionNewForm.getPetId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        Tutor tutor = tutorRepository.findById(adoptionNewForm.getTutorId())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND));

        if(!tutor.canSupportAPet(pet)) {
            redirectAttributes.addFlashAttribute("fail",
                    "Não foi possível adotar por conta da renda ser baixa");
            return "redirect:list/pets";
        }

        pet.updateThePetToNonAdoptable();
        adoptionRepository.save(adoptionNewForm.toModel(pet, tutor));
        redirectAttributes.addFlashAttribute("sucess","Animal adotado com sucesso!");
        return "redirect:/tutor/detalhes";
    }
}
