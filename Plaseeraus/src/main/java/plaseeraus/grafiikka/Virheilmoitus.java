package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class Virheilmoitus implements Runnable{
    private JFrame ruutu;
    private final String virheteksti;
    
    public Virheilmoitus(String virheteksti){
        this.virheteksti = virheteksti;
    }

    @Override
    public void run() {
        ruutu = new JFrame("Virheilmoitus");
        ruutu.setPreferredSize(new Dimension(400, 150));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        
        kirjoitaVirheteksti(ruutu.getContentPane());
        
        ruutu.pack();
        ruutu.setVisible(true);
    }
    
    public void kirjoitaVirheteksti(Container container){
        JLabel virheTeksti = new JLabel(virheteksti);
        container.add(virheTeksti);
        
    }
    
}
