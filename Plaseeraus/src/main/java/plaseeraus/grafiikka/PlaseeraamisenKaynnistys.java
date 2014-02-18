package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;
import plaseeraus.logiikka.Plaseeraaja;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.Vieras;

public class PlaseeraamisenKaynnistys implements ActionListener{
    private final PoytaLista poytalista;
    
    public PlaseeraamisenKaynnistys(PoytaLista poytalista){
        this.poytalista = poytalista;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        Plaseeraaja plaseeraaja = new Plaseeraaja();

        //Käydään pöytälista läpi plaseeraten pöydät
        for(Poyta yksiPoyta : this.poytalista.getPoytalista()){
            plaseeraaja.plaseeraa(yksiPoyta);

//            for (Vieras yksiIstuja : yksiPoyta.getIstujat()){
//                System.out.println(yksiIstuja);
//            }
//            System.out.println("");
        }
        
        /**
         * Piirretään pöytäkartta käyttäjälle Tilapiirros-framena
         */
        Tilapiirros poytakartta = new Tilapiirros(this.poytalista);
        SwingUtilities.invokeLater(poytakartta);
        
        
    }
    
    
}
