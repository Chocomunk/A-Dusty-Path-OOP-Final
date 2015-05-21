package Core;

import java.util.HashMap;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import GUI.*;
import Map.*;
import Player.Player;
import States.*;

public class Core extends StateBasedGame{
	
	public static final int menu = 0, map = 1, fight = 2, ruins = 3, deathState = 4, win = 5;
	public static final int TileX = 25, TileY = 25;
	private HashMap<Integer, TileMap> maps = new HashMap<Integer, TileMap>();
	private TileMap enemies;
	
	private Player player;
	
	public Core(String gameName) throws SlickException {
		super(gameName);
		this.addState(new Menu(menu, this));
		this.addState(new Map(map, this));
		this.addState(new Fight(fight, this));
		this.addState(new Ruins(ruins, this));
		this.addState(new DeathState(deathState, this));
		this.addState(new Win(win, this));
	}

	public static void main(String[] args){
		GUIHelper.Initialize();
	}

	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		this.getState(menu).init(gc, this);
		this.getState(map).init(gc, this);
		this.getState(fight).init(gc, this);
		this.getState(ruins).init(gc, this);
		this.getState(deathState).init(gc, this);
		this.getState(win).init(gc, this);
		//CHANGE THIS TO MENU AT END
		player = new Player(100, 50, 50, 0, 0, "res/Player.png", this);
		resetGame();
	}
	
	public void resetGame(){
		this.enterState(menu);
		((Map)this.getState(map)).reset();
		enemies = new TileMap(1, TileX, TileY);
	}
	
	public void Draw(Graphics g){
		player.Draw(g);
		enemies.Draw(g);
	}
	
	public void tick(int delta){
		enemies.tick(delta, this.getContainer());
		player.tick(delta, this, enemies);
		if(!enemies.allExists()){
			this.enterState(win);
		}
	}
	
	public void setTileMap(int index, TileMap map){maps.put(index, map);}
	public TileMap getTileMap(int index){return maps.get(index);}

	public TileMap getEnemies() {return enemies;}
	public Player getPlayer() {return player;}

	public void changePos(float x, float y){
		enemies.changePos(x, y);
		getTileMap(map).changePos(x, y);
	}
}

