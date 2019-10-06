package se.capgemini.ldjam45.model;

import java.awt.Image;

import se.capgemini.ldjam45.score.ScoreHandler;
import se.capgemini.ldjam45.sound.SoundEffect;

public class Item extends Hero {

	public Item(String name, String skill, int x, int y, int width, int height, Image image) {
		super(name, skill, x, y, width, height, image);
		World.itemsCreated++;
	}

	public String getSkill() {
		return skill;
	}

	public Item pickedUp() {
		isAlive = false;
		SoundEffect.PICK.play();
		ScoreHandler.addScore(100);

		return this;
	}

}
