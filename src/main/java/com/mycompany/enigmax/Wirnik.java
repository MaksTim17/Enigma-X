package com.mycompany.enigmax;

/**
 * Klasa Wirnik reprezentuje pojedynczy wirnik maszyny szyfrującej. Odpowiada za
 * permutację liter w oparciu o punkt obrotu oraz aktualną pozycję obrotu.
 */
public class Wirnik {

    private final String alfabetPrzetasowany;
    private int pozycjaObrotu;
    private final int punktObrotu;

    /**
     * Konstruktor klasy Wirnik
     *
     * @param alfabetPrzetasowany
     * @param pozycjaObrotu
     * @param punktObrotu
     */
    public Wirnik(String alfabetPrzetasowany, int pozycjaObrotu, int punktObrotu) {
        this.alfabetPrzetasowany = alfabetPrzetasowany;
        this.pozycjaObrotu = pozycjaObrotu;
        this.punktObrotu = punktObrotu;
    }

    /**
     * Metoda symulująca obrót wirnika przed każdorazowym zaszyfrowaniem znaku
     *
     * @return
     */
    public boolean obroc() {
        ++pozycjaObrotu;

        if (pozycjaObrotu == 26) {
            pozycjaObrotu = 0;
        }

        return pozycjaObrotu == punktObrotu;
    }

    /**
     * Metoda przekształcająca wprowadzony sygnał na podstawie aktualnej 
     * pozycji obrotu oraz wewnętrznego okablowania.
     * @param wejscie
     * @return
     */
    public int szyfrujWPrzod(int wejscie) {
        int index = (wejscie + pozycjaObrotu) % 26;

        char znak = alfabetPrzetasowany.charAt(index);

        int wyjscie = znak - 'A';

        return (wyjscie - pozycjaObrotu + 26) % 26;
    }

    /**
     * Metoda symuluje przepływ prądu przez wirnik w kierunku powrotnym.
     * Działanie jest matematyczną odwrotnością metody szyfrujWPrzod.
     * @param wejscie
     * @return
     */
    public int szyfrujWTyl(int wejscie) {
        int index = (wejscie + pozycjaObrotu) % 26;

        char znak = (char) (index + 'A');

        int wyjscie = alfabetPrzetasowany.indexOf(znak);

        return (wyjscie - pozycjaObrotu + 26) % 26;
    }
}
