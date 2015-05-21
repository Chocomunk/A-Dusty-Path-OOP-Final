package Map;

import java.util.ArrayList;
import java.util.List;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import Enemy.Enemy;
import Enemy.EnemyType;

public class TileMap {

	private Tile[][] grid;
	private List<Tile> tickable = new ArrayList<Tile>();
	
	public TileMap(int type, int x, int y){
		if(type == 0){
			generateBackGround(x,y);
		}else if(type == 1){
			placeEnemies(x,y);
		}
	}
	
	public void generateBackGround(int x, int y){
		grid = new Tile[x+20][y+15];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				Tile thisTile = null;
				//(i==9&&(j>=6||j<=x+1))&&(i==x+1&&(j>=6||j<=x+1))
				if((i==9&&(j>=6&&j<=y+7))||(i==x+10&&(j>=6&&j<=y+7)) || (j==6&&(i>=9&&i<=x+10))||(j==x+7&&(i>=9&&i<=x+10))){
					thisTile = new Tile(i-10,j-7,TileType.Wall);
				}else{
					int randChoose = (int) Math.floor(Math.random()*10);
					int typeNum = 0;
					
					if(randChoose>=1){
						typeNum = TileType.Grass.ordinal();
					}else{
						typeNum = TileType.Dirt.ordinal();
					}
					thisTile = new Tile(i-10,j-7,TileType.values()[typeNum]);
				}
				grid[i][j] = thisTile;
				if(thisTile.isEnterable()){
					tickable.add(thisTile);
				}
			}
		}
	}
	
	public void placeEnemies(int x, int y){
		grid = new Tile[x][y];
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				int randChoose = (int) Math.floor(Math.random()*20);
				Tile thisTile;
				if(randChoose < 1 && ((i!=10)&(j!=7))){
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
	
	public boolean allExists(){
		boolean exists = false;
		for(Tile[] i: this.grid){
			for(Tile j: i){
				if(j.isActivated()){
					exists = true;
				}
			}
		}
		return exists;
	}

	public void changePos(float x, float y) {
		for(Tile[] i: grid){
			for(Tile j: i){
				j.changeX(-x);
				j.changeY(-y);
			}
		}
	}
	
	public Tile getTile(int x, int y){return grid[x][y];}
	public Tile[][] getGrid(){return grid;}
	
	public void tick(int delta, GameContainer gc){
		for(Tile t: tickable){
			t.tick(delta, gc);
		}
	}
	
}
