package cz.GravelCZLP.BlockGame.Common.Packets.Play;

import java.util.UUID;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;

public class PlayerRemovePacket extends Packet {

	public UUID uuid;
	
	public PlayerRemovePacket(UUID puuid) {
		super(PacketStatus.PLAY);
		uuid = puuid;
	}
	
}
