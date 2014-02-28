package plaseeraus.logiikanTestit;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.Sukupuoli;
import plaseeraus.logiikka.Tuoli;
import plaseeraus.logiikka.Vieras;

public class PoytaTest {

    Poyta neljanPoyta;
    Vieras monk;

    @Before
    public void setUp() {
        neljanPoyta = new Poyta(4);
        monk = new Vieras("Adrian", "Monk", Sukupuoli.MIES, "");
    }

    //Onko tuolimäärä oikein
    @Test
    public void tuolimaaraOikein() {
        assertEquals(4, neljanPoyta.getTuolimaara());
    }

    //toStringToimii
    @Test
    public void toStringTulostuu() {
        assertEquals("4 tuolin pöytä", neljanPoyta.toString());
    }

    //Tuolilistan luonti
    @Test
    public void tuoliLuonnistuu() {
        neljanPoyta.luoTuolit();
        Tuoli kolmostuoli = neljanPoyta.getTuoli(3);
        kolmostuoli.otaIstuja(monk);

        assertEquals("Adrian Monk", kolmostuoli.toString());
    }

    @Test
    public void tuoliListaLuonnistuu() {
        neljanPoyta.luoTuolit();
        ArrayList<Tuoli> tuolit = neljanPoyta.getTuolilista();
        tuolit.get(1).otaIstuja(monk);

        assertEquals("Adrian Monk", tuolit.get(1).toString());

    }

    //Yhden tuolin tietojen haku. Printtaako annetun istujan?
    @Test
    public void getTuoliOikein() {
        neljanPoyta.luoTuolit();
        neljanPoyta.getTuoli(2).otaIstuja(monk);
        assertEquals("Adrian Monk", this.neljanPoyta.getTuoli(2).toString());
    }
}
