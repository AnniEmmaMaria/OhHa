package plaseeraus.logiikanTestit;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.Plaseeraaja;
import plaseeraus.logiikka.Poyta;
import plaseeraus.logiikka.Sukupuoli;
import plaseeraus.logiikka.Vieras;

public class PlaseeraajaTest {

    Plaseeraaja plaseeraaja;
    ArrayList<Vieras> testilista;
    Vieras ross;
    Vieras rachel;
    Vieras joey;
    Poyta kahdenPoyta;

    @Before
    public void setUp() {
        plaseeraaja = new Plaseeraaja();
        testilista = new ArrayList<>();
        ross = new Vieras("Ross", "Geller", Sukupuoli.MIES, "Rachel Green");
        rachel = new Vieras("Rachel", "Green", Sukupuoli.NAINEN, "Ross Geller");
        joey = new Vieras("Joey", "Tribbiani", Sukupuoli.MIES, "");
        testilista.add(ross);
        testilista.add(rachel);
        testilista.add(joey);
        kahdenPoyta = new Poyta(2);
    }


    @Test
    public void etsiikoNimellaVieraan() {
        String nimi = "Ross Geller";
        Vieras nimellaHaettuVieras = plaseeraaja.getVierasNimenPerusteella(nimi, testilista);
        
        assertEquals("Ross Geller", nimellaHaettuVieras.toString());
    }

}
