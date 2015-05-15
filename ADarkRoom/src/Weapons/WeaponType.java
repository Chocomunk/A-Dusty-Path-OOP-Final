package Weapons;

public enum WeaponType {
	Fists(1,1),Sword(5,3),Lance(12,8),SickStick(10,8),NessBat(20,10), Pepe(69,420);
	
	private double damage;
	private double cooldown;
	
	WeaponType(double damage,double cooldown){
		this.damage = damage;
		this.cooldown = cooldown;
	}

	public double getDamage() {return damage;}
	public double getCooldown() {return cooldown;}
}
