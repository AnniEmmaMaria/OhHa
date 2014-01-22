package plaseeraus.logiikka.vieraidenMaaritys;

public class Vieras {
    private String etunimi;
    private String sukunimi;
    private char sukupuoli;
    
    public Vieras (String etunimi, String sukunimi, char sukupuoli){
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
    public char getSukupuoli(){
        return this.sukupuoli;
    }
    //toString vieraan nimen tulostukseen
    @Override
    public String toString(){
        return etunimi + " " + sukunimi;
    }
    
    //HashMapia varten vieras yksilöidään EtunimiSukunimi -tyylisellä avaimella
    public String luoYksiloivaAvain(){
        return this.etunimi + this.sukunimi;
    }
}
