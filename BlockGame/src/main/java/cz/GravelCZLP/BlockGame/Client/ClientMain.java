package cz.GravelCZLP.BlockGame.Client;

import java.awt.Canvas;

import com.esotericsoftware.kryonet.Client;

import cz.GravelCZLP.BlockGame.Client.Input.LWJGLKeyboardInput;
import cz.GravelCZLP.BlockGame.Client.Render.RenderHandler;
import cz.GravelCZLP.BlockGame.Common.Player;

public class ClientMain extends Canvas {

	private static final long serialVersionUID = -3945308368451340727L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	public RenderHandler renderHandler;
	public LWJGLKeyboardInput keyInput;
	
	public Player thePlayer;
	public static Client c = null;
	public GameWindow gameWindow;
	
	public ClientMain() {
		gameWindow = new GameWindow(WIDTH, HEIGHT, "Block Game", this);
	}
	
	public void startGameRender() {
		renderHandler = new RenderHandler();
		renderHandler.startGameRender();
		renderHandler.doSomeStuff();
		
		keyInput = new LWJGLKeyboardInput(thePlayer);
		keyInput.startKeyInputListener();
	}
}
