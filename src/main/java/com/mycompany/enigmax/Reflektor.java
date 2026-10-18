package com.mycompany.enigmax;

/**
 * Klasa Reflektor reprezentuje element umieszczony na samym końcu bębna
 * z wirnikami, odpowiadający za odwrócenie biegu impulsu elektrycznego.
 * @author maksi
 */

public class Reflektor {
    
    private final String alfabetPrzetasowany;
    
    /**
     * Konstruktor klasy Reflektor
     * @param alfabetPrzetasowany 
     */
    
    public Reflektor(String alfabetPrzetasowany) {
        this.alfabetPrzetasowany = alfabetPrzetasowany;
    }
    
    /**
     * Metoda realizująca odbicie sygnału.
     * @param wejscie
     * @return 
     */
    
    public int odbij(int wejscie){
        char znak = alfabetPrzetasowany.charAt(wejscie);
        
        return znak - 'A';
    }
    
}
