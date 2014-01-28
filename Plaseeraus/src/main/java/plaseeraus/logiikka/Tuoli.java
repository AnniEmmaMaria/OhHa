package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;

public class Tuoli {
    private boolean vapaa;
    private char kenelle;       // mies tai nainen
    private int moneskoSivulla; //monesko tuoli on pöydän sillä sivulla
    private Vieras istuja;
    
    public Tuoli(char istujanSukupuoli, int monesko){
        this.vapaa = true;
        this.kenelle = istujanSukupuoli;
        this.moneskoSivulla = monesko;
        this.istuja = null;       
    }
    
    public boolean onkoVapaa(){
        return this.vapaa;
    }
    
    //Kuka istuu tässä
    public Vieras kukaIstuu(){
        return istuja;
    }
    
    //Tuoli ottaa istujan ja muuttuu varatuksi
    public void otaIstuja(Vieras istuja){
        this.istuja = istuja;
        this.vapaa = false;
    }
    
}
