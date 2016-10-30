package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;

public class PlayerMovePacket extends Packet {

	public int nextZ;
	public int nextX;
	public int nextY;
	
	public PlayerMovePacket(int nextX, int nextY, int nextZ) {
		super(PacketStatus.PLAY);
		this.nextX = nextX;
		this.nextZ = nextZ;
		this.nextY = nextY;
	}
	
}
