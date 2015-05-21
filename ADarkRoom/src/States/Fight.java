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
	WeaponButton sickStick;
	WeaponButton nessBat;
	WeaponButton pepe;
	
	Image bg;
	
	HealButton heal;
	
	String prog_Empty;
	String prog_Full;
	
	@Override	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		player = link.getPlayer();
		
		prog_Full = "res/TotalHealth.png";
		prog_Empty = "res/HealthEmpty.png";
		
		bg = new Image("res/Battle.PNG");
		
		fist = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.Fists), 337,600);
		sword = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.Sword), 438,600);
		lance = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.Lance), 539,600);
		sickStick = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.SickStick), 640,600);
		nessBat = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.NessBat), 741,600);
		pepe = new WeaponButton(prog_Full,prog_Empty, new Weapon(WeaponType.Pepe), 842,600);
		
		heal = new HealButton(prog_Full,prog_Empty,"res/HealButton.png","res/HealButton.png", 576,700);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		g.drawImage(bg, 0, 0);
		
		fist.Draw(g);
		sword.Draw(g);
		lance.Draw(g);
		sickStick.Draw(g);
		nessBat.Draw(g);
		pepe.Draw(g);
		heal.Draw(g);
		
		drawEntity(player, g, 350, 200);
		drawEntity(player.getFightTarget(), g, 770, 200);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		fist.tick(delta, player.getFightTarget(), gc);
		sword.tick(delta, player.getFightTarget(), gc);
		lance.tick(delta, player.getFightTarget(), gc);
		sickStick.tick(delta, player.getFightTarget(), gc);
		nessBat.tick(delta, player.getFightTarget(), gc);
		pepe.tick(delta, player.getFightTarget(), gc);
		heal.tick(delta, player, gc);
		
		if(player.getFightTarget().isDead()){
			reset();
			sbg.enterState(Core.map);
		}else if(player.isDead()){
			reset();
			player.reset();
			sbg.enterState(Core.deathState);
		}else{
			player.getFightTarget().tick(delta, player);
		}
	}
	
	void reset(){
		fist.reset();sword.reset();lance.reset();sickStick.reset();nessBat.reset();
		heal.reset();
	}
	
	void drawEntity(Entity entity, Graphics g, float x, float y) throws SlickException{
		
		Image full = new Image(this.prog_Full);
		Image empty = new Image(this.prog_Empty);
		
		double scalar = 2.5;
		
		float width = (float) (empty.getWidth()*scalar);
		float height = (float) (empty.getHeight()*scalar);
		
		float Ewidth = (float) (entity.getTexture().getWidth()*scalar);
		float Eheight = (float) (entity.getTexture().getHeight()*scalar);
		
		float ratio = (float) (((entity.getCurrentHealth())/entity.getTotalHealth())*width);
		float realX = (float) (x - (width/2 - Ewidth/2));
		float realY = y + Eheight;
		
		entity.getTexture().draw(x, y, (float)scalar);
		empty.draw(realX, realY, (float)scalar);
		full.getScaledCopy((float) scalar).draw(realX, realY, realX+ratio, realY+height, 0,0, ratio, height);
	}
	
	void updateEntity(Entity entity){
		
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
