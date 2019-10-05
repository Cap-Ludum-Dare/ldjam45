package model;

public class Hero extends Type implements Alive {

	private int speed = 10;
	private int dx = 0;
	private int dy = 0;
	
	public Hero(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public boolean isAlive() {
		return true;
	}
	
	public void move(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}

	public void update() {
		
	}

	public void tick() {
		x += dx * speed;
		y += dy * speed;
	}

}
