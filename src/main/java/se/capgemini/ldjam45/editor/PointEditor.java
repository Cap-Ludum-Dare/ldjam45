package se.capgemini.ldjam45.editor;

import java.awt.Point;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import se.capgemini.ldjam45.controller.Camera;

public class PointEditor {

	private static final String FILE_NAME = "scenario/scenario.txt";
	private static final int MULTIPLIER = 50;
	
	private Camera camera;
	
	// <Y, <X, Character>>
	private Map<Point, Character> map;
	
	public PointEditor(Camera camera) {
		load();
		this.camera = camera;
	}
	
	public char get(int x, int y) {
		x = camera.revertX(x) / MULTIPLIER;
		y = camera.revertY(y) / MULTIPLIER;
		Point point = new Point(x, y);
		return map.containsKey(point) ? map.get(point) : ' ';
	}
	
	public void put (int x, int y, char character) {
		x = camera.revertX(x) / MULTIPLIER;
		y = camera.revertY(y) / MULTIPLIER;

		
		if (x >= 0 && y >= 0) {
			map.put(new Point(x, y), character);
			
			save();
		} else {
			System.out.println("(" + x + ", " + y + ") are outside limits!");
		}
	}
	
	private void load() {

		try (ObjectInputStream stream = new ObjectInputStream(this.getClass().getClassLoader().getResourceAsStream(FILE_NAME))){
			map = (Map<Point, Character>)stream.readObject();
	        
		} catch (Exception ex) {
			ex.printStackTrace();
			map = new HashMap<Point, Character>();
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
