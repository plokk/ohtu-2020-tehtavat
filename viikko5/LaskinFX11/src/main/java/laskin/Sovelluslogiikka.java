package laskin;

public class Sovelluslogiikka {

    private int tulos;

    public void aseta(int luku) {
        tulos = luku;
    }

    public void plus(int luku) {
        tulos += luku;
    }

    public void miinus(int luku) {
        tulos -= luku;
    }

    public void nollaa() {
        aseta(0);
    }

    public int tulos() {
        return tulos;
    }
}
