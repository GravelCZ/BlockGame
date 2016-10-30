package cz.GravelCZLP.BlockGame.Client.Input;

import org.lwjgl.input.Keyboard;

import cz.GravelCZLP.BlockGame.Common.Player;

public class LWJGLKeyboardInput {

	public Player player;
	
	public LWJGLKeyboardInput(Player mainPlayer) {
		player = mainPlayer;
	}
	
	public void startKeyInputListener() {
		while(Keyboard.next()) {
			if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
				player.moveFront();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
				player.moveLeft();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
				player.moveBack();
			}
			if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
				player.moveRight();
			}
		 }
	}
	
}
