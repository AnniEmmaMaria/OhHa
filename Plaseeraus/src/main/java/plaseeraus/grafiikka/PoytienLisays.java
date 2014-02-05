package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import sun.awt.X11.XConstants;

//Käyttäjä määrittää tilan pöytien tuolimäärät
public class PoytienLisays implements Runnable {

    private JFrame ruutu;

    public PoytienLisays() {
    }

    @Override
    public void run() {
        ruutu = new JFrame("Määritä juhlatilan pöydät");
        ruutu.setPreferredSize(new Dimension(600, 700));
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        luoKomponentit(ruutu.getContentPane());

        ruutu.pack();
        ruutu.setVisible(true);
    }

    private void luoKomponentit(Container container) {
        //Ruudussa on 4 osaa
        GridLayout osatRuudussa = new GridLayout(4, 1);
        container.setLayout(osatRuudussa);

        //Kysymys ja sen tarkennus
        container.add(luokysymys());

        
        //Kenttä vastauksen antamiseen
        //container.add(luoVastauskentta());

        //Jo luotujen pöytien listaaminen näkyville
        //JTextArea poytalista = new JTextArea(tarkennusteksti);
        //Mitä seuraavaksi tehdään
        //container.add(luoJatkamisNappulat(vastauskentta));

    }
    
    private JPanel luokysymys(){
        JPanel paneeli = new JPanel(new GridLayout(2, 1, 2, 1));
        
        JLabel kysymys = new JLabel(" Anna pöydän tuolien määrä");
        kysymys.setFont(new Font("Arial", 6, 20));
        paneeli.add(kysymys);
        
        String tarkennusteksti = "<HTML> Kirjoita kokonaislukuna, montako tuolia pöydässä on. Pöydän on oltava suorakulmainen ja tuolien sen kahdella sivulla. Tuolien lukumäärän tulee olla parillinen ja vähintään 2</HTML>"; 
        JLabel tarkennus = new JLabel(tarkennusteksti);
        paneeli.add(tarkennus);
        
        return paneeli;
    }

    private JPanel luoVastauskentta() {
        JPanel paneeli = new JPanel(new GridLayout(1, 5));

        JLabel tuoleja = new JLabel("            Tuoleja on ");
        JTextField vastauskentta = new JTextField();
        JLabel tyhja = new JLabel(" ");

        paneeli.add(tyhja);
        paneeli.add(tuoleja);
        paneeli.add(vastauskentta);
        paneeli.add(tyhja);
        paneeli.add(tyhja);

        return paneeli;
    }

    private JTextArea listaaLuodutPoydat() {
        JTextArea poytalista = new JTextArea("");

        return null;

    }

    private JPanel luoJatkamisNappulat(JTextField vastauskentta) {
        JPanel paneeli = new JPanel(new GridLayout(1, 2));

        JButton uusiPoyta = new JButton("Lisää uusi pöytä");
        uusiPoyta.addActionListener(new tuolimaaranLukija(vastauskentta));
        JButton kaikkiPoydatLisatty = new JButton("Kaikki pöydät lisätty");

        paneeli.add(uusiPoyta);
        paneeli.add(kaikkiPoydatLisatty);

        return paneeli;
    }
}
