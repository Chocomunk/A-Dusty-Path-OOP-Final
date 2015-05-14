package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import GUI.*;

public class Fight extends BasicGameState{
	
	public Fight(int state){
	}
	

	public WeaponButton fist;
	public Button sword;
	public Button lance;
	
	@Override	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		fist = new WeaponButton("res/grass.png","res/dirt.png","res/grass.png","res/dirt.png", 100,600);
		sword = new Button("res/grass.png","res/dirt.png",100,700);
		lance = new Button("res/grass.png","res/dirt.png",100,800);
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		fist.Draw(g);
	//	sword.Draw(g);
	//	lance.Draw(g);
	}
	
	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		fist.tick(delta);
	//	GUIHelper.buttonState(sword, 1, sbg);
	//	GUIHelper.buttonState(lance, 1, sbg);
	}
	
	@Override
	public int getID() {
		return 2;
	}

}
