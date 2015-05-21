package Entity;

import Enemy.EnemyType;
import Map.Tile;

public class Entity extends Tile{
	private double currentHealth = 100;
	private double totalHealth = 100;
	private boolean Dead = false;
	
	private String image;

	public Entity(double Health, float x, float y, String texture){
		super(x,y,texture);
		this.totalHealth = Health;
		this.currentHealth = this.totalHealth;
		this.image = texture;
	}
	
	public Entity(float x, float y, EnemyType type){
		super(x,y,type);
		this.totalHealth = type.getTotalHealth();
		this.currentHealth = this.totalHealth;
		this.image = type.getLocation();
	}

	public void Die() {
		Dead = true;
	}
	
	public void resetStats(){
		this.setCurrentHealth(this.getTotalHealth());
	}

	public void takeDamage(double amount){
		if(this.getCurrentHealth() - amount > 0){
			this.setCurrentHealth(this.getCurrentHealth() - amount);
		}else if(this.getCurrentHealth() > 0){
			this.Die();
		}else{
			this.Die();
		}
	}
	
	public double getCurrentHealth() {return currentHealth;}
	public double getTotalHealth() {return totalHealth;}
	public String getImage() {return image;}
	public boolean isDead() {return Dead;}
	
	public void setDead(boolean Dead) {this.Dead = Dead;}
	public void setCurrentHealth(double d) {this.currentHealth = d;}
	public void setTotalHealth(int totalHealth) {this.totalHealth = totalHealth;}

}
