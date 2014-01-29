package plaseeraus.logiikka.vieraidenMaaritys;

import java.util.ArrayList;

public class Vieraslista {
    private ArrayList<Vieras> vieraslista;   //Lista sisältää kaikki vieraat

    public Vieraslista() {
        this.vieraslista = new ArrayList<>();
    }

    public ArrayList<Vieras> getVieraslista(){
        return this.vieraslista;
    }
    
    //Lisätään vieras listaan
    public void lisaaVierasListalle(Vieras uusiVieras) {
        vieraslista.add(uusiVieras);
    }
    
    //Tulostetaan kaikkien vieraiden nimet
    public void tulostaVieraidenNimet(){
        for(Vieras yksiVieras:vieraslista){
            System.out.println(yksiVieras.toString());
        }
    }

    //Montako vierasta on tulossa yhteensä
    public Integer vierasmaara(){
        return vieraslista.size();
    }
}
