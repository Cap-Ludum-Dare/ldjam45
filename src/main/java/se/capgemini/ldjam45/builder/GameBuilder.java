package se.capgemini.ldjam45.builder;

import java.awt.Window;
import java.util.Arrays;

import controller.Camera;
import controller.KeyController;
import controller.TimeController;
import model.Hero;
import model.Item;
import model.World;
import se.capgemini.ldjam45.sound.BackgroundMusic;
import se.capgemini.ldjam45.sound.SoundEffect;

public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}
	
	public void build() {
		
		// x, y, width, height
		Hero hero = new Hero(50, 50, 50, 80);
		
		Item item = new Item(300, 300, 30, 30);
		
		World world = new World(hero);
		world.addAll(Arrays.asList(item));
		
		Camera camera = new Camera(hero);
		UIBuilder ui = new UIBuilder();
		
		KeyController keyController = new KeyController(hero);
		ui.build(keyController, camera);
		ui.addViews(world);
		
		TimeController timer = new TimeController(hero);
		timer.addAll(world);
		timer.add(ui);
		
		timer.start();
		
	}

	public static void main(String[] m) {
		new GameBuilder().build();

		BackgroundMusic bgMusic = new BackgroundMusic();
		Thread t1 = new Thread(bgMusic);
		t1.start();

		SoundEffect.test(); // Test sound effects!
	}
	
}
