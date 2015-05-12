package GUI;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Button {
	
	private Image texture;
	private float x,y;
	
	public Button(String img, float x, float y) throws SlickException{
		this.texture = new Image(img);
		this.x = x;
		this.y = y;
	}

	public Image getTexture() {return texture;}
	public float getX() {return x;}
	public float getY() {return y;}
	
	public void setTexture(String texture) throws SlickException {this.texture = new Image(texture);}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}

	public boolean isMouseOver(){
		int posX = Mouse.getX();
		int posY = Display.getHeight() - Mouse.getY();
		
		int width = this.texture.getWidth();
		int height = this.texture.getHeight();
		
		if((posX>this.x && posX<this.x+width) && (posY>this.y && posY<this.y+height)){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean isMouseClicked(){
		if(this.isMouseOver() && Mouse.isButtonDown(0)){
			return true;
		}else{
			return false;
		}
	}
	
	public void Draw(Graphics g){
		g.drawImage(this.getTexture(), this.getX(), this.getY());
	}
	
}
