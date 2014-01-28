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
 

    
//    //MÄÄRITETÄÄN PÖYDÄN SIVUJEN TUOLIT. NIITÄ ON tuolimäärä/2 KAPPALETTA
//    //Vasemmalla puolella ensimmäisessä tuolissa istuu nainen
//    public ArrayList<Tuoli> laitaVasemmalleSivulleTuolit(){
//        for(int i = 0; i < tuolimaara/2; i++){
//            
//            //Parittomilla tuoleilla on naisille paikat
//            if(1‰2 == 0){
//            
//        }
//            luoTuoli('')
//        }
//        return null;
//    }
    
    private Tuoli luoTuoli(char istujanSukupuoli, int monesko){
        return new Tuoli(istujanSukupuoli, monesko);
    }
    
}
