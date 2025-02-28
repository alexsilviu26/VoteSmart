package Tema1;

public class Eroare {
    // Metoda pentru verificarea lungimii unui array de stringuri 
    public boolean verificaLungime(String[] parti, int numarElemente) {
        if (parti.length != numarElemente) {
            System.out.println("EROARE: Numar de argumente invalid");
            return true;
        }
        return false;
    }

    // Metoda pentru verificarea existentei unui obiect de tip Alegeri
    public boolean verificaExistenta(Alegeri alegere) {
        if (alegere == null) {
            System.out.println("EROARE: Nu exista alegeri cu acest id");
            return true;
        }
        return false;
    }
}
