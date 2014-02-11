package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class tuolimaaranLukija implements ActionListener{
    private final JTextField vastausKentta;
    private JTextArea tilastoKentta;
    
    public tuolimaaranLukija(JTextField vastausKentta, JTextArea tilastoKentta){
        this.vastausKentta = vastausKentta;
        this.tilastoKentta = tilastoKentta;
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int tuolimaara = Integer.parseInt(this.vastausKentta.getText());
        System.out.println("tuoleja on: " + tuolimaara);
    }
    
}
