package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Poyta;

public class PoytienLuoja implements ActionListener {

    private final JTextArea vastausKentta;
    private final PoytaLista poytalista;
    private final JTextField poytaTilasto;
    private final JTextField tuoliTilasto;
    private final ArrayList<JLabel> poydatTeksteina;

    public PoytienLuoja(JTextArea vastausKentta, PoytaLista poytalista, JTextField poytaTilastoKentta, JTextField tuolienSumma, ArrayList<JLabel> poydatTeksteina) {
        this.vastausKentta = vastausKentta;
        this.poytalista = poytalista;
        this.poytaTilasto = poytaTilastoKentta;
        this.tuoliTilasto = tuolienSumma;
        this.poydatTeksteina = null;
    }

    /**
     * Kaivetaan integeriksi vastauskentän numero Tehdään tämän kokoinen uusi
     * Poyta Tehdään String kaikista pöydistä Näytetään kaikki juhlien poydät ja
     * tuolien yhteismäärä
     *
     * @param e
     * @return
     */
    public void actionPerformed(ActionEvent e) {

        //Tongitaan annetun pöydän tuolimäärä
        int tuolimaara = 0;
        try {
            tuolimaara = Integer.parseInt(this.vastausKentta.getText());
        } catch (NumberFormatException e1) {
            Virheilmoitus virheRuutu = new Virheilmoitus("Tuolimääräksi ei annettu sopivaa lukua");
            SwingUtilities.invokeLater(virheRuutu);
        }

//        this.vastausKentta.setText("");
        //Luodaan tiedosta uusi pöytä
        poytalista.lisaaPoyta(tuolimaara);

        //LUODAAN UUSI JLABEL listaan
        JLabel uusiPoyta = new JLabel("Pöytä " + tuolimaara + ":lle vieraalle");
        this.poydatTeksteina.add(uusiPoyta);

        //Kasataan String, jossa on luodut pöydät allekkain
        String tilasto = "";
        int tuolienSumma = 0;
        for (Poyta yksiPoyta : this.poytalista.getPoytalista()) {
            tilasto = tilasto + yksiPoyta.toString() + "\n";

            tuolienSumma = tuolienSumma + yksiPoyta.getTuolimaara();
        }

        this.poytaTilasto.setText(tilasto);
        this.tuoliTilasto.setText("" + tuolienSumma);
    }

}
