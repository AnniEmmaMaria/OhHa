/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package plaseeraus.logiikanTestit;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import plaseeraus.logiikka.Sukupuoli;
import plaseeraus.logiikka.Vieras;
import plaseeraus.logiikka.VieraslistanLukija;

/**
 *
 * @author Anni Jokiniemi
 */
public class VieraslistanLukijaTest {

    VieraslistanLukija listanlukija;

    public VieraslistanLukijaTest() {

    }

    @Before
    public void setUp() {
        listanlukija = new VieraslistanLukija();
    }

    //Antaako vieraslistan
    @Test
    public void antaakoListan() {
        ArrayList<Vieras> tyhjaVieraslista = listanlukija.getVieraslista();
        tyhjaVieraslista.add(new Vieras("Eero", "Kurppa", Sukupuoli.MIES, "Katariina Raikas"));
        int listaKoko = tyhjaVieraslista.size();
        boolean onnistuiko = false;
        if (listaKoko == 1) {
            onnistuiko = true;
        }

        Assert.assertTrue(onnistuiko);
    }

    //Luoko rivistä tekstiä Vieras-olion 
    @Test
    public void luoTekstistaVieraan() {
        String tekstirivi = "Irene Raikas n";
        Vieras luotuVieras = listanlukija.luoTekstirivistaVierasOlio(tekstirivi);

        Assert.assertEquals("Irene Raikas", luotuVieras.toString());

    }
}
