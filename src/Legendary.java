
public class Legendary extends Card {

	@Override
	public void createCard(String name) {
		this.name = name;
		this.rarity = "Legendary";
		this.price = this.rand.nextInt(1300 - 1001) + 1000;
	}

	public Legendary(String name) {
		createCard(name);
	}
	
}
