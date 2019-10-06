package se.capgemini.ldjam45.model;

import java.awt.Image;

import se.capgemini.ldjam45.score.ScoreHandler;
import se.capgemini.ldjam45.sound.SoundEffect;

public class Item extends Hero {

	public Item(String name, int x, int y, int width, int height, Image image) {
		super(name, x, y, width, height, image);
	}

	public Item pickedUp() {
		isAlive = false;
		SoundEffect.PICK.play();
		ScoreHandler.addScore(100);
		return this;
	}

}
