package plaseeraus.logiikka;

import javax.swing.SwingUtilities;
import plaseeraus.alku.Aloittajat;
import plaseeraus.grafiikka.PoytienLisays;

public class Main {

    public static void main(String[] args) {
        
        
       
        //Aloitus
        Aloittajat aloittajat = new Aloittajat();
        
        PoytienLisays kayttoliittyma = new PoytienLisays(aloittajat.getPoytaLista());
        SwingUtilities.invokeLater(kayttoliittyma);
        
    }
//      
////        
//
//        //Luodaan pöytä 6:lle ja 4:lle
//        PoytaLista poydat = new PoytaLista();
//        poydat.lisaaPoyta(6);
//        poydat.lisaaPoyta(4);
//        
//        
//        Plaseeraaja plassaaja = new Plaseeraaja();
//        
//        
//
//        System.out.println("PLASEERATAAN 2 PÖYTÄÄ");
//        System.out.println("");
//        
//        ArrayList<Poyta> lista = poydat.annaPoytalista();
//        int poytaNro = 0;
//        for(Poyta poyta : lista){
//            System.out.println(poydat.tulostaListaltaPoytaNro(poytaNro));
//            
//            plassaaja.plaseeraa(poyta);
//            System.out.println("Pöydässä istuvat:");
//            plassaaja.tulostaIstujat(poyta);
//            System.out.println("");
//            
//            poytaNro++;
//        }
//
////        
//
//    }

}
