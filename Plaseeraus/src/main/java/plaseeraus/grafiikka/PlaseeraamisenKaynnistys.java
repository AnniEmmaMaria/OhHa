package plaseeraus.grafiikka;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import plaseeraus.logiikka.Plaseeraaja;
import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Poyta;

public class PlaseeraamisenKaynnistys implements ActionListener{
    private final PoytaLista poytalista;
    
    public PlaseeraamisenKaynnistys(PoytaLista poytalista){
        this.poytalista = poytalista;
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Aletaan plaseeraamaan!");
        Plaseeraaja plaseeraaja = new Plaseeraaja();
        
        //Käydään pöytälista läpi plaseeraten pöydät
        for(Poyta yksiPoyta : this.poytalista.getPoytalista()){
            plaseeraaja.plaseeraa(yksiPoyta);
            System.out.println("PÖYDÄSSÄ ISTUVAT");
            yksiPoyta.getIstujat();
            System.out.println("");
        }
        
    }
    
}
