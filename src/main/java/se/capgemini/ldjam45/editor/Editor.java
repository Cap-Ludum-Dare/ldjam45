package se.capgemini.ldjam45.editor;

import java.awt.Point;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.view.Images;

public class Editor {

	private static final String FILE_NAME = "scenario/scenario.txt";
	private static final int MULTIPLIER = 50;
	
	private Camera camera;
	
	// <Y, <X, Character>>
	private Map<Point, String> map;
	
	public Editor(Camera camera) {
		load();
		this.camera = camera;
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
		
		x = (revertedX / MULTIPLIER) - (revertedX % MULTIPLIER != 0 ? 1 : 0);
		y = (revertedY / MULTIPLIER) - (revertedY % MULTIPLIER != 0 ? 1 : 0);

		Point point = new Point(x, y);
		
		key = getKey(key, point); 
		
		map.put(point, key);
		
		save();
	}
	
	private String getKey(String key, Point point) {
		String currentKey = map.get(point);
		
		String name = null;
		int number = 1;
		
		if (currentKey != null && (currentKey.charAt(0) + "").equals((key + "").toUpperCase())) {
			number = Integer.parseInt(currentKey.split(Images.SEPARATOR)[1]) + 1;
			name = currentKey.split(Images.SEPARATOR)[0];
			
			String testKey = name + Images.SEPARATOR + number;
			try {
				Images.valueOf(testKey);
			} catch (Exception nonExistingKey) {
				number = 1;
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
