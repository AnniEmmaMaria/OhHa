package Vieraslistatiedosto;

public class vieras {
    private String etunimi;
    private String sukunimi;
    private String sukupuoli;
    
    public vieras (String etunimi, String sukunimi, String sukupuoli){
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
    
}
