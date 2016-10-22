package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet.PacketStatus;

public class PlayerMoveResponcePacket extends Packet {

	public int nextX;
	public int nextZ;
	
	public PlayerMoveResponcePacket(int z, int x) {
		super(PacketStatus.PLAY);
		nextX = x;
		nextZ = z;
	}
	
}
