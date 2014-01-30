package plaseeraus.logiikka;

public class Vieras {
    private String etunimi;
    private String sukunimi;
    private char sukupuoli;
    private boolean plaseerattu;
    private Vieras avec;
    
    public Vieras (String etunimi, String sukunimi, char sukupuoli, Vieras avec){
        this.etunimi = etunimi;
        this.sukunimi = sukunimi;
        this.sukupuoli = sukupuoli;
        this.plaseerattu = false;
        this.avec = null;
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
    
    //Vieras muuttuu plaseeratuksi
    public void plaseeraa(){
        this.plaseerattu = true;
    }
    
    
}
