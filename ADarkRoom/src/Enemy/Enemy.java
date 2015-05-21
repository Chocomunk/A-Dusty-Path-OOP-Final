package Enemy;

import Entity.Entity;
import Player.*;

public class Enemy extends Entity{
	
	private double damage;
	private double cooldown, cdTotal;
	private EnemyType EType;
	
	public Enemy(EnemyType type, int x, int y){
		super(x, y, type);
		this.cdTotal = type.getCooldown() * 1000;
		this.cooldown = this.cdTotal;
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
	
	public void Die(){
		super.Die();
		this.setActivated(false);
	}
	
	public void tick(int delta, Player player){
		if(this.isDead() || this.getCurrentHealth() == 0.0){
		//	this.Die();
		}else{
			if(cooldown > 0){
				cooldown -= delta;
			}else{
				cooldown = cdTotal;
				attack(player);
			}
		}
	}
	
	public void attack(Player player){
		player.takeDamage(this.damage);
	}
	
	public double getCooldown() {return cooldown;}
	public double getDamage() {return damage;}
	public EnemyType getEType() {return this.EType;}

	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	public void setDamage(double damage) {this.damage = damage;}
}
