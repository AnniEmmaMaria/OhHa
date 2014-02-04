package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

//Käyttäjä määrittää tilan pöytien tuolimäärät
public class PoytienLisays implements Runnable{
    private JFrame ruutu;
    
    public PoytienLisays(){
    }

    @Override
    public void run() {
        ruutu = new JFrame("Määritä juhlatilan pöydät");
        ruutu.setPreferredSize(new Dimension(500, 500));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        luoKomponentit(ruutu.getContentPane());
        
        ruutu.pack();
        ruutu.setVisible(true);
    }
    
    private void luoKomponentit(Container container){
        //Kysymysasettelu
        JLabel kysymys = new JLabel("Anna pöydän tuolimäärä");
        JLabel tarkennusKysymykseen = new JLabel("(Kirjoita kokonaislukuna, montako tuolia pöydän ympärillä on. \n Pöydän on oltava suorakulmainen ja tuolien sen kahdella sivulla. Tuolien lukumäärän tulee olla parillinen ja vähintään 2)");
                
        container.add(kysymys);
        //container.add(tarkennusKysymykseen);
        
    }
}
