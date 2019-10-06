package se.capgemini.ldjam45.builder;

import java.util.Arrays;

import se.capgemini.ldjam45.client.RestClient;
import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.controller.ClientController;
import se.capgemini.ldjam45.controller.KeyController;
import se.capgemini.ldjam45.controller.TimeController;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.model.Item;
import se.capgemini.ldjam45.model.World;
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
		Editor editor = new Editor(camera);
		UIBuilder ui = new UIBuilder();
		
		KeyController keyController = new KeyController(hero, editor);
		ui.build(keyController, camera, editor);
		ui.addViews(world);
		
		TimeController timer = new TimeController(hero);
		timer.addAll(world);
		timer.add(ui);
		
		timer.start();
		
	}

	public static void main(String[] m) {
		new GameBuilder().build();

		ClientController clientController = new ClientController();
		System.out.println(clientController.getScores());

		BackgroundMusic bgMusic = new BackgroundMusic();
		Thread t1 = new Thread(bgMusic);
		t1.start();

		SoundEffect.test(); // Test sound effects!
	}
	
}
