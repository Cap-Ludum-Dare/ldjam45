package se.capgemini.ldjam45.builder;

import java.util.Arrays;

import controller.KeyController;
import controller.TimeController;
import model.Hero;
import model.Item;
import model.World;

public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}
	
	public void build() {
		// x, y, width, height
		Hero hero = new Hero(50, 50, 50, 80);
		Item item = new Item(300, 300, 30, 30);
		
		World world = new World(hero);
		world.addAll(Arrays.asList(item));
		
		UIBuilder ui = new UIBuilder();
		ui.addViews(world);
		
		KeyController keyController = new KeyController(hero);
		ui.build(keyController);
		
		TimeController timer = new TimeController(hero);
		timer.addAll(world);
		timer.add(ui);
		
		timer.start();
		
	}

	public static void main(String[] m) {
		new GameBuilder().build();
	}
	
}
