package plaseeraus.grafiikka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.PoytaLista;

public class Tilapiirros extends JPanel implements Runnable{
    private JFrame ruutu;
    private final PoytaLista poytalista;

    public Tilapiirros(PoytaLista poytalista) {
        this.poytalista = poytalista;
    }
    
    @Override
    public void run(){
        ruutu = new JFrame("Juhlatila");
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ruutu.setPreferredSize(new Dimension(1000, 700));
        
        luoRuutu(ruutu.getContentPane());
        
        ruutu.pack();
        ruutu.setVisible(true);
    }
    /**
     * Luodaan tilakartan ruudun pohja
     * @param container
     */
    public void luoRuutu(Container container){
        container.add(new Tilapiirros(poytalista));
    }
    
    
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        /**
         * Otetaan loopilla kaikki listatut pöydät piirrettäviksi järjestyksessä.
         */
        int jarjNumero = 0;
        for(Poyta piirrettavaPoyta : this.poytalista.getPoytalista()){
            piirraPoyta(piirrettavaPoyta, jarjNumero , graphics);
            jarjNumero++;
        }
        
        graphics.drawString(TOOL_TIP_TEXT_KEY, WIDTH, WIDTH);
        
        
    }
    
    
    /**
     * Piirtää ruudulle annetun pöydän ja nimeää tuolien istujat siihen.
     * @param poyta vuorossa oleva Poyta-olio
     * @param jarjNumero monesko pöytä on salissa(määrää x-koordinaatin)
     * @param graphics
     */
    public void piirraPoyta(Poyta poyta, int jarjNumero, Graphics graphics){
        int koko = poyta.getTuolimaara();
        
        graphics.fillRect(30+jarjNumero*150, 16, 50, koko*50);
    }

}
