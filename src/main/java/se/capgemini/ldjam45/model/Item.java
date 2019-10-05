package se.capgemini.ldjam45.model;

public class Item extends Hero {

	public Item(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Item pickedUp() {
		isAlive = false;
		return this;
	}

}
