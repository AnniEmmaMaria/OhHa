package plaseeraus.logiikanTestit;

import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Plaseeraaja;
import plaseeraus.logiikka.Vieras;

public class PlaseeraajaTest {
    Plaseeraaja plaseeraaja;
    ArrayList<Vieras> testilista;
    Vieras vili;
    Vieras totte;
    
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
        testilista = new ArrayList<Vieras>();
        vili = new Vieras("Vili", "Vilperi", 'm', null);
        testilista.add(vili);
    }
    
    @After
    public void tearDown() {
    }

    //Jos plaseeraaja osaa lukea vieraslista.txt:n, 3. vieras on Risto Reipas
    @Test
    public void tekeekoListan() {
        ArrayList<Vieras> vierasLista = plaseeraaja.annaVieraslista();
        Vieras ristoko = vierasLista.get(2);
        assertEquals("Risto Reipas", ristoko.toString());
    }
    
    
}
