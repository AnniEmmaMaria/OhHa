package plaseeraus.logiikka.vieraidenMaaritys;

import java.util.ArrayList;

public class Vieraslista {

    private ArrayList<Vieras> kaikki;   //Lista sisältää kaikki vieraat

    public Vieraslista() {
        this.kaikki = new ArrayList<>();
    }

    //Lisätään vieras listaan
    public void lisaaVierasListalle(Vieras uusiVieras) {
        kaikki.add(uusiVieras);
    }
    
    //Tulostetaan kaikkien vieraiden nimet
    public void tulostaVieraidenNimet(){
        for(Vieras yksiVieras:kaikki){
            System.out.println(yksiVieras.toString());
        }
    }

    //Montako vierasta on tulossa yhteensä
    public Integer vierasmaara(){
        return kaikki.size();
    }
}
