package plaseeraus.grafiikka;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.Poyta;

public class Tilapiirros extends JPanel implements Runnable{
    private JFrame ruutu;

    public Tilapiirros() {
    }
    
    @Override
    public void run(){
        ruutu = new JFrame("Juhlatila");
        ruutu.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        ruutu.setPreferredSize(new Dimension(1000, 700));
        
        ruutu.pack();
        ruutu.setVisible(true);
    }
    
    @Override
    protected void paintComponent(Graphics grafiikka){
        super.paintComponent(grafiikka);
        
        grafiikka.setColor(Color.RED);
        grafiikka.drawRect(10, 20, 30, 40);
    }
    
    /**
     * Luodaan tilakartan ruudun pohja
     * @param container
     */
    public void luoRuutu(Container container){
        container.add(new Tilapiirros());
    }
    
    /**
     * Piirtää ruudulle annetun pöydän ja nimeää tuolien istujat siihen
     */
    public void piirraPoyta(Poyta poyta){
        
        
    }

}
