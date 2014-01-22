package plaseeraus.logiikka.vieraidenMaaritys;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VieraslistanLukija {

    File vieraslista;       //luettava vieraslista
    Scanner listanLukija;   //sen lukija
    KaikkiVieraat kaikki;
    
    public VieraslistanLukija() {
        vieraslista = new File("vieraslista.txt");

        //Vieraslistan lukijan teossa varmistetaan, että tekstitiedosto on olemassa
        try {
            listanLukija = new Scanner(vieraslista);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt");
        }
        
        kaikki = new KaikkiVieraat();
    }

    //Luetaan tiedoston rivit yksi kerrallaan ja tehdään riveistä Vieras-oliot
    //Lisätään oliot KaikkiVieraat-luokkaan
    public void luoRiveistaOliot() {



        while (listanLukija.hasNextLine()) {
            String rivi = listanLukija.nextLine();
            Vieras uusiVieras = luoTekstirivistaVierasOlio(rivi);
            kaikki.lisaaVierasListaan(uusiVieras);
        }
    }

    //Luo yhdestä tekstirivistä Vieras-olion etsimällä attribuutit (etu- ja sukunimi, sukupuoli) 
    private Vieras luoTekstirivistaVierasOlio(String tekstirivi) {

        //Välilyönnit (2 kpl) erottavat 3 attribuuttia
        int ekanValinInd = tekstirivi.indexOf(" ");
        int toisenValinInd = tekstirivi.indexOf(" ", ekanValinInd + 1);

        //Haetaan välilyöntien avulla attribuutit ja palautetaan Vieras-olio
        String etunimi = tekstirivi.substring(0, ekanValinInd);
        String sukunimi = tekstirivi.substring(ekanValinInd + 1, toisenValinInd);
        char sukupuoli = tekstirivi.charAt(toisenValinInd + 1);

        return new Vieras(etunimi, sukunimi, sukupuoli);
    }

}
