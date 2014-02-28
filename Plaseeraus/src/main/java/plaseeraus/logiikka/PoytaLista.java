package plaseeraus.logiikka;

import java.util.ArrayList;
import java.util.List;

/**
 * Säilyttää yhden juhlan pöydät listana
 * @author Anni Jokiniemi
 */
public class PoytaLista {
    private final List<Poyta> poydat;

    public PoytaLista() {
        this.poydat = new ArrayList<>();
    }

    public List<Poyta> getPoytalista() {
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
