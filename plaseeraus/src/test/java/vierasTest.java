import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.plaseeraus.Vieras;

public class vierasTest {
    Vieras totte;
    
    public vierasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        totte = new Vieras("Totte", "Svensson", "m");
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void etunimiOikein(){
        assertEquals("Totte", totte.getEtunimi());
    }
}
