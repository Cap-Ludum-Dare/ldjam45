package se.capgemini.ldjam45.builder;

import java.util.ArrayList;

import controller.KeyController;
import model.Hero;
import model.Updateable;
import se.capgemini.ldjam45.ui.Window;
import view.TypeView;
import view.View;

public class UIBuilder extends ArrayList<Updateable> implements Updateable {
	
	
	public void build(Hero hero) {
		View view = new View();
		
		// x, y, width, height
		// Hero secondus = new Hero(80, 80, 50, 50);
		TypeView heroView = new TypeView(hero);
		heroView.update();
		this.add(heroView);
		
		view.add(heroView);
		
		Window window = new Window();
		window.setContentPane(view);
		
		KeyController keyController = new KeyController(hero);
		window.addKeyListener(keyController);
		
		
	}

	public void update() {
		for (Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
	}

	public void tick() {

	}
	

}
