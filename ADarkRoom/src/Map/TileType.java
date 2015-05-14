package Map;

public enum TileType {
	
	Grass("res/grass.png", false),
	Dirt("res/dirt.png", true)
	;
	
	String img = null;
	boolean enterable;
	
	TileType(String img, boolean enterable){
		this.img = img;
		this.enterable = enterable;
	}
	
}
