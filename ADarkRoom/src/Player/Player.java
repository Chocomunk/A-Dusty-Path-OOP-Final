package Player;

import Enemy.Enemy;
import Entity.Entity;
import Resources.Resources;
import Weapons.Weapon;

public class Player extends Entity{
	/* Alvin (maybe pass this off to Eric too):
	 * The resources, or maybe everything here (though most likely just resources)
	 * could have a type of the resource object instead, that object could function
	 * to hold the total, current, and methods to decrease and increase. Simply put,
	 * these objects could reference the storage of that type of object, instead of
	 * the object itself (although it could easily also hold information or methods
	 * relating to the functionality of that object)
	 */
	private int currentWater = 0;
	private int totalWater = 0;
	private int currentFood = 0;
	private int totalFood = 0;
	

	public Player(double Health, int water, int food, float x, float y, String texture) {
		super(Health,x,y,texture);
		this.totalWater = water;
		this.totalFood = food;
		resetStats();
	}
	
	//INCOMPLETE
	//will add water and food to currentWater and currentFood
	/*ALVIN: This method could stand to receive an array of resources*/
	public void pickup(Resources[] r,int amount){
		
	}
	
	public void attack(Weapon weapon, Enemy enemy){
		enemy.takeDamage(weapon.dealDamage());
	}
	
	public void takeDamage(double amount){
		if(this.getCurrentHealth() - amount <= 0){
			this.setCurrentHealth(0);
			this.die();
		}else{
			this.setCurrentHealth(this.getCurrentHealth() - amount);;
		}
	}
	
	public void heal(double amount){
		if(this.getCurrentHealth() + amount > this.getTotalHealth()){
			this.setCurrentHealth(this.getTotalHealth());
		}else{
			this.setCurrentHealth(this.getCurrentHealth()+amount);;
		}
	}
	
	//INCOMPLETE
	//needs to print stuff to screen. including reasons (e.g out of water)
	/*Alvin: 
	 *This probably doesnt need to print things to the screen, but just 
	 *indicate to the Core class to stop the gameplay, possibly with a
	 *reason. These reasons could be organized through ID numbers for
	 *ease of use
	 */
	public void die(){
		
	}
	
	public void decreaseWater(int amount){
		if(currentWater - amount <= 0){
			this.setCurrentWater(0);
			this.die();
		}else{
			currentWater = currentWater - amount;
		}
	}
	
	public void eatFood(){
		if(currentFood - 1 >= 0){
			currentFood = currentFood - 1;
			this.heal(20);
		}else{
			this.setCurrentFood(0);
			//ALVIN print out of food to screen
		}
	}
	
	public void resetStats(){
		this.setCurrentFood(this.getTotalFood());
		this.setCurrentWater(this.getTotalWater());
	}
	
	public int getCurrentWater() {return currentWater;}
	public int getTotalWater() {return totalWater;}
	public int getCurrentFood() {return currentFood;}
	public int getTotalFood() {return totalFood;}
	
	public void setCurrentWater(int currentWater) {this.currentWater = currentWater;}
	public void setTotalWater(int totalWater) {this.totalWater = totalWater;}
	public void setCurrentFood(int currentFood) {this.currentFood = currentFood;}
	public void setTotalFood(int totalFood) {this.totalFood = totalFood;}
}
