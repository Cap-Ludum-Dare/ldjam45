package se.capgemini.ldjam45.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.*;

import se.capgemini.ldjam45.controller.Camera;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.model.Type;
import se.capgemini.ldjam45.model.Updateable;

public class TypeView extends JLabel implements Updateable {
	
	private static final long serialVersionUID = -6626113045924858904L;
	
	private Type type;
	private Camera camera;
	
	public TypeView(Camera camera) {
		this.setOpaque(false);
		this.camera = camera;
	}
	
	public TypeView(Camera camera, Type type) {
		this(camera);
		this.setType(type);
	}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

	}
	
	public void setType(Type type) {
		this.type = type;
		
		if (exists()) {
			Dimension dimension = new Dimension(type.width(), type.height());

			this.setIcon(new ImageIcon(type.getImage()));
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
				this.setLocation(camera.dx(type.x()), camera.dy(type.y()));
			}
		}
	}

	public void tick() {
	}
	
	
}