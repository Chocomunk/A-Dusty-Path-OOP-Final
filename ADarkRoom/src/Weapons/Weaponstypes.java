package Weapons;

public enum Weaponstypes {
	Fists(1,1),Sword(5,3),Lance(12,8),SickStick(10,8),NessBat(20,10), Pepe(69,420);
	private double damage;
	private double cooldown;
	Weaponstypes(double damage,double cooldown){
		this.damage = damage;
		this.cooldown = cooldown;
	}
}
