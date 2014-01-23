package plaseeraus.logiikka.vieraidenMaaritys;

import java.util.HashMap;


public class KaikkiVieraat {
    private HashMap<String, Vieras> kaikki;
    
    public KaikkiVieraat(){
        this.kaikki = null;
    }
    
    //Lisätään vieras listaan etunimiSukunimi avaimensa kanssa
    public void lisaaVierasListaan(Vieras uusiVieras){
        String avain = uusiVieras.luoYksiloivaAvain();
        kaikki.put(avain, uusiVieras);
        
    }

    }
}
