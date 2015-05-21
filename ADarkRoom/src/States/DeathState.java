package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Core.Core;
import GUI.*;

public class DeathState extends BasicGameState{
	
	private int stateID;
	private Core link;
	
	public DeathState(int state, Core core){
		stateID = state;
		this.link = core;
	}

	Button playOn;
	Button restart;
	Button quit;
	
	Image bg;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		playOn = new Button("res/Continue.png","res/Continue.png",192,600);
		restart = new Button("res/Return.png","res/Return.png",340,600);
		quit = new Button("res/Quit.png","res/Quit.png",488,600);
		
		bg = new Image("res/Defeat.PNG");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		g.drawImage(bg, 0, 0);
		
		playOn.Draw(g);
		restart.Draw(g);
		quit.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		GUIHelper.buttonState(playOn, Core.map, sbg);
		resetGame(gc);
		checkQuit(gc);
	}
	
	void resetGame(GameContainer gc){
		if(restart.isMouseClicked(gc)){
			link.resetGame();
		}else{
			GUIHelper.buttonHoverHandler(restart);
		}
	}
	
	void checkQuit(GameContainer gc){
		if(quit.isMouseClicked(gc)){
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
