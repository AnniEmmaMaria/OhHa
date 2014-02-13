package plaseeraus.logiikka;

import java.util.ArrayList;

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

    /**
     *Luo pöytään kuuluvat tuolit ja lisää ne tuolit-listaan
     */
    public void luoTuolit() {
        for (int tuoliNro = 1; tuoliNro <= this.tuolimaara; tuoliNro++) {
            Tuoli uusiTuoli = new Tuoli();
            this.tuolit.add(uusiTuoli);
        }
    }

    public Tuoli getTuoli(int tuolinNro) {
        Tuoli penkki = this.tuolit.get(tuolinNro);
        return penkki;
    }

    //Kaikkien tuolien listan hakeminen
    public ArrayList<Tuoli> getTuolilista() {
        return this.tuolit;
    }

    //Ketkä tässä pöydässä istuvat
    public void getIstujat() {
        for (Tuoli tuoli : tuolit) {
            System.out.println(tuoli);
        }
    }

    @Override
    public String toString() {
        return this.tuolimaara + " tuolin pöytä";
    }
}
