package ohtu.kivipaperisakset;

public abstract class KiviPaperiSakset {

    protected IO konsoli;
    private Tuomari tuomari;

    // tämä on ns template metodi
    public void pelaa(IO konsoli, Tuomari tuomari) {
        this.konsoli = konsoli;
        this.tuomari = tuomari;

        String ekanSiirto = ensimmaisenSiirto();
        String tokanSiirto = toisenSiirto(ekanSiirto);
        
        while (onkoOkSiirto(ekanSiirto) && onkoOkSiirto(tokanSiirto)) {
            tuomari.kirjaaSiirto(ekanSiirto, tokanSiirto);
            System.out.println(tuomari);
            System.out.println();

            ekanSiirto = ensimmaisenSiirto();
            tokanSiirto = toisenSiirto(ekanSiirto);
        }

        System.out.println();
        System.out.println("Kiitos!");
        System.out.println(tuomari);
    }
    
    protected String ensimmaisenSiirto() {
        System.out.print("Ensimmäisen pelaajan siirto: ");
        return konsoli.nextLine();
    }

    // tämä on abstrakti metodi sillä sen toteutus vaihtelee eri pelityypeissä
    abstract protected String toisenSiirto(String ekanSiirto);
    
    protected static boolean onkoOkSiirto(String siirto) {
        return "k".equals(siirto) || "p".equals(siirto) || "s".equals(siirto);
    }
}