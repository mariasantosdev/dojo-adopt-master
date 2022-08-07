package br.com.alura.dojoadopt.pet;

public enum Type {
    FISH("Peixe"),
    REPTILE(" Réptil"),
    DOG("Cachorro"),
    CAT("Gato"),
    BIRD("Passáro"),
    EXOTIC("Exótico");

    private final String description;

    Type(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
