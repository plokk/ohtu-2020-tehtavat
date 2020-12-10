package ohtu.kivipaperisakset;

public class KPSTekoaly extends KiviPaperiSakset {

    private Tekoaly tekoaly = new Tekoaly();

    @Override
    protected String toisenSiirto(String ekanSiirto) {
        String tokanSiirto = tekoaly.annaSiirto();
        System.out.println("Tietokone valitsi: " + tokanSiirto);
        tekoaly.asetaSiirto(ekanSiirto);
        return tokanSiirto;
    }
}
