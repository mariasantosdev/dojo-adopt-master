package br.com.alura.dojoadopt.pet;

import org.hibernate.validator.constraints.URL;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class PetNewForm {
    @NotBlank(message = "O nome não pode ser nulo ou vazio")
    @Size(max = 50)
    private String name;
    @Min(10)
    private BigDecimal monthlyCost;
    @PastOrPresent
    private LocalDate birthDate;
    @NotNull
    private SizeOfAnimal size;
    @NotNull
    private Type type;
    @URL
    @NotBlank
    private String photoUrl;

    public PetNewForm(String name, BigDecimal monthlyCost, LocalDate birthDate, SizeOfAnimal size, Type type,
                      String photoUrl) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.birthDate = birthDate;
        this.size = size;
        this.type = type;
        this.photoUrl = photoUrl;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getMonthlyCost() {
        return monthlyCost;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public SizeOfAnimal getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonthlyCost(BigDecimal monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setSize(SizeOfAnimal size) {
        this.size = size;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public Pet toModel() {
        return new Pet(name, monthlyCost, birthDate,size, type, photoUrl);
    }
}
