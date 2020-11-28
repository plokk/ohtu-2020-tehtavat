package laskin;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public abstract class Komento {

    protected Button nollaa;
    protected Button undo;
    protected TextField syotekentta;
    protected TextField tuloskentta;
    protected Sovelluslogiikka sovellus;
    protected int edellinenArvo;

    public Komento(TextField tuloskentta, TextField syotekentta, Button nollaa, Button undo, Sovelluslogiikka sovellus) {
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
        this.nollaa = nollaa;
        this.undo = undo;
        this.sovellus = sovellus;
    }

    public void aseta(int laskunTulos) {
        syotekentta.setText("");
        tuloskentta.setText("" + laskunTulos);

        if (laskunTulos == 0) {
            nollaa.disableProperty().set(true);
        } else {
            nollaa.disableProperty().set(false);
        }
        undo.disableProperty().set(false);
    }

    public abstract void peru();

    public abstract void suorita();
}