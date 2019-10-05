package model;

public class Hero extends Type implements Alive {

	public Hero(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public boolean isAlive() {
		return true;
	}

	public void update() {
		
	}

	public void tick() {
		
	}

}
