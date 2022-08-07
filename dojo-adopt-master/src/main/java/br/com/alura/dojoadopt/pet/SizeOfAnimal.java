package br.com.alura.dojoadopt.pet;

public enum SizeOfAnimal {
    MINI("Mini"),
    SMALL("Pequeno"),
    MEDIUM("Médio"),
    LARGE("Grande"),
    GIANT("Gigante");

    private final String description;

    SizeOfAnimal(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
