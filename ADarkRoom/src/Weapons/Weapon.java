package Weapons;

public class Weapon {
	
	private double damage, cooldown;
	private final double CRITCHANCE = 0.3, POISONCHANCE = 0.9;
	private final double CRITMULTIPLIER = 1.5;
	private boolean PoisonProced;
	private WeaponType type;

	public Weapon(WeaponType type){
		this.damage = type.getDamage();
		this.cooldown = type.getCooldown();
		this.type = type;
	}
	
	public double dealDamage() {
		double chance = Math.random();
		if(chance<=this.POISONCHANCE){
			this.setPoisonProced(true);
		}
		if(chance<=CRITCHANCE){
			return this.damage*this.CRITMULTIPLIER;
		}else{
			return this.damage;
		}
	}
	
	public double getDamage() {return damage;}
	public double getCooldown() {return cooldown;}
	public double getCRITCHANCE() {return CRITCHANCE;}
	public boolean isPoisonProced() {return PoisonProced;}
	
	public void setDamage(double damage) {this.damage = damage;}
	public void setCooldown(double cooldown) {this.cooldown = cooldown;}
	public void setPoisonProced(boolean poisonProced) {PoisonProced = poisonProced;}
	public String getImage() {return this.type.getLocation();}
}
