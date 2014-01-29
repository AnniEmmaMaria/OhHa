package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Main {

    
    public static void main(String[] args) {
        Poyta kuudenPoyta = new Poyta(6, 1);
        System.out.println("Tuoleja on siis " + kuudenPoyta.getTuolimaara());
        kuudenPoyta.luoTuolit();
        Tuoli jakkara = kuudenPoyta.getTuoli(2);
        System.out.println("tuoli tuli");
        System.out.println(jakkara);
        

    }
    
}
