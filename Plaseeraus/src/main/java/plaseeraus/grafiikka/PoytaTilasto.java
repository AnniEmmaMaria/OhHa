/*
 * Tilastoi erilliseen ruutuun annetut pöydät aina uuden pÃ¶ydÃ¤n annon yhteydessÃ¤
 */

package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.PoytaLista;

/**
 *
 * @author ajokinie@cs
 */
public class PoytaTilasto implements Runnable{
    JFrame ruutu;
    PoytaLista poytalista;
    
    public PoytaTilasto(PoytaLista poytalista){
        this.poytalista = poytalista;
        
    }

    @Override
    public void run() {
        ruutu = new JFrame("Annetut pöydät");
        ruutu.setPreferredSize(new Dimension(400, 100));
        ruutu.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ruutu.setLocation(700, 10);
        luoRakenne(ruutu.getContentPane());
        
        ruutu.pack();
        ruutu.setVisible(true);
        
    }
    
    public void luoRakenne(Container container){
        GridLayout ruudunOsat = new GridLayout(2, 2);
        container.setLayout(ruudunOsat);
        
        int poytienLkm = this.poytalista.getPoytalista().size();
        int tuolienLkm = 0;
        for(Poyta yksiPoyta:this.poytalista.getPoytalista()){
            tuolienLkm = tuolienLkm + yksiPoyta.getTuolimaara();
        }
        
        container.add(new JLabel("Lisätty: "));
        container.add(new JLabel(poytalista.tulostaListaltaPoytaNro(poytienLkm-1)));
        container.add(new JLabel("Paikkoja (yht) tähän mennessä: "));
        container.add(new JLabel("" + tuolienLkm));
        
    }
            
}
