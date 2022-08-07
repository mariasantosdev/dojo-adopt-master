package br.com.alura.dojoadopt.pet;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class PetNewFormValidator implements Validator {
    private final PetRepository petRepository;

    public PetNewFormValidator(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return PetNewForm.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object target, Errors errors) {
        PetNewForm petNewForm = (PetNewForm) target;

        if (petRepository.existsByNameAndType(petNewForm.getName(), petNewForm.getType())) {
            errors.reject("petNewForm.name.and.type.already.exists",
                    "Os animais devem ser unicos baseado na composição de nome e tipo");
        }
    }
}
