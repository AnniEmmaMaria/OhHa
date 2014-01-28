package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.Tuoli;

public class PoytaTest {
    Poyta neljanPoyta;

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
        neljanPoyta = new Poyta(4,1);
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
    public void poytanumeroOikein(){
        assertEquals(1, neljanPoyta.getPoydanNumero());
    }
}
