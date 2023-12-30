import java.util.Random;

public abstract class Card {
	protected String name;
	protected String rarity;
	protected int price;
	protected Random rand = new Random();
	
	public void showDetail() {
		System.out.printf("| %-30s | %-15s | %-10d |\n", this.name, this.rarity, this.price);
	}
	
	public abstract void createCard(String name);

	public int getPrice() {
		return this.price;
	}
}
