package plaseeraus.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.Virheilmoitus;

public class VieraslistanLukija {

    File vieraslista;
    Scanner listanLukija;
    ArrayList<Vieras> listaVieraista;

    /**
     * Luettava vieraslista annetaan Sen scanneria luotaessa varmistetaan
     * tekstitiedoston olemassaolo Vieraat tallennetaan ArrayListiin
     */
    public VieraslistanLukija() {
        this.vieraslista = new File("vieraslista.txt");
        try {
            listanLukija = new Scanner(vieraslista);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt");
        }
        this.listaVieraista = new ArrayList<>();
    }

    //Anna vieraslista, johon tekstitiedoston vieraat tallennettiin
    public ArrayList<Vieras> getVieraslista() {
        return this.listaVieraista;
    }
    

    /**
     * Luetaan tiedoston rivit yksi kerrallaan Tehdään riveistä Vieras-oliot
     * luoTekstirivistaVierasOlio-metodilla Lisätään oliot
     * listaVieraista-ArrayListiksi
     */
    public void luoTekstistaOliotListaksi() {

        while (listanLukija.hasNextLine()) {
            String rivi = listanLukija.nextLine();
            Vieras uusiVieras = luoTekstirivistaVierasOlio(rivi);
            this.listaVieraista.add(uusiVieras);
        }

    }

    /**
     * Luo yhdestä tekstirivistä Vieras-olion etsimällä attribuutit (etu- ja
     * sukunimi, sukupuoli, avec)
     *
     * @param .txt-tiedostosta luettu yksi tekstirivi
     * @return rivin tiedoista luodun Vieras-olion
     */
    private Vieras luoTekstirivistaVierasOlio(String tekstirivi) {

        //Välilyönnit (2 kpl) erottavat 3 attribuuttia
        int ekanValinInd = tekstirivi.indexOf(" ");
        int toisenValinInd = tekstirivi.indexOf(" ", ekanValinInd + 1);

        //Haetaan välilyöntien avulla attribuutit ja palautetaan Vieras-olio
        String etunimi = tekstirivi.substring(0, ekanValinInd);
        String sukunimi = tekstirivi.substring(ekanValinInd + 1, toisenValinInd);

        //Sukupuolen määrittelee m/n -kirjain
        Sukupuoli sukup = null;
        char sukupKirjain = tekstirivi.charAt(toisenValinInd + 1);
        if (sukupKirjain == 'm') {
            sukup = Sukupuoli.MIES;
        } else if (sukupKirjain == 'n') {
            sukup = Sukupuoli.NAINEN;
        } else {
            virheilmoitus("sukupuoli");
        }

        //Oletusarvoisesti avecia ei ole, jolloin se on tyhjä String
        String avec = "";

        //Jos kyseisellä vieraalla on kuitenkin määritetty avec
        if (tekstirivi.contains("(avec: ")) {
            int avecinNimenAlkuInd = tekstirivi.indexOf("(avec: ") + 7;
            avec = tekstirivi.substring(avecinNimenAlkuInd);
        }

        return new Vieras(etunimi, sukunimi, sukup, avec);
    }

    //Virheilmoituksen laukaisumetodi
    public void virheilmoitus(String aiheuttaja) {
        String virheteksti = "Vieraslistassa virhe kohdassa " + aiheuttaja;
        Virheilmoitus virheRuutu = new Virheilmoitus(virheteksti);
        SwingUtilities.invokeLater(virheRuutu);

    }

}
