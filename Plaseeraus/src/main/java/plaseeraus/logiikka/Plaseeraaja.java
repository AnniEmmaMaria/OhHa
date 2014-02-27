package plaseeraus.logiikka;

import java.util.ArrayList;
import java.util.Random;
import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.Virheilmoitus;

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

        for (int tuolinInd = 0; tuolinInd < koko; tuolinInd++) {
            ArrayList<Vieras> sallitutIstujat = listaaSallitutVieraat(valittuIstuja);
            valittuIstuja = arvoIstuja(sallitutIstujat);

            poyta.getTuoli(tuolinInd).otaIstuja(valittuIstuja);
        }
    }

    /**
     * Valitsee alkuperäiseltä vieraslistalta uudeksi listaksi ne vieraat,
     * joiden sallitaan istua tälle tuolille.
     *
     * @param
     * @return karsittu vieraslista
     */
    private ArrayList<Vieras> listaaSallitutVieraat(Vieras edellinenIstuja) {

        ArrayList<Vieras> sallitutIstujat = new ArrayList<>();
        ArrayList<Vieras> kaikkiVieraat = annaVieraslista();

        //Jos edellistä istujaa ei ole -> pöytä alkaa naisella
        if (edellinenIstuja == null) {
            sallitutIstujat = listaaVapaatNaiset(kaikkiVieraat);

            //Jos edellinen istuja on nainen
        } else if (edellinenIstuja.getSukupuoli() == Sukupuoli.NAINEN) {
            String avecNimi = edellinenIstuja.getAvec();

            if (!avecNimi.equals("")) {
                Vieras avec = getVierasNimenPerusteella(avecNimi, kaikkiVieraat);
                sallitutIstujat.add(avec);
            } else {
                sallitutIstujat = listaaVapaatMiehet(kaikkiVieraat);
            }

            //Jos edellinen istuja on mies tai null (ensimmäinen tuoli)
        } else {
            sallitutIstujat = listaaVapaatNaiset(kaikkiVieraat);
        }

        return sallitutIstujat;
    }

    /**
     * Valitsee naiset, joita ei ole vielä plaseerattu
     *
     * @param kaikkiVieraat
     * @return
     */
    private ArrayList<Vieras> listaaVapaatNaiset(ArrayList<Vieras> kaikkiVieraat) {
        ArrayList<Vieras> vapaatNaiset = new ArrayList();

        for (Vieras yksiVieras : kaikkiVieraat) {
            if (yksiVieras.onkoPlaseerattu() == false) {
                if (yksiVieras.getSukupuoli() == Sukupuoli.NAINEN) {
                    vapaatNaiset.add(yksiVieras);
                }
            }
        }
        return vapaatNaiset;
    }

    /**
     * Valitsee miehet, joita ei ole varattu avecina jollekin naiselle
     *
     * @param kaikkiVieraat
     * @return
     */
    private ArrayList<Vieras> listaaVapaatMiehet(ArrayList<Vieras> kaikkiVieraat) {
        ArrayList<Vieras> vapaatMiehet = new ArrayList();

        for (Vieras yksiVieras : kaikkiVieraat) {
            if (yksiVieras.onkoPlaseerattu() == false) {
                if (yksiVieras.getSukupuoli() == Sukupuoli.MIES && yksiVieras.getAvec().equals("")) {
                    vapaatMiehet.add(yksiVieras);
                }
            }
        }
        return vapaatMiehet;
    }

    /**
     * Arpoo listalta yhden vieraan ja palauttaa sen
     *
     * @param sallitutIstujat arpajaisiin osallistuvat vieraat
     * @return
     */
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

    /**
     * Etsitään nimistringin perusteella vieraslistalta Vieras-olio
     *
     * @param haettuNimi String "Etunumi Sukunimi" -muodossa haettu Vieras
     * @param vieraslista
     * @return
     */
    public Vieras getVierasNimenPerusteella(String haettuNimi, ArrayList<Vieras> vieraslista) {
        Vieras haettuVieras = null;

        for (Vieras yksiVieras : vieraslista) {
            if (yksiVieras.toString().equals(haettuNimi)) {
                haettuVieras = yksiVieras;
            } else {
                Virheilmoitus virheRuutu = new Virheilmoitus("avec");
                SwingUtilities.invokeLater(virheRuutu);
            }
        }
        return haettuVieras;
    }
}
