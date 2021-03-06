package se.capgemini.ldjam45.ui;

import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final long serialVersionUID = 8190955651177767499L;
	
	private static final int SIZE = 20000;
	private static final String NAME = "Ludum Dare 45: Young professional, the journey";
	
	public Window() {
		
		Dimension dimension = new Dimension(SIZE, SIZE);
		
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		
		this.setTitle(NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}

}
