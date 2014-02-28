package plaseeraus.logiikanTestit;

import plaseeraus.logiikka.Tuoli;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Sukupuoli;
import plaseeraus.logiikka.Vieras;

public class TuoliTest {
    Tuoli istuin;
    Vieras monica; 

    @Before
    public void setUp() {
        istuin = new Tuoli();
        monica = new Vieras("Monica", "Geller", Sukupuoli.NAINEN, "");
    }

    
    //Tuolin luontiasetukset oikein?
    @Test
    public void istuukoKukaanLuotaessa(){
        assertEquals(null, istuin.getIstuja());
    }


    //Onnistuuko istuminen? Toimiiko getteri?
    @Test
    public void voikoIstua(){
        istuin.otaIstuja(monica);
        assertEquals("Monica Geller", istuin.getIstuja().toString());   
    }
    
    //Tuleeko toStringillä istujan nimi
    @Test
    public void toStringillaIstuja(){
        istuin.otaIstuja(monica);
        assertEquals("Monica Geller", istuin.toString());
    }
}
