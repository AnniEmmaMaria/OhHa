package plaseeraus.alku;

import plaseeraus.logiikka.PoytaLista;
import plaseeraus.logiikka.Plaseeraaja;

public class Aloittajat {
    public PoytaLista poytalista;
    public Plaseeraaja plaseeraaja;
    
    public Aloittajat(){
        this.poytalista = new PoytaLista();
        this.plaseeraaja = new Plaseeraaja();
}
    
    public PoytaLista getPoytaLista(){
        return this.poytalista;
    }
}
