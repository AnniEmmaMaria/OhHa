package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.PoytaLista;

/**
 * Ensimmäinen esiintuleva ruutu, jossa käyttäjä antaa juhlien pöytien koot
 * Samalla otetaan mukaan myös toistaiseksi tyhjä PoytaLista, johon pöydät tallennetaan
 * @author Anni Jokiniemi
 */
public class AnnaPoyta implements Runnable{
    
    private JFrame ruutu;
    private final PoytaLista poytalista;

    public AnnaPoyta (PoytaLista tyhjaPoytalista) {
        this.poytalista = tyhjaPoytalista;
    }

    /**
     * Luodaan Pohja "Määritä juhlatilan pöydät" -nimiselle ruudulle
     */
    @Override
    public void run() {
        ruutu = new JFrame("Määritä juhlatilan pöydät");
        ruutu.setPreferredSize(new Dimension(700, 700));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ruutu.getContentPane());

        ruutu.pack();
        ruutu.setVisible(true); }
    
    
    public void luoKomponentit(Container container){
        
    }
    
}
