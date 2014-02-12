package plaseeraus.logiikanTestit;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.Sukupuoli;
import plaseeraus.logiikka.Tuoli;
import plaseeraus.logiikka.Vieras;

public class PoytaTest {

    Poyta neljanPoyta;
    Vieras vili;

    public PoytaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        neljanPoyta = new Poyta(4);
        vili = new Vieras("Vili", "Vilperi", Sukupuoli.MIES, "Nanni Koala");

    }

    @After
    public void tearDown() {
    }

    //Onko tuolimäärä ja pöydän numerointi salissa oikein
    @Test
    public void tuolimaaraOikein() {
        assertEquals(4, neljanPoyta.getTuolimaara());
    }

    @Test
    public void toStringTulostuu() {
        assertEquals("Tässä pöydässä on 4 tuolia.", neljanPoyta.toString());
    }

    //Tuolilistan luonti
    @Test
    public void tuoliLuonnistuu() {
        neljanPoyta.luoTuolit();
        Tuoli kolmostuoli = neljanPoyta.getTuoli(3);
        kolmostuoli.otaIstuja(vili);

        assertEquals("Vili Vilperi", kolmostuoli.toString());
    }

    @Test
    public void tuoliListaLuonnistuu() {
        neljanPoyta.luoTuolit();
        ArrayList<Tuoli> tuolit = neljanPoyta.getTuolilista();
        tuolit.get(1).otaIstuja(vili);
        
        assertEquals("Vili Vilperi", tuolit.get(1).toString());

    }
    
    //Yhden tuolin tietojen haku. Printtaako annetun istujan?
    @Test 
    public void getTuoliOikein(){
        neljanPoyta.luoTuolit();
        neljanPoyta.getTuoli(2).otaIstuja(vili);
        assertEquals("Vili Vilperi", this.neljanPoyta.getTuoli(2).toString());
    }
}
