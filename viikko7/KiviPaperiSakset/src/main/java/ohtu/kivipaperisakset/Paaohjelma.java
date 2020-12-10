package ohtu.kivipaperisakset;

public class Paaohjelma {

    public static void main(String[] args) {

        IO konsoli = new KonsoliIO();
        final String OHJE = "peli loppuu kun pelaaja antaa virheellisen siirron eli jonkun muun kuin k, p tai s";

        while (true) {
            System.out.println("\nValitse pelataanko"
                    + "\n (a) ihmistä vastaan "
                    + "\n (b) tekoälyä vastaan"
                    + "\n (c) parannettua tekoälyä vastaan"
                    + "\nmuilla valinnoilla lopetataan");

            String vastaus = konsoli.nextLine();
            if (vastaus.endsWith("a")) {
                System.out.println(OHJE);
                KPSPelaajaVsPelaaja kaksinpeli = new KPSPelaajaVsPelaaja();
                kaksinpeli.pelaa(konsoli, new Tuomari());
            } else if (vastaus.endsWith("b")) {
                System.out.println(OHJE);
                KPSTekoaly yksinpeli = new KPSTekoaly();
                yksinpeli.pelaa(konsoli, new Tuomari());
            } else if (vastaus.endsWith("c")) {
                System.out.println(OHJE);
                KPSParempiTekoaly pahaYksinpeli = new KPSParempiTekoaly();
                pahaYksinpeli.pelaa(konsoli, new Tuomari());
            } else {
                break;
            }

        }

    }
}
