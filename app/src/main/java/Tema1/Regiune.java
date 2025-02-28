package Tema1;

public class Regiune {
    //Variabilele clasei Regiune
    private String nume;
    private final Candidat[] candidat = new Candidat[100];
    private int numarCandidati = 0;
    private final Vot[] voturi = new Vot[100];
    private int numarVoturi;

    // Constructor fara parametri
    public Regiune() {
        this.nume = "";
        this.numarVoturi = 0;
    }

    // Metoda pentru adaugarea unui vot in lista de voturi
    public void adaugaVot(Vot vot) {
        voturi[numarVoturi] = vot;
        numarVoturi++;
    }

    //Metoda pentru a obtine lista de voturi
    public Vot[] obtineVoturi() {
        return voturi;
    }

    //Metoda pentru a obtine numele regiunii
    public String obtineNume() {
        return nume;
    }

    //Metoda pentru a obtine numarul de voturi
    public int obtineNumarVoturi() {
        return numarVoturi;
    }

    //Metoda pentru a adauga un candidat in lista de candidati
    public void adaugaCandidat(Candidat candidat) {
        this.candidat[numarCandidati] = candidat;
        numarCandidati++;
    }

    //Metoda pentru a seta numele regiunii
    public void setNume(String nume) {
        this.nume = nume;
    }
}