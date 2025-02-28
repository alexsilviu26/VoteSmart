package Tema1;

public class Alegeri {
    //Variabile necesare clasei
    private final String idAlegeri;
    private final String numeAlegeri;
    private String status;
    private final Circumscriptie[] circumscriptii = new Circumscriptie[100];
    private int numarCircumscriptii = 0;
    private final Candidat[] candidati = new Candidat[100];
    private int numarCandidati = 0;
    private final Vot[] voturi = new Vot[100];
    private int numarVoturi = 0;
    private final Votant[] votanti = new Votant[100];
    private int numarVotanti = 0;
    private final Regiune[] regiuni = new Regiune[100];
    private int numarRegiuni = 0;
    private final Frauda[] fraude = new Frauda[100];
    private int numarFraude = 0;

     // Constructorii clasei
     public Alegeri() {
        this.idAlegeri = ""; // Constructor fara parametri
        this.numeAlegeri = "";
        this.status = "NEINCEPUT"; // Statusul initial al alegerilor este "NEINCEPUT"
    }

    public Alegeri(String id_alegeri, String numeAlegeri) {
        this.idAlegeri = id_alegeri; // Constructor cu parametri
        this.numeAlegeri = numeAlegeri;
        this.status = "NEINCEPUT";
    }

    // Metoda pentru a obtine numele alegerilor
    public String obtineNume() {
        return numeAlegeri;
    }

    // Metoda pentru a obtine statusul alegerilor
    public String obtineStatus() {
        return status;
    }

    // Metoda pentru a seta un nou status
    public void setStatus(String status) {
        this.status = status;
    }

    // Metoda pentru a obtine o lista de alegeri
    public Alegeri[] obtineAlegeri(Alegeri[] alegeri) {
        return alegeri;
    }

    // Metoda pentru a obtine o anumita alegere dupa ID
    public Alegeri obtineAlegere(Alegeri[] alegeri, String idAlegeri) {
        for (Alegeri alegere : alegeri)
            if (alegere != null && alegere.obtineIdAlegeri().equals(idAlegeri))
                return alegere;
        return null;
    }

    // Metoda pentru a obtine ID-ul alegerilor
    public String obtineIdAlegeri() {
        return idAlegeri;
    }

    // Metoda pentru a elimina o alegere din lista dupa ID
    public void eliminaAlegeri(Alegeri[] alegeri, String idAlegeri) {
        for(int i = 0; i < alegeri.length; i++)
            if(alegeri[i] != null && alegeri[i].obtineIdAlegeri().equals(idAlegeri)) {
                for(int j = i; j < alegeri.length - 1; j++)
                    alegeri[j] = alegeri[j + 1];
                break;
            }
    }

    // Metoda pentru a lista toate alegerile
    public void listareAlegeri(Alegeri[] listaAlegeri) {
        Alegeri a = new Alegeri();
        int i = 0;
        System.out.println("Alegeri:");
        for (Alegeri alegeri : a.obtineAlegeri(listaAlegeri)) {
            if (alegeri != null) {
                System.out.println(alegeri.obtineIdAlegeri() + " " + alegeri.obtineNume());
                i++;
            }
        }
        if (i == 0) {
            System.out.println("GOL: Nu sunt alegeri");
        }
    }

    // Metoda pentru a obtine lista de circumscriptii
    public Circumscriptie[] circumscriptii() {
        return circumscriptii;
    }

    // Metoda pentru a adauga o circumscriptie noua
    public void adaugaCircumscriptie(Circumscriptie circumscriptie) {
        circumscriptii[numarCircumscriptii] = circumscriptie;
        numarCircumscriptii++;
    }

    // Metoda pentru a obtine o circumscriptie dupa nume
    public Circumscriptie obtineCricumscriptie(Circumscriptie[] circumscriptii, String numeCircumscriptie) {
        for (Circumscriptie value : circumscriptii)
            if (value != null && value.obtineNume().equals(numeCircumscriptie))
                return value;
        return null;
    }

    // Metoda pentru a elimina o circumscriptie dupa nume
    public void eliminaCircumscriptie(String numeCircumscriptie) {
        for (int i = 0; i < numarCircumscriptii; i++)
            if (circumscriptii[i].obtineNume().equals(numeCircumscriptie)) {
                for (int j = i; j < numarCircumscriptii - 1; j++)
                    circumscriptii[j] = circumscriptii[j + 1];
                numarCircumscriptii--;
                break;
            }
    }

    // Metoda pentru a obtine lista de votanti
    public Votant[] obtineVotanti() {
        return votanti;
    }

    // Metoda pentru a adauga un votant
    public void adaugaVotant(Votant votant) {
        votanti[numarVotanti] = votant;
        numarVotanti++;
    }

    // Metoda pentru a obtine lista de candidati
    public Candidat[] obtineCandidati() {
        return candidati;
    }

    // Metoda pentru a adauga un candidat
    public void adaugaCandidat(Candidat candidat) {
        candidati[numarCandidati] = candidat;
        numarCandidati++;
    }

    // Metoda pentru a elimina un candidat dupa CNP
    public void eliminaCandidat(String CNP) {
        for (int i = 0; i < numarCandidati; i++)
            if (candidati[i].obtineCNP().equals(CNP)) {
                for (int j = i; j < numarCandidati - 1; j++)
                    candidati[j] = candidati[j + 1];
                numarCandidati--;
                break;
            }
    }

    // Metoda pentru a obtine numarul de voturi
    public int obtineNumarVoturi() {
        return numarVoturi;
    }

    // Metoda pentru a obtine lista de voturi
    public Vot[] obtineVoturi(){
        return this.voturi;
    }

    // Metoda pentru a adauga un vot
    public void adaugaVot(Vot vot) {
        voturi[numarVoturi] = vot;
        numarVoturi++;
    }

    // Metoda pentru a obtine lista de fraude
    public Frauda[] obtineFraude() {
        return fraude;
    }

    // Metoda pentru a adauga o frauda
    public void adaugaFrauda(Frauda frauda) {
        fraude[numarFraude] = frauda;
        numarFraude++;
    }

    // Metoda pentru a obtine lista de regiuni
    public Regiune[] obtineRegiuni() {
        return regiuni;
    }

    // Metoda pentru a obtine numarul de regiuni
    public int obtineNumarRegiuni() {
        return numarRegiuni;
    }

    // Metoda pentru a adauga o regiune noua, daca nu exista deja
    public void adaugaRegiune(String numeRegiune) {
        // Verificare daca regiunea exista deja
        for (int i = 0; i < numarRegiuni; i++) {
            if (regiuni[i] != null && regiuni[i].obtineNume().equals(numeRegiune)) {
                return; // Regiunea exista deja, nu o mai adaugam
            }
        }
        // Daca regiunea este unica, o adaugam in lista
        Regiune newRegiune = new Regiune();
        newRegiune.setNume(numeRegiune);
        regiuni[numarRegiuni] = newRegiune;
        numarRegiuni++;
    }
}