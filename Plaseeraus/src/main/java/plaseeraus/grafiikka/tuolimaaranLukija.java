package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

public class tuolimaaranLukija implements ActionListener{
    private JTextField maaraKentta;
    
    public tuolimaaranLukija(JTextField maaraKentta){
        this.maaraKentta = maaraKentta;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tuolimaara = Integer.parseInt(this.maaraKentta.getText());
        System.out.println("tuoleja on: " + tuolimaara);
    }
    
}
