
public class Rare extends Card {
	
	@Override
	public void createCard(String name) {
		this.name = name;
		this.rarity = "Rare";
		this.price = this.rand.nextInt(699 - 401) + 400;
	}

	public Rare(String name) {
		createCard(name);
	}
	
}
