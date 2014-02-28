/*
 * Tapahtumakuuntelija kuuntelee annetun pöydän tuolimäärän ja luo kyseisen pöydän
 */
package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import plaseeraus.logiikka.PoytaLista;

/**
 * Kuuntelee vastauskentästä tuolimäärän ja lisää sen pöytälistaan
 * @author ajokinie@cs
 */
public class PoydanTekija implements ActionListener {
    private final PoytaLista poytalista;
    private final JTextArea vastausKentta;
    private final int tuolejaYht;

    public PoydanTekija(PoytaLista poytalista, JTextArea vastauskentta, int tuolejaYht) {
        this.poytalista = poytalista;
        this.vastausKentta = vastauskentta;
        this.tuolejaYht = tuolejaYht;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
                
        //Tongitaan annetun pöydän tuolimäärä
        int tuolimaara = 0;
        try{
            tuolimaara = Integer.parseInt(this.vastausKentta.getText());
        }catch(NumberFormatException e1){
            Virheilmoitus virheRuutu = new Virheilmoitus("Tuolim��r�ksi ei annettu sopivaa lukua");
            SwingUtilities.invokeLater(virheRuutu);
        }
        
        //Luodaan tiedosta uusi pöytä ja tyhjennetään vastauskenttä
        this.poytalista.lisaaPoyta(tuolimaara);
        this.vastausKentta.setText("");
        
        //Luodaan ruutu
        PoytaTilasto poytatilastoRuutu = new PoytaTilasto(poytalista);
        SwingUtilities.invokeLater(poytatilastoRuutu);
       

    }

}
