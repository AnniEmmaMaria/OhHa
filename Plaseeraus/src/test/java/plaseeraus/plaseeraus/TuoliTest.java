package plaseeraus.plaseeraus;

import plaseeraus.logiikka.Tuoli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class TuoliTest {
    Tuoli istuin;
    
    public TuoliTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        istuin = new Tuoli();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void onkoLuotaessaVapaa(){
    assertEquals(true, istuin.onkoVapaa());
    
}
}
