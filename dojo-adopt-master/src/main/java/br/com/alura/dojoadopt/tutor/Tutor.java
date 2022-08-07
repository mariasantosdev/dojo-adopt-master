package br.com.alura.dojoadopt.tutor;

import br.com.alura.dojoadopt.pet.Pet;
import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static javax.persistence.EnumType.STRING;

@Entity
public class Tutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 100)
    @NotBlank
    private String name;

    @NotBlank
    @CPF
    @Column(unique = true)
    private String cpf;

    @PastOrPresent
    @NotNull
    private LocalDate birthDate;

    @Positive
    @NotNull
    private BigDecimal remuneration;

    @Enumerated(STRING)
    private TypeofHousing typeofHousing;

    @URL
    @NotBlank
    private String photoUrl;

    @OneToMany
    private List<Pet> pets = new ArrayList<>();

    @Deprecated
    public Tutor(){}

    public Tutor(String name, String cpf, LocalDate birthDate, BigDecimal remuneration,String photoUrl, TypeofHousing typeofHousing) {
        this.name = name;
        this.cpf = cpf;
        this.photoUrl = photoUrl;
        this.birthDate = birthDate;
        this.remuneration = remuneration;
        this.typeofHousing = typeofHousing;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean canSupportAPet(Pet pet) {
        return this.remuneration.subtract(pet.getMonthlyCost()).compareTo(pet.getMonthlyCost()) >= 0;
    }
}
