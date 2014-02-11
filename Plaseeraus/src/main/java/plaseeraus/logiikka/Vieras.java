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
    
    //getterit nimi- ja sukupuolitiedoille
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
    
    //toString vieraan nimen tulostukseen
    @Override
    public String toString(){
        return etunimi + " " + sukunimi;
    }
    
    //Kertoo onko tälle vieraalle jo määrätty tuoli
    public boolean onkoPlaseerattu(){
        return this.plaseerattu;
    }
    
    //Vieras muuttuu plaseeratuksi
    public void plaseeraa(){
        this.plaseerattu = true;
    }
    
    
}
