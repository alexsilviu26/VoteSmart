package Tema1;

public class Frauda {
    // Variabilele clasei Frauda
    private final String numeCircumscriptie;
    private final String CNPVotant;
    private final String nume;

    // Constructorul clasei Frauda
    public Frauda(String numeCircumscriptie, String CNPVotant, String nume) {
        this.numeCircumscriptie = numeCircumscriptie;
        this.CNPVotant = CNPVotant;
        this.nume = nume;
    }

    // Metoda pentru a obtine numele circumscriptiei
    public String obtineNumeCircumscriptie() {
        return numeCircumscriptie;
    }

    // Metoda pentru a obtine CNP-ul votantului
    public String obtineCNPVotant() {
        return CNPVotant;
    }

    // Metoda pentru a obtine numele votantului
    public String obtineNume() {
        return nume;
    }
}
