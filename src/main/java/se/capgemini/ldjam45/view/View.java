package se.capgemini.ldjam45.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JPanel;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.World;
import se.capgemini.ldjam45.timer.TimeCountdown;

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
				
				int revertedX = camera.revertX(dx) / Images.TILE_SIZE;
				int revertedY = camera.revertY(dy) / Images.TILE_SIZE;
				
				if (!World.WORLD.contains(new Point(revertedX, revertedY))) {
					g.setColor(Color.black);
					g.fillRect(dx, dy, Images.TILE_SIZE, Images.TILE_SIZE);
					
				} else {
					if (images.background != null) {
						g.drawImage(images.background.getImage(), dx, dy, this);
					}
					
					g.drawImage(images.getImage(), dx, dy, this);
				}
				
				// g.setColor(Color.red);
				// g.drawString((camera.revertX(dx) / 50) + " " + (camera.revertY(dy) / 50), dx + 15, dy + 15);
			}
		}
		
		for (Overlay overlay : new ArrayList<Overlay>(overlays)) {
			if (overlay.isAlive()) {
				overlay.paintComponent(g, this.getWidth(), this.getHeight());
			}
		}

		g.setColor(Color.BLACK);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString("Time: " + TimeCountdown.getGameTimeInSeconds() + "s", 10, 50);
	}

}


