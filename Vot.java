package Tema1;

public class Vot {
    // Variabilele clasei Vot
    private final Circumscriptie circumscriptie;
    private final String CNPVotant;
    private final String CNPCandidat;

    // Constructorul clasei Vot
    public Vot(Circumscriptie circumscriptie, String CNPVotant, String CNPCandidat) {
        this.circumscriptie = circumscriptie;
        this.CNPVotant = CNPVotant;
        this.CNPCandidat = CNPCandidat;
    }

    // Metoda pentru a obtine CNP-ul candidatului
    public String obtineCNPCandidat() {
        return CNPCandidat;
    }

    // Metoda pentru a obtine CNP-ul votantului
    public String getCNPVotant() {
        return CNPVotant;
    }

    // Metoda pentru a obtine circumscriptia
    public Circumscriptie obtineNumeCircumscriptie() {
        return circumscriptie;
    }
}
