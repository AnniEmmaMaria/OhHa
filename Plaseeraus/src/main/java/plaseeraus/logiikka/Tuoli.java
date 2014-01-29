package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;

public class Tuoli {
    private boolean vapaa;
    private Vieras istuja;
    
    public Tuoli(){
        this.vapaa = true;
        this.istuja = null;       
    }
    

    //TUOLIN NYKYTILANTEEN KYSELYT
    
    public boolean getVapaa(){
        return this.vapaa;
    }
    
    public Vieras getIstuja(){
        return istuja;
    }
    
    
    //Tuoli ottaa istujan ja muuttuu varatuksi
    public void otaIstuja(Vieras istuja){
        this.istuja = istuja;
        this.vapaa = false;
    }
    
    @Override
    public String toString(){
        return "Tuoli on vapaa (" + vapaa + ") ";
    } 
          
    
}
