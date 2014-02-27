package plaseeraus.logiikka;

import javax.swing.SwingUtilities;
import plaseeraus.grafiikka.AnnaPoydat;

public class Main {

    public static void main(String[] args) {

        /**
         * Luodaan näiden juhlien pöytälista tyhjänä
         */
        PoytaLista poytalista = new PoytaLista();
        
        /**
         * Antaa ensimmäisen ruudun, jossa annetaan juhlien pöydät
         */
        AnnaPoydat annaPoydat = new AnnaPoydat(poytalista);
        SwingUtilities.invokeLater(annaPoydat);

    }
}
