package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Weapons.*;

import Core.Core;
import GUI.*;

public class Fight extends BasicGameState{
	
	private int stateID;
	public Fight(int state, Core core){
		stateID = state;
	}
	

	public WeaponButton fist;
	public WeaponButton sword;
	public WeaponButton lance;
	
	@Override	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		fist = new WeaponButton("res/grass.png","res/dirt.png","res/grass.png","res/dirt.png", new Weapon(WeaponType.Fists), 100,600);
		sword = new WeaponButton("res/grass.png","res/dirt.png","res/grass.png","res/dirt.png", new Weapon(WeaponType.Sword), 200,600);
		lance = new WeaponButton("res/grass.png","res/dirt.png","res/grass.png","res/dirt.png", new Weapon(WeaponType.Lance), 300,600);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		fist.Draw(g);
		sword.Draw(g);
		lance.Draw(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		fist.tick(delta);
		sword.tick(delta);
		lance.tick(delta);
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
