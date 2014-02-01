package plaseeraus.logiikka;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class VieraslistanLukija {
    File vieraslista;                   //luettava vieraslista
    Scanner listanLukija;               //sen lukija
    ArrayList<Vieras> listaVieraista;   //lista johon vieraat tallennetaan
    
    public VieraslistanLukija() {
        this.vieraslista = new File("vieraslista.txt");

        //Vieraslistan lukijan teossa varmistetaan tekstitiedoston olemassaolo
        try {
            listanLukija = new Scanner(vieraslista);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löytynyt");
        }
        
        this.listaVieraista = new ArrayList<>();
    }

    
    
    //Anna vieraslista, johon tekstitiedoston vieraat tallennettiin
    public ArrayList<Vieras> getVieraslista(){
        return this.listaVieraista;
    }
    
    
    //Luetaan tiedoston rivit yksi kerrallaan ja tehdään riveistä Vieras-oliot
    //Lisätään oliot listaVieraista-ArrayListiksi
    public void luoTekstistaOliotListaksi() {

        while (listanLukija.hasNextLine()) {
            String rivi = listanLukija.nextLine();
            Vieras uusiVieras = luoTekstirivistaVierasOlio(rivi);
            listaVieraista.add(uusiVieras);
        }
    }
    

    //Luo yhdestä tekstirivistä Vieras-olion etsimällä attribuutit (etu- ja sukunimi, sukupuoli) 
    private Vieras luoTekstirivistaVierasOlio(String tekstirivi) {
        
        //Välilyönnit (2 kpl) erottavat 3 attribuuttia
        int ekanValinInd = tekstirivi.indexOf(" ");
        int toisenValinInd = tekstirivi.indexOf(" ", ekanValinInd + 1);
       

        //Haetaan välilyöntien avulla attribuutit ja palautetaan Vieras-olio
        String etunimi = tekstirivi.substring(0, ekanValinInd);
        String sukunimi = tekstirivi.substring(ekanValinInd + 1, toisenValinInd);
        char sukupuoli = tekstirivi.charAt(toisenValinInd + 1);
        
        //Oletusarvoisesti avecia ei ole
        Vieras avec = null;     
       
        //Jos kyseisellä vieraalla on kuitenkinmääritetty avec
        if(tekstirivi.contains("(avec: ")){
             int avecinEtunimenAlkuInd = tekstirivi.indexOf("(avec: ") + 7;
             int avecinSukunimenAlkuInd = tekstirivi.indexOf(" ", avecinEtunimenAlkuInd);
             
             String avecinEtunimi = tekstirivi.substring(avecinEtunimenAlkuInd, avecinSukunimenAlkuInd-2);
             String avecinSukunimi = tekstirivi.substring(avecinSukunimenAlkuInd);
             
             //Avecin sukupuoli on eri kuin vieraan
             char avecinSukupuoli = 'm';
             if(sukupuoli == 'm'){
                 avecinSukupuoli = 'n';
             }
             
             avec = new Vieras(avecinEtunimi, avecinSukunimi, avecinSukupuoli, avec);
        }

        return new Vieras(etunimi, sukunimi, sukupuoli, avec);
    }

}