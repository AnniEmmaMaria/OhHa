package plaseeraus.logiikka;

import java.util.ArrayList;
import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;
import plaseeraus.logiikka.vieraidenMaaritys.VieraslistanLukija;

public class Plaseeraaja{
    
    
    
    //OTA VIERAAT ARRAYLISTANA
    private ArrayList<Vieras> annaVieraslista(){
        //Lue vieraslista.txt uudella VieraslistanLukijalla
        VieraslistanLukija lukija = new VieraslistanLukija();
        lukija.luoRiveistaOliotListaksi();
        
        return lukija.getVieraslista().getVieraslista();
    }
        
        
        
    
//    public void plaseeraa(Poyta poyta){
//        ArrayList<Tuoli> tuolilista = poyta.getTuolilista();
//        
//        
//        //Käydään pöydän tuolit yksi kerrallaan ja asetetaan istujat niille
//        for(int tuoliNro = 0; tuoliNro < poyta.getTuolimaara(); tuoliNro++){
//            
//            //Listataan ne, jotka saavat istua vuorossa olevalla tuolilla
//            ArrayList<Vieras> sallitutIstujat = new ArrayList<Vieras>();
//            //for (Vieras vieraat:this.vieraslista){
//                
//                
//            
////            Char istujanSukupuoli
////
////            //parillisille tuoleille istutetaan mies
////            if(tuoliNro % 2 == 0){
////                
//            }
//            
            
       
        
    
    
    public static void arvoIstuja(){
        
    }
}
