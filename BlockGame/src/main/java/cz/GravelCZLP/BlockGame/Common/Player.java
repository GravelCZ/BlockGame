package cz.GravelCZLP.BlockGame.Common;

import java.util.UUID;

public class Player {

	public int x;
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
}
