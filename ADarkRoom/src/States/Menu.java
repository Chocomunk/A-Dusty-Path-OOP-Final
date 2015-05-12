package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;
import GUI.Button;

public class Menu extends BasicGameState{
	
	public Menu(int state){
	}

	public Button play;
	public String mouse = "";
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		play = new Button("res/grass.png",100,100);
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		play.Draw(g);
		g.drawString(mouse, 50, 50);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		if(play.isMouseClicked()){
			sbg.enterState(1);
		}else if(play.isMouseOver()){
			play.setTexture("res/dirt.png");
		}else{
			play.setTexture("res/grass.png");
		}
		
	}

	public int getID() {
		return 0;
	}

}
