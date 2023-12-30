
public class Uncommon extends Card {
	
	@Override
	public void createCard(String name) {
		this.name = name;
		this.rarity = "Uncommon";
		this.price = this.rand.nextInt(449 - 151) + 150;
	}

	public Uncommon(String name) {
		createCard(name);
	}
	
}
