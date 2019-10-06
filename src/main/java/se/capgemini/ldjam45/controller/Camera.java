package se.capgemini.ldjam45.controller;

import se.capgemini.ldjam45.model.Type;
import se.capgemini.ldjam45.ui.Window;

public class Camera {
	
	private Type centeredType;
	private Window window;
	
	public Camera(Type centeredType) {
		this.setType(centeredType);
	}
	
	public void setWindow(Window window) {
		this.window = window;
	}
	
	public void setType(Type centeredType) {
		this.centeredType = centeredType;
	}
	
	public int xOffset() {
		return (centeredType.x() + centeredType.width()/2) - window.getWidth()/2;
	}
	
	public int yOffset() {
		return (centeredType.y() + centeredType.height()/2) - window.getHeight()/2;
	}
	
	public int dx(int originalX) {
		return originalX - xOffset();
	}
	
	public int revertX(int newX) {
		return xOffset() + newX;
	}
	
	public int dy(int originalY) {
		return originalY - yOffset();
	}
	
	public int revertY(int newY) {
		return yOffset() + newY;
	}

}
