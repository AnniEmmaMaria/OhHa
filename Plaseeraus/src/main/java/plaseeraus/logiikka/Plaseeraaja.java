package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Plaseeraaja {
    
    //Luodaan Vieraslista jonne tallennetaan Vieras-olioina txt-tiedoston rivit
    public static void listaaVieraat(){
        Vieraslista lista = new Vieraslista();
        VieraslistanLukija lukija = new VieraslistanLukija(lista);
        lukija.luoRiveistaOliotListaksi();
    }
    
    public static void arvoIstuja(){
        
    }
}
