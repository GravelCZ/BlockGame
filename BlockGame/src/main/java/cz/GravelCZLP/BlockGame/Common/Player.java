package cz.GravelCZLP.BlockGame.Common;

import java.util.UUID;

import cz.GravelCZLP.BlockGame.Client.ClientMain;
import cz.GravelCZLP.BlockGame.Common.Packets.Play.PlayerMovePacket;

public class Player {

	public int x;
	public int y;
	public int z;
	
	public String name;
	public UUID uuid;
	
	public int health;
	
	@Deprecated
	public Player() {}
	
	public Player(String name, int startx, int startz, int health) {
		this.name = name;
		x = startx;
		z = startz;
		this.health = health;
	}
	
	public void jump() {
		y += 1;
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		y -= 1;
	}
	public void moveLeft() {
		PlayerMovePacket packet = new PlayerMovePacket((x - 5), y, z);
		ClientMain.c.sendTCP(packet);
	}
	public void moveRight() {
		
	}
	public void moveFront() {
		
	}
	public void moveBack() {
		
	}
}
