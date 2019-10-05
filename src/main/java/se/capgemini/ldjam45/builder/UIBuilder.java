package se.capgemini.ldjam45.builder;

import model.Hero;
import se.capgemini.ldjam45.ui.Window;
import view.TypeView;
import view.View;

public class UIBuilder {
	
	
	public void build() {
		View view = new View();
		
		// x, y, width, height
		Hero hero = new Hero(80, 80, 50, 50);
		TypeView heroView = new TypeView(hero);
		heroView.update();
		
		view.add(heroView);
		
		Window window = new Window();
		window.setContentPane(view);
		
		
	}
	

}
