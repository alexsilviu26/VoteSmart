package Tema1;

public class Votant {
    // Variabilele clasei Votant
    private final String CNP;
    private final int varsta;
    private final String nume;
    private final String indemanatic;
    private String status = "";

    // Constructor fara parametri
    public Votant() {
        this.CNP = "";
        this.varsta = 0;
        this.nume = "";
        this.indemanatic = "";
    }

    // Constructor cu parametri
    public Votant(String CNP, int varsta, String indemanatic, String nume) {
        this.CNP = CNP;
        this.varsta = varsta;
        this.nume = nume;
        this.indemanatic = indemanatic;
    }

    // Metoda pentru a seta statusul votantului
    public void setStatus(String status) {
        this.status = status;
    }

    // Metoda pentru a obtine statusul votantului
    public String obtineStatus() {
        return status;
    }

    // Metoda pentru a afla daca votantul este indemanatic
    public String Indemanatic() {
        return indemanatic;
    }

    // Metoda pentru a obtine varsta votantului
    public int obtineVarsta() {
        return varsta;
    }

    // Metoda pentru a obtine varsta votantului
    public String obtineCNP() {
        return CNP;
    }

    // Metoda pentru a obtine numele votantului
    public String obtineNume() {
        return nume;
    }

    //Metoda pentru verificarea varstei votantului
    public int verificaVarsta(int varsta) {
        if (varsta < 18) {
            System.out.println("EROARE: Varsta invalida");
            return 1;
        }
        return 0;
    }

    //Metoda pentru verificarea CNP-ului votantului
    public int verificaCNP(String CNP) {
        if (CNP.length() != 13) {
            System.out.println("EROARE: CNP invalid");
            return 1;
        }
        return 0;
    }

    //Metoda pentru a obtine un votant dupa CNP
    public Votant obtineVotant(Votant[] votanti, String CNP) {
        if (votanti == null) {
            return null;
        }
        for (Votant votant : votanti) {
            if (votant != null && votant.obtineCNP().equals(CNP)) {
                return votant;
            }
        }
        return null;
    }
}
