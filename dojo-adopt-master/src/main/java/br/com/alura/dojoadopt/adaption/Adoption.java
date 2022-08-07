package br.com.alura.dojoadopt.adaption;

import br.com.alura.dojoadopt.pet.Pet;
import br.com.alura.dojoadopt.tutor.Tutor;
import org.joda.time.DateTime;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import static javax.persistence.GenerationType.IDENTITY;

@Entity
public class Adoption {
    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;
    private DateTime adoptionDate;
    @NotNull
    @OneToOne
    private Pet pet;
    @NotNull
    @ManyToOne
    private Tutor tutor;

    @Deprecated
    protected Adoption() {}

    public Adoption(DateTime date, Pet pet, Tutor tutor) {
        this.pet = pet;
        this.tutor = tutor;
    }
}
