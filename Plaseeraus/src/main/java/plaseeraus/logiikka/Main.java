package plaseeraus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Main {

    public static void main(String[] args) {
       //Luodaan pöytä 6:lle ja 2:lle
        Poyta kuudenPoyta = new Poyta(6, 2);
        kuudenPoyta.luoTuolit();
        Poyta kahdenPoyta = new Poyta(2, 1);                
        kahdenPoyta.luoTuolit();

        Plaseeraaja plassaaja = new Plaseeraaja();
        plassaaja.annaVieraslista();

        plassaaja.plaseeraa(kahdenPoyta);
        System.out.println("Kahden pöydässä istuvat:");
        plassaaja.tulostaIstujat(kahdenPoyta);
        
        System.out.println("");
        
        plassaaja.plaseeraa(kuudenPoyta);
        System.out.println("Kuuden pöydässä istuvat:");
        plassaaja.tulostaIstujat(kuudenPoyta);
       

    }
}