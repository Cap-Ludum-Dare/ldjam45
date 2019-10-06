package se.capgemini.ldjam45.score;

public class ScoreHandler {

    private static int totalScore = 0;
    private static String username = "";

    public static int addScore(int score) {
        totalScore += score;
        return totalScore;
    }

    public static int getTotalScore() {
        return totalScore;
    }

    public static void setTotalScore(int totalScore) {
        ScoreHandler.totalScore = totalScore;
    }

    public static String getUsername() {
        return username;
    }

    public static void setUsername(String username) {
        ScoreHandler.username = username;
    }
}
