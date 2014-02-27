/**
 * Tekee plaseeraustyön ja luo tuloksen pöytäkartan näyttävänä ruutuna
 */

package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import plaseeraus.logiikka.Plaseeraaja;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Poyta;

/**
 * Otetaan annetut pöydät sisältävä lista
 * @author ajokinie@cs
 */
public class PlaseeraamisenKaynnistys implements ActionListener{
    private final PoytaLista poytalista;
    
    public PlaseeraamisenKaynnistys(PoytaLista poytalista){
        this.poytalista = poytalista;
        
    }
    
    
    /**
     * Luotava Plaseeraaja hoitaa plaseeraustyön läpikäymällä pöytälistan
     * Luodaan pöytäkartan esittävä ruutu Tilapiirros
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        Plaseeraaja plaseeraaja = new Plaseeraaja();

        for(Poyta yksiPoyta : this.poytalista.getPoytalista()){
            plaseeraaja.plaseeraa(yksiPoyta);
        }
  
        Tilapiirros poytakartta = new Tilapiirros(this.poytalista);
        SwingUtilities.invokeLater(poytakartta);
    }
    
    
}
