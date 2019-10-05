package se.capgemini.ldjam45.builder;

import controller.TimeController;
import model.Hero;
import model.World;

public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}
	
	public void build() {
		// x, y, width, height
		Hero hero = new Hero(50, 50, 50, 80);
		
		World world = new World(hero);
		
		UIBuilder ui = new UIBuilder();
		ui.build(hero);
		world.add(ui);
		
		TimeController timer = new TimeController(world);
		timer.start();
		
	}

	public static void main(String[] m) {
		new GameBuilder().build();
	}
	
}
