package com.mycompany.enigmax;

/**
 * Z angielskiego "Plugboard" Krosownica łączyła pary liter kablami.
 *
 * @author maksi
 */
public class Krosownica {

    private final String polaczenia;

    /**
     * Konstruktor klasy Krosownica
     *
     * @param polaczenia
     */
    public Krosownica(String polaczenia) {
        this.polaczenia = polaczenia;
    }

    /**
     * Metoda realizująca podmianę indeksu
     * @param wejscie
     * @return 
     */
    
    public int zamien(int wejscie) {
        char znak = polaczenia.charAt(wejscie);

        return znak - 'A';
    }
}
