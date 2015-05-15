package Enemy;

import Resources.Resources;

public enum EnemyType {
	
	Bandits(5,3,1), DrBoom(7,7,7), Alvin(1,1,1),Pepe(4.20,69,0),Link(45,8,14), Friedland(100,10,10);
	
	
	private double currentHealth;
	private double totalHealth;
	private double cooldown;
	private double damage;
	private Resources[] drops;
	
	EnemyType(double totalHealth,double cooldown,double damage,Resources... res){
		this.cooldown = cooldown;
		this.damage = damage;
		this.totalHealth = totalHealth;
		this.currentHealth = totalHealth;
		this.drops = res;
	}

	public double getCurrentHealth() {return currentHealth;}
	public double getTotalHealth() {return totalHealth;}
	public double getCooldown() {return cooldown;}
	public double getDamage() {return damage;}
	public Resources[] getDrops() {return drops;}
}
