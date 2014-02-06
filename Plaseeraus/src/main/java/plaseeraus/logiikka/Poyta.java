package plaseeraus.logiikka;

import java.util.ArrayList;

public class Poyta {
    private final int tuolimaara;
    private final int moneskoSalissa;
    private final ArrayList<Tuoli> tuolit;
    
    public Poyta(int tuolimaara, int moneskoSalissa){
        this.tuolimaara = tuolimaara;
        this.moneskoSalissa = moneskoSalissa;
        this.tuolit = new ArrayList<>();
        
    }
    
    //getterit pöydän tietojen hakuun
    public int getTuolimaara(){
        return this.tuolimaara;
    }
    public int getPoydanNumero(){
        return this.moneskoSalissa;
    }
 
    //Luodaan kaikki pöydän sivuilla olevat tuolit listaksi
    public void luoTuolit(){
        for(int tuoliNro = 1; tuoliNro <= this.tuolimaara; tuoliNro++){
               Tuoli uusiTuoli = new Tuoli();
               this.tuolit.add(uusiTuoli);
        }
    }
    
    
    //Yksittäisen tuolin tietojen hakeminen
    public Tuoli getTuoli(int tuolinNro){
        return this.tuolit.get(tuolinNro);
    }
    //Kaikkien tuolien listan hakeminen
    public ArrayList<Tuoli> getTuolilista(){
        return this.tuolit;
    }
    
    @Override
    public String toString(){
        return "Pöydässä nro " + this.moneskoSalissa + " on " + this.tuolimaara + " tuolia.";
    }
}
