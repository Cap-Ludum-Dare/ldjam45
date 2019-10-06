package se.capgemini.ldjam45.builder;

import java.awt.*;
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

	private void addItem(List<Item> items, String name, int x, int y, Image image) {
		Item item = new Item(name, x, y, 30, 30, image);
		items.add(item);
	}

	public void build() {
		
		// x, y, width, height
		Hero hero = new Hero("You",50, 50, 50, 80, Images.HERO_0.getImage());

		List<Item> items = new ArrayList<Item>();

		// Level 0:
		//   Walking
		//   Running

		// Level 1
		addItem(items, "Backpack", 100, 100, Images.BACKPACK.getImage());
		addItem(items, "Book", 200, 100, Images.BOOK.getImage());
		addItem(items, "Computer", 300, 100, Images.COMPUTER.getImage());
		addItem(items, "Joystick", 400, 100, Images.JOYSTICK.getImage());
		addItem(items, "Juice", 500, 100, Images.JUICE.getImage());
		addItem(items, "Notepad", 600, 100, Images.NOTEPAD.getImage());
		addItem(items, "Remote", 700, 100, Images.REMOTE.getImage());
		addItem(items, "Screwdriver", 800, 100, Images.SCREWDRIVER.getImage());
		addItem(items, "Smartphone", 900, 100, Images.SMARTPHONE.getImage());
		addItem(items, "Toothbrush", 1000, 100, Images.TOOTHBRUSH.getImage());

		// Level 2
		addItem(items, "Blender", 1100, 100, Images.BLENDER.getImage());
		addItem(items, "Brush", 1200, 100, Images.BRUSH.getImage());
		addItem(items, "Calculator", 1300, 100, Images.CALCULATOR.getImage());
		addItem(items, "Chemistry", 1400, 100, Images.CHEMISTRY.getImage());
		addItem(items, "Coffee", 1500, 100, Images.COFFEE.getImage());
		addItem(items, "Headset", 1600, 100, Images.HEADSET.getImage());
		addItem(items, "Pan", 1700, 100, Images.PAN.getImage());
		addItem(items, "Pepper", 1800, 100, Images.PEPPER.getImage());
		addItem(items, "Wheel", 1900, 100, Images.WHEEL.getImage());
		addItem(items, "Wine", 2000, 100, Images.WINE.getImage());

		// Level 3
		addItem(items, "Backend", 2100, 100, Images.BACKEND.getImage());
		addItem(items, "Bell", 2200, 100, Images.BELL.getImage());
		addItem(items, "Color", 2300, 100, Images.COLOR.getImage());
		addItem(items, "Frontend", 2400, 100, Images.FRONTEND.getImage());
		addItem(items, "Key", 2500, 100, Images.KEY.getImage());
		addItem(items, "Keyboard", 2600, 100, Images.KEYBOARD.getImage());
		addItem(items, "Pen", 2700, 100, Images.PEN.getImage());
		addItem(items, "Screen", 2800, 100, Images.SCREEN.getImage());
		addItem(items, "Stack", 2900, 100, Images.STACK.getImage());
		addItem(items, "Video games", 3000, 100, Images.VIDEO_GAMES.getImage());

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
