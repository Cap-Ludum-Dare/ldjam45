package model;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Hero extends Type {
	
	private List<Item> items = new ArrayList<Item>();

	protected boolean isAlive = true;
	private int speed = 10;
	private int dx = 0;
	private int dy = 0;
	
	public Hero(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	public boolean isAlive() {
		return isAlive;
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
	
	public boolean isInteractable(Type type) {
		Rectangle rectangle = new Rectangle(x, y, width, height);
		Rectangle compared = new Rectangle(type.x, type.y, type.width, type.height);
		return rectangle.intersects(compared);
	}

	public void interact(Interactable interactable) {
		if (interactable instanceof Item) {
			items.add(((Item)interactable).pickedUp());
		}
	}

}
