package plaseeraus.logiikanTestit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Plaseeraaja;

public class PlaseeraajaTest {
    Plaseeraaja plaseeraaja;
    
    public PlaseeraajaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        plaseeraaja = new Plaseeraaja();
    }
    
    @After
    public void tearDown() {
    }

    // @Test
    // public void hello() {}
}
