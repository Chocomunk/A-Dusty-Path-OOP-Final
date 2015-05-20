package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Core.Core;
import GUI.*;

public class DeathState extends BasicGameState{
	
	private int stateID;
	public DeathState(int state, Core core){
		stateID = state;
	}

	public Button playOn;
	public Button quit;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		playOn = new Button("res/grass.png","res/dirt.png",100,200);
		quit = new Button("res/dirt.png","res/grass.png",200,200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		playOn.Draw(g);
		quit.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		GUIHelper.buttonState(playOn, 1, sbg);
		checkQuit(gc);
	}

	void checkQuit(GameContainer gc){
		if(quit.isMouseClicked()){
			gc.exit();
		}else{
			GUIHelper.buttonHoverHandler(quit);
		}
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
