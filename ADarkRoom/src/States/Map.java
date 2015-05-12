package States;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import Map.TileMap;

public class Map extends BasicGameState{
	
	public Map(int state){
	}

	TileMap tile;
	
	public void init(GameContainer gc, StateBasedGame sbg)throws SlickException {
		tile = new TileMap();
	}

	public void render(GameContainer gc, StateBasedGame sbg, Graphics g)throws SlickException {
		tile.Draw(g);
	}

	public void update(GameContainer gc, StateBasedGame sbg, int delta)throws SlickException {
		
	}

	public int getID() {
		return 1;
	}

}
