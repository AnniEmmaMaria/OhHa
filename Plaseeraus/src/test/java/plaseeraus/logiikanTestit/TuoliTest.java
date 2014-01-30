package plaseeraus.logiikanTestit;

import plaseeraus.logiikka.Tuoli;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Vieras;

public class TuoliTest {
    Tuoli istuin;
    Vieras vili; 

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
        vili = new Vieras("Vili", "Vilperi", 'm', null);
    }

    @After
    public void tearDown() {
    }

    //Tuolin luontiasetukset oikein?
    @Test
    public void istuukoKukaanLuotaessa(){
        assertEquals(null, istuin.getIstuja());
    }

    //Onnistuuko istuminen?
    @Test
    public void voikoIstua(){
        istuin.otaIstuja(vili);
        assertEquals("Vili Vilperi", istuin.getIstuja().toString());   
    }
}
