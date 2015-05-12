package Map;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import GUI.GUIHelper;

public class Tile {
	
	private float x,y,width,height;
	private Image texture;
	private TileType type;
	
	public Tile(float x, float y, float width, float height, TileType type){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		try {
			this.texture = new Image(type.img);
		} catch (SlickException e) {e.printStackTrace();}
	}
	
	public Tile(float x, float y, TileType type){
		this(x,y,64,64,type);
	}
	
	public TileType getType() {return type;}
	public float getX() {return x;}
	public float getY() {return y;}
	public float getWidth() {return width;}
	public float getHeight() {return height;}
	public Image getTexture() {return texture;}
	public boolean getEnterable(){return type.enterable;}
	
	public void Draw(Graphics g){
		GUIHelper.DrawTile(this.getTexture(), this.getX(), this.getY(), g);
	}
}
