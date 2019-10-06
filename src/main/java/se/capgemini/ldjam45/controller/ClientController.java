package se.capgemini.ldjam45.controller;

import se.capgemini.ldjam45.client.RestClient;
import se.capgemini.ldjam45.model.Score;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static java.lang.Thread.sleep;

public class ClientController implements Runnable {

    private RestClient client;
    private LinkedList<Runnable> tasks = new LinkedList<>();

    public ClientController() {
        client = new RestClient();
    }

    public void start() {
    }

    public List<Score> getScores() {
        return client.getScores();
    }

    public List<Score> getHighScore() {
        return client.getHighScore();
    }

    public List<Score> getTop3() {
        return client.getTop3Scores();
    }

    public String saveScore(String username, int score) {
        return client.saveScore(username, score);
    }


    @Override
    public void run() {
        while (true) {
            if (!tasks.isEmpty()) {
                Runnable runnable = tasks.removeFirst();
                runnable.run();
            } else {
                try {
                    sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
