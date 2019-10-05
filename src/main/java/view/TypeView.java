package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JLabel;

import model.Hero;
import model.Type;
import model.Updateable;

public class TypeView extends JLabel implements Updateable {
	
	private static final long serialVersionUID = -6626113045924858904L;
	
	private Type type;
	
	public TypeView() {
		this.setOpaque(true);
	}
	
	public TypeView(Type type) {
		this();
		this.setType(type);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		if (exists()) {
			this.setBackground(Color.green);
		} else {
			this.setBackground(Color.red);		
		}
	}
	
	public void setType(Type type) {
		this.type = type;
		
		if (exists()) {
			Dimension dimension = new Dimension(type.width(), type.height());
			
			this.setSize(dimension);
			this.setPreferredSize(dimension);
			this.setVisible(true);
		}
	}
	
	public boolean exists() {
		return this.type != null;
	}

	public void update() {
		if (exists()) {
			if (!type.isAlive()) {
				type = null;
				this.setVisible(false);
			} else {
				this.setLocation(type.x(), type.y());
			}
		}
	}

	public void tick() {
	}
	
	
}
