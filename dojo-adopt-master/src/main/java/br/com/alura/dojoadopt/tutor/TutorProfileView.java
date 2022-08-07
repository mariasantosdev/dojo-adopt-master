package br.com.alura.dojoadopt.tutor;

public class TutorProfileView {
    private Long id;
    private String name;
    private String cpf;
    private String photoUrl;

    public TutorProfileView(Tutor tutor) {
        this.id = tutor.getId();
        this.name = tutor.getName();
        this.cpf = tutor.getCpf();
        this.photoUrl = tutor.getPhotoUrl();
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
}
