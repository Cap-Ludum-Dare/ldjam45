package se.capgemini.ldjam45.ui;

import se.capgemini.ldjam45.sound.SoundEffect;

import java.awt.Dimension;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private static final int SIZE = 1000;
	private static final String NAME = "Ludum Dare 45";
	
	public Window() {
		
		Dimension dimension = new Dimension(SIZE, SIZE);
		
		this.setPreferredSize(dimension);
		this.setSize(dimension);
		
		this.setTitle(NAME);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setVisible(true);
		
	}

	private static void sleep(int seconds) {
		try
		{
			TimeUnit.SECONDS.sleep(seconds);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}
	}

	public static void main(String[] m) {
		//SoundEffect.DYING.play();
		//sleep (2);
		//SoundEffect.EXPLOSION.play();
		//sleep (2);
		//SoundEffect.HIT.play();
		//sleep (2);
		//SoundEffect.JUMP.play();
		//sleep (2);
		//SoundEffect.LASER.play();
		//sleep (2);
		//SoundEffect.PICK.play();
		//sleep (2);
		//SoundEffect.PICKUP.play();
		//sleep (2);
		//SoundEffect.SELECT.play();
		//sleep (2);
		//SoundEffect.WALKING.play();

		new Window();
	}

}
