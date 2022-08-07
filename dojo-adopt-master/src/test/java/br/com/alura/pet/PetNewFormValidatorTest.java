package br.com.alura.pet;

import br.com.alura.dojoadopt.pet.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.mockito.Mockito.*;
import org.springframework.validation.Errors;

public class PetNewFormValidatorTest {

    private PetRepository petRepository;
    private PetNewFormValidator petNewFormValidator;
    private Errors errors;

    @BeforeEach
    void setUp() {
        petRepository = mock(PetRepository.class);
        petNewFormValidator = new PetNewFormValidator(petRepository);
        errors = mock(Errors.class);
    }

    @Test
    void should_reject_when_already_exists_a_pet_with_the_same_name_and_type() {
        when(petRepository.existsByNameAndType("Brida", Type.DOG)).thenReturn(true);

        var form = new PetNewForm("Brida",new BigDecimal("10.00"), LocalDate.now(), SizeOfAnimal.SMALL,
                Type.DOG,"https://www.google.com/search?q=poodle+url&client=ubuntu&channel=fs&sxsrf=APq-WBs5hUHtH5-50W8eQ-kkC4LG872tEA:1646851315067&tbm=isch&source=iu&ictx=1&vet=1&fir=oELskyl6x56jNM%252C4sFsZtQuqYbyDM%252C_%253Bg8qkmkO--nefmM%252CGg4cNcsZ9H44XM%252C_%253B4nlM_D8Tfmfu8M%252COKuh7rhqOR4ZMM%252C_%253Bzv6ZIbtEO_nWYM%252CGg4cNcsZ9H44XM%252C_%253BdMM1hZ7-bOGyWM%252CrIpZiZNEa2AMJM%252C_%253B7XRw3PeraIYDhM%252C4sFsZtQuqYbyDM%252C_%253BX7-PEL3ayIyk-M%252CHtPwEgz0tzlUDM%252C_%253BqZbTlc25G3GtyM%252COKuh7rhqOR4ZMM%252C_%253Bcn6Vob18jT7WnM%252COKuh7rhqOR4ZMM%252C_%253BOkCzdehat6zXwM%252C4sFsZtQuqYbyDM%252C_&usg=AI4_-kTzZeKasEuIMTra3Va57OvaF2KOiw&sa=X&ved=2ahUKEwj4nIed17n2AhWcppUCHbgcD7sQ9QF6BAgOEAE#imgrc=4nlM_D8Tfmfu8M");

        petNewFormValidator.validate(form,errors);

        verify(errors).reject("petNewForm.name.and.type.already.exists",
                "Os animais devem ser unicos baseado na composição de nome e tipo");
    }

    @Test
    void should_not_reject_when_an_animal_does_not_exist_with_the_same_name_and_type() {
        when(petRepository.existsByNameAndType("Brida", Type.DOG)).thenReturn(false);

        var form = new PetNewForm("Brida",new BigDecimal("10.00"), LocalDate.now(), SizeOfAnimal.SMALL,
                Type.DOG,"https://www.google.com/search?q=poodle+url&client=ubuntu&channel=fs&sxsrf=APq-WBs5hUHtH5-50W8eQ-kkC4LG872tEA:1646851315067&tbm=isch&source=iu&ictx=1&vet=1&fir=oELskyl6x56jNM%252C4sFsZtQuqYbyDM%252C_%253Bg8qkmkO--nefmM%252CGg4cNcsZ9H44XM%252C_%253B4nlM_D8Tfmfu8M%252COKuh7rhqOR4ZMM%252C_%253Bzv6ZIbtEO_nWYM%252CGg4cNcsZ9H44XM%252C_%253BdMM1hZ7-bOGyWM%252CrIpZiZNEa2AMJM%252C_%253B7XRw3PeraIYDhM%252C4sFsZtQuqYbyDM%252C_%253BX7-PEL3ayIyk-M%252CHtPwEgz0tzlUDM%252C_%253BqZbTlc25G3GtyM%252COKuh7rhqOR4ZMM%252C_%253Bcn6Vob18jT7WnM%252COKuh7rhqOR4ZMM%252C_%253BOkCzdehat6zXwM%252C4sFsZtQuqYbyDM%252C_&usg=AI4_-kTzZeKasEuIMTra3Va57OvaF2KOiw&sa=X&ved=2ahUKEwj4nIed17n2AhWcppUCHbgcD7sQ9QF6BAgOEAE#imgrc=4nlM_D8Tfmfu8M");

        petNewFormValidator.validate(form,errors);

        verify(errors, never()).rejectValue(anyString(), anyString());
    }
}
