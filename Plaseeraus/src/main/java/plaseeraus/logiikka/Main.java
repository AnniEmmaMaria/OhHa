package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;


public class Main {

    
    public static void main(String[] args) {
        Vieras putti = new Vieras("Putti", "Vaaksanheimo", 'm');
        String avain = putti.luoYksiloivaAvain();
        System.out.println("Putin avain on: " + avain);
       
    }
    
}
