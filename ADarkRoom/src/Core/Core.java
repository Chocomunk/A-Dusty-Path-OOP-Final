package Core;

import java.util.HashMap;

import org.newdawn.slick.*;
import org.newdawn.slick.state.*;

import GUI.*;
import Map.*;
import Player.Player;
import States.*;

public class Core extends StateBasedGame{
	
	public static final int menu = 0, map = 1, fight = 2, ruins = 3, deathState = 4;
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
		this.enterState(menu);
		player = new Player(100, 50, 50, 0, 0, "res/Player.png");
		enemies = new TileMap(1);
	}
	
	public void Draw(Graphics g){
		player.Draw(g);
		enemies.Draw(g);
	}
	
	public void tick(int delta){
		enemies.tick(delta, this.getContainer());
		player.tick(delta, this, enemies);
	}
	
	public void setTileMap(int index, TileMap map){maps.put(index, map);}
	public TileMap getTileMap(int index){return maps.get(index);}

	public TileMap getEnemies() {return enemies;}
	public Player getPlayer() {return player;}
	
}

