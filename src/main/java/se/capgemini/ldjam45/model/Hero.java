package se.capgemini.ldjam45.model;

import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class Hero extends Type {
	
	private List<Item> items = new ArrayList<Item>();

	protected boolean isAlive = true;
	private int speed = 10;
	private int dx = 0;
	private int dy = 0;

	public Hero(String name, int x, int y, int width, int height, Image image) {
		super(name, x, y, width, height, image);
	}
	
	public boolean isAlive() {
		return isAlive;
	}
	
	public void move(int dx, int dy) {
		this.dx = dx;
		this.dy = dy;
	}
	
	public void move() {
		x = nextX();
		y = nextY();
	}

	public void update() {
		
	}

	public void tick() {

	}
	
	public int nextY() {
		return y + dy * speed;
	}
	
	public int nextX() {
		return x + dx * speed;
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

	public Image getImage(){
		return this.image;
	}

}
