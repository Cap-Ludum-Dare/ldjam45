package se.capgemini.ldjam45.score;

public class ScoreHandler {

    private static int totalScore = 0;

    public static int addScore(int score) {
        totalScore += score;
        return totalScore;
    }

    public static int getTotalScore() {
        return totalScore;
    }
}
