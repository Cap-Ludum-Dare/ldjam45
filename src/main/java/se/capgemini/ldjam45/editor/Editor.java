package se.capgemini.ldjam45.editor;

import java.awt.Point;
import java.awt.Rectangle;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.view.Images;

public class Editor {

	private static final String FILE_NAME = "scenario/scenario.txt";
	private static final int MULTIPLIER = Images.TILE_SIZE;
	
	private Camera camera;
	
	// <Y, <X, Character>>
	private Map<Point, String> map;
	
	public Editor(Camera camera) {
		load();
		this.camera = camera;
	}
	
	public String getOriginal(int x, int y) {
		x = x / MULTIPLIER;
		y = y / MULTIPLIER;
		
		Point point = new Point(x, y);
		return map.containsKey(point) ? map.get(point) : " ";
	}
	
	public boolean isWalkable(int x, int y) {
		int originalX = x;
		int originalY = y;
		x = x / MULTIPLIER;
		y = y / MULTIPLIER;
		
		boolean isWalkable = true;
		
		for (int i = x - 1; i<=x+1; i++) {
			for (int j = y - 1; j<=y+1; j++) {
				Point point = new Point(i, j);
				String key = map.get(point);
	
				try {
					Images images = Images.valueOf(key);
					
					if (!images.isWalkable()) {
						Rectangle hero = new Rectangle(originalX, originalY, Images.HERO_WIDTH, Images.HERO_HEIGHT);
						Rectangle square = new Rectangle(i * MULTIPLIER, j * MULTIPLIER, Images.TILE_SIZE, Images.TILE_SIZE);
						
						if (hero.intersects(square)) {
							isWalkable = false;
							break;
						}
					}
				} catch (Exception ex) {
				}
			}
		}
		
		return isWalkable;
	}
	
	public String get(int x, int y) {
		x = camera.revertX(x) / MULTIPLIER;
		y = camera.revertY(y) / MULTIPLIER;
		Point point = new Point(x, y);
		return map.containsKey(point) ? map.get(point) : " ";
	}
	
	public void put (int x, int y, String key) {
		int revertedX = camera.revertX(x);
		int revertedY = camera.revertY(y);
		
		int diffX = revertedX > 0 ? 0 : -1;
		int diffY = revertedY > 0 ? 0 : -1;
		
		x = (revertedX / MULTIPLIER) + diffX;
		y = (revertedY / MULTIPLIER) + diffY;
		
		Point point = new Point((int)x, (int)y);
		
		key = getKey(key, point); 
		
		map.put(point, key);
		
		save();
	}
	
	private String getKey(String key, Point point) {
		String currentKey = map.get(point);
		
		String name = null;
		int number = 0;
		
		if (currentKey != null && (currentKey.charAt(0) + "").equals((key + "").toUpperCase())) {
			number = Integer.parseInt(currentKey.split(Images.SEPARATOR)[1]) + 1;
			name = currentKey.split(Images.SEPARATOR)[0];
			
			String testKey = name + Images.SEPARATOR + number;
			try {
				Images.valueOf(testKey);
			} catch (Exception nonExistingKey) {
				number = 0;
			}
			
		} else {
			Images images = Images.getImage(key);
			name = images.name().split(Images.SEPARATOR)[0];
		}
		
		return name + Images.SEPARATOR + number;
	}
	
	private void load() {

		try (ObjectInputStream stream = new ObjectInputStream(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME))){
			map = (Map<Point, String>)stream.readObject();
	        
		} catch (Exception ex) {
			ex.printStackTrace();
			map = new HashMap<Point, String>();
		}
	}
	
	private void save() {
		try (ObjectOutputStream stream = new ObjectOutputStream(new FileOutputStream(this.getClass().getClassLoader().getResource(FILE_NAME).getFile()))){
	        stream.writeObject(map);
	        
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
