package Core;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import GUI.GUIHelper;
import States.*;

public class Core extends StateBasedGame{
	
	private static final int menu = 0;
	private static final int map = 1;
	private static final int fight = 2;
	
	public Core(String gameName) {
		super(gameName);
		this.addState(new Menu(menu));
		this.addState(new Map(map));
		this.addState(new Fight(fight));
	}

	public static void main(String[] args){
		GUIHelper.Initialize();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(map).init(gc, this);
		this.getState(fight).init(gc, this);
		//CHANGE THIS TO MENU AT END
		this.enterState(fight);
	}
}
