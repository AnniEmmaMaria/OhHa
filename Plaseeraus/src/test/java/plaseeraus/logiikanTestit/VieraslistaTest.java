package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.vieraidenMaaritys.Vieras;
import plaseeraus.logiikka.vieraidenMaaritys.Vieraslista;

public class VieraslistaTest {

    Vieraslista lista;
    Vieras jeppe;

    public VieraslistaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        lista = new Vieraslista();
        jeppe = new Vieras("Jeppe", "Karppa", 'm');
    }

    @After
    public void tearDown() {
    }

    //Onko luotu lista aluksi tyhjä?
    @Test
    public void luotunaTyhja() {
        String vieraidenLkm = "Vieraita on: " + lista.vierasmaara();
        assertEquals("Vieraita on: 0", vieraidenLkm);
    }

    //Onnistuuko vieraan lisääminen (pitäisi kasvattaa listan kokoa)
    @Test
    public void vieraanLisays() {
        lista.lisaaVierasListalle(jeppe);
        String vieraidenLkm = "Vieraita on: " + lista.vierasmaara();
        assertEquals("Vieraita on: 1", vieraidenLkm);

    }
    

}
