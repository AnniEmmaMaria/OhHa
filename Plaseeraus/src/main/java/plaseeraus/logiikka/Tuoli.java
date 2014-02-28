package plaseeraus.logiikka;

/**
 * Tuoli liitty aina yhteen pöytään ja Vieras on sen kautta pöydässä
 * @author Anni Jokiniemi
 */
public class Tuoli {
    private Vieras istuja;
    
    public Tuoli(){
        this.istuja = null;       
    }


    public Vieras getIstuja(){
        return this.istuja;
    }       
    
    /**
     * @return tuolissa istuvan vieraan toString
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
