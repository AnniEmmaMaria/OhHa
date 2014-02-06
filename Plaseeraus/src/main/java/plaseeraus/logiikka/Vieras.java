package plaseeraus.logiikka;

public class Vieras {
    private String etunimi;
    private String sukunimi;
    private char sukupuoli;
    private boolean plaseerattu;
    private String avec;
    
    public Vieras (String etunimi, String sukunimi, char sukupuoli, String avec){
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
    public char getSukupuoli(){
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
