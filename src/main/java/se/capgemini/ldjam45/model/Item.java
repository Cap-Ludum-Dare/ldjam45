package se.capgemini.ldjam45.model;

import se.capgemini.ldjam45.sound.SoundEffect;

public class Item extends Hero {

	public Item(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public Item pickedUp() {
		isAlive = false;
		SoundEffect.PICK.play();
		return this;
	}

}
