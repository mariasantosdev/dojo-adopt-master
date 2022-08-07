package br.com.alura.dojoadopt.pet;

public class PetView {
    private final String photoUrl;
    private final Long id;
    private final String name;
    private String ageInYears;
    private final SizeOfAnimal size;
    private final Type type;

    public PetView(Pet pet) {
        this.photoUrl = pet.getPhotoUrl();
        this.id = pet.getId();
        this.name = pet.getName();
        this.size = pet.getSize();
        this.type = pet.getType();
        this.ageInYears = pet.getAgeInYears();
    }

    public String getAgeInYears() {
        return ageInYears;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public SizeOfAnimal getSize() {
        return size;
    }

    public Type getType() {
        return type;
    }
}
