package cz.GravelCZLP.BlockGame.Common.Packets;

public class PacketStartLogin extends Packet {

	public String name;
	
	public PacketStartLogin(String playerName) {
		super(PacketStatus.LOGIN);
		name = playerName;
	}
}
