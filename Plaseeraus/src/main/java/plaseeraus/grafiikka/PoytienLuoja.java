package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Poyta;

public class tuolimaaranLukija implements ActionListener{
    private final JTextArea vastausKentta;
    private PoytaLista poytalista;
    private JTextArea poytaTilasto;
    private JTextField tuoliTilasto;
    
    public tuolimaaranLukija(JTextArea vastausKentta, PoytaLista poytalista, JTextArea poytaTilastoKentta, JTextField tuolienSumma){
        this.vastausKentta = vastausKentta;
        this.poytalista = poytalista;
        this.poytaTilasto = poytaTilastoKentta;
        this.tuoliTilasto = tuolienSumma;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Tongitaan annetun pöydän tuolimäärä
        int tuolimaara = Integer.parseInt(this.vastausKentta.getText());
        this.vastausKentta.setText("");
        //Luodaan tiedosta uusi pöytä
        poytalista.lisaaPoyta(tuolimaara);
        
        //Kasataan String, jossa on luodut pöydät
        String tilasto = "";
        int tuolienSumma = 0;
        for(Poyta yksiPoyta : this.poytalista.annaPoytalista()){
            tilasto = tilasto + yksiPoyta.toString() + "\n";
            
            tuolienSumma = tuolienSumma + yksiPoyta.getTuolimaara();
        }
        
        this.poytaTilasto.setText(tilasto);
        this.tuoliTilasto.setText("" + tuolienSumma);
    }
    
}
