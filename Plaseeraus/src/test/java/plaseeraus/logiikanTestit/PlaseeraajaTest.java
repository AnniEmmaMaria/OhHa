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

    //Plaseeraa ensimmäisenä naisen
     @Test
    public void plaseeraaEkaksiNaisen(){
        plaseeraaja.plaseeraa(kahdenPoyta);
        String sukup = kahdenPoyta.getTuoli(0).getIstuja().getSukupuoli().toString();
        assertEquals(Sukupuoli.NAINEN.toString() , sukup);
    }
//    
//    
//    //Sallii naisen paikalle naisen
//    @Test
//    public void parillisellePaikalleNainen(){
//        ArrayList<Vieras> naislista = plaseeraaja.listaaSallitutVieraat(4, joey);
//        String naisSukupuoli = naislista.get(0).getSukupuoli().toString();
//        assertEquals(Sukupuoli.NAINEN.toString(), naisSukupuoli);
//    }
//    
//    //Sallii miehen paikalle miehen
//    @Test
//    public void parittomallePaikalleMies(){
//        ArrayList<Vieras> mieslista = plaseeraaja.listaaSallitutVieraat(3, rachel);
//        String miesSukupuoli = mieslista.get(0).getSukupuoli().toString();
//        assertEquals(Sukupuoli.MIES.toString(), miesSukupuoli);
//    }
    
    //Jos plaseeraaja osaa lukea vieraslista.txt:n, 3. vieras on Risto Reipas
    @Test
    public void tekeekoListan() {
        ArrayList<Vieras> vierasLista = plaseeraaja.annaVieraslista();
        Vieras ristoko = vierasLista.get(2);
        assertEquals("Risto Reipas", ristoko.toString());
    }
    
    
    
}
