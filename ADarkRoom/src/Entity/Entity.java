package Entity;

import Map.Tile;

public class Entity extends Tile{
	private double currentHealth = 10;
	private double totalHealth = 10;
	
	public Entity(double Health, float x, float y, String texture){
		super(x,y,texture);
		this.totalHealth = Health;
		this.currentHealth = this.totalHealth;
	}
	
	public double getCurrentHealth() {return currentHealth;}
	public double getTotalHealth() {return totalHealth;}
	
	public void setCurrentHealth(double d) {this.currentHealth = d;}
	public void setTotalHealth(int totalHealth) {this.totalHealth = totalHealth;}
}
