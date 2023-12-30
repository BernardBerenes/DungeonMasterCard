import java.util.Random;
import java.util.Scanner;

public class Main {
	private Scanner scan = new Scanner(System.in);
	private Random rand = new Random();
	private int coins = 1000;
	private Collection collections = new Collection();
	
	private String[] legendaryName = {
			"Agnolus the Midgod",
			"Barvert the God Slayer",
			"Zeonas the Chosen One",
			"Winter Guard Andor",
			"Selise the Empress of Sun",
			"Raibs the Empress of Moon",
			"Thodem the Immortal King",
			"Yordus the Dark Knight",
			"Erlang the One Being",
			"Paxnel the Ancient"
	};
	
	private String[] epicName = {
			"Javas the Hollow",
			"Jabbahut Slavemaster",
			"Gosbu Angnoluson",
			"Albion the Fallen Knight",
			"Pecados the Stonearm",
			"Firegod Magnus",
			"Jordmungan the Giant",
			"Honuros the Phoenix",
			"Krico of the Madagas",
			"Fredrickson the Conqueror"
	};
	
	private String[] rareName = {
			"Reggin the Barbarian",
			"Hatojin No Master Ronin",
			"Sergeant Private",
			"Radagam the Dragon",
			"Oz the Magician",
			"Balurds the Gatekeeper",
			"Jered the Pirate King",
			"Percys Seven Seas Guardian",
			"Morses the High Priest",
			"Freiren the Myhtical Elf"
	};

	private String[] uncommonName = {
			"Grandmaster Yorsn",
			"Jonthor the Taskmaster",
			"Burhan the Envelope Carrier",
			"Xander Liar Wolf",
			"Richarn the Lycan",
			"Blaire the Witch of Oz",
			"Pedroz the Dragontamer",
			"Adrian the Strongman",
			"Anabel Cursed Doll",
			"Sigros the Tree Sentinel"
	};
	
	private String[] commonName = {
			"Lestey the Marksman",
			"Hunterman Kroger",
			"Secret Assasin Vix",
			"Mustof the Richest Man",
			"Ordor the Golem",
			"Mumen the Rider",
			"Zuck the Spy",
			"Osman the Warlord",
			"Kabbal the Abyssal",
			"Mortis the Vampire"
	};
	
	private void gacha() {
		String rarity;
		int price;
		int randomRarity = rand.nextInt(100);
		int randomCard = rand.nextInt(10);
		if(randomRarity <= 4) {
			this.collections.add(new Legendary(legendaryName[randomCard]));
		} else if(randomRarity <= 14) {
			this.collections.add(new Epic(epicName[randomCard]));
		} else if(randomRarity <= 34) {
			this.collections.add(new Rare(rareName[randomCard]));
		} else if(randomRarity <= 59) {
			this.collections.add(new Uncommon(uncommonName[randomCard]));
		} else if(randomRarity <= 99) {
			this.collections.add(new Common(commonName[randomCard]));
		}
		this.coins -= 100;
	}
	
	private boolean showCollection() {
		printEnter();
		System.out.println("+---------------------------------------------------------------+");
		System.out.println("| Champion Name                  | Card Rarity     | Sell Price |");
		System.out.println("+---------------------------------------------------------------+");
		boolean isEmpty = collections.show();
		System.out.println("+---------------------------------------------------------------+");
		return isEmpty;
	}
	
	private void sell() {
		String name;
		if(!showCollection()) {
			return;
		}
		do {
			System.out.print("Card name you want to sell: ");
			name = scan.nextLine();
			int sellPrice = collections.remove(name);
			if(sellPrice != -1) {
				System.out.println("You get " + sellPrice + " from selling " + name);
				this.coins += sellPrice;
				break;
			} else {
				System.out.println("Card not found. Please enter the name in your collection");
			}
		} while(true);
		pressEnter();
	}
	
	private void mainMenu() {
		int mainMenuChoice = -1;
		do {
			menu();
			try {	
				mainMenuChoice = scan.nextInt();
			} catch (Exception e) {

			} finally {
				scan.nextLine();
			}
			
			switch (mainMenuChoice) {
			case 1:
				gacha();
				break;

			case 2:
				showCollection();
				pressEnter();
				break;
			
			case 3:
				sell();
				break;
			}
		} while(mainMenuChoice != 4);
	}

	private void menu() {
		printEnter();
		System.out.println("Dungeon Master Card Gacha");
		System.out.println("=========================");
		System.out.println("COIN : " + coins);
		System.out.println("=========================");
		System.out.println("1. Gacha (100 coins)");
		System.out.println("2. Your collection");
		System.out.println("3. Sell");
		System.out.println("4. Exit");
		System.out.print(">> ");
	}
	
	private void pressEnter() {
		System.out.println("Press enter to continue...");
		scan.nextLine();
	}
	
	private void printEnter() {
		for (int i = 0; i < 10; i++) {
			System.out.println();
		}
	}
	
	public Main() {
		mainMenu();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}
