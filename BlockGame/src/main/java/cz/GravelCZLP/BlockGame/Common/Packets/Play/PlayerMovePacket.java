package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;

public class PlayerMovePacket extends Packet {

	public int nextZ;
	public int nextX;
	
	public PlayerMovePacket(int nextX, int nextZ) {
		super(PacketStatus.PLAY);
	}
	
}
