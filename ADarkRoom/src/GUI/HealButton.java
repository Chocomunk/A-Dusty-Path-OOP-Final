package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Entity.Entity;
import Player.Player;
import Weapons.Weapon;
import Weapons.WeaponType;

public class HealButton extends WeaponButton{

	private float x,y;
	
	public HealButton(String prog_Full, String prog_Empty, String img,String hovimg, float x, float y)throws SlickException {
		super(prog_Full, prog_Empty, new Weapon(WeaponType.Fists), x, y);
		this.setCdTotal(3);
		this.setHover(hovimg);
		this.setTexture(img);
		this.setToTexture();
		this.x = x; this.y = y;
	}
	
	@Override
	public void tick(int delta, Entity player, GameContainer gc){
		super.tick(delta, player, gc);
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
	
	@Override
	public void Draw(Graphics g){
			
			Image full = this.getProg_Full();
			Image empty = this.getProg_Empty();
			
			double scalar = 2;
			
			float width = (float) (empty.getWidth()*scalar);
			float height = (float) (empty.getHeight()*scalar);
			
			float Ewidth = this.getCurrTex().getWidth();
			float Eheight = this.getCurrTex().getHeight();
			
			float ratio = (float) (ratio = ((this.getCdTotal()-this.getCdCurr())/this.getCdTotal())*width);
			float realX = (float) (x - (width/2 - Ewidth/2));
			float realY = y + Eheight;
			
			this.getCurrTex().draw(x, y);
			empty.draw(realX, realY, (float)scalar);
			full.getScaledCopy((float) scalar).draw(realX, realY, realX+ratio, realY+height, 0,0, ratio, height);
	}
}
