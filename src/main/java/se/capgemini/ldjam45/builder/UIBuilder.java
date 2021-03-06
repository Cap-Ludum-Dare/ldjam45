package se.capgemini.ldjam45.builder;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.controller.KeyController;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.model.Type;
import se.capgemini.ldjam45.model.Updateable;
import se.capgemini.ldjam45.model.World;
import se.capgemini.ldjam45.score.ScoreHandler;
import se.capgemini.ldjam45.sound.SoundEffect;
import se.capgemini.ldjam45.timer.TimeCountdown;
import se.capgemini.ldjam45.ui.Window;
import se.capgemini.ldjam45.view.GameOver;
import se.capgemini.ldjam45.view.Overlay;
import se.capgemini.ldjam45.view.TypeView;
import se.capgemini.ldjam45.view.Victory;
import se.capgemini.ldjam45.view.View;

public class UIBuilder extends ArrayList<Updateable> implements Updateable {

    private View view;
    private Camera camera;
    private Window window;

    public UIBuilder() {

    }

    public void build(KeyController keyController, Camera camera, Editor editor) {
        view = new View(editor, camera);
        window = new Window();
        window.setContentPane(view);
        window.addKeyListener(keyController);
        view.addMouseListener(keyController);

        view.addOverlays(
                new Overlay(Arrays.asList(
                        "Welcome",
                        "Let's start with nothing!"
                ), new Font("Arial", Font.BOLD, 30), 20000, 50),

                new Overlay(Arrays.asList(
                        "Credits LD45",
                        "Renata Faria, Linda-Marie Karlsson, Alfredo Faria,",
                        "Lars Tufvesson & Oskar Präntare"
                ), new Font("Arial", Font.PLAIN, 12), 100000, -70));

        this.camera = camera;
        camera.setWindow(window);
    }

    public void addViews(List<Type> types) {
        for (Type type : types) {
            this.addView(type);
        }
    }

    private int DISTANCE_BELOW = 30;
    private int TIME_ON_SCREEN = 1000; // Milliseconds

    public void addView(Type type) {
        TypeView typeView = new TypeView(camera, type);
        this.add(typeView);
        view.add(typeView);
        typeView.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent arg0) {
                SoundEffect.HIT.play();
                view.addOverlays(
                        new Overlay(Arrays.asList(
                                type.getName()
                        ), new Font("Arial", Font.BOLD, 30), TIME_ON_SCREEN, typeView.getY() + typeView.getHeight() + DISTANCE_BELOW));
            }
        });
    }

    public void showScoreAndSkill(String skill) {
        view.addOverlays(
                new Overlay(Arrays.asList(
                        "Added skill: " + skill
                ), new Font("Arial", Font.BOLD, 30), TIME_ON_SCREEN * 2, view.getHeight() - 400)
        );

        view.addOverlays(
                new Overlay(Arrays.asList(
                        "SCORE: " + ScoreHandler.getTotalScore()
                ), new Font("Arial", Font.BOLD, 30), TIME_ON_SCREEN * 2, view.getHeight() - 200)
        );
    }


    public void update() {
        for (Updateable updateable : new ArrayList<Updateable>(this)) {
            updateable.update();
        }
    }

    public synchronized void tick() {

    	if (window.getContentPane() instanceof View) {
	        if (Hero.items.size() >= World.itemsCreated - 2) {
	            window.setContentPane(new Victory());
	        } else if (TimeCountdown.getGameTimeInSeconds() <= 0) {
	            window.setContentPane(new GameOver());
	        }
    	}

        ((JPanel)window.getContentPane()).updateUI();
    }


}
