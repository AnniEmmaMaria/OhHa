package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Vieras;

public class VierasTest {

    Vieras chandler;

    public VierasTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        chandler = new Vieras("Chandler", "Bing", 'm', "Monica Geller");
    }

    @After
    public void tearDown() {
    }

    //Toimivatko getterit ja toString oikein?
    @Test
    public void etunimiOikein() {
        assertEquals("Chandler", chandler.getEtunimi());
    }

    @Test
    public void sukunimiOikein() {
        assertEquals("Bing", chandler.getSukunimi());
    }

    @Test
    public void sukupuoliOikein() {
        assertEquals('m', chandler.getSukupuoli());
    }

    @Test
    public void avecOikein() {
        assertEquals("Monica Geller", chandler.getAvec());
    }

    @Test
    public void toStringOikein() {
        assertEquals("Chandler Bing", chandler.toString());
    }

    //Toimiiko plaseerauksen true / false
    @Test
    public void plaseeraamatonAlussa() {
        String plaseeraustosi = "tosi";
        if (chandler.onkoPlaseerattu() == false) {
            plaseeraustosi = "vale";
        }

        assertEquals("vale", plaseeraustosi);
    }

    @Test
    public void plaseerautuuko() {
        chandler.plaseeraa();
        boolean plaseerattu = chandler.onkoPlaseerattu();
        assertTrue(plaseerattu);
    }

}


