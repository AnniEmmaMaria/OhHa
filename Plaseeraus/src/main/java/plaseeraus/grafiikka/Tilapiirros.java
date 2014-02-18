package plaseeraus.grafiikka;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.List;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Vieras;

public class Tilapiirros extends JPanel implements Runnable{
    private JFrame ruutu;
    private final PoytaLista poytalista;

    public Tilapiirros(PoytaLista poytalista) {
        this.poytalista = poytalista;
    }

    public Tilapiirros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
    /**
     * 
     * @param graphics 
     */
    @Override
    protected void paintComponent(Graphics graphics){
        super.paintComponent(graphics);
        
        graphics.drawRect(50, 70, 30, 100);
        /**
         * Otetaan loopilla kaikki listatut pöydät piirrettäviksi järjestyksessä.
         */
        int jarjNumero = 0;
        for(Poyta piirrettavaPoyta : this.poytalista.getPoytalista()){
            //Pöydän 1.  (vasemmalla) sivulla istuvat
            ArrayList<Vieras> sivunIstujat = sivullaIstuvat(piirrettavaPoyta, 1);
            
            for(Vieras istuja:sivunIstujat){
                System.out.println(istuja);
            }
            
            piirraPoyta(piirrettavaPoyta, jarjNumero , graphics);
            jarjNumero++;
        }
        
        //graphics.drawString(TOOL_TIP_TEXT_KEY, WIDTH, WIDTH);
        
        
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

    /**
     * Listaa pöydän sillä puolella istuvat vieraat ArrayListiksi
     * @param poyta kyseessä oleva Poyta
     * @param puoli 1. eli vasen tai 2. eli oikea
     * @return 
     */
    public ArrayList<Vieras> sivullaIstuvat(Poyta poyta, int puoli){
        ArrayList<Vieras> kaikkiPoydanIstujat = poyta.getIstujat();
        int istujienLkm = kaikkiPoydanIstujat.size();
        ArrayList<Vieras> sivullaIstujat = new ArrayList<>();
        
        double puoletIstujista = istujienLkm/2;
        if(puoli == 1){
            sivullaIstujat = (ArrayList<Vieras>) kaikkiPoydanIstujat.subList(0, (int) puoletIstujista);
        }else{
            sivullaIstujat = (ArrayList<Vieras>) kaikkiPoydanIstujat.subList((int) puoletIstujista+1, istujienLkm);
        }
        return sivullaIstujat;
    }
}
