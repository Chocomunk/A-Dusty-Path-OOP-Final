package Weapons;

import Enemies.Enemies;

public class Weapons {
	
	private double damage;
	private double cooldown;
	private final double CRITCHANCE = 0.1;
	private double poisonChance;
	
	public Weapons(int damage,double cooldown){
		this.damage = damage;
		this.cooldown = cooldown;
	}
	public double getDamage() {return damage;}
	public double getCooldown() {return cooldown;}
	public double getCRITCHANCE() {return CRITCHANCE;}
	public void setDamage(double damage) {this.damage = damage;}
	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	
}
