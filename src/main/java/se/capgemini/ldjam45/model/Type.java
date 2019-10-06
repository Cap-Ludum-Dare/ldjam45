package se.capgemini.ldjam45.model;

import java.awt.*;

public abstract class Type implements Updateable, Interactable, Alive {
	
	protected int x;
	protected int y;
	protected int width;
	protected int height;
	protected Image image;
	
	public Type(int x, int y, int width, int height, Image image) {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		this.image = image;
	}
	
	public int x() {
		return x;
	}
	
	public int y() {
		return y;
	}
	
	public int width() {
		return width;
	}
	
	public int height() {
		return height;
	}
	
	public void setX(int x) {
		this.x = x;
	}
	
	public void setY(int y) {
		this.y = y;
	}

	public Image getImage() {
		return image;
	}
}
