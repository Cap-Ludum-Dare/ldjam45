package se.capgemini.ldjam45.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Arrays;
import java.util.List;

import se.capgemini.ldjam45.model.Alive;

public class Overlay implements Alive {

	private List<String> overlays;
	private long lifetime;
	private long start = System.currentTimeMillis();
	private int initHeight;
	private Font font;
	
	public Overlay(List<String> overlays, Font font, long lifetime, int initHeight) {
		this.overlays = overlays;
		this.lifetime = lifetime;
		this.initHeight = initHeight;
		this.font = font;
	}

	@Override
	public boolean isAlive() {
		return lifetime + start > System.currentTimeMillis();
	}
	
	public boolean isFinished() {
		return start > 0 && !isAlive();
	}
	
	public void start() {
		if (start == 0) {
			start = System.currentTimeMillis();
		}
	}
	
	public void paintComponent(Graphics g, int width, int height) {
		
		start();
		
		int y = 0;
		for (String overlay : overlays) {

			
			double div = lifetime / Math.max(1, System.currentTimeMillis() - start);

			g.setFont(font);
			g.setColor(new Color(0, 0, 0, 255 - (int)(255/div)));
			g.drawString(overlay,
					width / 2 - g.getFontMetrics().stringWidth(overlay) / 2,
					(int)(1.5 * font.getSize()) * y + (initHeight < 0 ? height + initHeight : initHeight));
			y++;
		}
		
	}
	
}
