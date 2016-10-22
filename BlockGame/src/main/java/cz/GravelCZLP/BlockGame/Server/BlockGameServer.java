package cz.GravelCZLP.BlockGame.Server;

import java.io.IOException;

import com.esotericsoftware.kryonet.Server;

import cz.GravelCZLP.BlockGame.Server.Net.Listeners.PacketListener;

public class BlockGameServer {

	public Server s;
	
	public int mapSizeX;
	public int mapSizeZ; //Y
	
	public boolean isReady;
	
	public void performStartServer(int port) throws IOException {
		s = new Server();
		s.start();
		s.bind(port);
		s.addListener(new PacketListener(this));
		
		mapSizeX = 360;
		mapSizeZ = 420; // DANK MEMES !!!!!!!11
	}
}
