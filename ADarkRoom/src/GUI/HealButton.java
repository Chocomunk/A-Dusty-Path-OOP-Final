package GUI;

import org.newdawn.slick.SlickException;

import Entity.Entity;
import Player.Player;
import Weapons.Weapon;
import Weapons.WeaponType;

public class HealButton extends WeaponButton{

	public HealButton(String prog_Full, String prog_Empty, String img,String hovimg, float x, float y)throws SlickException {
		super(prog_Full, prog_Empty, img, hovimg, new Weapon(WeaponType.Fists), x, y);
		this.setCdTotal(3);
	}
	
	@Override
	public void tick(int delta, Entity player){
		super.tick(delta, player);
		if(player.getCurrentHealth() == player.getTotalHealth()){
			this.setClickable(false);
		}else{
			this.setClickable(true);
		}
	}
	
	@Override
	public void handleWeaponEvent(Entity player){
		((Player)player).heal(25);
	}
	
}
