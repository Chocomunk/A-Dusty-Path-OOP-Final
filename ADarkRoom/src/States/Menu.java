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

	Button play;
	Button quit;
	Button cheat;
	
	Image bg;
	Image title;
	
	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		play = new Button("res/StartButton.png","res/StartButton.png",400,700);
		quit = new Button("res/Quit.png","res/Quit.png",600,700);
		cheat = new Button("res/CheatButton.png","res/CheatButton.png",750,700);
		
		bg = new Image("res/Menu.PNG");
		title = new Image("res/Title.png");
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		g.drawImage(bg, 0, 0);
		g.drawImage(title, 340, 200);
		
		play.Draw(g);
		quit.Draw(g);
		cheat.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		GUIHelper.buttonState(play, Core.map, sbg);
		GUIHelper.buttonState(cheat, Core.win, sbg);
		checkQuit(gc);
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
