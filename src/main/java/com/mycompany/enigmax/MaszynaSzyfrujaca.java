package com.mycompany.enigmax;

/**
 * Główna klasa symulująca działanie maszyny szyfrującej. Odpowiada za
 * połączenie krosownicy, zestawu wirników oraz reflektora w jeden kompletny
 * obwód szyfrujący. Steruje przepływem sygnału i dba o odpowiednie obracanie
 * wirników przed zaszyfrowaniem znaku.
 *
 * @author maksi
 */
public class MaszynaSzyfrujaca {

    private Krosownica krosownica;
    private Reflektor reflektor;
    private Wirnik[] wirniki;

    /**
     * Konstruktor klasy Maszyna Szyfrująca
     *
     * @param krosownica
     * @param reflektor
     * @param wirniki
     */
    public MaszynaSzyfrujaca(Krosownica krosownica, Reflektor reflektor, Wirnik[] wirniki) {
        this.krosownica = krosownica;
        this.reflektor = reflektor;
        this.wirniki = wirniki;
    }

    /**
     * 
     * @param znak
     * @return 
     */
    
    public char szyfrujZnak(char znak) {
        for (int i = 0; i < wirniki.length; i++) {
            boolean czyObracac = wirniki[i].obroc();
            if (!czyObracac) {
                break;
            }
        }
        int sygnal = znak - 'A';

        sygnal = krosownica.zamien(sygnal);

        for (int i = 0; i < wirniki.length; i++) {
            sygnal = wirniki[i].szyfrujWPrzod(sygnal);
        }

        sygnal = reflektor.odbij(sygnal);

        for (int i = wirniki.length - 1; i >= 0; i--) {
            sygnal = wirniki[i].szyfrujWTyl(sygnal);
        }

        sygnal = krosownica.zamien(sygnal);

        return (char) (sygnal + 'A');
    }
}
