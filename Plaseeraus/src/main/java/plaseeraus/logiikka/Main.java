package plaseeraus.logiikka;

import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.PoytienLisays;

public class Main {

    public static void main(String[] args) {
        PoytienLisays kayttoliittyma = new PoytienLisays();
        SwingUtilities.invokeLater(kayttoliittyma);

        //Luodaan pöytä 6:lle ja 4:lle
        Poyta kuudenPoyta = new Poyta(6, 2);
        kuudenPoyta.luoTuolit();
        Poyta neljanPoyta = new Poyta(4, 1);
        neljanPoyta.luoTuolit();

        Plaseeraaja plassaaja = new Plaseeraaja();
        plassaaja.annaVieraslista();

        plassaaja.plaseeraa(neljanPoyta);
        System.out.println("Neljän pöydässä istuvat:");
        plassaaja.tulostaIstujat(neljanPoyta);

        System.out.println("");

        plassaaja.plaseeraa(kuudenPoyta);
        System.out.println("Kuuden pöydässä istuvat:");
        plassaaja.tulostaIstujat(kuudenPoyta);
    }

}
