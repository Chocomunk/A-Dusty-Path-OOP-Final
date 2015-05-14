package Enemies;

import Player.*;
import Weapons.*;
public class Enemies {
	private double currentHealth;
	private double totalHealth;
	private double cooldown;
	private double damage;
	
	public Enemies(double curentHealth, double totalHealth, double cooldown, double damage){
		this.currentHealth = curentHealth;
		this.totalHealth = totalHealth;
		this.cooldown = cooldown;
		this.damage = damage;
	}
	/*Alvin:
	 * I suggest using an enum with an array to determine what each enemy drops
	 * This method should not target the player and put onto the the drop, but
	 * instead there should be a method which activates upon death to call the
	 * pickup method with our array of resources
	 * Or even a method that directly  returns an array of resources, which can
	 * then be implemented into another method to be used in pickup
	 */
	public Resources drop(Player target){
		Resources[]  droplist = [Resources water, Resources food];
		int decide = (int)(Math.round(Math.random()));
		int amount = (int)(Math.random() * 10);
		Player.pickup(droplist[decide],amount);
	}
	public void takeDamage(Weapons target){
		double damage = target.getDamage();
		double crit = Math.random();
		if(crit < target.getCRITCHANCE()){
			this.currentHealth = this.currentHealth - (damage * 1.5);
		}
		else{
			this.currentHealth = this.currentHealth - damage;
		}
	}
	public void dealDamage(Player target){
		double currentHealth = target.getCurrentHealth();
		currentHealth = currentHealth - this.damage;
		target.setCurrentHealth(currentHealth);
	}
	public double getCurrentHealth() {return currentHealth;}
	public void setCurrentHealth(double currentHealth) {this.currentHealth = currentHealth;}
	public double getTotalHealth() {return totalHealth;}
	public void setTotalHealth(double totalHealth) {this.totalHealth = totalHealth;}
	public double getCooldown() {return cooldown;}
	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	public double getDamage() {return damage;}
	public void setDamage(double damage) {this.damage = damage;}
}
