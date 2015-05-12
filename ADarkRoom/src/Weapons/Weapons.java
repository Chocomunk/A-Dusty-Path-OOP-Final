package Weapons;

import Enemies.Enemies;

public class Weapons {
	
	private double damage;
	private double cooldown;
	private final double CRITCHANCE = 0.1;
	
	public Weapons(int damage,double cooldown){
		this.damage = damage;
		this.cooldown = cooldown;
	}
	
	/*Alvin:
	 * As explained on your enemies class, dont use the acctual
	 * enemy as a target of this to use on, have it so the enemy
	 * is having this used on it. If that was confusing, essentially
	 * have a take damage method in enemy, and on the call of "use"
	 * just have the enemy take the damage of our damage amount
	 */
	public void use(Enemies target){
		double currentHealth = target.getCurrentHealth();
		double crit = Math.random();
		if(crit < CRITCHANCE){
			currentHealth = currentHealth - (this.damage * 1.5);
		}
		else{
			currentHealth = currentHealth - this.damage;
		}
	}
	
	public double getDamage() {return damage;}
	public double getCooldown() {return cooldown;}
	public double getCRITCHANCE() {return CRITCHANCE;}
	public void setDamage(double damage) {this.damage = damage;}
	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	
}
