package se.capgemini.ldjam45.builder;

import java.util.ArrayList;
import java.util.List;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.controller.KeyController;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Type;
import se.capgemini.ldjam45.model.Updateable;

import se.capgemini.ldjam45.ui.Window;
import se.capgemini.ldjam45.view.TypeView;
import se.capgemini.ldjam45.view.View;

public class UIBuilder extends ArrayList<Updateable> implements Updateable {
	
	private View view;
	private Camera camera;

	public UIBuilder(){

	}
	
	public void build(KeyController keyController, Camera camera, Editor editor) {
		view = new View(editor, camera);
		Window window = new Window();
		window.setContentPane(view);
		window.addKeyListener(keyController);
		view.addMouseListener(keyController);
		
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
		view.updateUI();
	}
	

}
