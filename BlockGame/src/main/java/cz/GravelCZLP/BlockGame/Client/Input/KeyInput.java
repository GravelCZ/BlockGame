package cz.GravelCZLP.BlockGame.Client.Input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import cz.GravelCZLP.BlockGame.Client.ClientMain;

public class KeyInput implements KeyListener {

	private ClientMain main;
	
	public KeyInput(ClientMain mainClass) {
		main = mainClass;
	}
	
	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if (code == 37) {
			main.thePlayer.x-=5;
		} else if (code == 38) {
			main.thePlayer.z+=5;
		} else if (code == 39) {
			main.thePlayer.x+=5;
		} else if (code == 40) {
			main.thePlayer.z-=5;
		} else {
			return;
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) {}

	@Override
	public void keyTyped(KeyEvent arg0) {}

}
