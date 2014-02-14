package plaseeraus.logiikka;

import java.util.ArrayList;

public class PoytaLista {

    private final ArrayList<Poyta> poydat;

    public PoytaLista() {
        this.poydat = new ArrayList<>();
    }

    public ArrayList<Poyta> getPoytalista() {
        return this.poydat;
    }

    /**
     * Lisaa uuden Poyta-olion listaan
     * @param tuolimaara = montako tuolia uuden pöydän ympärillä on
     */
    public void lisaaPoyta(int tuolimaara) {
        Poyta uusiPoyta = new Poyta(tuolimaara);
        uusiPoyta.luoTuolit();
        this.poydat.add(uusiPoyta);
    }

    public String tulostaListaltaPoytaNro(int monesko) {
        return this.poydat.get(monesko).toString();
    }

}
