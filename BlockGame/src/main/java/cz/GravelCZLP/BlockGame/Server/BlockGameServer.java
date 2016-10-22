package cz.GravelCZLP.BlockGame.Server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

import cz.GravelCZLP.BlockGame.Server.Net.Listeners.PacketListener;

public class BlockGameServer {

	public static int port = 0;
	
	public static void main(String[] args) throws IOException {
		for (int i = 0; i < args.length; i++) {
			if (args[i].equalsIgnoreCase("--port")) {
				port = Integer.parseInt(args[(i + 1)]);
			}
		}
		new BlockGameServer().performStartServer();
	}
	
	public Server s;
	
	public int mapSizeX;
	public int mapSizeZ; //Y
	
	public boolean isReady;
	
	public void performStartServer() throws IOException {
		s = new Server();
		s.start();
		s.bind(port);
		s.addListener(new PacketListener(this));
		
		mapSizeX = 360;
		mapSizeZ = 420; // DANK MEMES !!!!!!!11
		
	}
}
