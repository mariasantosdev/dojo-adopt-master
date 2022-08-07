package br.com.alura.dojoadopt.tutor;

import org.hibernate.validator.constraints.URL;
import org.hibernate.validator.constraints.br.CPF;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

import static javax.persistence.EnumType.STRING;

public class TutorNewForm {
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
        private String photoUrl;

        public String getName() {
                return name;
        }

        public String getCpf() {
                return cpf;
        }

        public LocalDate getBirthDate() {
                return birthDate;
        }

        public BigDecimal getRemuneration() {
                return remuneration;
        }

        public TypeofHousing getTypeofHousing() {
                return typeofHousing;
        }

        public String getPhotoUrl() {
                return photoUrl;
        }

        public void setName(String name) {
                this.name = name;
        }

        public void setCpf(String cpf) {
                this.cpf = cpf;
        }

        public void setPhotoUrl(String photoUrl) {
                this.photoUrl = photoUrl;
        }

        public void setBirthDate(LocalDate birthDate) {
                this.birthDate = birthDate;
        }

        public void setRemuneration(BigDecimal remuneration) {
                this.remuneration = remuneration;
        }

        public void setTypeofHousing(TypeofHousing typeofHousing) {
                this.typeofHousing = typeofHousing;
        }

        public Tutor toModel() {
                return new Tutor(name,cpf,birthDate,remuneration,photoUrl,typeofHousing);
        }
}
