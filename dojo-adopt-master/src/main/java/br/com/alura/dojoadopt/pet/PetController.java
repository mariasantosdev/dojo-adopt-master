package br.com.alura.dojoadopt.pet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class PetController {

    private final PetRepository petRepository;
    private final PetNewFormValidator petNewFormValidator;

    public PetController(PetRepository petRepository, PetNewFormValidator petNewFormValidator) {
        this.petRepository = petRepository;
        this.petNewFormValidator = petNewFormValidator;
    }

    @InitBinder("petNewForm")
    void initBinderCategoryForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(petNewFormValidator);
    }

    @GetMapping("/list/pets")
    //TODO fazer um link ja jsp newform para o perfil do tutor
    //TODO trocar o nome da jsp
    String read(Model model) {
        List<PetView> pets = petRepository.findAllByAdoptedIsTrue().stream().map(PetView::new).toList();

        model.addAttribute("pets", pets);
        return "/pet/list";
    }

    @GetMapping("/create/pet/form")
    String createPetForm(PetNewForm petNewForm, Model model) {
        model.addAttribute("types",Type.values());
        model.addAttribute("sizes", SizeOfAnimal.values());
        return "/pet/newForm";
    }

    @PostMapping("/create/pet")
    String create(@Valid PetNewForm petNewForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createPetForm(petNewForm, model);
        }
        petRepository.save(petNewForm.toModel());

        return "redirect:/list/pets";
    }
}
