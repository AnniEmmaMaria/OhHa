package plaseeraus.logiikanTestit;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import plaseeraus.logiikka.PoytaLista;

public class PoytaListaTest {

    PoytaLista lista;

    @Before
    public void setUp() {
        lista = new PoytaLista();
    }

    @Test
    public void lisaaPoydan() {
        lista.lisaaPoyta(6);
        assertFalse(lista.getPoytalista().isEmpty());
    }

    @Test
    public void tulostaaHalutunPoydanStringin() {
        lista.lisaaPoyta(6);
        lista.lisaaPoyta(22);
        assertEquals("22 tuolin pöytä", lista.tulostaListaltaPoytaNro(1));

    }
}
