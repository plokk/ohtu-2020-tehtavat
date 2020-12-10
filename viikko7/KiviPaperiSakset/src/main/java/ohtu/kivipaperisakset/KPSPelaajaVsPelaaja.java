package ohtu.kivipaperisakset;

public class KPSPelaajaVsPelaaja extends KiviPaperiSakset {
    @Override
    protected String toisenSiirto(String ekanSiirto) {
        System.out.print("Toisen pelaajan siirto: ");
        return konsoli.nextLine();
    }
}
