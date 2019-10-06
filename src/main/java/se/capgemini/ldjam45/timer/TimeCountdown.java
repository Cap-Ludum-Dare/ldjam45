package se.capgemini.ldjam45.timer;

public class TimeCountdown {

    private static long gameTime = System.currentTimeMillis();

    public static long getGameTimeInSeconds() {
        return 300 - (System.currentTimeMillis() - gameTime) / 1000;
    }
}
