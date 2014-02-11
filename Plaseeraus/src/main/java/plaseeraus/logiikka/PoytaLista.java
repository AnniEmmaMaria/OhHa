package plaseeraus.logiikka;

import java.util.ArrayList;

public class PoytaLista {
    private ArrayList<Poyta> poydat;
    
    public PoytaLista(){
        this.poydat = new ArrayList<>();
    }
    
    public void lisaaPoyta(Poyta uusiPoyta){
        this.poydat.add(uusiPoyta);
    }
    
    public String tulostaListaltaPoytaNro(int monesko){
        return this.poydat.get(monesko).toString();
    }
    
}
