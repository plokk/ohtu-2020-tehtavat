package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Nollaa extends Komento {
    public Nollaa(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        super(tuloskentta, syotekentta, nollaa, undo, sovellus);
    }

    @Override
    public void peru() {
        aseta(edellinenArvo);
        sovellus.aseta(edellinenArvo);
    }

    @Override
    public void suorita() {
        try {
            edellinenArvo = Integer.parseInt(tuloskentta.getText());
        } catch (Exception e) {
        }

        sovellus.nollaa();
        aseta(sovellus.tulos());
    }
}