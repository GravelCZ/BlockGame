package cz.GravelCZLP.BlockGame.Common.Packets;

import java.util.UUID;

public class PacketPlayerLogout extends Packet {

	public UUID uuid;
	
	public PacketPlayerLogout(UUID uid) {
		super(PacketStatus.LOGOUT);
		uuid = uid;
	}
	
}
