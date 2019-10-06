package se.capgemini.ldjam45.view;

import java.awt.Graphics;

import javax.swing.JPanel;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.editor.Editor;

public class View extends JPanel {

	private static final int ICON_SIZE = 50;
	private static final long serialVersionUID = 2118299654730994785L;
	private Editor editor;
	private Camera camera;

	public View(Editor editor, Camera camera) {
		this.setLayout(null);
		this.editor = editor;
		this.camera = camera;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		

		for(int x = - ICON_SIZE; x < (this.getWidth() + ICON_SIZE); x += ICON_SIZE){
			for(int y = - ICON_SIZE; y < (this.getHeight() + ICON_SIZE); y += ICON_SIZE) {
				
				int dx = camera.revertX(-camera.xOffset() + x - camera.xOffset() % ICON_SIZE);
				int dy = camera.revertY(-camera.yOffset() + y - camera.yOffset() % ICON_SIZE);
				
				String key = editor.get(dx, dy);
				
				Images images = null;
				try {
					images = key == null || key.trim().isEmpty() ? null : Images.valueOf(key);
				} catch (Exception ex) {
					// System.out.println("Image " + key + " doesn't exist.");
				}
					
				images = images == null ? Images.defaultImage() : images;
					
				g.drawImage(images.getImage(), dx, dy, this);
			}
		}
	}

}


