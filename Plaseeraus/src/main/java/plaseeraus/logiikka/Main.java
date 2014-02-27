package plaseeraus.logiikka;

import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.annaPoydat;

public class Main {

    public static void main(String[] args) {

        /**
         * Luodaan näiden juhlien pöytälista tyhjänä
         */
        PoytaLista poytalista = new PoytaLista();
        
        /**
         * Antaa ensimmäisen ruudun, jossa annetaan juhlien pöydät
         */
        annaPoydat poytienAnto = new annaPoydat(poytalista);
        SwingUtilities.invokeLater(poytienAnto);

    }
}
