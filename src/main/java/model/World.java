package model;

import java.util.ArrayList;
import java.util.Arrays;

public class World extends ArrayList<Type> implements Updateable {

	private Hero hero;
	
	public World(Hero hero) {
		super(Arrays.asList(hero));
		this.hero = hero;
	}

	public void update() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
	}

	public void tick() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.tick();
			
			if (updateable instanceof Alive &&
					!((Alive)updateable).isAlive()) {
				this.remove(updateable);
			}
		}
	}
	
}
