package br.com.alura.dojoadopt.tutor;

import br.com.alura.dojoadopt.pet.PetRepository;
import br.com.alura.dojoadopt.pet.PetView;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TutorController {

    private final TutorRepository tutorRepository;
    private final TutorNewFormValidator tutorNewFormValidator;
    private final PetRepository petRepository;

    public TutorController(TutorRepository tutorRepository, TutorNewFormValidator tutorNewFormValidator, PetRepository petRepository) {
        this.tutorRepository = tutorRepository;
        this.tutorNewFormValidator = tutorNewFormValidator;
        this.petRepository = petRepository;
    }

    @InitBinder("tutorNewForm")
    void initBinderTutorForm(WebDataBinder webDataBinder){
        webDataBinder.addValidators(tutorNewFormValidator);
    }

    @GetMapping("/list/tutors")
    String read(Model model) {
        List<TutorView> tutors = tutorRepository.findAll().stream().map(TutorView::new).toList();

        model.addAttribute("tutors", tutors);
        return "/tutor/list";
    }

    @GetMapping("/create/tutor/form")
    String createTutorForm(TutorNewForm tutorNewForm, Model model) {
        model.addAttribute("typesOfHousing", TypeofHousing.values());
        return "/tutor/newForm";
    }

    @PostMapping("/create/tutor")
    String create(@Valid TutorNewForm tutorNewForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return createTutorForm(tutorNewForm, model);
        }
        tutorRepository.save(tutorNewForm.toModel());

        return "redirect:/list/tutors";
    }

    @GetMapping("tutor/detalhes")
    String detalhes() {

    }

    @GetMapping("/tutor/{tutorId}/profile")
    String profile(@PathVariable Long tutorId, Model model) {
        Tutor tutor = tutorRepository.findById(tutorId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

        TutorProfileView tutorProfileView = new TutorProfileView(tutor);

        List<PetView> pets = petRepository.findAllByAdoptedIsTrue().stream().map(PetView::new).toList();

        model.addAttribute("tutorProfile", tutorProfileView);
        model.addAttribute("pets", pets);
        return "/tutor/profile";
    }
}
