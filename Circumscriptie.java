package Tema1;

public class Circumscriptie {
    // Variabilele clasei Circumscriptie
    private final String numeCircumscriptie;
    private final String regiune;
    private final Votant[] votanti = new Votant[100];
    private int numarVotanti = 0;
    private final Vot[] voturi = new Vot[100];
    private int numarVoturi = 0;
    private final Candidat[] candidati = new Candidat[100];
    private int numarCandidati = 0;

    // Constructor fara parametri
    public Circumscriptie() {
        this.numeCircumscriptie = "";
        this.regiune = "";
    }

    // Constructor cu parametri
    public Circumscriptie(String numeCircumscriptie, String regiune) {
        this.numeCircumscriptie = numeCircumscriptie;
        this.regiune = regiune;
    }

    // Metoda pentru adaugarea unui candidat in lista de candidati
    public void add_candidat(Candidat candidat) {
        candidati[numarCandidati] = candidat;
        numarCandidati++;
    }

    // Returneaza numele regiunii in care se afla circumscriptia
    public String get_regiune() {
        return regiune;
    }

    // Returneaza numele circumscriptiei
    public String obtineNume() {
        return numeCircumscriptie;
    }

    // Returneaza lista de voturi inregistrate
    public Vot[] obtineVoturi() {
        return this.voturi;
    }

    // Returneaza numarul de voturi inregistrate in circumscriptie
    public int obtineNumarVoturi() {
        return numarVoturi;
    }

    // Metoda pentru obtinerea unei circumscriptii dintr-o lista, dupa numele ei
    public Circumscriptie obtineCricumscriptie(Circumscriptie[] circumscriptii, String numeCircumscriptie) {
        for (Circumscriptie circumscriptie : circumscriptii) {
            if (circumscriptie != null && circumscriptie.obtineNume().equals(numeCircumscriptie))
                return circumscriptie;
        }
        return null;
    }

    // Metoda pentru adaugarea unui votant in lista de votanti
    public void adaugaVotant(Votant votant) {
        votanti[numarVotanti] = votant;
        numarVotanti++;
    }

    // Returneaza lista de votanti din circumscriptie
    public Votant[] obtineVotanti() {
        return votanti;
    }

    // Metoda pentru adaugarea unui vot in lista de voturi
    public void adaugaVot(Vot vot) {
        voturi[numarVoturi] = vot;
        numarVoturi++;
    }
}