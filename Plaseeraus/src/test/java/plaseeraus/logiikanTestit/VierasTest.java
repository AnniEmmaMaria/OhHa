package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.vieraidenMaaritys.Vieras;

public class VierasTest {
    Vieras totte;
    
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
        totte = new Vieras("Totte", "Svensson", 'm');
    }
    
    @After
    public void tearDown() {
    }

    //Toimivatko getterit ja toString oikein?
    @Test
    public void etunimiOikein(){
        assertEquals("Totte", totte.getEtunimi());
    }
     @Test 
     public void sukunimiOikein(){
         assertEquals("Svensson", totte.getSukunimi());
     }
      @Test 
     public void sukupuoliOikein(){
         assertEquals('m', totte.getSukupuoli());
     }
     @Test 
     public void toStringOikein(){
         assertEquals("Totte Svensson", totte.toString());
     }

 
            
}
