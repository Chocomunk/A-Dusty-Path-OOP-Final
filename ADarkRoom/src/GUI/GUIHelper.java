package GUI;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import Core.Core;

public class GUIHelper {
	
	public static final int WIDTH = 1280, HEIGHT = 960;
	private static final String NAME = "OOP Final Project - A Dusty Path";
	
	public static void Initialize(){
		AppGameContainer appgc;
		try{
			appgc = new AppGameContainer(new Core(NAME));
			appgc.setDisplayMode(WIDTH,  HEIGHT,  false);
			appgc.start();
		}catch(SlickException e){e.printStackTrace();}
	}

	public static void DrawTile(Image texture, float x, float y, Graphics g) {
		g.drawImage(texture,x*64,y*64);
	}
}
