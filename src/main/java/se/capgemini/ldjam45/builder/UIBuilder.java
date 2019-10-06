package se.capgemini.ldjam45.builder;

import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;

import controller.Camera;
import model.Hero;
import model.Type;
import model.Updateable;
import se.capgemini.ldjam45.ui.Window;
import view.TypeView;
import view.View;

public class UIBuilder extends ArrayList<Updateable> implements Updateable {
	
	private View view;
	private Camera camera;

	public UIBuilder(){
		this.view = new View();
	}
	
	public void build(KeyListener keyListener, Camera camera) {
		Window window = new Window();
		window.setContentPane(view);
		window.addKeyListener(keyListener);
		
		this.camera = camera;
		camera.setWindow(window);
	}
	
	public void addViews(List<Type> types) {
		for (Type type : types) {
			this.addView(type);
		}
	}
	
	public void addView(Type type) {
		TypeView typeView = new TypeView(camera, type);
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
