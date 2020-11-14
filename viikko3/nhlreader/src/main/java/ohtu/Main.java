package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException {
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
                
        //System.out.println("json-muotoinen data:");
        //System.out.println( bodyText );

        // Esim:
        // [{"name":"Travis Zajac","nationality":"CAN","assists":16,"goals":9,"penalties":28,"team":"NJD","games":69}]

        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        Arrays.sort(players);

        System.out.println("Players from FIN " + new Date() + "\n\r");
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.format("%-20s", player.getName());
                System.out.format("%6s", player.getTeam());
                System.out.format("%4d", player.getGoals());
                System.out.format("%2s", "+");
                System.out.format("%3d", player.getAssists());
                System.out.format("%2s", "=");
                System.out.format("%3d", player.getScore());
                //System.out.format("%3d", k); 
                System.out.println();
            }
        }
    }
  
}