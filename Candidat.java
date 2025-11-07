package Tema1;

public class Candidat {
    // Variabilele membru ale clasei Candidat
    private String CNP;
    private String nume;
    private final int varsta;
    private int voturi;

     // Constructor implicit (fara parametri)
     public Candidat() {
        this.CNP = "";
        this.nume = "";
        this.varsta = 0;
        this.voturi = 0;
    }

    // Constructor cu parametri
    public Candidat(String CNP, String nume, int varsta) {
        this.CNP = CNP;
        this.nume = nume;
        this.varsta = varsta;
        this.voturi = 0; // Initial, numarul de voturi este 0
    }

    // Metoda pentru a seta numele candidatului
    public void setNume(String nume) {
        this.nume = nume;
    }

    // Metoda pentru a seta CNP-ul candidatului
    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    // Metoda pentru a obtine CNP-ul candidatului
    public String obtineCNP() {
        return CNP;
    }

    // Metoda pentru a obtine numele candidatului
    public String obtineNume() {
        return nume;
    }

    // Metoda pentru a obtine varsta candidatului
    public int obtineVarsta() {
        return varsta;
    }

    // Metoda pentru a obtine numarul de voturi ale candidatului
    public int obtineVoturi() {
        return voturi;
    }

    // Metoda pentru a verifica daca un CNP este valid
    public int verificaCNP(String CNP) {
        if (CNP.length() != 13) {
            System.out.println("EROARE: CNP invalid");
            return 1;
        }
        for (int i = 0; i < CNP.length(); i++) {
            if (CNP.charAt(i) < '0' || CNP.charAt(i) > '9') {
                System.out.println("EROARE: CNP invalid");
                return 1;
            }
        }
        return 0;
    }

    // Metoda pentru a verifica daca varsta este valida pentru un candidat
    public int verificaVarsta(int varsta) {
        if (varsta < 35) {
            System.out.println("EROARE: Varsta invalida");
            return 1;
        }
        return 0;
    }

    // Metoda pentru a gasi un candidat in lista dupa CNP
    public Candidat obtineCandidat(Candidat[] candidati, String CNP) {
        for (Candidat candidat : candidati)
            if (candidat != null && candidat.obtineCNP().equals(CNP))
                return candidat;
        return null;
    }

    // Metoda pentru a adauga un vot pentru acest candidat
    public void adaugaVot() {
        voturi++;
    }
}