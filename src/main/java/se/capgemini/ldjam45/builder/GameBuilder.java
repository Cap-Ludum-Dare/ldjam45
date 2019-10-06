package se.capgemini.ldjam45.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import se.capgemini.ldjam45.view.Images;


public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}
	
	public void build() {
		
		// x, y, width, height
		Hero hero = new Hero("You",50, 50, 50, 80, Images.HERO_0.getImage());

		List<Item> items = new ArrayList<Item>();
		Item item = new Item("Backpack", 100, 100, 30, 30, Images.BACKPACK.getImage());
		items.add(item);
		item = new Item("Book", 200, 100, 30, 30, Images.BOOK.getImage());
		items.add(item);
		item = new Item("Computer", 300, 100, 30, 30, Images.COMPUTER.getImage());
		items.add(item);
		item = new Item("Joystick", 400, 100, 30, 30, Images.JOYSTICK.getImage());
		items.add(item);
		item = new Item("Juice", 500, 100, 30, 30, Images.JUICE.getImage());
		items.add(item);
		item = new Item("Notepad", 600, 100, 30, 30, Images.NOTEPAD.getImage());
		items.add(item);
		item = new Item("Remote", 700, 100, 30, 30, Images.REMOTE.getImage());
		items.add(item);
		item = new Item("Screwdriver", 800, 100, 30, 30, Images.SCREWDRIVER.getImage());
		items.add(item);
		item = new Item("Smartphone", 900, 100, 30, 30, Images.SMARTPHONE.getImage());
		items.add(item);
		item = new Item("Toothbrush", 1000, 100, 30, 30, Images.TOOTHBRUSH.getImage());
		items.add(item);
		item = new Item("Blender", 1100, 100, 30, 30, Images.BLENDER.getImage());
		items.add(item);
		item = new Item("Brush", 1200, 100, 30, 30, Images.BRUSH.getImage());
		items.add(item);
		item = new Item("Calculator", 1300, 100, 30, 30, Images.CALCULATOR.getImage());
		items.add(item);
		item = new Item("Chemistry", 1400, 100, 30, 30, Images.CHEMISTRY.getImage());
		items.add(item);
		item = new Item("Coffee", 1500, 100, 30, 30, Images.COFFEE.getImage());
		items.add(item);
		item = new Item("Headset", 1600, 100, 30, 30, Images.HEADSET.getImage());
		items.add(item);
		item = new Item("Pan", 1700, 100, 30, 30, Images.PAN.getImage());
		items.add(item);
		item = new Item("Pepper", 1800, 100, 30, 30, Images.PEPPER.getImage());
		items.add(item);
		item = new Item("Wheel", 1900, 100, 30, 30, Images.WHEEL.getImage());
		items.add(item);
		item = new Item("Wine", 2000, 100, 30, 30, Images.WINE.getImage());
		items.add(item);
		item = new Item("Backend", 2100, 100, 30, 30, Images.BACKEND.getImage());
		items.add(item);
		item = new Item("Bell", 2200, 100, 30, 30, Images.BELL.getImage());
		items.add(item);
		item = new Item("Color", 2300, 100, 30, 30, Images.COLOR.getImage());
		items.add(item);
		item = new Item("Frontend", 2400, 100, 30, 30, Images.FRONTEND.getImage());
		items.add(item);
		item = new Item("Key", 2500, 100, 30, 30, Images.KEY.getImage());
		items.add(item);
		item = new Item("Keyboard", 2600, 100, 30, 30, Images.KEYBOARD.getImage());
		items.add(item);
		item = new Item("Pen", 2700, 100, 30, 30, Images.PEN.getImage());
		items.add(item);
		item = new Item("Screen", 2800, 100, 30, 30, Images.SCREEN.getImage());
		items.add(item);
		item = new Item("Stack", 2900, 100, 30, 30, Images.STACK.getImage());
		items.add(item);
		item = new Item("Video games", 3000, 100, 30, 30, Images.VIDEO_GAMES.getImage());
		items.add(item);

		World world = new World(hero);
		world.addAll(items);
		
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
