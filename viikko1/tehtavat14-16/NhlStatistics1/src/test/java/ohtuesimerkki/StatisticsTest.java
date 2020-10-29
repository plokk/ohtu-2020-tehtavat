package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri",   "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    @Before
    public void setUp(){
        // luodaan Statistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @Test
    public void searchNoPlayer() {
        assertEquals(stats.search("fakePlayer"), null);
    }

    @Test
    public void searchPlayer() {
        assertEquals(stats.search("Semenko").getName(), "Semenko");
    }

    @Test
    public void teamEDM() {
        assertEquals(stats.team("EDM").size(), 3);
        assertEquals(stats.team("EDM").get(0).getName(), "Semenko");
        assertEquals(stats.team("EDM").get(1).getName(), "Kurri");
        assertEquals(stats.team("EDM").get(2).getName(), "Gretzky");
    }

    @Test
    public void topScorers() {
        assertEquals(stats.topScorers(0).size(), 1);
        assertEquals(stats.topScorers(0).get(0).getName(), "Gretzky");
        assertEquals(stats.topScorers(1).get(1).getName(), "Lemieux");
    }
}
