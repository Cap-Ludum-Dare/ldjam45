package se.capgemini.ldjam45.builder;

import controller.TimeController;

public class GameBuilder {
	
	public GameBuilder() {
		
		
		
	}
	
	public void build() {
		UIBuilder ui = new UIBuilder();
		ui.build();
		
		TimeController timer = new TimeController();
		timer.start();
	}

	public static void main(String[] m) {
		new GameBuilder().build();
	}
	
}
