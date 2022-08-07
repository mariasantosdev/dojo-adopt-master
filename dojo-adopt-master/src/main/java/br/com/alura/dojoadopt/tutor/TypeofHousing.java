package br.com.alura.dojoadopt.tutor;

public enum TypeofHousing {
    HOUSE("Casa"),
    APARTMENT("Aparamento"),
    HOUSE_WITH_YARD("Casa com quintal"),
    HOUSE_WITH_POOL("Casa com piscina"),
    FARM("Sítio");

    private String description;

    TypeofHousing(String displayName) {
        this.description = displayName;
    }

    public String getDescription() {
        return description;
    }
}
