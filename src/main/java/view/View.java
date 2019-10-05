package view;

import java.awt.*;

import javax.swing.*;

public class View extends JPanel {

	private static final int ICON_SIZE = 50;
	private static final long serialVersionUID = 2118299654730994785L;

	public View() {
		this.setLayout(null);
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(int x = 0; x < (this.getWidth() + ICON_SIZE); x += ICON_SIZE){
			for(int y = 0; y < (this.getHeight() + ICON_SIZE); y += ICON_SIZE){
				g.drawImage(Images.GRASS2.getImage(), x, y, this);
			}
		}
	}

}


