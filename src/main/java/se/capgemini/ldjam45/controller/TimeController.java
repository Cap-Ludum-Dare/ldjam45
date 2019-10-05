package se.capgemini.ldjam45.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import se.capgemini.ldjam45.model.Alive;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.model.Type;
import se.capgemini.ldjam45.model.Updateable;

public class TimeController extends ArrayList<Updateable> {
	
	private static final int UI_UPDATE_OFFSET_MS = 25;
	private static final int GAME_UPDATE_OFFSET_MS = 100;
	
	private Timer uiTimer;
	private Timer gameTimer;
	private Hero hero;
	
	
	public TimeController(Hero hero) {
		this.hero = hero;
		
		uiTimer = new Timer(UI_UPDATE_OFFSET_MS, new Updater());
		gameTimer = new Timer(GAME_UPDATE_OFFSET_MS, new Ticker());
	}
	
	public void start() {
		uiTimer.start();
		gameTimer.start();
	}
	
	public void tick() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.tick();
			
			if (updateable instanceof Alive &&
					!((Alive)updateable).isAlive()) {
				this.remove(updateable);
			} else if (updateable instanceof Type
					&& hero.isInteractable((Type)updateable)) {
				hero.interact((Type)updateable);
			}
		}
	}
	
	public void update() {
		for(Updateable updateable : new ArrayList<Updateable>(this)) {
			updateable.update();
		}
	}
	
	private class Ticker implements ActionListener {
		/**
		 *  Updates the game every {@link GAME_UPDATE_OFFSET_MS}.
		 */
		public void actionPerformed(ActionEvent e) {
			tick();
		}
	}
	
	private class Updater implements ActionListener {
		/**
		 * Updates the UI every @UI_UPDATE_OFFSET_MS.
		 */
		public void actionPerformed(ActionEvent e) {
			update();
		}
	}

}
