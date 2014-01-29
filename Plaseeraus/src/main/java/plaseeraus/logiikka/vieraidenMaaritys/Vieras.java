package plaseeraus.logiikka.vieraidenMaaritys;

public class Vieras {
    private String etunimi;
    private String sukunimi;
    private char sukupuoli;
    private boolean plaseerattu;
    
    public Vieras (String etunimi, String sukunimi, char sukupuoli){
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sukupuoli = sukupuoli;
        this.plaseerattu = false;
    }
    
    //getterit nimi- ja sukupuolitiedoille
    public String getEtunimi(){
        return this.etunimi;
    }
    public String getSukunimi(){
        return this.sukunimi;
    }  
    public char getSukupuoli(){
        return this.sukupuoli;
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
    
    
    
}
