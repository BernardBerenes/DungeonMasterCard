
public class Epic extends Card {
	
	@Override
	public void createCard(String name) {
		this.name = name;
		this.rarity = "Epic";
		this.price = this.rand.nextInt(999 - 701) + 700;
	}

	public Epic(String name) {
		createCard(name);
	}
	
}
