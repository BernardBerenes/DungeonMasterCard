
public class Common extends Card {
	
	@Override
	public void createCard(String name) {
		this.name = name;
		this.rarity = "Common";
		this.price = this.rand.nextInt(150);
	}

	public Common(String name) {
		createCard(name);
	}
	
}
