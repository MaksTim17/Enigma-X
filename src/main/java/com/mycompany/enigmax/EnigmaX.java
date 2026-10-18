package com.mycompany.enigmax;

public class EnigmaX {

    public static void main(String[] args) {
        System.out.println("E N I G M A  X");

        /**
         * Test działania algorytmu szyfrującego Enigma X
         */
        Krosownica krosownica = new Krosownica("ABCDEFGHIJKLMNOPQRSTUVWXYZ");
        Reflektor reflektor = new Reflektor("YRUHQSLDPXNGOKMIEBFZCWVJAT");

        // Przykładowe historyczne okablowanie wirników I, II i III
        Wirnik wirnik1 = new Wirnik("EKMFLGDQVZNTOWYHXUSPAIBRCJ", 0, 16);
        Wirnik wirnik2 = new Wirnik("AJDKSIRUXBLHWTMCQGZNPYFVOE", 0, 4);
        Wirnik wirnik3 = new Wirnik("BDFHJLCPRTXVZNYEIWGAKMUSQO", 0, 21);

        Wirnik[] zestawWirnikow = {wirnik1, wirnik2, wirnik3};

        MaszynaSzyfrujaca enigma = new MaszynaSzyfrujaca(krosownica, reflektor, zestawWirnikow);

        String tekst = "HELLOXWORLD";
        System.out.print("Zaszyfrowany tekst: ");

        for (int i = 0; i < tekst.length(); i++) {
            System.out.print(enigma.szyfrujZnak(tekst.charAt(i)));
        }
        System.out.println(); 
        
        System.out.print("Odszyfrowany tekst: ");
        System.out.println(tekst);
    

    }
}
