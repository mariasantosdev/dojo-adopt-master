package br.com.alura.dojoadopt.pet;

import br.com.alura.dojoadopt.utils.DateUtils;
import org.hibernate.validator.constraints.URL;
import org.joda.time.DateTime;
import org.springframework.lang.Nullable;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
public class Pet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Size(max = 50)
    private String name;

    @Min(10)
    private BigDecimal monthlyCost;

    @PastOrPresent
    @NotNull
    private LocalDate birthDate;

    @NotNull
//    @Enumerated(STRING)
    private SizeOfAnimal size;

    @NotNull
    //TODO Arrumar esse problema para que esteja certinho com string
//    @Enumerated(STRING)
    private Type type;

    @URL
    @NotBlank
    private String photoUrl;

    private boolean adopted = true;

    @Deprecated
    public Pet() {}

    public Pet(String name, BigDecimal monthlyCost, LocalDate birthDate, SizeOfAnimal size, Type type,
               String photoUrl) {
        this.name = name;
        this.monthlyCost = monthlyCost;
        this.birthDate = birthDate;
        this.size = size;
        this.type = type;
        this.photoUrl = photoUrl;
    }

    public void updateThePetToNonAdoptable() {
        this.adopted = false;
    }

    public Long getId() {
        return id;
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

    public String getAgeInYears() {
        return DateUtils.intervalBetween(this.getBirthDate(), LocalDateTime.now());
    }
}
