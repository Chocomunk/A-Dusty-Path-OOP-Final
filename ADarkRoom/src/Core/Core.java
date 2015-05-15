package Core;

import java.util.HashMap;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import GUI.*;
import Map.*;
import States.*;

public class Core extends StateBasedGame{
	
	private static final int menu = 0, map = 1, fight = 2;
	private HashMap<Integer, TileMap> maps = new HashMap<Integer, TileMap>();
	
	public Core(String gameName) {
		super(gameName);
		this.addState(new Menu(menu, this));
		this.addState(new Map(map, this));
		this.addState(new Fight(fight, this));
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
	
	public void setTileMap(int index, TileMap map){maps.put(index, map);}
	public TileMap getTileMap(int index){return maps.get(index);}
}
