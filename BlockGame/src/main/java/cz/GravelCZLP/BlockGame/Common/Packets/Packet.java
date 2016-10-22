package cz.GravelCZLP.BlockGame.Common.Packets;

import cz.GravelCZLP.BlockGame.Common.Player;

public class Packet {

	public enum PacketStatus {
		LOGIN, PLAY, LOGOUT;
	}
	
	public PacketStatus status;
	public Player player;
	
	public Packet(PacketStatus s) {
		status = s;
	}
	
	public void setPlayer(Player p) {
		player = p;
	}
	public Player getPlayer() {
		return player;
	}
}
