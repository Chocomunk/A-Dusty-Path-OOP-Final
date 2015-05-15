package Resources;

public class Resources{
	
	private int amount;
	
	public Resources(int amount){
		this.setAmount(amount);
	}

	public int getAmount() {return amount;}
	public void setAmount(int amount) {this.amount = amount;}
	public void subractAmount(int amount) {this.amount -= amount;}
	public void addAmount(int amount) {this.amount += amount;}
	
}
