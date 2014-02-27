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
        
        //Jos edellinen istuja on nainen
        if(edellinenIstuja.getSukupuoli() == Sukupuoli.NAINEN){
            String avecNimi = edellinenIstuja.getAvec();
            
            if(!avecNimi.equals("")){
                Vieras avec = getVierasNimenPerusteella(avecNimi, kaikkiVieraat);
                sallitutIstujat.add(avec);
            }else{
                sallitutIstujat = listaaVapaatMiehet();
            }
            
        //Jos edellinen istuja on mies
        }else{

        }
//        
//        boolean onSallittuVieras = false;
//
//        for (Vieras vieras : kaikkiVieraat) {
//            //Vain paikattomat vieraat kelpaavat
//            if (vieras.onkoPlaseerattu() == false) {
//                
//                if (tuolinInd % 2 == 0){
//                    onSallittuVieras = sopiikoNaisenPaikalle(vieras);
//                }else if (tuolinInd % 2 != 0 ){
//                    onSallittuVieras = sopiikoMiehenPaikalle(vieras);
//                }
//            }
//            
//            if(onSallittuVieras){
//                sallitutIstujat.add(vieras);
//            }
//            
//        }
//        
        
        
        
//        
//        //Huomioidaan, että nainen saa avecinsa viereensä
//        String avecNimi = edellinenIstuja.getAvec();
//
//        if (avecNimi.equals("")) {
//            for (Vieras vieras : kaikkiVieraat) {
//                //Vain paikattomat vieraat kelpaavat
//                if (vieras.onkoPlaseerattu() == false) {
//
//                    //nainen parillisille tuoleille
//                    if (tuolinInd % 2 == 0 && vieras.getSukupuoli() == Sukupuoli.NAINEN) {
//                        sallitutIstujat.add(vieras);
//
//                    } else if (tuolinInd % 2 != 0 && vieras.getSukupuoli() == Sukupuoli.MIES) {
//                        sallitutIstujat.add(vieras);
//                    }
//                }
//            }
//        } else {
//            Vieras avec = getVierasNimenPerusteella(avecNimi, kaikkiVieraat);
//            sallitutIstujat.add(avec);
//        }

        return sallitutIstujat;
        }
    

    

    private boolean sopiikoNaisenPaikalle(Vieras vieras, Vieras edellinenIstuja) {
        boolean sopiiko = false;

        return sopiiko;
    }
    
    /**
     * Valitsee miehet, joita ei ole varattu avecina jollekin naiselle
     * @param kaikkiVieraat
     * @return 
     */
       private ArrayList<Vieras> listaaVapaatMiehet(ArrayList<Vieras> kaikkiVieraat) {
           ArrayList<Vieras> vapaatMiehet = new ArrayList();
           
           for(Vieras yksiVieras:kaikkiVieraat){
               if(yksiVieras.getSukupuoli() == Sukupuoli.MIES && yksiVieras.getAvec().equals("")){
                   vapaatMiehet.add(yksiVieras);
               }
           }
  
       
       

       return vapaatMiehet;
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
