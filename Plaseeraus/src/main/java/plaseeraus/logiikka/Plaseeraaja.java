package plaseeraus.logiikka;

import java.util.ArrayList;
import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Plaseeraaja {
    
    //Luodaan Vieraslista jonne tallennetaan Vieras-olioina txt-tiedoston rivit
    public static void listaaVieraat(){
        Vieraslista lista = new Vieraslista();
        VieraslistanLukija lukija = new VieraslistanLukija(lista);
        
        lukija.luoRiveistaOliotListaksi();
    }
    
    public void plaseeraa(Poyta poyta){
        ArrayList<Tuoli> tuolilista = poyta.getTuolilista();
        
        for(int tuoliNro = 0; tuoliNro < poyta.getTuolimaara(); tuoliNro++){
            //parillisille tuoleille istutetaan mies
            if(tuoliNro % 2 == 0){
                
            }
            
            
        }
        
    }
    
    public static void arvoIstuja(){
        
    }
}
