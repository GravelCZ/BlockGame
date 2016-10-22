package cz.GravelCZLP.BlockGame.Common.Packets;

import cz.GravelCZLP.BlockGame.Common.Player;

public class PacketNewPlayer extends Packet {

	public Player player;
	
	public PacketNewPlayer(Player newPlayer) {
		super(PacketStatus.LOGIN);
		player = newPlayer;
	}

}
