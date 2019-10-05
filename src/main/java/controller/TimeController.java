package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import model.World;

public class TimeController {
	
	private static final int UI_UPDATE_OFFSET_MS = 25;
	private static final int GAME_UPDATE_OFFSET_MS = 100;
	
	private Timer uiTimer;
	private Timer gameTimer;
	private World world;
	
	
	public TimeController(World world) {
		uiTimer = new Timer(UI_UPDATE_OFFSET_MS, new Updater());
		gameTimer = new Timer(GAME_UPDATE_OFFSET_MS, new Ticker());
		
		this.world = world;
	}
	
	public void start() {
		uiTimer.start();
		gameTimer.start();
	}
	
	private class Ticker implements ActionListener {

		/**
		 *  Updates the game every {@link GAME_UPDATE_OFFSET_MS}.
		 */
		public void actionPerformed(ActionEvent e) {
			world.tick();
		}
		
	}
	
	private class Updater implements ActionListener {

		/**
		 * Updates the UI every @UI_UPDATE_OFFSET_MS.
		 */
		public void actionPerformed(ActionEvent e) {
			world.update();
		}
		
	}

}
