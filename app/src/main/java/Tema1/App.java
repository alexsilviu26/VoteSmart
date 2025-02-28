package Tema1;

import java.io.*;
import java.util.*;

public class App {
    private final Scanner scanner;

    public App(InputStream input) {
        this.scanner = new Scanner(input);
    }

    public void run() {
        Alegeri[] alegeri = new Alegeri[100];
        Cazuri c = new Cazuri();
        int alegeri_count = 0;
        String idAlegere;
        String parametrii;
        while (true) {
            String comanda = scanner.next();
            switch (comanda) {
                case "0":
                    //Creare alegeri
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz0(alegeri, parametrii, alegeri_count);
                    break;
                case "1":
                    //Pornire alegeri
                    scanner.nextLine();
                    idAlegere = scanner.next();
                    c.caz1(alegeri, idAlegere);
                    break;
                case "2":
                    //Adaugare circumscriptie
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz2(alegeri, parametrii);
                    break;
                case "3":
                    //Eliminare circumscriptie
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz3(alegeri, parametrii);
                    break;
                case "4":
                    //Adaugare candidat
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz4(alegeri, parametrii);
                    break;
                case "5":
                    //Eliminare candidat
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz5(alegeri, parametrii);
                    break;
                case "6":
                    //Adaugare votant
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz6(alegeri, parametrii);
                    break;
                case "7":
                    //Listare candidati alegeri
                    scanner.nextLine();
                    idAlegere = scanner.next();
                    c.caz7(alegeri, idAlegere);
                    break;
                case "8":
                    //Listare votanti circumscriptie
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz8(alegeri, parametrii);
                    break;
                case "9":
                    //Votare
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz9(alegeri, parametrii);
                    break;
                case "10":
                    //Oprire alegeri
                    scanner.nextLine();
                    idAlegere = scanner.nextLine();
                    c.caz10(alegeri, idAlegere);
                    break;
                case "11":
                    //Creare raport vot per circumscriptie
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz11(alegeri, parametrii);
                    break;
                case "12":
                    //Creare raport vot national
                    scanner.nextLine();
                    idAlegere = scanner.nextLine();
                    c.caz12(alegeri, idAlegere);
                    break;
                case "13":
                    //Analiza detaliata per circumscriptie
                    scanner.nextLine();
                    parametrii = scanner.nextLine();
                    c.caz13(alegeri, parametrii);
                    break;
                case "14":
                    //Analiza detaliata nationala
                    scanner.nextLine();
                    idAlegere = scanner.nextLine();
                    c.caz14(alegeri, idAlegere);
                    break;
                case "15":
                    //Raportare fraudare
                    scanner.nextLine();
                    idAlegere = scanner.next();
                    c.caz15(alegeri, idAlegere);
                    break;
                case "16":
                    //Sterge alegeri
                    scanner.nextLine();
                    idAlegere = scanner.next();
                    c.caz16(alegeri, idAlegere);
                    break;
                case "17":
                    //Afisare alegeri
                    c.caz17(alegeri);
                    break;
                case "18":
                    //Iesire
                    return;
                default:
                //In cazul in care nu identificam comanda afisam un mesaj de eroare
                    System.out.println("EROARE: Comanda invalida");
                    break;
            }

        }
    }

    public static void main(String[] args) {
        App app = new App(System.in);
        app.run();
    }
}