package plaseeraus.logiikka;

import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.PoytienAnto;
import plaseeraus.grafiikka.Tilapiirros;

public class Main {

    public static void main(String[] args) {
        /**
         * Luodaan näiden juhlien pöytälista tyhjänä
         */
        PoytaLista poytalista = new PoytaLista();
        
        /**
         * Antaa ensimmäisen ruudun, jossa annetaan juhlien pöydät
         */
        PoytienAnto poytienAnto = new PoytienAnto(poytalista);
        SwingUtilities.invokeLater(poytienAnto);
//        
//        Tilapiirros poytakartta = new Tilapiirros();
//        SwingUtilities.invokeLater(poytakartta);
 
        
    }
}
