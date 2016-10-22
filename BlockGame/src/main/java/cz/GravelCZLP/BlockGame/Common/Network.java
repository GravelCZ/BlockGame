package cz.GravelCZLP.BlockGame.Common;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketNewPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketStartLogin;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PacketSummonPlayer;

public class Network {

	public static void injectPackets(EndPoint endpoint) {
		Kryo k = endpoint.getKryo();
		k.register(Player.class);
		k.register(Packet.class);
		k.register(Packet.PacketStatus.class);
		k.register(PacketNewPlayer.class);
		k.register(PacketStartLogin.class);
		k.register(PacketSummonPlayer.class);
	}
	
}
