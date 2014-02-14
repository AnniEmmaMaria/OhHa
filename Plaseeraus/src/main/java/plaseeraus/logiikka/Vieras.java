package plaseeraus.logiikka;

public class Vieras {
    private final String etunimi;
    private final String sukunimi;
    private final Sukupuoli sukupuoli;
    private boolean plaseerattu;
    private final String avec;
    
    public Vieras (String etunimi, String sukunimi, Sukupuoli sukupuoli, String avec){
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sukupuoli = sukupuoli;
        this.plaseerattu = false;
        this.avec = avec;
    }
    
    //getterit nimi-, sukupuoli- ja avectiedoille
    public String getEtunimi(){
        return this.etunimi;
    }
    public String getSukunimi(){
        return this.sukunimi;
    }  
    public Sukupuoli getSukupuoli(){
        return this.sukupuoli;
    }
    public String getAvec(){
        return this.avec;
    }
    
    /**
     * toString palauttaa vain vieraan nimen
     * @return 
     */
    @Override
    public String toString(){
        return etunimi + " " + sukunimi;
    }
    
    /**
     * Onko tälle vieraalle jo määrätty tuoli
     * @return true jo plaseeratuille vieraille
     */
    public boolean onkoPlaseerattu(){
        return this.plaseerattu;
    }
    
    /**
     * Muuttaa vieraan statuksen plaseeratuksi
     */
    public void plaseeraa(){
        this.plaseerattu = true;
    }
    
    
}
