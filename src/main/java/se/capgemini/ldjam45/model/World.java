package se.capgemini.ldjam45.model;

import java.awt.*;
import java.util.*;

import se.capgemini.ldjam45.builder.UIBuilder;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.view.Images;

public class World extends ArrayList<Type> implements Updateable {

	public static final Rectangle WORLD = new Rectangle(-40, -40, 90, 90);
	public static int itemsCreated = 0;
	
	private Hero hero;
	private Editor editor;
	private UIBuilder ui;
	
	public World(Hero hero, Editor editor, UIBuilder ui) {
		this.hero = hero;
		this.editor = editor;
		this.ui = ui;
	}

	public void randomizeItems() {
		Images[] imagesArray = {
				Images.BACKPACK,
				Images.BOOK,
				Images.COMPUTER,
				Images.JOYSTICK,
				Images.JUICE,
				Images.NOTEPAD,
				Images.REMOTE,
				Images.SCREWDRIVER,
				Images.SMARTPHONE,
				Images.TOOTHBRUSH,
				Images.BLENDER,
				Images.BRUSH,
				Images.CALCULATOR,
				Images.CHEMISTRY,
				Images.COFFEE,
				Images.HEADSET,
				Images.PAN,
				Images.PEPPER,
				Images.WHEEL,
				Images.WINE,
				Images.BACKEND,
				Images.BELL,
				Images.COLOR,
				Images.FRONTEND,
				Images.KEY,
				Images.KEYBOARD,
				Images.PEN,
				Images.SCREEN,
				Images.STACK,
				Images.VIDEO_GAMES
		};



		Set<Point> points = new HashSet<Point>();
		Random random = new Random();
		for (Images images : imagesArray) {
				int x = random.nextInt(World.WORLD.width) + World.WORLD.x;
				int y = random.nextInt(World.WORLD.height) + World.WORLD.y;
				
				Point point = new Point(x, y);
				final int maxCount = 20;
				for (int i = 0; i < maxCount; i++) {
					if (!points.contains(point) &&
							editor.getExact(point).trim().isEmpty()) {
						String name = images.name().substring(0, 1).toUpperCase() + images.name().substring(1);
						String skill = images.skill;
						Item item = new Item(name, skill,x * Images.TILE_SIZE, y * Images.TILE_SIZE, Images.ITEM_SIZE, Images.ITEM_SIZE, images.getImage());
						this.add(item);
						points.add(point);
						break;
					}
				}
				
		}
		
		
	}

	public void update() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
		
		hero.update();
	}

	public void tick() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.tick();
			
			if (updateable instanceof Alive &&
					!((Alive)updateable).isAlive()) {
				this.remove(updateable);
			} else if (updateable instanceof Type
					&& hero.isInteractable((Type)updateable)) {
				String skill = hero.interact((Type)updateable);
				if (!skill.isEmpty()) {
					ui.showScoreAndSkill(skill);
				}
			}
		}
		
		
		hero.tick();
		
		int nextX = hero.nextX();
		int nextY = hero.nextY();
		
		if (nextX != hero.x() || nextY != hero.y()) {
			boolean isWalkable = editor.isWalkable(nextX, nextY);
			
			if (isWalkable) {
				hero.move();
			}
		}
		
	}
	
}
