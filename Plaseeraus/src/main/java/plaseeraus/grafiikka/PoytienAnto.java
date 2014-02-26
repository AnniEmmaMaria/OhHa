package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import plaseeraus.logiikka.PoytaLista;

//Käyttäjä määrittää tilan pöytien tuolimäärät
public class PoytienAnto implements Runnable {

    private JFrame ruutu;
    private final PoytaLista poytalista;

    public PoytienAnto(PoytaLista tyhjaPoytalista) {
        this.poytalista = tyhjaPoytalista;
    }

    @Override
    public void run() {
        ruutu = new JFrame("Määritä juhlatilan pöydät");
        ruutu.setPreferredSize(new Dimension(700, 700));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ruutu.getContentPane());

        ruutu.pack();
        ruutu.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        //Ruudussa on 3 osaa
        GridLayout osatRuudussa = new GridLayout(4, 1, 10, 10);
        container.setLayout(osatRuudussa);

        //Kysymys ja sen tarkennus
        container.add(Kysymys());
        //Kenttä vastauksen antamiseen. Jo luotujen pöytien listaaminen näkyville
        container.add(PoydanLisays());
        //Mitä seuraavaksi tehdään
        container.add(JatkamisNappula());
        //Tyhjää alareunaan
        container.add(new JLabel(""));

    }

    //Kerrotaan käyttäjälle, mitä pitää tehdä
    private JPanel Kysymys() {
        //Paneelissa on 2 tekstiä allekkain ja niille lisätään annetut marginaalit
        JPanel paneeli = new JPanel(new GridLayout(2, 1));
        Border marginaalit = new EmptyBorder(5, 10, 0, 10);

        //Itse kysymys JLabelina isommalla fontilla
        JLabel kysymys = new JLabel(" Anna pöydän tuolien määrä");
        kysymys.setFont(new Font("Arial", 8, 20));
        kysymys.setBorder(marginaalit);
        paneeli.add(kysymys);

        //Vastausohjeet usealle riville jaettuna
        String tarkennusteksti = "<HTML> Kirjoita kokonaislukuna, montako tuolia pöydässä on. Pöydän on oltava suorakulmainen ja tuolien sen kahdella sivulla. Tuolien lukumäärän tulee olla parillinen ja vähintään 2</HTML>";
        JLabel tarkennus = new JLabel(tarkennusteksti);
        tarkennus.setBorder(marginaalit);
        paneeli.add(tarkennus);

        return paneeli;
    }

    /**
     * Kentässä annetaan uuden pöydän koko Alle listataan annetut pöydät ja
     * pidetään kirjaa paikoista
     *
     * @return
     */
    public JPanel PoydanLisays() {
        JPanel paneeli = new JPanel(new GridLayout(2, 2, 50, 20));
        JPanel vasenYla = new JPanel(new GridBagLayout());
        JPanel oikeaKeski = new JPanel(new GridLayout(1, 3, 30, 20));
        JPanel vasenAla = new JPanel(new GridLayout(10, 2));

        //Vasen ylänurkka: rivissä kysymys, vastauskenttä ja vastauksen loppu
        JLabel seuraavassaPoydassa = new JLabel("Seuraavassa pöydässä on ");
        JTextArea vastauskentta = new JTextArea(1, 3);
        JLabel kplTuoleja = new JLabel(" kpl tuoleja");

        vasenYla.add(seuraavassaPoydassa);
        vasenYla.add(vastauskentta);
        vasenYla.add(kplTuoleja);

        //Alimmissa grideissä on paneeleina jo lisätyt pöydät ja tuolien summa
        JPanel poytaTilasto = new JPanel(new GridLayout());
        JPanel tuoliTilasto = new JPanel(new GridLayout());

        poytaTilasto.add(new JLabel("Tallennetut pöydät:          "));
        JTextField poydatListana = new JTextField();
        poytaTilasto.add(poydatListana);

        tuoliTilasto.add(new JLabel("Paikkoja yhteensä:       "));
        JTextField tuolienSumma = new JTextField();
        tuoliTilasto.add(tuolienSumma);

        //Oikea ylänurkka: nappula "Lisää pöytä"
        JButton uusiPoyta = new JButton("Lisää pöytä");
        JLabel poydanTiedot = new JLabel();
        ArrayList<JLabel> po = new ArrayList<>();
        uusiPoyta.addActionListener(new PoytienLuoja(vastauskentta, this.poytalista, poydatListana, tuolienSumma, po));

        //Vasen alanurkka: Lista lisätyistä pöydistä
        for (JLabel yhdenPoydanRivi : po) {
            vasenAla.add(yhdenPoydanRivi);
        }

        //Täytetään paneelin 4 lokeroa
        paneeli.add(vasenYla);       //vasen ylänurkka
        paneeli.add(vasenAla);      //oikea ylänurkka = tyhjä
        paneeli.add(new JLabel());      //vasen keskikohta = tyhjä
        paneeli.add(uusiPoyta);         //oikea keskikohta = nappula
        paneeli.add(poytaTilasto);      //vasen alanurkka = pöytätilasto
        paneeli.add(tuoliTilasto);      //oikea alanurkka = tuolitilasto

        return paneeli;
    }

    //Plaseerauksen aloittava nappula
    public JPanel JatkamisNappula() {
        JPanel paneeli = new JPanel(new GridLayout(1, 3, 20, 20));
        JButton kaikkiPoydatLisatty = new JButton("Kaikki pöydät lisätty");
        kaikkiPoydatLisatty.addActionListener(new PlaseeraamisenKaynnistys(this.poytalista));

        paneeli.add(new JLabel(""));
        paneeli.add(kaikkiPoydatLisatty);
        paneeli.add(new JLabel(""));

        return paneeli;
    }
}
