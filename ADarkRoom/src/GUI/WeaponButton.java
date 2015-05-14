package GUI;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class WeaponButton extends Button{

	private Image prog_Full, prog_Empty;
	private float ratio, total;
	private float realX, realY;
	private float cdTotal, cdCurr;
	
	public WeaponButton(String prog_Full, String prog_Empty,String img, String hovimg, float x, float y)throws SlickException {
		super(img, hovimg, x, y);
		this.prog_Empty = new Image(prog_Empty);
		this.prog_Full = new Image(prog_Full);
		total = this.prog_Empty.getWidth();
		ratio = total;
		realX = this.getX() + (this.prog_Full.getWidth()/2 - this.getCurrTex().getWidth()/2);
		realY = this.getY() + this.getCurrTex().getHeight();
		cdTotal = 1000;
		cdCurr = 0;
	}
	
	public void tick(int delta){
		if(this.isMouseClicked() && cdCurr == 0){
			cdCurr = cdTotal;
			handleWeaponEvent();
		}
		if(cdCurr>0){
			ratio = ((cdTotal-cdCurr)/cdTotal)*total;
			cdCurr -= delta;
		}
		if(ratio>total){ratio = total;}
		if(cdCurr < 0){cdCurr = 0;}
	}
	
	void handleWeaponEvent(){
		
	}
	
	@Override
	public void Draw(Graphics g){
		super.Draw(g);
		g.drawImage(prog_Empty, realX, realY);
		g.drawImage(this.prog_Full, realX, realY, realX+ratio, realY+total, 0, 0, ratio, total);
	}
}
