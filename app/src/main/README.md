    Nicolăescu Alexandru-Valentin - 324CB

                        README Tema 1
            VoteSmart – Platformă de Votare Online


        Introducere
        Proiectul VoteSmart își propune să implementeze o platformă de votare online 
    utilizând principiile programării orientate pe obiecte (OOP). Scopul aplicației 
    este de a simula procesele implicate într-un sistem electoral: crearea și 
    gestionarea alegerilor, adăugarea și eliminarea candidaților, înregistrarea 
    votanților și a circumscripțiilor, procesul de votare propriu-zis și generarea 
    diverselor rapoarte legate de rezultate și eventualele fraude.

        Structura Proiectului
    Proiectul este organizat în mai multe clase, fiecare modelând o componentă 
    specifică a procesului electoral. Fiecare clasă este implementată în fișiere
    separate pentru a asigura modularitatea și claritatea codului.

        Clasele Principale
    Alegeri:
        Modelează o sesiune de alegeri.
        Conține informații despre circumscripții, voturi, candidați, votanți și fraude.
        Include constructori și metode pentru gestionarea alegerilor, obținerea de date și operațiuni necesare.

    Candidat:
        Reprezintă un candidat într-o circumscripție.
        Conține informații precum nume, CNP și vârstă.
        Include metode de validare a informațiilor și accesare a datelor.

    Cases:
        Implementează toate funcționalitățile cerute de temă.
        Fiecare funcționalitate este un caz distinct în această clasă, utilizând metodele din celelalte clase.
        Folosește tipuri de date specifice pentru a facilita accesul la metodele și datele necesare.

    Circumscriptie:
        Modelează o circumscripție electorală.
        Conține date despre votanți, candidați și voturi, precum și informații specifice precum numele și regiunea.

    Eroare:
        Conține implementarea a două tipuri de erori frecvent întâlnite:
        Inexistența unei sesiuni de alegeri.
        Insuficiența argumentelor furnizate pentru o comandă.

    Frauda:
        Modelează informațiile despre posibile fraude în procesul de votare.
        Include metode pentru accesarea și gestionarea informațiilor despre fraude.

    Regiune:
        Reprezintă o regiune geografică.
        Include metode pentru gestionarea informațiilor legate de regiuni, cum ar fi adăugarea și accesarea acestora.

    Vot:
        Reprezintă un vot individual.
        Conține metode pentru gestionarea și obținerea informațiilor despre un vot.

    Votant:
        Modelează un votant în cadrul unei circumscripții.
        Include informații relevante precum CNP și vârstă și metode pentru validarea acestor date.
    
        Stil și Convenții
    
    Codul este scris folosind convenția camelCase, cu variabile private și metode publice.
    Limbajul folosit este româna pentru a reflecta clar cerințele și specificațiile.
    Încapsularea este respectată prin utilizarea variabilelor private, accesibile doar prin metode publice.
        
        Aspecte Cheie ale Implementării
    În cadrul clasei App, aplicația folosește un ciclu repetitiv de tip while pentru a menține funcționarea activă, iar inputul este gestionat 
    printr-o structură switch care apelează metodele corespunzătoare în funcție de comandă.
    Modularitate: Fiecare clasă este separată în fișiere distincte, ceea ce facilitează întreținerea și modificarea codului.
    Validarea Datelor: Validarea datelor esențiale precum CNP-ul și vârsta este gestionată în clasele Candidat și Votant.
    Gestionarea Erorilor: Clasele sunt pregătite să gestioneze scenarii de eroare frecvent întâlnite, asigurând un comportament robust al aplicației.
    Funcționalități Diverse: Aplicația acoperă toate cerințele temei, inclusiv raportarea voturilor și a fraudelor, analiza detaliată și gestionarea 
    sesiunilor de alegeri.


        Posibile Îmbunătățiri
    Cazuri Limită Suplimentare:
    Tratarea cazurilor în care toți candidații sunt egali ca număr de voturi.
    Validarea votanților care încearcă să voteze în afara circumscripției în care sunt înregistrați.
    Optimizarea gestionării candidaților care nu au primit niciun vot.
    
        Refactorizarea Comenzilor:
    Simplificarea structurii de comandă pentru a evita repetițiile.
    Crearea unei structuri de meniu pentru o navigare mai ușoară între opțiuni.
    Optimizarea procesului de validare a datelor pentru a reduce codul redundant.

        Concluzie
    Proiectul VoteSmart reprezintă o aplicație Java simplificată pentru gestionarea proceselor electorale, 
    folosind conceptele de programare orientată pe obiecte pentru a asigura modularitate, extensibilitate și claritate în cod.
    Aplicația respectă cerințele temei și oferă funcționalități complete pentru simularea unui sistem electoral.