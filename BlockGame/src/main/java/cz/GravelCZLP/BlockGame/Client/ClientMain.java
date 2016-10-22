package cz.GravelCZLP.BlockGame.Client;

import java.awt.Canvas;

import com.esotericsoftware.kryonet.Client;

import cz.GravelCZLP.BlockGame.Common.Player;

public class ClientMain extends Canvas implements Runnable {

	private static final long serialVersionUID = -3945308368451340727L;

	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
	
	//private Thread t;
	//private boolean running = false;
	public Player thePlayer;
	public Client c = null;
	public GameWindow gameWindow;
	
	public ClientMain() {
		gameWindow = new GameWindow(WIDTH, HEIGHT, "Block Game", this);
	}

	public synchronized void start() {
		
	}

	public synchronized void stop() {
		
	}
	
	@Override
	public void run() {
		
	}
}
