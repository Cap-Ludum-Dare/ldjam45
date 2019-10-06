package se.capgemini.ldjam45.model;

import se.capgemini.ldjam45.view.Images;

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
	private int index = 0;

	private Image[] rightArray = {
			Images.HERO_6.getImage(),
			Images.HERO_7.getImage()
	};
	private Image[] leftArray = {
			Images.HERO_2.getImage(),
			Images.HERO_3.getImage()
	};
	private Image[] upArray = {
			Images.HERO_4.getImage(),
			Images.HERO_5.getImage()
	};
	private Image[] downArray = {
			Images.HERO_0.getImage(),
			Images.HERO_1.getImage()
	};

	public Hero(String name, String skill, int x, int y, int width, int height, Image image) {
		super(name, skill, x, y, width, height, image);
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
		
		index = (++index) % 2;
		if (isRight()) {
			image = rightArray[index];
		} else if (isLeft()){
			image = leftArray[index];
		} else if (isUp()) {
			image = upArray[index];
		} else if (isDown()) {
			image = downArray[index];
		}
	}

	public void update() {
		
	}

	public void tick() {

	}

	private boolean isDown() {
		return dy > 0;
	}

	private boolean isUp() {
		return dy < 0;
	}

	private boolean isLeft() {
		return dx < 0;
	}

	private boolean isRight() {
		return dx > 0;

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

	public String interact(Interactable interactable) {
		if (interactable instanceof Item) {
			Item item = (Item) interactable;
			items.add(item.pickedUp());
			return item.getSkill();
		}
		return "";
	}

	public Image getImage(){
		return this.image;
	}

	public void setImage(Image image){
		this.image = image;
	}

}
