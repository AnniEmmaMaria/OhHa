package plaseeraus.logiikka;

import java.util.ArrayList;
import java.util.Random;

public class Plaseeraaja {
    private final VieraslistanLukija lukija;
    private final Random arpoja;

    public Plaseeraaja() {
        this.lukija = new VieraslistanLukija();
        this.arpoja = new Random();
    }

    
    /**
     * Plaseeraa vieraslistalta vieraat annettuun pöytään
     * @param poyta jonka tuoleille valitaan vieraat istumaan 
     */
    
    public void plaseeraa(Poyta poyta) {
        int koko = poyta.getTuolimaara();

        //Tuoli kerrallaan
        for (int tuolinInd = 0; tuolinInd < koko; tuolinInd++) {
            //määritetään sallitut istujat
            ArrayList<Vieras> sallitutIstujat = listaaSallitutVieraat(tuolinInd);
            //Arvotaan heistä yksi
            Vieras valittuIstuja = arvoIstuja(sallitutIstujat);
            //Istutetaan valittu tuolille
            poyta.getTuoli(tuolinInd).otaIstuja(valittuIstuja);  
        }
    }
        
    
    /**
     * Valitsee alkuperäiseltä vieraslistalta uudeksi listaksi ne vieraat, 
     * joiden sallitaan istua tälletuolille
     * @param tuolinInd plaseerausvuorossa olevan tuolin numero (0,1,..)
     * @return karsittu vieraslista
     */
    private ArrayList<Vieras> listaaSallitutVieraat(int tuolinInd) {
        
        ArrayList<Vieras> sallitutIstujat = new ArrayList<>();
        ArrayList<Vieras> kaikkiVieraat = annaVieraslista();

        //Käydään kaikki vieraat sis. lista läpi ja poimitaan sopivat vieraat
        for (Vieras vieras : kaikkiVieraat) {
            
            //Vain paikattomat vieraat kelpaavat
            if (vieras.onkoPlaseerattu() == false) {
                
                //mies parillisille tuoleille
                if (tuolinInd % 2 == 0 && vieras.getSukupuoli() == Sukupuoli.MIES) {
                    sallitutIstujat.add(vieras);
                }else if(tuolinInd % 2 != 0 && vieras.getSukupuoli() == Sukupuoli.NAINEN){
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
    
    //Ota Vieras-oliot sisältävä ArrayList "Vieraslista" lukijalla
    public ArrayList<Vieras> annaVieraslista() {
        //Luodaan VieraslistanLukijassa ArrayListin sisältö ja otetaan lista ulos
        lukija.luoTekstistaOliotListaksi();
        
        return lukija.getVieraslista();
    }
    
//    //Tulostaa pöydän istujat
//    public void tulostaIstujat(Poyta poyta){
//        ArrayList<Tuoli> tuolit = poyta.getTuolilista();
//        
//        for(Tuoli tuoli:tuolit){
//            System.out.println(tuoli);
//            
//        }
    }
    
