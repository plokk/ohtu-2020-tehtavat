package ohtu;

public class TennisGame {
    
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private String playerOneName;
    private String playerTwoName;

    public TennisGame(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerName == "player1")
            playerOneScore += 1;
        else
            playerTwoScore += 1;
    }

    private String getScoreWhenEqual(int score) {
        switch (score)
        {
            case 0:
                return "Love-All";
            case 1:
                return "Fifteen-All";
            case 2:
                return "Thirty-All";
            case 3:
                return "Forty-All";
            default:
                return "Deuce";
        }
    }

    private String getScoreWhenAtLeastOnePlayerHasFourOrMore() {
        int scoreDifference = playerOneScore - playerTwoScore;
        if (scoreDifference == 1) return "Advantage player1";
        else if (scoreDifference == -1) return "Advantage player2";
        else if (scoreDifference >= 2) return "Win for player1";
        else return "Win for player2";
    }

    private String getScoreString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
        }
        return "";
    }

    private String getCommonScore() {
        return getScoreString(playerOneScore) + "-" + getScoreString(playerTwoScore);
    }

    public String getScore() {
        if (playerOneScore == playerTwoScore)
        {
            return getScoreWhenEqual(playerOneScore);
        }
        else if (playerOneScore >=4 || playerTwoScore >=4)
        {
            return getScoreWhenAtLeastOnePlayerHasFourOrMore();
        }
        else
        {
            return getCommonScore();
        }
    }
}