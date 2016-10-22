package cz.GravelCZLP.BlockGame.Server.Net.Listeners;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.esotericsoftware.kryonet.Connection;
import com.esotericsoftware.kryonet.Listener;

import cz.GravelCZLP.BlockGame.Common.Player;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet;
import cz.GravelCZLP.BlockGame.Common.Packets.Packet.PacketStatus;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketNewPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketPlayerLogout;
import cz.GravelCZLP.BlockGame.Common.Packets.PacketStartLogin;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PacketSummonPlayer;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMovePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMoveResponcePacket;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerRemovePacket;
import cz.GravelCZLP.BlockGame.Server.BlockGameServer;

public class PacketListener extends Listener {

	private BlockGameServer server;
	
	public List<Player> playerlist = new ArrayList<>();
	
	public PacketListener(BlockGameServer s) {
		server = s;
	}
	
	@Override
	public void connected(Connection connection) {
	
	
	}
	
	@Override
	public void received(Connection connection, Object object) {
		
		if (!(object instanceof Packet)) {
			return;
		}
		Packet packet = (Packet) object;
		if (packet.status == PacketStatus.LOGIN) {
			handleLoginPacket(connection, packet);
		} else if (packet.status == PacketStatus.PLAY) {
			handlePlayPacket(connection, packet);
		} else if (packet.status == PacketStatus.LOGOUT) {
			handleLogOutPacket(connection, packet);
		}
	}
	
	@Override
	public void disconnected(Connection connection) {
	
	
	}
	
	public void handleLoginPacket(Connection conn, Packet packet) {
		if (packet instanceof PacketStartLogin) {
			PacketStartLogin login = (PacketStartLogin) packet;
			@SuppressWarnings("deprecation")
			Player p = new Player();
			p.health = 20;
			p.name = login.name;
			p.uuid = UUID.randomUUID();
			p.x = getDefaultX();
			p.z = getDefaultY();
			PacketNewPlayer sendpacket = new PacketNewPlayer(p);
			conn.sendTCP(sendpacket);
			server.s.sendToAllExceptTCP(conn.getID(), new PacketSummonPlayer(p));
		}
	}
	
	public void handlePlayPacket(Connection conn, Packet packet) {
		if (packet instanceof PlayerMovePacket) {
			PlayerMovePacket movePacket = (PlayerMovePacket) packet;
			if (movePacket.nextX > server.mapSizeX || movePacket.nextZ > server.mapSizeZ) {
				conn.sendTCP(new PlayerMoveResponcePacket(server.mapSizeX, server.mapSizeZ));
			}
		}
	}
	public void handleLogOutPacket(Connection conn, Packet packet) {
		if (packet instanceof PacketPlayerLogout) {
			PacketPlayerLogout logout = (PacketPlayerLogout) packet;
			for (int i = 0; i < playerlist.size(); i++) {
				if (playerlist.get(i).uuid == logout.uuid) {
					playerlist.remove(i);
					break;
				}
			}
			server.s.sendToAllExceptTCP(conn.getID(), new PlayerRemovePacket(logout.uuid));
		}
	}
	private int getDefaultX() {
		return 60;
	}
	private int getDefaultY() {
		return 100;
	}
}
