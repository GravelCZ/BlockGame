package cz.GravelCZLP.BlockGame;

import java.io.IOException;

import cz.GravelCZLP.BlockGame.Client.ClientMain;
import cz.GravelCZLP.BlockGame.Server.BlockGameServer;

public class Main {

	public static void main(String[] args) {
		if (args[0].equalsIgnoreCase("--server") || args[0].equalsIgnoreCase("-s")) {
			if (args[1].equalsIgnoreCase("--port") || args[1].equalsIgnoreCase("-p")) {
				try {
					new BlockGameServer().performStartServer(Integer.parseInt(args[3]));
				} catch (NumberFormatException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		if (args[0].equalsIgnoreCase("--client") || args[0].equalsIgnoreCase("-c")) {
			new ClientMain();
		}
	}

}
