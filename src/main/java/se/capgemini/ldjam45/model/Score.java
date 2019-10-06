package se.capgemini.ldjam45.model;

public class Score {

    private String username;
    private Integer score;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "username='" + username + '\'' +
                ", score=" + score +
                '}';
    }
}
