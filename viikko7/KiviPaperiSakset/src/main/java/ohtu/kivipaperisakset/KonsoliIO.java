package ohtu.kivipaperisakset;

import java.util.Scanner;

public class KonsoliIO implements IO {
    private Scanner lukija;

    public KonsoliIO() {
        lukija = new Scanner(System.in);
    }

    public String nextLine() {
        return lukija.nextLine();
    }

    public void print(String m) {
        System.out.println(m);
    }
}
