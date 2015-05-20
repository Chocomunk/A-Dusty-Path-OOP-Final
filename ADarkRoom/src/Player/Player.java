package Player;

import org.newdawn.slick.Input;
import org.newdawn.slick.state.StateBasedGame;

import Core.Core;
import Enemy.Enemy;
import Entity.Entity;
import Map.Tile;
import Map.TileMap;
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
	
	private Enemy fightTarget = null;

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
	public void Die(){
		super.Die();
	}
	
	public void decreaseWater(int amount){
		if(currentWater - amount <= 0){
			this.setCurrentWater(0);
			this.Die();
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
		this.setCurrentHealth(this.getTotalHealth());
		this.setX(0);this.setY(0);
		this.setDead(false);
	}
	
	public void tick(int delta, StateBasedGame sbg, TileMap map){
		handleKeyInput(sbg.getContainer().getInput());
		if(this.checkEntered(map.getTile((int)this.getX(), (int)this.getY()))){
			this.onEnter(map.getTile((int)this.getX(), (int)this.getY()), sbg);
		}
	}

	private void onEnter(Tile tile, StateBasedGame sbg) {
		sbg.enterState(Core.fight);
		this.fightTarget = (Enemy) tile;
	}

	public void handleKeyInput(Input input) {
	    if(input.isKeyPressed(Input.KEY_UP) && this.getY() > 0){
	    	//Move up
	    	this.changeY(-1);
	    }else if(input.isKeyPressed(Input.KEY_DOWN) && this.getY() < 15){
	    	//Move down
	    	this.changeY(1);
	    }else if(input.isKeyPressed(Input.KEY_RIGHT) && this.getX() < 20){
	    	//Move right
	    	this.changeX(1);
	    }else if(input.isKeyPressed(Input.KEY_LEFT) && this.getX() > 0){
	    	//Move left
	    	this.changeX(-1);
	    }
	}
	
	public int getCurrentWater() {return currentWater;}
	public int getTotalWater() {return totalWater;}
	public int getCurrentFood() {return currentFood;}
	public int getTotalFood() {return totalFood;}
	public Enemy getFightTarget() {return fightTarget;}

	public void setCurrentWater(int currentWater) {this.currentWater = currentWater;}
	public void setTotalWater(int totalWater) {this.totalWater = totalWater;}
	public void setCurrentFood(int currentFood) {this.currentFood = currentFood;}
	public void setTotalFood(int totalFood) {this.totalFood = totalFood;}
}
