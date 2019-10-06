package se.capgemini.ldjam45.view;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.controller.ClientController;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Score;
import se.capgemini.ldjam45.score.ScoreHandler;

import javax.swing.*;
import java.awt.*;
import java.util.List;

import static se.capgemini.ldjam45.view.Images.*;

public class GameOver extends JPanel {

    private Editor editor;
    private Camera camera;
    private ClientController clientController;

    public GameOver(Editor editor, Camera camera) {
        this.setLayout(null);
        this.editor = editor;
        this.camera = camera;
        this.clientController = new ClientController();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        int x = this.getWidth() / 2 - (WIN_X_SIZE / 2);
        int y = this.getHeight() / 2 - (WIN_Y_SIZE / 2);

        g.drawImage(GAME_OVER.getImage(), x, y, this);
        g.setFont(new Font("Verdana", Font.BOLD, 50));
        g.drawString("Scores: ", this.getWidth() - (this.getWidth() * 3/10), this.getHeight() - (this.getHeight() * 9/10));
        List<Score> scores = clientController.getScores();
        g.setFont(new Font("Verdana", Font.BOLD, 20));
        int spacement = 0;
        for (Score s : scores) {
            spacement += 50;
            g.drawString(s.getUsername() + ": " + s.getScore(), this.getWidth() - (this.getWidth() * 3/10), this.getHeight() - (this.getHeight() * 9/10) + spacement);
        }

        g.setColor(Color.black);
        g.setFont(new Font("Verdana", Font.BOLD, 30));
        g.drawString(String.valueOf("Your Score: " + ScoreHandler.getTotalScore()), this.getWidth() / 2 - (g.getFontMetrics().stringWidth(String.valueOf(ScoreHandler.getTotalScore()) + g.getFontMetrics().stringWidth(String.valueOf("Your Score: ")) / 2)), this.getHeight() - (this.getHeight() * 2/10));
    }
}
