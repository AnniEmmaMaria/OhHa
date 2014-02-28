package plaseeraus.logiikka;

import java.util.ArrayList;

/**
 * Poyta sisältää listana tuolinsa, joille vieraat voi istuttaa
 * @author Anni Jokiniemi
 */
public class Poyta {

    private final int tuolimaara;
    private final ArrayList<Tuoli> tuolit;

    public Poyta(int tuolimaara) {
        this.tuolimaara = tuolimaara;
        this.tuolit = new ArrayList<>();
    }

    
    public int getTuolimaara() {
        return this.tuolimaara;
    }

    public Tuoli getTuoli(int tuolinNro) {
        Tuoli tuoli = this.tuolit.get(tuolinNro);
        return tuoli;
    }

    public ArrayList<Tuoli> getTuolilista() {
        return this.tuolit;
    }

    /**
     * Antaa listan pöytään plaseeratuista vieraista
     * @return listana pöydässä istuvat vieras-oliot
     */
    public ArrayList<Vieras> getIstujat() {
        ArrayList<Vieras> istujat = new ArrayList<>();
        for (Tuoli tuoli : tuolit) {
            istujat.add(tuoli.getIstuja());
        }
        return istujat;
    }

    @Override
    public String toString() {
        return this.tuolimaara + " tuolin p�yt�";
    }

    /**
     * Luo pöytään kuuluvat tuolit ja lisää ne tuolit-listaan
     */
    public void luoTuolit() {
        for (int tuoliNro = 1; tuoliNro <= this.tuolimaara; tuoliNro++) {
            Tuoli uusiTuoli = new Tuoli();
            this.tuolit.add(uusiTuoli);
        }
    }

}
