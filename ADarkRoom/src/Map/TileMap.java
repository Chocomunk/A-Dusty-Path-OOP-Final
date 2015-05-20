package Map;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import Enemy.Enemy;
import Enemy.EnemyType;
import GUI.GUIHelper;

public class TileMap {

	private Tile[][] grid;
	private List<Tile> tickable = new ArrayList<Tile>();
	
	public TileMap(int type){
		if(type == 0){
			generateBackGround();
		}else if(type == 1){
			placeEnemies();
		}
	}
	
	public void generateBackGround(){
		grid = new Tile[GUIHelper.WIDTH/64][GUIHelper.HEIGHT/64];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				int randChoose = (int) Math.floor(Math.random()*10);
				int typeNum = 0;
				
				if(randChoose>=1){
					typeNum = TileType.Grass.ordinal();
				}else{
					typeNum = TileType.Dirt.ordinal();
				}
				Tile thisTile = new Tile(i,j,TileType.values()[typeNum]);
				grid[i][j] = thisTile;
				if(thisTile.isEnterable()){
					tickable.add(thisTile);
				}
			}
		}
	}
	
	public void placeEnemies(){
		grid = new Tile[GUIHelper.WIDTH/64][GUIHelper.HEIGHT/64];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				int randChoose = (int) Math.floor(Math.random()*20);
				Tile thisTile;
				if(randChoose < 1 && ((i!=0)&(j!=0))){
				//	thisTile = new Enemy(EnemyType.Link, i, j);
					EnemyType[] types = EnemyType.values();
					int randIndex = (int) Math.floor(Math.random()*types.length);
					thisTile = new Enemy(types[randIndex], i, j);
				}else{
					thisTile = new Tile(i,j,TileType.EMPTY);
				}
				grid[i][j] = thisTile;
				if(thisTile.isEnterable()){
					tickable.add(thisTile);
				}
			}
		}
	}
	
	public TileMap(Tile[][] map){
		this.grid = map;
	}
	
	public void Draw(Graphics g){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				if(grid[i][j].getType() != TileType.EMPTY){
					grid[i][j].Draw(g);
				}
			}
		}
	}
	
	public Tile getTile(int x, int y){
		return grid[x][y];
	}
	
	public void tick(int delta, GameContainer gc){
		for(Tile t: tickable){
			t.tick(delta, gc);
		}
	}
	
}
