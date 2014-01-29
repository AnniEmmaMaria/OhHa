package plaseeraus.logiikka;

import java.util.ArrayList;

public class Poyta {
    private int tuolimaara;
    private int moneskoSalissa;
    private ArrayList<Tuoli> tuolit;
    
    public Poyta(int tuolimaara, int moneskoSalissa){
        this.tuolimaara = tuolimaara;
        this.moneskoSalissa = moneskoSalissa;
        this.tuolit = new ArrayList<Tuoli>();
        
    }
    
    //getterit pöydän tietojen hakuun
    public int getTuolimaara(){
        return this.tuolimaara;
    }
    public int getPoydanNumero(){
        return this.moneskoSalissa;
    }
 
    public void luoTuolit(){
        Tuoli uusiTuoli = null;
        char istujanSukupuoli = 'x';
        int tuolinNro = 1;                //Ensimmäinen tuoli on nro 1
        
        while(tuolinNro <= this.tuolimaara){
            //Parittomille tuoleille miehiä, parillisille naisia
            if(tuolinNro % 2 != 0){     
                istujanSukupuoli = 'm';
            }else{
                istujanSukupuoli = 'n';
            }
            
            //Luodaan näillä uusi tuoli ja lisätään se pöytään
            uusiTuoli = luoTuoli(istujanSukupuoli, tuolinNro);
            this.tuolit.add(uusiTuoli);
            
            tuolinNro++;
        }
    }
    
    //Yksittäisen tuolin luominen
    private Tuoli luoTuoli(char istujanSukupuoli, int monesko){
        return new Tuoli(istujanSukupuoli, monesko);
    }
    
    //Yksittäisen tuolin tietojen hakeminen
    public Tuoli getTuoli(int tuolinNro){
        return this.tuolit.get(tuolinNro - 1);
    }
}
