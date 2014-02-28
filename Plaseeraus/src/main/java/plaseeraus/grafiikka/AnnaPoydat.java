/*
 * Ensimm�inen ilmestyv� ruutu, jossa k�ytt�j� antaa p�ytien koot
 */
package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.PoytaLista;

/**
 * Luodaan JFrame p�ytien antamiseen ja tuodaan toistaiseksi tyhj� PoytaLista,
 * johon annetut p�yd�t lis�t��n
 */
public class AnnaPoydat implements Runnable {
    JFrame ruutu;
    PoytaLista poytaLista;

    public AnnaPoydat(PoytaLista poytaLista) {
        this.poytaLista = poytaLista;

    }

    /**
     * Aloitusruudun pohja otsikolla "Määritä juhlatilan pöydät"
     */
    @Override
    public void run() {
        ruutu = new JFrame("M��rit� juhlatilan p�yd�t");
        ruutu.setPreferredSize(new Dimension(600, 500));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoRakenne(ruutu.getContentPane());

        ruutu.pack();
        ruutu.setVisible(true);
    }

    /**
     * Luodaan perusrakenne ruudulle. 3 riviä, 1 sarake
     *
     * @param container
     */
    public void luoRakenne(Container container) {
        GridLayout ruudunOsat = new GridLayout(3,1);
        container.setLayout(ruudunOsat);

        container.add(Kysymys());
        container.add(maaritaPoyta());
        container.add(PlaseerauksenAloitusNappi());

    }
    
    /**
     * Kaksi tekstiosaa päällekkäin
     * @return Kysymys "Anna pöydät" ja tarkemmat ohjeet tähän
     */
     private JPanel Kysymys() {
        JPanel paneeli = new JPanel(new GridLayout(2, 1));

        //Itse kysymys JLabelina isommalla fontilla
        JLabel kysymys = new JLabel(" Anna p�yd�n tuolien m��r�");
        kysymys.setFont(new Font("Arial", 8, 20));
        paneeli.add(kysymys);

        //Vastausohjeet usealle riville jaettuna
        String tarkennusteksti = "<HTML> Kirjoita kokonaislukuna, montako tuolia p�yd�ss� on. P�yd�n on oltava suorakulmainen ja tuolien sen kahdella sivulla. Tuolien lukum��r�n tulee olla parillinen ja v�hint��n 2</HTML>";
        JLabel tarkennus = new JLabel(tarkennusteksti);
        paneeli.add(tarkennus);

        return paneeli;
    }

     
    /**
     * Sisältää myös tapahtumakuuntelijan PoydanTekija
     *
     * @return vastauskentän ja lisäysnapin sisältävä rivi
     */
    public JPanel maaritaPoyta() {
        JPanel paneeli = new JPanel(new GridBagLayout());
        
        //Vasen: Vastauskenttä (tuolimäärälle) teksteineen
        JLabel seuraavassaPoydassa = new JLabel("Seuraavassa p�yd�ss� on ");
        JTextArea vastauskentta = new JTextArea(1, 3);
        JLabel istumapaikkaa = new JLabel(" istumapaikkaa");

        paneeli.add(seuraavassaPoydassa);
        paneeli.add(vastauskentta);
        paneeli.add(istumapaikkaa);

        //Oikea: Lisää pöytä -nappula ja tyhjät reunat ympärillä
        JLabel tyhja = new JLabel("         ");
        JButton LisaaPoyta = new JButton("Lis�� annettu p�yt�");
        LisaaPoyta.addActionListener(new PoydanTekija(poytaLista, vastauskentta, 8));

        paneeli.add(tyhja);
        paneeli.add(LisaaPoyta);
        
        return paneeli;
    }
    
    public JPanel Tilastot(){
        JPanel paneeli = new JPanel(new GridBagLayout());
        
        
        return paneeli;
    }

    public JPanel PlaseerauksenAloitusNappi() {
        JPanel paneeli = new JPanel(new GridLayout(3, 3));

        JButton kaikkiPoydatAnnettu = new JButton("Kaikki p�yd�t annettu");
        kaikkiPoydatAnnettu.addActionListener(new PlaseeraamisenKaynnistys(poytaLista));

        paneeli.add(new JLabel());
        paneeli.add(kaikkiPoydatAnnettu);
        paneeli.add(new JLabel());

        return paneeli;
    }
}
