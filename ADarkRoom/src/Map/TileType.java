package Map;

import Enemy.EnemyType;

public enum TileType {
	
	Grass("res/grass.png", false),
	Dirt("res/dirt.png", true),
	EMPTY("", false),
	
	Bandits(EnemyType.Bandits), 
	DrBoom(EnemyType.DrBoom), 
	Alvin(EnemyType.Alvin),
	Pepe(EnemyType.Pepe),
	Link(EnemyType.Link), 
	Friedland(EnemyType.Friedland)
	;
	
	String img = null;
	boolean enterable;
	EnemyType EType;
	
	TileType(String img, boolean enterable){
		this.img = img;
		this.enterable = enterable;
	}
	
	TileType(EnemyType type){
		this.img = type.getLocation();
		this.enterable = true;
	}
	
	public TileType tileType(){
		return this;
	}
	
	public void setTile(String img, boolean enterable){
		this.img = img;
		this.enterable = enterable;
	}
	
	public static TileType findEType(EnemyType type){
		TileType ty = Bandits;
		for(TileType t: TileType.values()){
			if(t.EType == type){
				ty = t;
			}
		}
		return ty;
	}
}
