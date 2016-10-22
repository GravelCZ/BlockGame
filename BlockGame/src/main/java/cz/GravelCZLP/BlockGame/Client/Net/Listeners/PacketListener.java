package cz.GravelCZLP.BlockGame.Client.Net.Listeners;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import cz.GravelCZLP.BlockGame.Client.ClientMain;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet.PacketStatus;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketNewPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.OtherPlayerMovePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PacketSummonPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMoveResponcePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerRemovePacket;

public class PacketListener extends Listener {

	public ClientMain main;
	
	public PacketListener(ClientMain game) {
		main = game;
	}
	
	@Override
	public void received(Connection connection, Object object) {
		if (!(object instanceof Packet)) {
			return;
		}
		Packet p = (Packet) object;
		PacketStatus ps = p.status;
		if (ps == PacketStatus.LOGIN) {
			handleLoginPacket(p);
		} else if (ps == PacketStatus.PLAY) {
			handlePlayPacket(p);
		} else if (ps == PacketStatus.LOGOUT) {
			handleLogoutPacket(p);
		}
	}
	
	private void handlePlayPacket(Packet p) {
		if (p instanceof PacketSummonPlayer) {
			
		}
		if (p instanceof PlayerMoveResponcePacket) {
			
		}
		if (p instanceof PlayerRemovePacket) {
			
		}
		if (p instanceof OtherPlayerMovePacket) {
			
		}
	}
	
	private void handleLoginPacket(Packet p) {
		if (p instanceof PacketNewPlayer) {
			PacketNewPlayer packet = (PacketNewPlayer) p;
			main.thePlayer = packet.player;
		}
	}
	
	private void handleLogoutPacket(Packet p) {
		
	}
}
