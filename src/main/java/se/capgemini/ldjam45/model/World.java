package se.capgemini.ldjam45.model;

import java.util.ArrayList;

import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.view.Images;

public class World extends ArrayList<Type> implements Updateable {

	private Hero hero;
	private Editor editor;
	
	public World(Hero hero, Editor editor) {
		this.hero = hero;
		this.editor = editor;
	}

	public void update() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
		
		hero.update();
	}

	public void tick() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.tick();
			
			if (updateable instanceof Alive &&
					!((Alive)updateable).isAlive()) {
				this.remove(updateable);
			} else if (updateable instanceof Type
					&& hero.isInteractable((Type)updateable)) {
				hero.interact((Type)updateable);
			}
		}
		
		
		hero.tick();
		
		int nextX = hero.nextX();
		int nextY = hero.nextY();
		
		if (nextX != hero.x() || nextY != hero.y()) {
			boolean isWalkable = editor.isWalkable(nextX, nextY);
			
			if (isWalkable) {
				hero.move();
			}
		}
		
	}
	
}
