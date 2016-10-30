package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import cz.GravelCZLP.BlockGame.Common.Player;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet;

public class PacketSummonPlayer extends Packet {

	public Player p;
	
	public PacketSummonPlayer(Player np) {
		super(PacketStatus.PLAY);
		p = np;
	}
	
}
