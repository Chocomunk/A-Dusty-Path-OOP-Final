package Weapons;

public enum WeaponType {
	Fists(1,1, "res/Fists.png"),
	Sword(5,3, "res/Sword.png"),
	Lance(12,8, "res/Lance.png"),
	SickStick(10,8, "res/SickStick.png"),
	NessBat(20,10, "res/NessBat.png"), 
	Pepe(69,420, "res/PepeWeapon.png");
	
	private double damage;
	private double cooldown;
	private String location;
	
	WeaponType(double damage,double cooldown, String location){
		this.damage = damage;
		this.cooldown = cooldown;
		this.location = location;
	}

	public double getDamage() {return damage;}
	public double getCooldown() {return cooldown;}
	public String getLocation() {return location;}
}
