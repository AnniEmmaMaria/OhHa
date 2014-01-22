package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;

public class Tuoli {
    private boolean vapaa;
    private String kenelle;
    private Vieras istuja;
    
    public Tuoli(){
        this.vapaa = true;
        this.kenelle = null;
        this.istuja = null;       
    }
    
    public boolean onkoVapaa(){
        return this.vapaa;
    }
    
}
