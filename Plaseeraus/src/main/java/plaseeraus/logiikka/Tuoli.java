package plaseeraus.logiikka;

public class Tuoli {
    private Vieras istuja;
    
    public Tuoli(){
        this.istuja = null;       
    }
    
    

    public Vieras getIstuja(){
        return this.istuja;
    }     
    /**
     * Tuolin toString palauttaa siinä istuvan vieraan toStringin
     * @return 
     */
    @Override
    public String toString(){
        return this.istuja.toString();
    }
    
    
    /**
     * Asettaa tuoliin Vieras-olion istumaan
     * @param istuja = istujaksi valittu vieras
     */
    public void otaIstuja(Vieras istuja){
        this.istuja = istuja;
        istuja.plaseeraa();
    }
 
          
    
}
