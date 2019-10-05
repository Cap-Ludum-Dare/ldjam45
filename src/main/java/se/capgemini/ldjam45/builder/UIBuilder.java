package se.capgemini.ldjam45.builder;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import model.Type;
import model.Updateable;
import se.capgemini.ldjam45.ui.Window;
import view.TypeView;
import view.View;

public class UIBuilder extends ArrayList<Updateable> implements Updateable {
	
	private View view = new View();
	
	public void build(KeyListener keyListener) {
		Window window = new Window();
		window.setContentPane(view);
		window.addKeyListener(keyListener);
	}
	
	public void addViews(List<Type> types) {
		for (Type type : types) {
			this.addView(type);
		}
	}
	
	public void addView(Type type) {
		TypeView typeView = new TypeView(type);
		this.add(typeView);
		view.add(typeView);
	}

	public void update() {
		for (Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
	}

	public void tick() {

	}
	

}
