package Enemies;

import Player.Player;

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
	public void drop(Player target){
		double decide = (int)(Math.random() * 10);
		int amount = (int)(Math.random() * 10);
		if(this.currentHealth < 0){
			if(decide <= 3){
				target.pickup(target.getCurrentFood(),amount);
			}
			else if(decide == 4 || decide == 5){
			}
			else{
				target.pickup(target.getCurrentFood(), amount);
			}
		}
	}
	
	/*Alvin:
	 * This is an awkward method, please consider doing more robust methods 
	 * such as takeDamage and dealDamage, and handling the cooldown somewhere else.
	 * Other group members may want to handle the cooldown themselves. Essentially, 
	 * handeling the "battle" all in one very specified method is not optimal.
	 */
	public void battle(Player target) throws InterruptedException{

		while(target.getCurrentHealth() > 0 && this.getCurrentHealth() > 0){
			target.setCurrentHealth(target.getCurrentHealth() - this.damage);
			Thread.sleep((long) (this.cooldown * 1000));
		}
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
