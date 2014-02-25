package plaseeraus.grafiikka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Vieras;

public class Tilapiirros extends JPanel implements Runnable {

    private JFrame ruutu;
    private final PoytaLista poytalista;

    public Tilapiirros(PoytaLista poytalista) {
        this.poytalista = poytalista;
    }

    public Tilapiirros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() {
        ruutu = new JFrame("Juhlatila");
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ruutu.setPreferredSize(new Dimension(1400, 700));

        luoRuutu(ruutu.getContentPane());

        ruutu.pack();
        ruutu.setVisible(true);
    }

    /**
     * Luodaan tilakartan ruudun pohja
     *
     * @param container
     */
    public void luoRuutu(Container container) {
        container.add(new Tilapiirros(poytalista));
    }

    /**
     *
     * @param graphics
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);

        /**
         * Otetaan loopilla kaikki listatut pöydät piirrettäviksi
         * järjestyksessä.
         */
        int jarjNumero = 0;
        for (Poyta piirrettavaPoyta : this.poytalista.getPoytalista()) {

            //Piirretään itse pöytä
            piirraPoyta(piirrettavaPoyta, jarjNumero, graphics);

            //Pöydän 1.  (vasemmalla) sivulla istuvat kirjoitetaan ruutuun
            ArrayList<Vieras> vasemmanSivunIstujat = sivullaIstuvat(piirrettavaPoyta, 1);
            kirjoitaVieraat(vasemmanSivunIstujat, 1, jarjNumero, graphics);

            //Pöydän 2.  (oikealla) sivulla istuvat kirjoitetaan ruutuun
            ArrayList<Vieras> oikeanSivunIstujat = sivullaIstuvat(piirrettavaPoyta, 2);
            kirjoitaVieraat(oikeanSivunIstujat, 2, jarjNumero, graphics);

            //Seuraavan pöydän järjestysnumero vaihdetaan
            jarjNumero++;
        }
    }

    /**
     * Piirtää ruudulle annetun pöydän ja nimeää tuolien istujat siihen.
     *
     * @param poyta vuorossa oleva Poyta-olio
     * @param jarjNumero monesko pöytä on salissa(määrää x-koordinaatin)
     * @param graphics
     */
    public void piirraPoyta(Poyta poyta, int jarjNumero, Graphics graphics) {
        int koko = poyta.getTuolimaara();

        graphics.setColor(Color.GRAY);
        graphics.fillRect(150 + jarjNumero * 380, 30, 50, koko * 20);

    }

    /**
     * Kirjoittaa yhdellä sivulla istuvien vieraiden nimet
     *
     * @param sivunIstujat
     * @param kumpiSivu 1. (vasen) vai 2. (oikea)
     * @param moneskoPoyta
     * @param graphics
     */
    public void kirjoitaVieraat(ArrayList<Vieras> sivunIstujat, int kumpiSivu, int moneskoPoyta, Graphics graphics) {
        graphics.setColor(Color.BLACK);
        int istujienLkm = sivunIstujat.size();

        //vasen sivu
        int xKoordinaatti = 20 + 360 * moneskoPoyta;
        int yKoordinaatti = 50 + 40 * (istujienLkm - 1);

        if (kumpiSivu == 1) {
            for (Vieras istuja : sivunIstujat) {
                graphics.drawString(istuja.toString(), xKoordinaatti, yKoordinaatti);

                yKoordinaatti = yKoordinaatti - 40;
            }
        //oikea sivu
        } else {
            xKoordinaatti = 220 + 380 * moneskoPoyta;
            yKoordinaatti = 50;
            for (Vieras istuja : sivunIstujat) {
                graphics.drawString(istuja.toString(), xKoordinaatti, yKoordinaatti);
                
                yKoordinaatti = yKoordinaatti + 40;

            }
        }
    }

    /**
     * Listaa pöydän sillä puolella istuvat vieraat ArrayListiksi
     *
     * @param poyta kyseessä oleva Poyta
     * @param puoli 1. eli vasen tai 2. eli oikea
     * @return
     */
    public ArrayList<Vieras> sivullaIstuvat(Poyta poyta, int puoli) {
        ArrayList<Vieras> kaikkiPoydanIstujat = poyta.getIstujat();
        int istujienLkm = kaikkiPoydanIstujat.size();
        ArrayList<Vieras> sivullaIstujat = new ArrayList<>();

        //Mistä tuoliNro:sta lista aloitetaan? Pöydän puoli määrää.
        int tuoliNro = 0;
        if (puoli == 2) {
            tuoliNro = istujienLkm / 2;
        }
        //Lisätään tämä puoli listaksi
        for (int i = 1; i <= istujienLkm / 2; i++) {
            sivullaIstujat.add(kaikkiPoydanIstujat.get(tuoliNro));
            tuoliNro++;
        }

        return sivullaIstujat;
    }

}
