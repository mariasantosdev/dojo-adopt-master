package br.com.alura.dojoadopt.tutor;

public class TutorView {
    private final Long id;
    private final String name;
    private final String cpf;
    private final String photoUrl;

    public TutorView(Tutor tutor) {
        this.id = tutor.getId();
        this.name = tutor.getName();
        this.cpf = tutor.getCpf();
        this.photoUrl = tutor.getPhotoUrl();
    }

    public Long getId() {
        return id;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public String getName() {
        return name;
    }

    public String getCpf() {
        return cpf;
    }
}
