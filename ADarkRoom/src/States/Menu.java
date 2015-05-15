package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Core.Core;
import GUI.*;

public class Menu extends BasicGameState{
	
	private int stateID;
	public Menu(int state, Core core){
		stateID = state;
	}

	public Button play;
	public Button quit;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		play = new Button("res/grass.png","res/dirt.png",100,100);
		quit = new Button("res/dirt.png","res/grass.png",200,200);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		play.Draw(g);
		quit.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		GUIHelper.buttonState(play, 1, sbg);
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
