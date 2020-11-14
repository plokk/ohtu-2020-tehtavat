
package ohtu;

public class Player implements Comparable<Player> {
    private int assists;
    private int goals;
    private String name;
    private String nationality;
    private String team;

    public void setName(String name) {
        this.name = name;
    }

    public int getAssists() {
        return assists;
    }

    public int getGoals() {
        return goals;
    }

    public String getName() {
        return name;
    }

    public String getNationality() {
        return nationality;
    }

    public String getTeam() {
        return team;
    }

    public int getScore() {
        return goals + assists;
    }

    @Override
    public int compareTo(Player player){
        return player.getScore() - getScore();
    }

    @Override
    public String toString() {
        return name + " team " + team + " goals " + goals + " assists " + assists;
    }
      
}
