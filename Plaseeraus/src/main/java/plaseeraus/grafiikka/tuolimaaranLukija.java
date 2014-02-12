package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import plaseeraus.logiikka.PoytaLista;

public class tuolimaaranLukija implements ActionListener{
    private final JTextArea vastausKentta;
    private PoytaLista poytalista;
    private JTextField tilastoKentta;
    
    public tuolimaaranLukija(JTextArea vastausKentta, PoytaLista poytalista, JTextField poytaTilastoKentta){
        this.vastausKentta = vastausKentta;
        this.poytalista = poytalista;
        this.tilastoKentta = poytaTilastoKentta;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Tongitaan annetun pöydän tuolimäärä
        int tuolimaara = Integer.parseInt(this.vastausKentta.getText());
        this.vastausKentta.setText("");
        //Luodaan tiedosta uusi pöytä
        poytalista.lisaaPoyta(tuolimaara);
        this.tilastoKentta.setText("kukkuu");
        System.out.println("Lisäsi pöydän");
    }
    
}
