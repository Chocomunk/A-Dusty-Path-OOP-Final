package Map;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Enemy.EnemyType;
import GUI.GUIHelper;

public class Tile {
	
	private float x,y,width,height;
	private Image texture;
	private TileType type;
	private boolean activated = true;
	
	public Tile(float x, float y, TileType type){
		this(x,y,64,64,type);
	}

	public Tile(float x, float y, EnemyType etype){
		this.x = x;
		this.y = y;
		this.width = 64;
		this.height = 64;
		this.type = TileType.findEType(etype);
		try {
			if(etype.getLocation() != "" && etype != null){
				this.texture = new Image(etype.getLocation());
			}
		} catch (SlickException e) {e.printStackTrace();}
	}

	public Tile(float x, float y, String img){
		this.x = x;
		this.y = y;
		this.width = 64;
		this.height = 64;
		this.type = TileType.EMPTY;
		try {
			if(img != ""){
				this.texture = new Image(img);
			}
		} catch (SlickException e) {e.printStackTrace();}
	}

	public Tile(float x, float y, float width, float height, TileType type){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.type = type;
		try {
			if(type.img != ""){
				this.texture = new Image(type.img);
			}
		} catch (SlickException e) {e.printStackTrace();}
	}
	
	public TileType getType() {return type;}
	public float getX() {return x;}
	public float getY() {return y;}
	public float getWidth() {return width;}
	public float getHeight() {return height;}
	public Image getTexture() {return texture;}
	public boolean isEnterable(){return type.enterable;}
	public boolean isActivated() {return activated;}

	public void setActivated(boolean activated) {this.activated = activated;}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}
	public void changeX(float x) {this.x += x;}
	public void changeY(float y) {this.y += y;}

	public void Draw(Graphics g){
		if(this.isActivated()){
			GUIHelper.DrawTile(this.getTexture(), this.getX(), this.getY(), g);
		}
	}
	
	public void tick(int delta, GameContainer gc){
		
	}
	
	public boolean checkEntered(Tile t){
		return t.isEnterable() && ((t.x==this.x)&&(t.y==this.y)) && t.isActivated();
	}
	
	public void onEnter(){
		
	}
}
