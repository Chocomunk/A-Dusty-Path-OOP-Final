package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Player.Player;
import Weapons.*;

import Core.Core;
import Entity.Entity;
import GUI.*;

public class Fight extends BasicGameState{
	
	private int stateID;
	private Player player;
	private Core link;
	
	public Fight(int state, Core core) throws SlickException{
		stateID = state;
		link = core;
	}
	

	WeaponButton fist;
	WeaponButton sword;
	WeaponButton lance;
	
	HealButton heal;
	
	String prog_Empty;
	String prog_Full;
	
	@Override	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		player = link.getPlayer();
		
		prog_Full = "res/grass.png";
		prog_Empty = "res/dirt.png";
		
		fist = new WeaponButton(prog_Full,prog_Empty,"res/grass.png","res/dirt.png", new Weapon(WeaponType.Fists), 100,600);
		sword = new WeaponButton(prog_Full,prog_Empty,"res/grass.png","res/dirt.png", new Weapon(WeaponType.Sword), 200,600);
		lance = new WeaponButton(prog_Full,prog_Empty,"res/grass.png","res/dirt.png", new Weapon(WeaponType.Lance), 300,600);
		
		heal = new HealButton(prog_Full,prog_Empty,"res/grass.png","res/dirt.png", 400,600);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		fist.Draw(g);
		sword.Draw(g);
		lance.Draw(g);
		heal.Draw(g);
		
		drawEntity(player, g, 100, 200);
		drawEntity(player.getFightTarget(), g, 200, 200);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		fist.tick(delta, player.getFightTarget());
		sword.tick(delta, player.getFightTarget());
		lance.tick(delta, player.getFightTarget());
		heal.tick(delta, player);
		
		if(player.getFightTarget().isDead()){
			reset();
			sbg.enterState(Core.map);
		}else if(player.isDead()){
			reset();
			player.resetStats();
			sbg.enterState(Core.deathState);
		}else{
			player.getFightTarget().tick(delta, player);
		}
	}
	
	void reset(){
		fist.reset();sword.reset();lance.reset();
		heal.reset();
	}
	
	void drawEntity(Entity entity, Graphics g, float x, float y) throws SlickException{
		
		Image full = new Image(this.prog_Full);
		Image empty = new Image(this.prog_Empty);
		
		float width = empty.getWidth();
		
		float ratio = (float) (((entity.getCurrentHealth())/entity.getTotalHealth())*width);
		float realX = (float) (x - (width/2 - entity.getTexture().getWidth()/2));
		float realY = y + entity.getTexture().getHeight();;
		
		g.drawImage(entity.getTexture(), x, y);
		g.drawImage(empty, realX, realY);
		g.drawImage(full, realX, realY, realX+ratio, realY+width, 0, 0, ratio, width);
	}
	
	void updateEntity(Entity entity){
		
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
