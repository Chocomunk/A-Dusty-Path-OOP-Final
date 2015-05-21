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
		reset();
	}

	@Override
	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		tile.Draw(g);
		link.Draw(g);
	}

	@Override
	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		link.tick(delta);
	}
	
	public void reset(){
		tile = new TileMap(0, Core.TileX, Core.TileY);
		link.setTileMap(this.stateID, tile);
	}
	
	@Override
	public int getID() {
		return stateID;
	}

}
