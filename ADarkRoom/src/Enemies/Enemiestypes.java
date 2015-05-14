package Enemies;
import Enemies.Enemies;
public enum Enemiestypes {
	
	Bandits(5,5,3,1), DrBoom(7,7,7,7), Alvin(1,1,1,1),Pepe(4.20,4.20,69,0),Link(45,45,8,14), Friedland(100,100,10,10);
	
	
	private double currentHealth;
	private double totalHealth;
	private double cooldown;
	private double damage;
	Enemiestypes(double Health,double totalHealth,double cooldown,double damage){
		this.cooldown = cooldown;
		this.currentHealth = currentHealth;
		this.damage = damage;
		this.totalHealth = totalHealth;
	}
}
