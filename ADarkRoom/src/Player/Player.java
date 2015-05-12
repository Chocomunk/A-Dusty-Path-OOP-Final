package Player;

import Enemies.Enemies;
import Weapons.Weapons;

public class Player {
	/* Alvin (maybe pass this off to Eric too):
	 * The resources, or maybe everything here (though most likely just resources)
	 * could have a type of the resource object instead, that object could function
	 * to hold the total, current, and methods to decrease and increase. Simply put,
	 * these objects could reference the storage of that type of object, instead of
	 * the object itself (although it could easily also hold information or methods
	 * relatign to the functionality of that object)
	 */
	private double currentHealth = 10;
	private double totalHealth = 10;
	private double currentStamina = 10;
	private double totalStamina = 10;
	private int currentWater = 0;
	private int totalWater = 0;
	private int currentFood = 0;
	private int totalFood = 0;
	
	//NOTE: see which methods will need to print to screen. (e.g +5 water for pickup() method)
	
	//INCOMPLETE
	//will add water and food to currentWater and currentFood
	/*ALVIN: This method could stand to receive an array of resources*/
	public void pickup(Resource r,int amount){
		
	}
	
	public void attack(Weapons weapon,Enemies enemy){
		if(this.decreaseStamina(1)){
			enemy.takeDamage(weapon.getDamage());
		}
	}
	
	//subtracts amount to current health 
	//NOT THE SAME AS SETTER METHOD
	public void takeDamage(double amount){
		if(currentHealth - amount <= 0){
			this.setCurrentHealth(0);
			this.die();
		}else{
			currentHealth -= amount;
		}
	}
	
	//adds amount to current health 
	//NOT THE SAME AS SETTER METHOD
	public void heal(double amount){
		if(currentHealth + amount > totalHealth){
			this.setCurrentHealth(this.totalHealth);
		}else{
			currentHealth += amount;
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
	
	//Alvin: possibly create another method to handle gain of stamina over time?
	public void increaseStamina(int amount){
		if(currentStamina + amount > totalStamina){
			this.setCurrentStamina(this.totalStamina);
		}else{
			currentStamina = currentStamina + amount;
		}
	}
	
	//INCOMPLETE
	public Boolean decreaseStamina(int amount){
		if(currentStamina - amount < 0){
			//ALVIN show on screen that player doesn't have enough stamina
			//to perform certain action (E.g attack)
			this.setCurrentStamina(0);
			return false; //false as in player cannot attack
		}else{
			currentStamina = currentStamina - amount;
			return true; //true as in player can attack
		}
	}
	
	public void decreaseWater(int amount){
		if(currentWater - amount <= 0){
			this.setCurrentWater(0);
			this.die();
		}else{
			currentWater = currentWater - amount;
		}
	}
	
	//INCOMPLETE
	//Alvin: food may also increase health
	public void eatFood(){
		if(currentFood - 1 >= 0){
			currentFood = currentFood - 1;
			this.increaseStamina(5);
		}else{
			this.setCurrentFood(0);
			//ALVIN print out of food to screen
		}
	}
	
	public double getCurrentHealth() {return currentHealth;}
	public void setCurrentHealth(double d) {this.currentHealth = d;}
	public double getTotalHealth() {return totalHealth;}
	public void setTotalHealth(int totalHealth) {this.totalHealth = totalHealth;}
	public double getCurrentStamina() {return currentStamina;}
	public void setCurrentStamina(double totalStamina2) {this.currentStamina = totalStamina2;}
	public double getTotalStamina() {return totalStamina;}
	public void setTotalStamina(int totalStamina) {this.totalStamina = totalStamina;}
	public int getCurrentWater() {return currentWater;}
	public void setCurrentWater(int currentWater) {this.currentWater = currentWater;}
	public int getTotalWater() {return totalWater;}
	public void setTotalWater(int totalWater) {this.totalWater = totalWater;}
	public int getCurrentFood() {return currentFood;}
	public void setCurrentFood(int currentFood) {this.currentFood = currentFood;}
	public int getTotalFood() {return totalFood;}
	public void setTotalFood(int totalFood) {this.totalFood = totalFood;}
}
