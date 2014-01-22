package plaseeraus.plaseeraus;

public class Vieras {
    private String etunimi;
    private String sukunimi;
    private String sukupuoli;
    
    public Vieras (String etunimi, String sukunimi, String sukupuoli){
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sukupuoli = sukupuoli;
    }
    
    //getterit nimi- ja sukupuolitiedoille
    public String getEtunimi(){
        return this.etunimi;
    }
    public String getSukunimi(){
        return this.sukunimi;
    }  
    public String getSukupuoli(){
        return this.sukupuoli;
    }
    //toString vieraan nimen tulostukseen
    @Override
    public String toString(){
        return etunimi + sukunimi;
    }
}
