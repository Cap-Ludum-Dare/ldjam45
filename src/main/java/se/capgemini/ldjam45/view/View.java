package se.capgemini.ldjam45.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import se.capgemini.ldjam45.editor.PointEditor;

public class View extends JPanel {

	private static final int ICON_SIZE = 50;
	private static final long serialVersionUID = 2118299654730994785L;
	private PointEditor editor;

	public View(PointEditor editor) {
		this.setLayout(null);
		this.editor = editor;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int x = 0; x < (this.getWidth() + ICON_SIZE); x += ICON_SIZE){
			for(int y = 0; y < (this.getHeight() + ICON_SIZE); y += ICON_SIZE){
				g.drawImage(Images.GRASS2.getImage(), x, y, this);
				g.setColor(Color.RED);
				g.drawString("" + editor.get(x, y), x, y);
			}
		}
	}

}


