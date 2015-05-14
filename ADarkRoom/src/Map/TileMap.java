package Map;

import org.newdawn.slick.Graphics;

import GUI.GUIHelper;

public class TileMap {

	private Tile[][] grid;
	
	public TileMap(){
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
				
				grid[i][j] = new Tile(i,j,TileType.values()[typeNum]);
			}
		}
	}
	
	public TileMap(Tile[][] map){
		this.grid = map;
	}
	
	public void Draw(Graphics g){
		for(int i=0; i<grid.length; i++){
			for(int j=0; j<grid[i].length; j++){
				grid[i][j].Draw(g);
			}
		}
	}
	
}