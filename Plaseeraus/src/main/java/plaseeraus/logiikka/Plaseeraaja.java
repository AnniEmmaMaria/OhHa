package plaseeraus.logiikka;

import java.util.ArrayList;
import java.util.Random;

/**
 * Tekee plaseeraustyön eli laittaa tuoleille vieraat
 */
public class Plaseeraaja {

    private final VieraslistanLukija lukija;
    private final Random arpoja;

    public Plaseeraaja() {
        this.lukija = new VieraslistanLukija();
        this.arpoja = new Random();
    }

    /**
     * Määrää istujan tuolille kerrallaan. Ottaavieraslistalta sallitut vieraat,
     * arpoo näistä yhden ja istuttaa tuolille
     *
     * @param poyta jonka tuoleille valitaan vieraat istumaan
     */
    public void plaseeraa(Poyta poyta) {
        int koko = poyta.getTuolimaara();
        Vieras valittuIstuja = null; 
        ArrayList<Vieras> sallitutIstujat = null;      

        for (int tuolinInd = 0; tuolinInd < koko; tuolinInd++) {
            sallitutIstujat = listaaSallitutVieraat(tuolinInd, valittuIstuja);
            valittuIstuja = arvoIstuja(sallitutIstujat);
            poyta.getTuoli(tuolinInd).otaIstuja(valittuIstuja);
        }
    }

    /**
     * Valitsee alkuperäiseltä vieraslistalta uudeksi listaksi ne vieraat,
     * joiden sallitaan istua tälle tuolille
     *
     * @param tuolinInd plaseerausvuorossa olevan tuolin numero (0,1,..)
     * @return karsittu vieraslista
     */
    private ArrayList<Vieras> listaaSallitutVieraat(int tuolinInd, Vieras edellinenIstuja) {

        ArrayList<Vieras> sallitutIstujat = new ArrayList<>();
        ArrayList<Vieras> kaikkiVieraat = annaVieraslista();
        
        //Huomioidaan, että nainen saa avecinsa viereensä
//        if(!edellinenIstuja.getAvec().equals("")){
//            
//        }

        for (Vieras vieras : kaikkiVieraat) {
            //Vain paikattomat vieraat kelpaavat
            if (vieras.onkoPlaseerattu() == false) {

                //nainen parillisille tuoleille
                if (tuolinInd % 2 == 0 && vieras.getSukupuoli() == Sukupuoli.NAINEN) {
                    sallitutIstujat.add(vieras);
                    
                } else if (tuolinInd % 2 != 0 && vieras.getSukupuoli() == Sukupuoli.MIES) {
                    sallitutIstujat.add(vieras);
                }
            }
        }
        return sallitutIstujat;
    }

    //Arpoo listalta yhden vieraan ja palauttaa sen
    private Vieras arvoIstuja(ArrayList<Vieras> sallitutIstujat) {

        int listanKoko = sallitutIstujat.size();

        //random arpoja arpoo kokonaisluvun väliltä [0,listanKoko[
        int arvottuLuku = arpoja.nextInt(listanKoko);
        //palautetaan tällä luvulla esiintyvä sallittu Vieras
        return sallitutIstujat.get(arvottuLuku);
    }

    /**
     * VieraslistanLukija luo tekstitiedoston vieraslistasta Vieras-oliot
     *
     * @return Vieras-oliot listattuna ArrayListiksi
     */
    public ArrayList<Vieras> annaVieraslista() {
        lukija.luoTekstistaOliotListaksi();
        return lukija.getVieraslista();
    }

}
