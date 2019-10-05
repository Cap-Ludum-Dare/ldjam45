package controller;

import model.Type;
import se.capgemini.ldjam45.ui.Window;

public class Camera {
	
	private Type centeredType;
	private Window window;
	
	public Camera(Type centeredType, Window window) {
		this.centeredType = centeredType;
		this.window = window;
	}
	
	public int xOffset() {
		return (centeredType.x() - centeredType.width()/2) - window.getWidth();
	}
	
	public int yOffset() {
		return (centeredType.y() - centeredType.height()/2) - window.getHeight();
	}
	
	public int dx(int originalX) {
		return originalX - xOffset();
	}
	
	public int dy(int originalY) {
		return originalY - yOffset();
	}

}
