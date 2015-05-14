package GUI;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.util.BufferedImageUtil;

public class Button {
	
	private Image texture, hover, currTex;
	private float x;
	private float y;
	private boolean clickable = true;
	
	public Button(String img, String hovimg, float x, float y) throws SlickException{
		this.texture = new Image(img);
		this.hover = new Image(hovimg);
		this.x = x;
		this.y = y;
		this.setToTexture();
	}
	public Button(String img, float x, float y) throws SlickException{
		this(img,img,x,y);
	}

	public Image getHover() {return hover;}
	public Image getTexture() {return texture;}
	public float getX() {return x;}
	public float getY() {return y;}
	public boolean isClickable() {return clickable;}
	public Image getCurrTex() {return currTex;}
	
	public void setTexture(String texture) throws SlickException {this.texture = new Image(texture);}
	public void setTexture(Image texture) {this.texture = texture;}
	public void setHover(Image hoverTex) {this.hover = hoverTex;}
	public void setHover(String hoverTex) throws SlickException {this.hover = new Image(hoverTex);}
	public void setX(float x) {this.x = x;}
	public void setY(float y) {this.y = y;}
	public void setClickable(boolean clickable) {this.clickable = clickable;}
	public void setCurrTex(Image currTex) {this.currTex = currTex;}
	public void setToHover(){this.setCurrTex(this.hover);}
	public void setToTexture(){this.setCurrTex(this.texture);}

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
		if(this.isMouseOver() && Mouse.isButtonDown(0)&&this.clickable){
			return true;
		}else{
			return false;
		}
	}
	
	public void Draw(Graphics g){
		g.drawImage(this.getCurrTex(), this.getX(), this.getY());
	}
}
