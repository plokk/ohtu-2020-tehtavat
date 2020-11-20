package ohtu.intjoukkosovellus;

public class IntJoukko {

    public final static int KAPASITEETTI = 5, // aloitustalukon koko
                            OLETUSKASVATUS = 5;  // luotava uusi taulukko on näin paljon isompi kuin vanha
    private int kasvatuskoko;     // Uusi taulukko on tämän verran vanhaa suurempi.
    private int[] kokonaislukujoukko;      // Joukon luvut säilytetään taulukon alkupäässä.
    private int alkioidenLukumaara;    // Tyhjässä joukossa alkioiden_määrä on nolla.

    public enum JoukkoOperaatio {
        EROTUS,
        LEIKKAUS,
        YHDISTE
    };

    public IntJoukko() {
        this(KAPASITEETTI, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti) {
        this(kapasiteetti, OLETUSKASVATUS);
    }

    public IntJoukko(int kapasiteetti, int kasvatuskoko) {
        if (kapasiteetti < 0) {
            throw new IndexOutOfBoundsException("Kapasitteetti väärin");//heitin vaan jotain :D
        }
        if (kasvatuskoko < 0) {
            throw new IndexOutOfBoundsException("kapasiteetti2");//heitin vaan jotain :D
        }
        luoTyhjaJoukko(kapasiteetti);
        alkioidenLukumaara = 0;
        this.kasvatuskoko = kasvatuskoko;
    }

    public void luoTyhjaJoukko(int kapasiteetti) {
        kokonaislukujoukko = new int[kapasiteetti];
        for (int i = 0; i < kokonaislukujoukko.length; i++) {
            kokonaislukujoukko[i] = 0;
        }
    }

    public void kasvataTaulukkoa() {
        int[] taulukkoOld = new int[kokonaislukujoukko.length];
        taulukkoOld = kokonaislukujoukko;
        kopioiTaulukko(kokonaislukujoukko, taulukkoOld);
        kokonaislukujoukko = new int[alkioidenLukumaara + kasvatuskoko];
        kopioiTaulukko(taulukkoOld, kokonaislukujoukko);
    }

    public boolean lisaa(int luku) {
        if (kuuluu(luku)) return false;
        kokonaislukujoukko[alkioidenLukumaara] = luku;
        alkioidenLukumaara++;
        if (alkioidenLukumaara % kokonaislukujoukko.length == 0) {
            kasvataTaulukkoa();
        }
        return true;
    }

    public boolean kuuluu(int luku) {
        for (int i = 0; i < alkioidenLukumaara; i++) {
            if (luku == kokonaislukujoukko[i]) {
                return true;
            }
        }
        return false;
    }

    public int etsiKohta(int luku) {
        for (int i = 0; i < alkioidenLukumaara; i++) {
            if (luku == kokonaislukujoukko[i]) {
                return i;
            }
        }
        return -1;
    }

    public void nollaaAlkio(int kohta) {
        if (kohta == -1) {
            return;
        }
        kokonaislukujoukko[kohta] = 0;
    }

    public boolean poistaAlkio(int kohta) {
        if (kohta == -1) return false;
        int apu;
        for (int j = kohta; j < alkioidenLukumaara - 1; j++) {
            apu = kokonaislukujoukko[j];
            kokonaislukujoukko[j] = kokonaislukujoukko[j + 1];
            kokonaislukujoukko[j + 1] = apu;
        }
        alkioidenLukumaara--;
        return true;
    }

    public boolean poista(int luku) {
        int kohta = etsiKohta(luku);
        nollaaAlkio(kohta);
        return poistaAlkio(kohta);
    }

    private void kopioiTaulukko(int[] vanha, int[] uusi) {
        for (int i = 0; i < vanha.length; i++) {
            uusi[i] = vanha[i];
        }
    }

    public int mahtavuus() {
        return alkioidenLukumaara;
    }

    @Override
    public String toString() {
        if (alkioidenLukumaara == 0) return "{}";
        String tuotos = "{";
        for (int i = 0; i < alkioidenLukumaara - 1; i++) {
            tuotos += kokonaislukujoukko[i];
            tuotos += ", ";
        }
        tuotos += kokonaislukujoukko[alkioidenLukumaara - 1];
        tuotos += "}";
        return tuotos;
    }

    public int[] toIntArray() {
        int[] taulu = new int[alkioidenLukumaara];
        for (int i = 0; i < taulu.length; i++) {
            taulu[i] = kokonaislukujoukko[i];
        }
        return taulu;
    }

    private static IntJoukko teeJoukkoOperaatio(JoukkoOperaatio operaatio, IntJoukko a, IntJoukko b) {
        IntJoukko c = new IntJoukko();
        switch (operaatio) {
            case EROTUS:
                c = muodostaErotus(c, a.toIntArray(), b.toIntArray());
                break;
            case LEIKKAUS:
                c = muodostaLeikkaus(c, a.toIntArray(), b.toIntArray());
                break;
            case YHDISTE:
                c = muodostaYhdiste(c, a.toIntArray(), b.toIntArray());
        }
        return c;
    }

    private static IntJoukko muodostaErotus(IntJoukko erotusJoukko, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            erotusJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            erotusJoukko.poista(bTaulu[i]);
        }
        return erotusJoukko;
    }

    private static IntJoukko muodostaLeikkaus(IntJoukko leikkausJoukko, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            for (int j = 0; j < bTaulu.length; j++) {
                if (aTaulu[i] == bTaulu[j]) {
                    leikkausJoukko.lisaa(bTaulu[j]);
                }
            }
        }
        return leikkausJoukko;
    }

    private static IntJoukko muodostaYhdiste(IntJoukko yhdisteJoukko, int[] aTaulu, int[] bTaulu) {
        for (int i = 0; i < aTaulu.length; i++) {
            yhdisteJoukko.lisaa(aTaulu[i]);
        }
        for (int i = 0; i < bTaulu.length; i++) {
            yhdisteJoukko.lisaa(bTaulu[i]);
        }
        return yhdisteJoukko;
    }

    public static IntJoukko yhdiste(IntJoukko a, IntJoukko b) {
        return teeJoukkoOperaatio(JoukkoOperaatio.YHDISTE, a, b);
    }

    public static IntJoukko leikkaus(IntJoukko a, IntJoukko b) {
        return teeJoukkoOperaatio(JoukkoOperaatio.LEIKKAUS, a, b);
    }
    
    public static IntJoukko erotus (IntJoukko a, IntJoukko b) {
        return teeJoukkoOperaatio(JoukkoOperaatio.EROTUS, a, b);
    }
}