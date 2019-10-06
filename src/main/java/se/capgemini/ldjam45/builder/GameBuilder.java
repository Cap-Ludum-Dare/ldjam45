package se.capgemini.ldjam45.builder;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
import se.capgemini.ldjam45.ui.Window;
import se.capgemini.ldjam45.view.Images;
import se.capgemini.ldjam45.view.Victory;
import se.capgemini.ldjam45.view.View;


public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}

	private void addItem(List<Item> items, String name, String skill, int x, int y, Image image) {
		Item item = new Item(name, skill, x, y, 30, 30, image);
		items.add(item);
	}

	public void build() {
		
		// x, y, width, height
		Hero hero = new Hero("You","You", 50, 50, 50, 80, Images.HERO_0.getImage());

		List<Item> items = new ArrayList<Item>();

		// Level 0:
		//   Walking
		//   Running

		// Level 1
		addItem(items, "Computer", "Playing computer games", 300, 100, Images.COMPUTER.getImage());
		addItem(items, "Smartphone", "Playing mobile games", 900, 100, Images.SMARTPHONE.getImage());
		addItem(items, "Backpack", "Traveling alone", 100, 100, Images.BACKPACK.getImage());
		addItem(items, "Book", "Reading", 200, 100, Images.BOOK.getImage());
		addItem(items, "Joystick", "Playing arcade games", 400, 100, Images.JOYSTICK.getImage());
		addItem(items, "Juice", "Drinking soda", 500, 100, Images.JUICE.getImage());
		addItem(items, "Notepad", "Writing notes", 600, 100, Images.NOTEPAD.getImage());
		addItem(items, "Remote", "Playing console games", 700, 100, Images.REMOTE.getImage());
		addItem(items, "Screwdriver", "Hack your computer", 800, 100, Images.SCREWDRIVER.getImage());
		addItem(items, "Toothbrush", "Brushing your teeth", 1000, 100, Images.TOOTHBRUSH.getImage());

		// Level 2
		addItem(items, "Blender", "Making smoothies", 1100, 100, Images.BLENDER.getImage());
		addItem(items, "Brush", "Painting", 1200, 100, Images.BRUSH.getImage());
		addItem(items, "Calculator", "Math", 1300, 100, Images.CALCULATOR.getImage());
		addItem(items, "Chemistry", "Chemistry", 1400, 100, Images.CHEMISTRY.getImage());
		addItem(items, "Coffee", "Drinking coffee", 1500, 100, Images.COFFEE.getImage());
		addItem(items, "Headset", "Listening to opera", 1600, 100, Images.HEADSET.getImage());
		addItem(items, "Pan", "Cooking", 1700, 100, Images.PAN.getImage());
		addItem(items, "Pepper", "Eating spicy food", 1800, 100, Images.PEPPER.getImage());
		addItem(items, "Wheel", "Driving a car", 1900, 100, Images.WHEEL.getImage());
		addItem(items, "Wine", "Drinking wine", 2000, 100, Images.WINE.getImage());

		// Level 3
		addItem(items, "Backend", "Backend programming", 2100, 100, Images.BACKEND.getImage());
		addItem(items, "Bell", "Realtime programming", 2200, 100, Images.BELL.getImage());
		addItem(items, "Color", "Creating graphics for games", 2300, 100, Images.COLOR.getImage());
		addItem(items, "Frontend", "Frontend programming", 2400, 100, Images.FRONTEND.getImage());
		addItem(items, "Key", "Cryptography", 2500, 100, Images.KEY.getImage());
		addItem(items, "Keyboard", "Typing fast on a keyboard", 2600, 100, Images.KEYBOARD.getImage());
		addItem(items, "Pen", "Writing a CV", 2700, 100, Images.PEN.getImage());
		addItem(items, "Screen", "Programming in Python", 2800, 100, Images.SCREEN.getImage());
		addItem(items, "Stack", "Full stack developer", 2900, 100, Images.STACK.getImage());
		addItem(items, "Video games", "Creating games", 3000, 100, Images.VIDEO_GAMES.getImage());
		
		Camera camera = new Camera(hero);
		Editor editor = new Editor(camera);
		UIBuilder ui = new UIBuilder();
		/*
		testing victory
		 */
		Victory v = new Victory(editor, camera);
		Window w = new Window();
		w.setContentPane(v);
		
		World world = new World(hero, editor, ui);
		world.addAll(items);
		
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
	}
}
