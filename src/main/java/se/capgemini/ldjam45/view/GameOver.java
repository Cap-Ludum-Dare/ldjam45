package se.capgemini.ldjam45.view;

import se.capgemini.ldjam45.controller.ClientController;
import se.capgemini.ldjam45.model.Score;
import se.capgemini.ldjam45.score.ScoreHandler;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static se.capgemini.ldjam45.view.Images.*;

public class GameOver extends JPanel {

    private ClientController clientController;
    private String username;
    private List<Score> scores = new ArrayList<Score>();
    
    public GameOver() {
        this.setLayout(null);
        username = JOptionPane.showInputDialog("Insert username: ");
        username = username == null ? "Guest" : username.replaceAll("[^A-Za-z0-9 ]", "");
        
        
        this.clientController = new ClientController();

        new Thread() {
        	public void run() {
                clientController.saveScore(username, ScoreHandler.getTotalScore());
                
                scores = clientController.getScores();
        	}
        }.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.getWidth() / 2 - (WIN_X_SIZE / 2);
        int y = this.getHeight() / 2 - (WIN_Y_SIZE / 2);

        g.drawImage(GAME_OVER.getImage(), x, y, this);
        g.setFont(new Font("Verdana", Font.BOLD, 50));
        g.drawString("Scores: ", this.getWidth() - (this.getWidth() * 3 / 10), this.getHeight() - (this.getHeight() * 9 / 10));

        g.setFont(new Font("Verdana", Font.BOLD, 20));
        int spacement = 0;
        for (Score score : scores) {
            spacement += 50;
            g.drawString(score.getUsername() + ": " + score.getScore(), this.getWidth() - (this.getWidth() * 3 / 10), this.getHeight() - (this.getHeight() * 9 / 10) + spacement);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString(String.valueOf("Your Score: " + ScoreHandler.getTotalScore()), this.getWidth() / 2 - (g.getFontMetrics().stringWidth(String.valueOf(ScoreHandler.getTotalScore()) + g.getFontMetrics().stringWidth(String.valueOf("Your Score: ")) / 2)), this.getHeight() - (this.getHeight() * 2 / 10));


    }
}
