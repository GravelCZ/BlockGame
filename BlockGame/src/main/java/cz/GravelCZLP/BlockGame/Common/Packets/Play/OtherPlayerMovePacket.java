package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;

public class OtherPlayerMovePacket extends Packet {

	public int nextX;
	public int nextY;
	
	public OtherPlayerMovePacket() {
		super(PacketStatus.PLAY);
	}
	
}
