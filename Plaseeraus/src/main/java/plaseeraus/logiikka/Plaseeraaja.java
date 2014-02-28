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
        //Koska ensimmäinen plaseerattava on nainen tehdään yksi tekomies-Vieras
        Vieras valittuIstuja = new Vieras("teko", "mies", Sukupuoli.MIES, "");

        for (int tuolinInd = 0; tuolinInd < koko; tuolinInd++) {
            ArrayList<Vieras> sallitutIstujat = listaaSallitutVieraat(tuolinInd, valittuIstuja);
            valittuIstuja = arvoIstuja(sallitutIstujat);

            poyta.getTuoli(tuolinInd).otaIstuja(valittuIstuja);
        }
    }

    /**
     * Valitsee alkuperäiseltä vieraslistalta uudeksi listaksi ne vieraat,
     * joiden sallitaan istua tälle tuolille. Lista käydään for-loopilla läpi.
     * Soveliaat vieraat otaantulokseen
     * @param tuoliNro mille tuolille haetaan istuja
     * @param edellinenIstuja oikealle puolelle jo plaseerattu vieras
     *@return lista paikalle sallituista vieraista
     */
    public ArrayList<Vieras> listaaSallitutVieraat(int tuoliNro, Vieras edellinenIstuja) {

        ArrayList<Vieras> sallitutIstujat = new ArrayList<>();
        ArrayList<Vieras> kaikkiVieraat = annaVieraslista();
        ArrayList<Vieras> vapaatVieraat = new ArrayList<>();
        String edellisenAvec = edellinenIstuja.getAvec();

        //Plaseeratut vieraat poistetaan
        for (Vieras vieras : kaikkiVieraat) {
            if (vieras.onkoPlaseerattu() == false) {
                vapaatVieraat.add(vieras);
            }
        }

        //Ensimmäiseen tuoliin nainen
        if (tuoliNro == 0) {
            sallitutIstujat = listaaVapaatNaiset(vapaatVieraat);

        //Parilliseen tuoliin nainen
        } else if (tuoliNro % 2 == 0) {
            //Jos naisella on avec
            if (!edellisenAvec.equals("")) {
                Vieras avec = getVierasNimenPerusteella(edellisenAvec, vapaatVieraat);
                sallitutIstujat.add(avec);
                //jos naisella ei ole avecia
            } else {
                sallitutIstujat = listaaVapaatMiehet(kaikkiVieraat);
            }
        //Parittomaan tuoliin mies
        } else {
            sallitutIstujat = listaaVapaatNaiset(vapaatVieraat);
        }

        return sallitutIstujat;

    }

    /**
     * Valitsee naiset, joita ei ole vielä plaseerattu
     *
     * @param vapaatVieraat eli plaseeraamattomat vieraat
     * @return Istumapaikalle sopivat naiset
     */
    public ArrayList<Vieras> listaaVapaatNaiset(ArrayList<Vieras> vapaatVieraat) {
        ArrayList<Vieras> vapaatNaiset = new ArrayList();

        for (Vieras yksiVieras : vapaatVieraat) {
            if (yksiVieras.getSukupuoli() == Sukupuoli.NAINEN) {
                vapaatNaiset.add(yksiVieras);
            }
        }
        return vapaatNaiset;
    }

    /**
     * Valitsee miehet, joita ei ole varattu avecina jollekin naiselle
     *
     * @param vapaatVieraat eli plaseeraamattomat vieraat
     * @return Istumapaikalle sopivat miehet
     */
    public ArrayList<Vieras> listaaVapaatMiehet(ArrayList<Vieras> vapaatVieraat) {
        ArrayList<Vieras> vapaatMiehet = new ArrayList();

        for (Vieras yksiVieras : vapaatVieraat) {
                if (yksiVieras.getSukupuoli() == Sukupuoli.MIES && yksiVieras.getAvec().equals("")) {
                    vapaatMiehet.add(yksiVieras);
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

        //random arpoja arpoo kokonaisluvun väliltä[0,listanKoko[
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
