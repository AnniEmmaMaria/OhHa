package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Main {

    
    public static void main(String[] args) {
        Vieraslista lista = new Vieraslista();
        VieraslistanLukija lukija = new VieraslistanLukija(lista);
        
        lukija.luoRiveistaOliotListaksi();
        System.out.println("Vieraita on: " + lista.vierasmaara());
        System.out.println("---");
        lista.tulostaVieraidenNimet();
        

    }
    
}
