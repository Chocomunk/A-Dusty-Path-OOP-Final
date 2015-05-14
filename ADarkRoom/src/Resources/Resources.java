package Resources;

public class Resources{
	private int currentWater,currentFood;
	private int totalWater,totalFood=100;
	
	public Resources(int currentWater,int currentFood){
		this.currentFood=currentFood;
		this.currentWater=currentWater;
	}
	
	public void checkLimitResources(){
		if(currentFood>totalFood)
		{
			currentFood=totalFood;
		}
		if(currentWater>totalWater)
		{
			currentWater=totalWater;
		}	
	}
	
	public int getCurrentWater() {return currentWater;}
	public void setCurrentWater(int currentWater) {this.currentWater = currentWater;}
	public int getTotalWater() {return totalWater;}
	public void setTotalWater(int totalWater) {this.totalWater = totalWater;}
	public int getCurrentFood() {return currentFood;}
	public void setCurrentFood(int currentFood) {this.currentFood = currentFood;}
	public int getTotalFood() {return totalFood;}
	public void setTotalFood(int totalFood) {this.totalFood = totalFood;}
}
