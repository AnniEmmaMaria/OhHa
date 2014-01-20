package Vieraslistatiedosto;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class vieraslistanLukija {
    //Määritetään luettava vieraslista ja sille lukija
    File vieraslista = new File("src\\main\\java\\Vieraslistatiedosto\\vieraslista.txt");
    //Scanner listanLukija = new Scanner(vieraslista);
    
    //Metodi tekee yhdestä vieraslistan rivistä vieras-olion
    public static void luoVierasOlio(){
        String etunimi = "Mato";
        String sukunimi = "Matala";
        String sukupuoli = "m";
        
        vieras uusiVieras = new vieras(etunimi, sukunimi, sukupuoli);
    }
    
    //Metodi lisää vieras-olion ArrayListiin vieraista
    public static void lisaaListaan(vieras uusiVieras){
    //Ensin pitää luoda naisille ja miehille ArrayListit (oikeasti muualla!!)
    ArrayList<vieras> naiset = new ArrayList<>();
    ArrayList<vieras> miehet = new ArrayList<>();
    
        if(uusiVieras.getSukupuoli().equals("n")){
            naiset.add(uusiVieras);
        }else{
            miehet.add(uusiVieras);
        }
    }
    
   
    
    
}
