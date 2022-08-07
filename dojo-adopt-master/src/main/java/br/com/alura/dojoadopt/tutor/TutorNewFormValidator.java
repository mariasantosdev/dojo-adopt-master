package br.com.alura.dojoadopt.tutor;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class TutorNewFormValidator implements Validator {

    public final TutorRepository tutorRepository;

    public TutorNewFormValidator(TutorRepository tutorRepository) {
        this.tutorRepository = tutorRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return TutorNewForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        TutorNewForm tutorNewForm = (TutorNewForm) target;

        if (tutorRepository.existsByCpf(tutorNewForm.getCpf())) {
            errors.reject("tutorNewForm.cpf.already.exists",
                    "Já existe um tutor cadastrado com esse cpf");
        }
    }
}
