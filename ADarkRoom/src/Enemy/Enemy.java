package Enemy;

import Entity.Entity;
import Player.*;
import Resources.Resources;

public class Enemy extends Entity{
	
	private double cooldown, damage;
	private EnemyType type;
	private int x,y;
	
	public Enemy(EnemyType type, int x, int y){
		super(type.getTotalHealth());
		this.x = x; this.y = y;
		this.cooldown = type.getCooldown();
		this.damage = type.getDamage();
	}
	
	/*Alvin:
	 * I suggest using an enum with an array to determine what each enemy drops
	 * This method should not target the player and put onto the the drop, but
	 * instead there should be a method which activates upon death to call the
	 * pickup method with our array of resources
	 * Or even a method that directly  returns an array of resources, which can
	 * then be implemented into another method to be used in pickup
	 */
	
	public void takeDamage(double amount){
		this.currentHealth -= amount;
	}
	
	public void dealDamage(Player target){
		double currentHealth = target.getCurrentHealth();
		currentHealth = currentHealth - this.damage;
		target.setCurrentHealth(currentHealth);
	}
	
	public double getCooldown() {return cooldown;}
	public double getDamage() {return damage;}
	public EnemyType getType() {return type;}
	public int getX() {return x;}
	public int getY() {return y;}
	public Resources[] drop(){return this.type.getDrops();}

	public void setX(int x) {this.x = x;}
	public void setY(int y) {this.y = y;}
	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	public void setDamage(double damage) {this.damage = damage;}
}
