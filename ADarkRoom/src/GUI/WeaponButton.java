package GUI;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Entity.Entity;
import Weapons.Weapon;

public class WeaponButton extends Button{

	private Image prog_Full, prog_Empty;
	private float ratio, total;
	private float realX, realY;
	private float cdTotal, cdCurr;
	private Weapon weapon;
	
	public WeaponButton(String prog_Full, String prog_Empty, Weapon weapon, float x, float y)throws SlickException {
		super(weapon.getImage(), weapon.getImage(), x, y);
		this.prog_Empty = new Image(prog_Empty);
		this.prog_Full = new Image(prog_Full);
		this.total = this.prog_Empty.getWidth();
		this.ratio = total;
		this.realX = this.getX() - (this.prog_Full.getWidth()/2 - this.getCurrTex().getWidth()/2);
		this.realY = this.getY() + this.getCurrTex().getHeight();
		this.cdTotal = (float)(weapon.getCooldown()*1000.0);
		this.cdCurr = 0;
		this.weapon = weapon;
	}
	
	public void tick(int delta, Entity enemy, GameContainer gc){
		if(this.isMouseClicked(gc) && cdCurr == 0){
			cdCurr = cdTotal;
			handleWeaponEvent(enemy);
		}
		if(cdCurr>0){
			ratio = ((cdTotal-cdCurr)/cdTotal)*total;
			cdCurr -= delta;
			statusEffects(enemy, delta);
		}
		if(ratio>total){ratio = total;}
		if(cdCurr < 0){cdCurr = 0;}
	}
	
	void statusEffects(Entity enemy, int delta) {
		if(weapon.isPoisonProced()){
			//Deal damage to enemy (must pass in as parameter)
			enemy.takeDamage(10*(delta/1000));
		}
	}

	void handleWeaponEvent(Entity enemy){
		//Deal damage to enemy (must pass in as parameter)
		enemy.takeDamage(this.weapon.dealDamage());
	}
	
	public void reset(){
		this.cdCurr = 0;
		this.ratio = total;
	}
	
	@Override
	public void Draw(Graphics g){
		super.Draw(g);
		g.drawImage(prog_Empty, realX, realY);
		g.drawImage(this.prog_Full, realX, realY, realX+ratio, realY+prog_Full.getHeight(), 0, 0, ratio, prog_Full.getHeight());
	}

	public void setCdTotal(float cdTotal) {this.cdTotal = cdTotal*1000;}
	public void setCdCurr(float cdCurr) {this.cdCurr = cdCurr;}

	public float getCdTotal() {return cdTotal;}
	public float getCdCurr() {return cdCurr;}
	public Image getProg_Full() {return prog_Full;}
	public Image getProg_Empty() {return prog_Empty;}	
	
}
