package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.PoytaLista;

public class PoytaListaTest {
    PoytaLista lista;
    
    public PoytaListaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        lista = new PoytaLista();
        lista.lisaaPoyta(6);
        lista.lisaaPoyta(22);
    }
    
    @After
    public void tearDown() {
    }

     @Test
     public void tulostaaHalutunPoydanStringin() {
         assertEquals("22 tuolin pöytä", lista.tulostaListaltaPoytaNro(1));
     
     }
}
