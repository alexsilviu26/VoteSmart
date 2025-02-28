package Tema1;

import java.util.*;

public class Cazuri {
    public Cazuri() {
    }
    //Variabile ce ajuya la implementarea metodelor
    private final Eroare e = new Eroare();
    private final Alegeri a = new Alegeri();
    private final Candidat c = new Candidat();
    //Metoda pentru cazul in care se vrea crearea alegerilor
    public void caz0(Alegeri[] alegeri, String parametrii, int alegeriCount) {
        String[] parti = parametrii.split(" ", 2);
        //verificam daca avem suficiente elemente in inputul comenzii
        if(e.verificaLungime(parti, 2))
            return;
        String idAlegere = parti[0];
        String numeAlegere = parti[1];
        if (numeAlegere == null || numeAlegere.isEmpty()) {
            System.out.println("EROARE: Numele alegerilor nu poate fi vid");
            return;
        }
        //verificam daca exista o alegere cu acelasi ID si daca nu o cream
        if (a.obtineAlegere(alegeri, idAlegere) == null) {
            alegeri[alegeriCount] = new Alegeri(idAlegere, numeAlegere);
            System.out.println("S-au creat alegerile " + numeAlegere);
        } else {
            System.out.println("EROARE: Deja exista alegeri cu id " + idAlegere);
        }
    }
    //Metoda pentru cazul in care se doreste pornirea alegerilor
    public void caz1(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegeri cu acelasi ID
        if (a.obtineAlegere(alegeri, idAlegere) == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        } else {
            //in caz afirmativ le pornim schimbandu-le statusul
            Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
            if (alegere.obtineStatus().equals("NEINCEPUT")) {
                alegere.setStatus("IN_CURS");
                System.out.println("Au pornit alegerile " + alegere.obtineNume());
            } else
                System.out.println("EROARE: Alegerile deja au inceput");
        }
    }

    //Metoda pentru cazul in care se doreste adaugarea unei circumscriptii
    public void caz2(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 3);
        if(e.verificaLungime(parti, 3))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        String regiune = parti[2];
        Circumscriptie circumscriptie = new Circumscriptie(numeCircumscriptie, regiune);
        //verificam daca exista alegeri cu acelasi ID
        if (a.obtineAlegere(alegeri, idAlegere) == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        } else {
            //daca exista le verificam statusul si daca totul e in regula adaugam circumscriptia
            Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
            if (!alegere.obtineStatus().equals("IN_CURS")) {
                System.out.println("EROARE: Nu este perioada de votare");
            } else {
                //verificam daca circumscriptia exista deja
                if (circumscriptie.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie) != null) {
                    System.out.println("EROARE: Deja exista o circumscriptie cu numele " + numeCircumscriptie);
                } else {
                    alegere.adaugaCircumscriptie(circumscriptie);
                    alegere.adaugaRegiune(regiune);
                    System.out.println("S-a adaugat circumscriptia " + numeCircumscriptie);
                }
            }
        }
    }

    //Metoda pentru cazul in care se doreste stergerea unei circumscriptii
    public void caz3(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 2);
        if(e.verificaLungime(parti, 2))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        Circumscriptie c = new Circumscriptie();
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        //verificam daca exista alegeri cu acelasi ID si perioada de votare
        if (e.verificaExistenta(alegere))
            return;
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Nu este perioada de votare");
            return;
        }
        //verificam daca exista circumscriptia si o stergem
        if (c.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie) != null) {
            alegere.eliminaCircumscriptie(numeCircumscriptie);
            System.out.println("S-a sters circumscriptia " + numeCircumscriptie);
        } else {
            //daca nu exista afisam eroare
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
        }
    }

    //Metoda pentru cazul in care se doreste adaugarea unui candidat
    public void caz4(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 4);
        if(e.verificaLungime(parti, 4))
            return;
        String idAlegere = parti[0];
        String CNP = parti[1];
        int varsta = Integer.parseInt(parti[2]);
        String nume = parti[3];
        //verificam daca exista alegeri cu acelasi ID si perioada de votare
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Nu este perioada de votare");
            return;
        }
        //verificam daca CNP-ul si varsta sunt valide
        if (c.verificaCNP(CNP) == 1) {
            return;
        }
        if (c.verificaVarsta(varsta) == 1) {
            return;
        }
        //verificam daca candidatul exista deja
        Candidat candidat = c.obtineCandidat(alegere.obtineCandidati(), CNP);
        if (candidat != null) {
            System.out.println("EROARE: Candidatul " + candidat.obtineNume() + " are deja acelasi CNP");
            return;
        }
        //daca nu exista il adaugam
        if (c.obtineCandidat(alegere.obtineCandidati(), CNP) == null) {
            candidat = new Candidat(CNP, nume, varsta);
            alegere.adaugaCandidat(candidat);
            System.out.println("S-a adaugat candidatul " + nume);
        }
    }
    //metoda pentru cazul in care se doreste eliminarea unui candidat din alegeri
    public void caz5(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 2);
        if(e.verificaLungime(parti, 2))
            return;
        String idAlegere = parti[0], CNP = parti[1];
        //Verificam daca exista alegeri cu acelasi ID si perioada de votare
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Nu este perioada de votare");
            return;
        }
        //verificam daca candidatul exista si il stergem
        Candidat candidat = c.obtineCandidat(alegere.obtineCandidati(), CNP);
        if (candidat == null) {
            System.out.println("EROARE: Nu exista un candidat cu CNP-ul " + CNP);
            return;
        }
        alegere.eliminaCandidat(CNP);
        System.out.println("S-a sters candidatul " + candidat.obtineNume());
    }

    //metoda pentru cazul in care se doreste adaugarea unui votant in circumscriptie
    public void caz6(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 6);
        if(e.verificaLungime(parti, 6))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        String CNP = parti[2];
        int varsta = Integer.parseInt(parti[3]);
        String neindemanatic = parti[4];
        String nume = parti[5];
        //verificam daca exista alegeri cu acelasi ID si perioada de votare
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Nu este perioada de votare");
            return;
        }
        //verificam daca CNP-ul si varsta sunt valide
        Votant votant = new Votant(CNP, varsta, neindemanatic, nume);
        if (votant.verificaCNP(CNP) == 1) {
            return;
        }
        if (votant.verificaVarsta(varsta) == 1) {
            return;
        }
        //verificam daca exista circumscriptia
        Circumscriptie circumscriptie = alegere.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie);
        if (circumscriptie == null) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
            return;
        }
        //verificam daca exista deja votantul
        Votant votantCircumscriptie = votant.obtineVotant(circumscriptie.obtineVotanti(), CNP);
        if (votantCircumscriptie != null) {
            System.out.println("EROARE: Votantul " + votantCircumscriptie.obtineNume() + " are deja acelasi CNP");
            return;
        }
        //daca nu exista il adaugam
        if (votant.obtineVotant(circumscriptie.obtineVotanti(), CNP) == null) {
            Votant votant2 = new Votant(CNP, varsta, neindemanatic, nume);
            circumscriptie.adaugaVotant(votant2);
            alegere.adaugaVotant(votant2);
            System.out.println("S-a adaugat votantul " + nume);
        }
    }
    //Metoda pentru cazul in care se doreste afisarea candidatilor
    public void caz7(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegeri cu acelasi ID si daca sunt in perioada de votare
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Inca nu au inceput alegerile");
            return;
        }
        //verificam daca exista candidati si ii afisam
        Candidat[] candidati = alegere.obtineCandidati();
        //numaram candidatii
        int numarCandidati = 0;
        for (Candidat candidat : candidati) {
            if (candidat != null) {
                numarCandidati++;
            }
        }
        //daca nu exista afisam un mesaj
        if (numarCandidati == 0) {
            System.out.println("GOL: Nu sunt candidati");
            return;
        }
        //afisam candidatii
        System.out.println("Candidatii:");
        for (Candidat candidat : candidati) {
            if (candidat != null) {
                System.out.println(candidat.obtineNume() + " " + candidat.obtineCNP() + " " + candidat.obtineVarsta());
            }
        }
    }

    //Metoda pentru cazul in care se doreste afisarea votantilor
    public void caz8(Alegeri[] alegeri, String list) {
        //prelucram inputul comenzii
        String[] parti = list.split(" ", 2);
        if(e.verificaLungime(parti, 2))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        //verificam daca exista alegeri cu acelasi ID si daca sunt in perioada de votare
        Alegeri alegere = a.obtineAlegere(a.obtineAlegeri(alegeri), idAlegere);
        if (alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!alegere.obtineStatus().equals("IN_CURS") && !alegere.obtineStatus().equals("TERMINAT")) {
            System.out.println("EROARE: Inca nu au inceput alegerile");
            return;
        }
        //verificam daca exista circumsriptia
        Circumscriptie circumscriptie = alegere.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie);
        if (circumscriptie == null) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
            return;
        }
        //verificam daca exista votanti si ii afisam analog metodei pentru candidati anterioara
        Votant[] votanti = circumscriptie.obtineVotanti();
        int numarVotanti = 0;
        for (Votant votant : votanti) {
            if (votant != null) {
                numarVotanti++;
            }
        }
        if (numarVotanti == 0) {
            System.out.println("GOL: Nu sunt votanti in " + numeCircumscriptie);
            return;
        }
        System.out.println("Votantii din " + numeCircumscriptie + ":");
        for (Votant votant : votanti) {
            if (votant != null) {
                System.out.println(votant.obtineNume() + " " + votant.obtineCNP() + " " + votant.obtineVarsta());
            }
        }
    }

    //Metoda pentru cazul in care se doreste votarea
    public void caz9(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 4);
        if(e.verificaLungime(parti, 4))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        String CNP_votant = parti[2];
        String CNP_candidat = parti[3];
        //verificam dac exista alegeri cu acelasi ID si daca sunt in perioada de votare
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Nu este perioada de votare");
            return;
        }
        //verificam daca exista circumscriptia unde se doreste a se vota
        Circumscriptie circumscriptie = alegere.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie);
        if (circumscriptie == null) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
            return;
        }
        Votant v = new Votant();
        //votantul carui ii corespunde votul
        Votant votant = v.obtineVotant(circumscriptie.obtineVotanti(), CNP_votant);
        Votant votantNational = v.obtineVotant(alegere.obtineVotanti(), CNP_votant);
        //votantul nu exista in circumscriptie
        if (votant == null) {
            System.out.println("FRAUDA: Votantul cu CNP-ul " + CNP_votant + " a incercat sa comita o frauda. Votul a fost anulat");
            Frauda frauda = new Frauda(circumscriptie.obtineNume(), CNP_votant, votantNational.obtineNume());
            alegere.adaugaFrauda(frauda);
            return;
        }
        // verificam daca votantul deja a mai votat
        if (votant.obtineStatus().equals("VOTAT")) {
            System.out.println("FRAUDA: Votantul cu CNP-ul " + CNP_votant + " a incercat sa comita o frauda. Votul a fost anulat");
            Frauda frauda = new Frauda(circumscriptie.obtineNume(), CNP_votant, votant.obtineNume());
            alegere.adaugaFrauda(frauda);
            return;
        }
        //verificam daca exista candidatul care se doreste a fi votat
        Candidat candidat = c.obtineCandidat(alegere.obtineCandidati(), CNP_candidat);
        if (candidat == null) {
            System.out.println("EROARE: Nu exista un candidat cu CNP-ul " + CNP_candidat);
            return;
        }
        //daca votantul e neindemanatic votul sau nu e valid, deci nu se adauga in lista dde voturi
        if (votant.Indemanatic().equals("da")) {
            System.out.println(votant.obtineNume() + " a votat pentru " + candidat.obtineNume());
            alegere.adaugaVot(new Vot(circumscriptie, CNP_votant, CNP_candidat));
            alegere.adaugaVotant(votant);
            votant.setStatus("VOTAT");
            return;
        }
        //daca votantul e indemanatic atunci votul sau e valid si se adauga in lista de voturi
        if (votant.Indemanatic().equals("nu")) {
            System.out.println(votant.obtineNume() + " a votat pentru " + candidat.obtineNume());
            alegere.adaugaVot(new Vot(circumscriptie, CNP_votant, CNP_candidat));
            alegere.adaugaVotant(votant);
            candidat.adaugaVot();
            circumscriptie.adaugaVot(new Vot(circumscriptie, CNP_votant, CNP_candidat));
            circumscriptie.add_candidat(candidat);
            //adaugam votul in regiunea in care este circumscriptia
            for(Regiune regiune : alegere.obtineRegiuni())
            {
                if(regiune != null && regiune.obtineNume().equals(circumscriptie.get_regiune()))
                {
                    regiune.adaugaVot(new Vot(circumscriptie, CNP_votant, CNP_candidat));
                    regiune.adaugaCandidat(c);
                }
            }
            //actualizam statusul votantului pentru a evita fraude
            votant.setStatus("VOTAT");
        }
    }

    //Metoda pentru terminarea alegerilor
    public void caz10(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegerile
        if (a.obtineAlegere(alegeri, idAlegere) == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
        } else {
            //daca exista si sunt in curs atunci ke oprim afisand un mesaj si schimbandu-le statusul
            Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
            if (alegere.obtineStatus().equals("IN_CURS")) {
                alegere.setStatus("TERMINAT");
                System.out.println("S-au terminat alegerile " + alegere.obtineNume());
            } else
                System.out.println("EROARE: Nu este perioada de votare");
        }
    }

    //Metoda pentru afisarea voturilor dintr-o circumscriptie per candidat
    public void caz11(Alegeri[] alegeri, String parametrii) {
        //prelucram inputul comenzii
        String[] parti = parametrii.split(" ", 2);
        if (parti.length != 2) {
            System.out.println("EROARE: Numar de argumente invalid");
            return;
        }
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        //verificam daca exista alegerile si daca sunt in perioada corecta
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if(alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!alegere.obtineStatus().equals("TERMINAT")) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
            return;
        }
        //verificam daca exista circumscriptia pentru care sa facem afisarea
        Circumscriptie circumscriptie = alegere.obtineCricumscriptie(alegere.circumscriptii(), numeCircumscriptie);
        if (circumscriptie == null) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
            return;
        }

        Vot[] voturi = circumscriptie.obtineVoturi();
        Candidat[] candidatiCircumscriptie = new Candidat[100];
        Candidat[] candidati = alegere.obtineCandidati();
        int numarCandidatiVotati = 0;
        boolean unicitate;
        //parcurgem lista de voturi si le atribuim fiecarui candidat in functie de circumscriptie
        for (Vot vot : voturi) {
            if (vot != null) {
                unicitate = true;
                String CNP_candidat = vot.obtineCNPCandidat();
                Candidat candidat = new Candidat();
                candidat.setCNP(CNP_candidat);
                candidat.setNume(c.obtineCandidat(candidati, CNP_candidat).obtineNume());
                candidat.adaugaVot();
                //verificam daca exista in lista candidatul si ii adaugam votul in caz afirmativ
                for (int i = 0; i < numarCandidatiVotati; i++) {
                    if(candidatiCircumscriptie[i]!=null){
                        if (candidatiCircumscriptie[i].obtineCNP().equals(candidat.obtineCNP())) {
                            candidatiCircumscriptie[i].adaugaVot();
                            unicitate = false;
                        }
                    }
                }
                //adaugam un mod unic fiecare candidat in lista de candidati din circumscriptie
                if (unicitate) {
                    candidatiCircumscriptie[numarCandidatiVotati] = candidat;
                    numarCandidatiVotati++;
                }
            }
            //daca nu a votat nimeni afisam un mesaj
            if (numarCandidatiVotati == 0) {
                System.out.println("GOL: Lumea nu isi exercita dreptul de vot in " + numeCircumscriptie);
                return;
            }
            //afisam raporturile
            System.out.println("Raport voturi " + circumscriptie.obtineNume() + ":");
            for (int i = 0; i < numarCandidatiVotati; i++) {
                if (candidatiCircumscriptie[i] != null) {
                    System.out.println(candidatiCircumscriptie[i].obtineNume() + " " + candidatiCircumscriptie[i].obtineCNP() + " - " + candidatiCircumscriptie[i].obtineVoturi());
                }
            }
        }
    }
    //Metoda pentru afisarea voturilor per candidat pe plan national
    public void caz12(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegerile si daca sunt in perioada corecta
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        if (alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
            return;
        }
        //atribuim asemanator metodei anterioare fiecarui candidat voturile sale de la toate circumscriptiile
        Vot[] voturi = alegere.obtineVoturi();
        Candidat[] candidati = alegere.obtineCandidati();
        Candidat[] candidatiNationali = new Candidat[100];
        int numarCandidatiVotati = 0, unicitate;
        for (Vot vot : voturi) {
            if (vot != null) {
                unicitate = 0;
                String CNP_candidat = vot.obtineCNPCandidat();
                
                Candidat candidat = new Candidat();
                candidat.setCNP(CNP_candidat);
                candidat.setNume(c.obtineCandidat(candidati, CNP_candidat).obtineNume());
                candidat.adaugaVot();
                //verificam daca exista in lista candidatul si ii adaugam votul in caz afirmativ

                for (int i = 0; i < numarCandidatiVotati; i++) {
                    if (candidatiNationali[i].obtineCNP().equals(candidat.obtineCNP())) {
                        candidatiNationali[i].adaugaVot();
                        unicitate = 1;
                    }
                }
                //verificam daca candidatul a mai fost votat si daca nu il adaugam in lista
                if (unicitate == 0) {
                    candidatiNationali[numarCandidatiVotati] = candidat;
                    numarCandidatiVotati++;
                }

            }
            //daca nu a votat nimeni afisam un mesaj
            if (numarCandidatiVotati == 0) {
                System.out.println("GOL: Lumea nu isi exercita dreptul de vot in Romania");
                return;
            }
        }
        //afisam rapoturile la nivel national
        System.out.println("Raport voturi Romania:");
        for (int i = 0; i < numarCandidatiVotati; i++) {
            if (candidatiNationali[i] != null) {
                System.out.println(candidatiNationali[i].obtineNume() + " " + candidatiNationali[i].obtineCNP() + " - " + candidatiNationali[i].obtineVoturi());
            }
        }

    }

    public void caz13(Alegeri[] alegeri, String line) {
        //prelucram inputul comenzii
        String[] parti = line.split(" ", 2);
        if(e.verificaLungime(parti, 2))
            return;
        String idAlegere = parti[0];
        String numeCircumscriptie = parti[1];
        //verificam daca exista alegerile si daca sunt in perioada corecta
        Alegeri aux = a.obtineAlegere(alegeri, idAlegere);
        if (aux == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return;
        }
        if (!aux.obtineStatus().equals("TERMINAT")) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
            return;
        }
        //verificam daca exista circumscriptia pentru care sa facem afisarea
        Circumscriptie circ = aux.obtineCricumscriptie(aux.circumscriptii(), numeCircumscriptie);
        if (circ == null) {
            System.out.println("EROARE: Nu exista o circumscriptie cu numele " + numeCircumscriptie);
            return;
        }
        //cu o metoda similara a celei pentru afisarea voturilor per circumscriptie distribuim voturile pe candidati
        Vot[] voturi = circ.obtineVoturi();
        //lista candidati din alegerile nationale
        Candidat[] candidati = aux.obtineCandidati();
        //lista candidati cu voturi in circumscriptia curenta
        Candidat[] candidati2 = new Candidat[100];
        int numarCandidatiVotati = 0;
        boolean unicitate;
        for (Vot value : voturi) {
            if (value != null) {
                unicitate = true;
                String CNP_candidat = value.obtineCNPCandidat();
                
                Candidat candidat = new Candidat();
                candidat.setCNP(CNP_candidat);
                candidat.setNume(c.obtineCandidat(candidati, CNP_candidat).obtineNume());
                candidat.adaugaVot();
                for (int i = 0; i < numarCandidatiVotati; i++) {
                    if (candidati2[i].obtineCNP().equals(candidat.obtineCNP())) {
                        candidati2[i].adaugaVot();
                        unicitate = false;
                    }
                }
                if (unicitate) {
                    candidati2[numarCandidatiVotati] = candidat;
                    numarCandidatiVotati++;
                }
            }
        }
        //daca nu exista voturi afisam un mesaj
        if (numarCandidatiVotati == 0) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in " + numeCircumscriptie);
            return;
        }
        //calculam procentajele si afisam raportul
        int procentaj = (circ.obtineNumarVoturi() * 100) / aux.obtineNumarVoturi();
        int procentaj_intern = (candidati2[0].obtineVoturi() * 100) / circ.obtineNumarVoturi();
        System.out.println("In " + numeCircumscriptie + " au fost " + circ.obtineNumarVoturi() + " voturi din " + aux.obtineNumarVoturi() + ". Adica " + procentaj + "%. Cele mai multe voturi au fost stranse de " + candidati2[0].obtineCNP() + " " + candidati2[0].obtineNume() + ". Acestea constituie " + procentaj_intern + "% din voturile circumscriptiei.");
    }

    //Metoda pentru afisarea rapoartelor la nivel national
    public void caz14(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegeri si sunt inperioada corecta
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        if (alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
            return;
        }
        //ceificam daca exista circumscriptii si daca nu afisam un mesaj
        Circumscriptie[] circumscriptii = alegere.circumscriptii();
        if (circumscriptii == null || circumscriptii.length == 0) {
            System.out.println("GOL: Nu exista circumscriptii");
            return;
        }

        //sortam candidati si voturile per regiuni, dupa care sortam alfabetic regiunile
        Regiune[] regiuni = alegere.obtineRegiuni();
        int numarRegiuni = alegere.obtineNumarRegiuni();
        Arrays.sort(regiuni, 0, numarRegiuni, Comparator.comparing(Regiune::obtineNume));
        int totalVoturiRomania = alegere.obtineNumarVoturi();
        if (totalVoturiRomania == 0) {
            System.out.println("GOL: Lumea nu isi exercita dreptul de vot in Romania");
            return;
        }
        System.out.println("In Romania au fost " + totalVoturiRomania + " voturi.");
        for (Regiune regiune : regiuni) {
            if (regiune != null) {
                Vot[] vot = regiune.obtineVoturi();
                // lista candidati din alegerile nationale
                Candidat[] candidati = alegere.obtineCandidati();
                // lista candidati cu voturi in circumscriptia curenta
                Candidat[] candidatiRegiune = new Candidat[100];
                int numarCandidatiVotati = 0;
                boolean verifica;
                //parcurgem lista de voturi si le atribuim fiecarui candidat in functie de regiune
                for (Vot value : vot) {
                    if (value != null) {
                        verifica = true;
                        String CNP_candidat = value.obtineCNPCandidat();
                        
                        Candidat candidat = new Candidat();
                        candidat.setCNP(CNP_candidat);
                        candidat.setNume(c.obtineCandidat(candidati, CNP_candidat).obtineNume());
                        candidat.adaugaVot();

                        // verificam candidatul sa nu existe deja in lista regionala
                        for (int i = 0; i < numarCandidatiVotati; i++) {
                            if (candidatiRegiune[i] != null && candidatiRegiune[i].obtineCNP().equals(candidat.obtineCNP())) {
                                candidatiRegiune[i].adaugaVot();
                                verifica = false;
                                break; // Exit loop if found
                            }
                        }

                        // daca gasim candidati ii adaugam in lista
                        if (verifica) {
                            candidatiRegiune[numarCandidatiVotati] = candidat;
                            numarCandidatiVotati++;
                        }
                    }
                }

                // verificam sa avem cel putin un candidat pentru a putea calcula procentajele si a afisa raportul
                if (numarCandidatiVotati > 0 && candidatiRegiune[0] != null) {
                    int procentaj = (regiune.obtineNumarVoturi() * 100) / alegere.obtineNumarVoturi();
                    int procentaj_intern = (candidatiRegiune[0].obtineVoturi() * 100) / regiune.obtineNumarVoturi();
                    System.out.println("In " + regiune.obtineNume() + " au fost " + regiune.obtineNumarVoturi() + " voturi din " + alegere.obtineNumarVoturi() + ". Adica " + procentaj + "%. Cele mai multe voturi au fost stranse de " + candidatiRegiune[0].obtineCNP() + " " + candidatiRegiune[0].obtineNume() + ". Acestea constituie " + procentaj_intern + "% din voturile regiunii.");
                }
            }
        }
    }

    //Metoda pentru afisarea fraudelor
    public void caz15(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista alegeri si s-au terminat
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        if (alegere.obtineStatus().equals("IN_CURS")) {
            System.out.println("EROARE: Inca nu s-a terminat votarea");
            return;
        }
        //obtinem fraudele, le pastram astfel incat sa fie unice si le afisam
        Frauda[] fraude = alegere.obtineFraude();
        HashSet<String> fraudeUnice = new HashSet<>();
        for (Frauda frauda : fraude) {
            if (frauda != null) {
                fraudeUnice.add("In " + frauda.obtineNumeCircumscriptie() + ": " + frauda.obtineCNPVotant() + " " + frauda.obtineNume());
            }
        }
        //daca nu avem fraude afisam un mesaj
        if (fraudeUnice.isEmpty()) {
            System.out.println("GOL: Romanii sunt cinstiti");
            return;
        }
        //listam fraudele
        System.out.println("Fraude comise:");
        for (String frauda : fraudeUnice) {
            System.out.println(frauda);
        }
    }
    //metoda pentru stergerea alegerilor
    public void caz16(Alegeri[] alegeri, String idAlegere) {
        //verificam daca exista si in caz afirmativ le stergem
        Alegeri alegere = a.obtineAlegere(alegeri, idAlegere);
        if (e.verificaExistenta(alegere))
            return;
        a.eliminaAlegeri(alegeri, idAlegere);
        System.out.println("S-au sters alegerile " + alegere.obtineNume());
    }
    //metoda pentru listarea alegerilor
    public void caz17(Alegeri[] alegeri) {
        a.listareAlegeri(alegeri);
    }
}