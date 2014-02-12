package plaseeraus.logiikka;

import java.util.ArrayList;

public class Poyta {
    private final int tuolimaara;
    private final ArrayList<Tuoli> tuolit;
    
    public Poyta(int tuolimaara){
        this.tuolimaara = tuolimaara;
        this.tuolit = new ArrayList<>();
        
    }
    
    //getterit pöydän tietojen hakuun
    public int getTuolimaara(){
        return this.tuolimaara;
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
        Tuoli penkki = this.tuolit.get(tuolinNro);
        return penkki;
    }
    //Kaikkien tuolien listan hakeminen
    public ArrayList<Tuoli> getTuolilista(){
        return this.tuolit;
    }
    
    @Override
    public String toString(){
        return this.tuolimaara + " tuolin pöytä";
    }
}
