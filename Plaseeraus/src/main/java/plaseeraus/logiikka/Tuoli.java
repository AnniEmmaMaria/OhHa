package plaseeraus.logiikka;

import plaseeraus.logiikka.vieraidenMaaritys.Vieras;

public class Tuoli {
    private Vieras istuja;
    
    public Tuoli(){
        this.istuja = null;       
    }
    

    //Kuka tuolissa istuu? Kenties null?
    public Vieras getIstuja(){
        return this.istuja;
    }
    
    
    //Tuoli ottaa istujan
    public void otaIstuja(Vieras istuja){
        this.istuja = istuja;
        istuja.plaseeraa();
    }
    
    @Override
    public String toString(){
        return "Tuolissa istuu " + this.istuja;
    } 
          
    
}
