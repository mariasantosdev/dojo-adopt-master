package br.com.alura.dojoadopt.adaption;

import br.com.alura.dojoadopt.pet.Pet;
import br.com.alura.dojoadopt.tutor.Tutor;
import org.joda.time.DateTime;

import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotNull;

public class AdoptionNewForm {
    @NotNull
    private Long petId;
    @NotNull
    private Long tutorId;

    @FutureOrPresent
    private DateTime date = DateTime.now();
    public Long getPetId() {
        return petId;
    }

    public void setPetId(Long petId) {
        this.petId = petId;
    }

    public Long getTutorId() {
        return tutorId;
    }

    public void setTutorId(Long tutorId) {
        this.tutorId = tutorId;
    }

    public DateTime getDate() {
        return date;
    }

    public void setDate(DateTime date) {
        this.date = date;
    }

    public Adoption toModel(Pet pet, Tutor tutor) {
        return new Adoption(this.date,pet,tutor);
    }
}
