package se.capgemini.ldjam45.controller;

import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import se.capgemini.ldjam45.editor.Editor;
import se.capgemini.ldjam45.model.Hero;
import se.capgemini.ldjam45.view.Images;

public class KeyController implements KeyListener, MouseListener, WindowListener, ComponentListener {
	
	private char currentKey = ' ';
	private Hero hero;
	private Editor editor;
	
	public KeyController(Hero hero, Editor editor) {
		this.hero = hero;
		this.editor = editor;
	}
	
	public void componentHidden(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentMoved(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentResized(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void componentShown(ComponentEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void mouseExited(MouseEvent event) {

	}

	public void mousePressed(MouseEvent event) {
		// editor.put(event.getX(), event.getY(), "" + currentKey);
	}

	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	public void keyPressed(KeyEvent key) {
		
		if (key.isAltDown()) {
			currentKey = key.getKeyChar();
		}
		
		if (key.isAltDown() && key.getKeyChar() == KeyEvent.VK_F4) {
			System.exit(1);
		}
		
		if (key.getKeyChar() == 'w' || key.getKeyCode() == KeyEvent.VK_NUMPAD8) {
			hero.move(0, -1);
		} else if (key.getKeyChar() == 's' || key.getKeyCode() == KeyEvent.VK_NUMPAD2) {
			hero.move(0, 1);
		} else if (key.getKeyChar() == 'a' || key.getKeyCode() == KeyEvent.VK_NUMPAD4) {
			hero.move(-1, 0);
		} else if (key.getKeyChar() == 'd' || key.getKeyCode() == KeyEvent.VK_NUMPAD6) {
			hero.move(1, 0);
		} else if (key.getKeyCode() == KeyEvent.VK_NUMPAD7) {
			hero.move(-1, -1);
		} else if (key.getKeyCode() == KeyEvent.VK_NUMPAD9) {
			hero.move(1, -1);
		} else if (key.getKeyCode() == KeyEvent.VK_NUMPAD1) {
			hero.move(-1, 1);
		} else if (key.getKeyCode() == KeyEvent.VK_NUMPAD3) {
			hero.move(1, 1);
		}
	}


	public void keyReleased(KeyEvent arg0) {
		hero.move(0, 0);
	}

	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
