/*
 * Tilastoi erilliseen ruutuun annetut pöydät aina uuden pöydän annon yhteydessä
 */

package plaseeraus.grafiikka;

import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

/**
 *
 * @author ajokinie@cs
 */
public class PoytaTilasto implements Runnable{
    JFrame ruutu;
    
    public PoytaTilasto(){
        
    }

    @Override
    public void run() {
        ruutu = new JFrame("Annetut pöydät");
        ruutu.setPreferredSize(new Dimension(100, 100));
        ruutu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ruutu.setLocation(1000, 10);
        
        ruutu.pack();
        ruutu.setVisible(true);
        
    }
    
    public void luoRakenne(){
        
    }
            
}
