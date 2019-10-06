package se.capgemini.ldjam45.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.editor.Editor;

public class View extends JPanel {

	private static final int ICON_SIZE = 50;
	private static final long serialVersionUID = 2118299654730994785L;
	private Editor editor;
	private Camera camera;
	private List<Overlay> overlays = new ArrayList<Overlay>();

	public View(Editor editor, Camera camera) {
		this.setLayout(null);
		this.editor = editor;
		this.camera = camera;
	}
	
	public void addOverlays(Overlay... overlays) {
		this.overlays.addAll(Arrays.asList(overlays));
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
				
				// g.setColor(Color.red);
				// g.drawString((camera.revertX(dx) / 50) + " " + (camera.revertY(dy) / 50), dx + 15, dy + 15);
			}
		}
		
		for (Overlay overlay : new ArrayList<Overlay>(overlays)) {
			if (overlay.isAlive()) {
				overlay.paintComponent(g, this.getWidth(), this.getHeight());
			}
		}
		
	}

}


