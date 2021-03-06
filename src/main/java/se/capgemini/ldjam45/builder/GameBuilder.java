package se.capgemini.ldjam45.builder;

import java.awt.*;
import java.util.List;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.controller.KeyController;
import se.capgemini.ldjam45.controller.TimeController;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.model.Item;
import se.capgemini.ldjam45.model.World;
import se.capgemini.ldjam45.sound.BackgroundMusic;
import se.capgemini.ldjam45.ui.Window;
import se.capgemini.ldjam45.view.GameOver;
import se.capgemini.ldjam45.view.Images;
import se.capgemini.ldjam45.view.Victory;

import javax.swing.*;


public class GameBuilder {
	
	public GameBuilder() {
	}

	private void addItem(List<Item> items, String name, String skill, int x, int y, Image image) {
		Item item = new Item(name, skill, x, y, 30, 30, image);
		items.add(item);
	}

	public void build() {
		
		// x, y, width, height
		Hero hero = new Hero("You","You", 50, 50, Images.HERO_WIDTH, Images.HERO_HEIGHT, Images.HERO_0.getImage());

		Camera camera = new Camera(hero);
		Editor editor = new Editor(camera);
		UIBuilder ui = new UIBuilder();
		/*
		testing victory
		 */
		/*Victory v = new Victory();
		Window w = new Window();
		w.setContentPane(v);

		GameOver gameOver = new GameOver();
		Window w2 = new Window();
		w2.setContentPane(gameOver);*/
		
		World world = new World(hero, editor, ui);
		world.randomizeItems();

		KeyController keyController = new KeyController(hero, editor);
		ui.build(keyController, camera, editor);
		ui.addViews(world);
		ui.addView(hero);
		
		TimeController timer = new TimeController(hero, ui);
		timer.add(world);
		timer.add(ui);
		
		timer.start();
	}

	public static void main(String[] m) {
		new GameBuilder().build();

		BackgroundMusic bgMusic = new BackgroundMusic();
		Thread t1 = new Thread(bgMusic);
		t1.start();

		// SoundEffect.test(); // Test sound effects!

	}
}
