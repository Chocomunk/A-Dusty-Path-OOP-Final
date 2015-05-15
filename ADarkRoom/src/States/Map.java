package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Core.Core;
import Map.TileMap;

public class Map extends BasicGameState{
	
	private int stateID;
	private Core link;
	public Map(int state, Core core){
		this.stateID = state;
		this.link = core;
	}

	TileMap tile;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		tile = new TileMap();
		link.setTileMap(this.stateID, tile);
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
