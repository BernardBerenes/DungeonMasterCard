import java.util.ArrayList;

public class Collection {
	private ArrayList<Card> cards;

	public Collection() {
		this.cards = new ArrayList<>();
	}
	
	public void add(Card card) {
		this.cards.add(card);
	}
	
	public boolean checkEmpty() {
		return cards.isEmpty();
	}
	
	public boolean show() {
		if(this.checkEmpty()) {
			System.out.println("| You have no card                                              |");
			return false;
		}
		for (Card card : cards) {
			card.showDetail();
		}
		return true;
	}
	
	public int remove(String name) {
		for (Card card : cards) {
			if(card.name.equals(name)) {
				this.cards.remove(card);
				return card.getPrice();
			}
		}
		return -1;
	}
	
}
