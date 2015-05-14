package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Map.TileMap;

public class Map extends BasicGameState{
	
	public Map(int state){
	}

	TileMap tile;

	@Override
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		tile = new TileMap();
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
		return 1;
	}

}
