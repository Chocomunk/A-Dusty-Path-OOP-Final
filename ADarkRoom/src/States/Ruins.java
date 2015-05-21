package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Core.Core;
import Map.TileMap;

public class Ruins extends BasicGameState{
	
	private int stateID;
	public Ruins(int state, Core core){
		stateID = state;
	}

	TileMap tile;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		tile = new TileMap(0, Core.TileX, Core.TileY);
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		tile.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		
	}

	@Override
	public int getID() {
		return stateID;
	}

}
