package se.capgemini.ldjam45.model;

import java.util.ArrayList;

import se.capgemini.ldjam45.builder.UIBuilder;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.view.Images;

public class World extends ArrayList<Type> implements Updateable {

	private Hero hero;
	private Editor editor;
	private UIBuilder ui;
	
	public World(Hero hero, Editor editor, UIBuilder ui) {
		this.hero = hero;
		this.editor = editor;
		this.ui = ui;
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
				String skill = hero.interact((Type)updateable);
				if (!skill.isEmpty()) {
					ui.showScoreAndSkill(skill);
				}
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
