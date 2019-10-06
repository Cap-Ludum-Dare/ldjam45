package model;

import javax.swing.*;
import java.awt.*;

public class Item extends Hero {

	public Item(int x, int y, int width, int height, Image image) {
		super(x, y, width, height, image);
	}

	public Item pickedUp() {
		isAlive = false;
		return this;
	}

}
