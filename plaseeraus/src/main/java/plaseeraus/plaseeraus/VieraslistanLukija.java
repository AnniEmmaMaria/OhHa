package plaseeraus.plaseeraus;

import plaseeraus.plaseeraus.Vieras;
import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class VieraslistanLukija {
    //Määritetään luettava vieraslista ja sille lukija
    File vieraslista = new File("src\\main\\java\\Vieraslistatiedosto\\vieraslista.txt");
    //Scanner listanLukija = new Scanner(vieraslista);
    
    //Metodi tekee yhdestä vieraslistan rivistä Vieras-olion
    public static void luoVierasOlio(){
        String etunimi = "Mato";
        String sukunimi = "Matala";
        String sukupuoli = "m";
        
        Vieras uusiVieras = new Vieras(etunimi, sukunimi, sukupuoli);
    }
    
    //Metodi lisää Vieras-olion ArrayListiin vieraista
    public static void lisaaListaan(Vieras uusiVieras){
    //Ensin pitää luoda naisille ja miehille ArrayListit (oikeasti muualla!!)
    ArrayList<Vieras> naiset = new ArrayList<>();
    ArrayList<Vieras> miehet = new ArrayList<>();
    
        if(uusiVieras.getSukupuoli().equals("n")){
            naiset.add(uusiVieras);
        }else{
            miehet.add(uusiVieras);
        }
    }
    
   
    
    
}
