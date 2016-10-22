package cz.GravelCZLP.BlockGame.Common;

import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryonet.EndPoint;

import cz.GravelCZLP.BlockGame.Common.Packets.Packet;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketNewPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketPlayerLogout;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketStartLogin;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.OtherPlayerMovePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PacketSummonPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMovePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMoveResponcePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerRemovePacket;

public class Network {

	public static void injectPackets(EndPoint endpoint) {
		Kryo k = endpoint.getKryo();
		//basic stuff
		k.register(Player.class);
		k.register(Packet.class);
		k.register(Packet.PacketStatus.class);
		
		//login and logout
		k.register(PacketNewPlayer.class);
		k.register(PacketStartLogin.class);
		k.register(PacketPlayerLogout.class);
		
		//play
		k.register(OtherPlayerMovePacket.class);
		k.register(PacketSummonPlayer.class);
		k.register(PlayerMovePacket.class);
		k.register(PlayerMoveResponcePacket.class);
		k.register(PlayerRemovePacket.class);
		
	}
	
}
