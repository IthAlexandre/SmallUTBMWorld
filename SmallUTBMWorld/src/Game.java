import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import org.newdawn.slick.SlickException;

public class Game {
	private ArrayList<ClickableElement> cElements;
	private Map map;
	private ArrayList<Player> players;
	public static ArrayList<Race> Races;
	private LinkedList<Superpower> superpowers;
	private ArrayList<Combo> combos;
	private Stack comboDeck;

	public Game() throws SlickException {
		initializeRaces();
		initializeSuperPowers();
		initializeCombos();
		initializeMap();

		players = new ArrayList<Player>();
		Iterator<Combo> itCombo = combos.iterator();
		GameController gc = new GameController(this);

		players.add(new Player("Paul", itCombo.next(), gc));
		players.add(new Player("John", itCombo.next(), gc));
		players.add(new Player("Eric", itCombo.next(), gc));
		
		/*cElements = new ArrayList<ClickableElement>();
		cElements.add(new ClickableRegion());
		cElements.add(new ClickableRegion(400, 0, 50, 50));
		cElements.add(new ClickableRegion(800, 0, 50, 50));*/

	}

	public void initializeMap() {
		map = new Map();
		cElements = new ArrayList<ClickableElement>();

		try {
			cElements.add(0,new ClickableRegion(1, 55, 300, 50, "selec.png"));
			cElements.add(1,new ClickableRegion(2, 90, 360, 50, "selec.png"));
			cElements.add(2,new ClickableRegion(3, 50, 430, 50, "selec.png"));
			cElements.add(3,new ClickableRegion(4, 100, 490, 50, "selec.png"));
			cElements.add(4,new ClickableRegion(5, 65, 565, 50, "selec.png"));
			cElements.add(5,new ClickableRegion(6, 135, 100, 50, "selec.png"));
			cElements.add(6,new ClickableRegion(7, 180, 185, 50, "selec.png"));
			cElements.add(7,new ClickableRegion(8, 115, 250, 50, "selec.png"));
			cElements.add(8,new ClickableRegion(9, 180, 300, 50, "selec.png"));
			cElements.add(9,new ClickableRegion(10, 220, 360, 50, "selec.png"));
			cElements.add(10,new ClickableRegion(11, 165, 430, 50, "selec.png"));
			cElements.add(11,new ClickableRegion(12, 210, 555, 50, "selec.png"));
			cElements.add(12,new ClickableRegion(13, 280, 470, 50, "selec.png"));
			cElements.add(13,new ClickableRegion(14, 330, 390, 50, "selec.png"));
			cElements.add(14,new ClickableRegion(15, 300, 265, 50, "selec.png"));
			cElements.add(15,new ClickableRegion(16, 240, 240, 50, "selec.png"));
			cElements.add(16,new ClickableRegion(17, 290, 165, 50, "selec.png"));
			cElements.add(17,new ClickableRegion(18, 235, 120, 50, "selec.png"));
			cElements.add(18,new ClickableRegion(19, 240, 55, 50, "selec.png"));
			
			cElements.add(19,new ClickableRegion(20, 340, 55, 50, "selec.png"));
			cElements.add(20,new ClickableRegion(21, 355, 115, 50, "selec.png"));
			cElements.add(21,new ClickableRegion(22, 360, 205, 50, "selec.png"));
			cElements.add(22,new ClickableRegion(23, 400, 290, 50, "selec.png"));
			cElements.add(23,new ClickableRegion(24, 465, 330, 50, "selec.png"));

			cElements.add(24,new ClickableRegion(25, 465, 415, 50, "selec.png"));
			cElements.add(25,new ClickableRegion(26, 380, 480, 50, "selec.png"));
			cElements.add(26,new ClickableRegion(27, 380, 550, 50, "selec.png"));
			cElements.add(27,new ClickableRegion(28, 470, 500, 50, "selec.png"));
			cElements.add(28,new ClickableRegion(29, 555, 560, 50, "selec.png"));

			cElements.add(29,new ClickableRegion(30, 570, 465, 50, "selec.png"));
			cElements.add(30,new ClickableRegion(31, 545, 365, 50, "selec.png"));
			cElements.add(31,new ClickableRegion(32, 540, 280, 50, "selec.png"));
			cElements.add(32,new ClickableRegion(33, 480, 190, 50, "selec.png"));
			cElements.add(33,new ClickableRegion(34, 445, 100, 50, "selec.png"));

			cElements.add(34,new ClickableRegion(35, 430, 45, 50, "selec.png"));
			cElements.add(35,new ClickableRegion(36, 530, 50, 50, "selec.png"));
			cElements.add(36,new ClickableRegion(37, 520, 115, 50, "selec.png"));
			cElements.add(37,new ClickableRegion(38, 620, 35, 50, "selec.png"));
			cElements.add(38,new ClickableRegion(39, 680, 85, 50, "selec.png"));

			cElements.add(39,new ClickableRegion(40, 630, 135, 50, "selec.png"));
			cElements.add(40,new ClickableRegion(41, 620, 190, 50, "selec.png"));
			cElements.add(41,new ClickableRegion(42, 655, 250, 50, "selec.png"));
			cElements.add(42,new ClickableRegion(43, 620, 310, 50, "selec.png"));
			cElements.add(43,new ClickableRegion(44, 735, 370, 50, "selec.png"));

			cElements.add(44,new ClickableRegion(45, 650, 410, 50, "selec.png"));
			cElements.add(45,new ClickableRegion(46, 690, 540, 50, "selec.png"));
			cElements.add(46,new ClickableRegion(47, 850, 550, 50, "selec.png"));
			cElements.add(47,new ClickableRegion(48, 770, 470, 50, "selec.png"));
			cElements.add(48,new ClickableRegion(49, 840, 395, 50, "selec.png"));

			cElements.add(49,new ClickableRegion(50, 725, 310, 50, "selec.png"));
			cElements.add(50,new ClickableRegion(51, 855, 310, 50, "selec.png"));
			cElements.add(51,new ClickableRegion(52, 780, 270, 50, "selec.png"));
			cElements.add(52,new ClickableRegion(53, 840, 215, 50, "selec.png"));
			cElements.add(53,new ClickableRegion(54, 730, 190, 50, "selec.png"));
			
			cElements.add(54,new ClickableRegion(55, 810, 140, 50, "selec.png"));
			cElements.add(55,new ClickableRegion(56, 840, 65, 50, "selec.png"));
			cElements.add(56,new ClickableRegion(57, 750, 35, 50, "selec.png"));
			cElements.add(57,new ClickableRegion(58, 445, 240, 50, "selec.png"));



		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		((ClickableRegion) cElements.get(0)).addNear("2,8,9,");
		((ClickableRegion) cElements.get(1)).addNear("1,3,9,10,11,");
		((ClickableRegion) cElements.get(2)).addNear("2,4,11,");
		((ClickableRegion) cElements.get(3)).addNear("3,5,11,12,13,14,");
		((ClickableRegion) cElements.get(4)).addNear("4,12,");
		((ClickableRegion) cElements.get(5)).addNear("7,18,19,");
		((ClickableRegion) cElements.get(6)).addNear("6,8,16,17,18,");
		((ClickableRegion) cElements.get(7)).addNear("1,7,9,16,");
		((ClickableRegion) cElements.get(8)).addNear("1,2,8,10,15,16,");
		((ClickableRegion) cElements.get(9)).addNear("2,9,11,14,15,");
		((ClickableRegion) cElements.get(10)).addNear("2,3,4,10,14,");
		((ClickableRegion) cElements.get(11)).addNear("4,5,13,27,");
		((ClickableRegion) cElements.get(12)).addNear("4,12,14,26,27,");
		((ClickableRegion) cElements.get(13)).addNear("4,10,11,13,15,23,24,25,26,");

		((ClickableRegion) cElements.get(14)).addNear("9,10,16,22,23,");
		((ClickableRegion) cElements.get(15)).addNear("7,8,9,15,17,22,");
		((ClickableRegion) cElements.get(16)).addNear("7,16,18,21,22,");
		((ClickableRegion) cElements.get(17)).addNear("6,7,17,19,20,21,");
		((ClickableRegion) cElements.get(18)).addNear("6,18,20,");
		
		((ClickableRegion) cElements.get(19)).addNear("18,19,21,35,");
		((ClickableRegion) cElements.get(20)).addNear("17,18,20,33,34,35,");
		((ClickableRegion) cElements.get(21)).addNear("15,16,17,23,58,");
		((ClickableRegion) cElements.get(22)).addNear("14,115,22,24,32,58,");
		((ClickableRegion) cElements.get(23)).addNear("14,23,25,31,32,");

		((ClickableRegion) cElements.get(24)).addNear("14,24,26,28,30,31,");
		((ClickableRegion) cElements.get(25)).addNear("13,14,25,27,28,");
		((ClickableRegion) cElements.get(26)).addNear("12,13,26,28,29,");
		((ClickableRegion) cElements.get(27)).addNear("25,26,27,29,30,");
		((ClickableRegion) cElements.get(28)).addNear("27,28,30,46,");

		((ClickableRegion) cElements.get(29)).addNear("25,28,29,31,45,46,");
		((ClickableRegion) cElements.get(30)).addNear("24,25,30,32,43,44,45,");
		((ClickableRegion) cElements.get(31)).addNear("23,24,31,33,42,43,58,");
		((ClickableRegion) cElements.get(32)).addNear("17,21,22,32,34,37,40,41,42,58,");
		((ClickableRegion) cElements.get(33)).addNear("21,33,35,36,37,");

		((ClickableRegion) cElements.get(34)).addNear("20,21,34,35,");
		((ClickableRegion) cElements.get(35)).addNear("34,35,37,38,");
		((ClickableRegion) cElements.get(36)).addNear("33,34,36,38,39,40,");
		((ClickableRegion) cElements.get(37)).addNear("36,37,39,57,");
		((ClickableRegion) cElements.get(38)).addNear("37,38,40,55,56,57,");
		
		((ClickableRegion) cElements.get(39)).addNear("33,37,39,41,54,55,");
		((ClickableRegion) cElements.get(40)).addNear("33,40,42,54,");
		((ClickableRegion) cElements.get(41)).addNear("32,33,41,43,50,52,54,");
		((ClickableRegion) cElements.get(42)).addNear("31,32,42,44,50,");
		((ClickableRegion) cElements.get(43)).addNear("31,43,45,48,49,50,");

		((ClickableRegion) cElements.get(44)).addNear("30,31,44,46,48,");
		((ClickableRegion) cElements.get(45)).addNear("29,30,45,47,48,");
		((ClickableRegion) cElements.get(46)).addNear("46,48,49,");
		((ClickableRegion) cElements.get(47)).addNear("44,45,46,47,49,");
		((ClickableRegion) cElements.get(48)).addNear("44,47,48,50,51,");

		((ClickableRegion) cElements.get(49)).addNear("42,43,44,49,51,52,");
		((ClickableRegion) cElements.get(50)).addNear("49,50,52,");
		((ClickableRegion) cElements.get(51)).addNear("42,50,51,53,54,");
		((ClickableRegion) cElements.get(52)).addNear("52,54,55,");
		((ClickableRegion) cElements.get(53)).addNear("40,41,42,52,53,55,");

		((ClickableRegion) cElements.get(54)).addNear("39,40,53,54,56,");
		((ClickableRegion) cElements.get(55)).addNear("39,55,57,");
		((ClickableRegion) cElements.get(56)).addNear("38,39,56,");
		((ClickableRegion) cElements.get(57)).addNear("22,23,32,33,");

		//		((ClickableRegion) cElements.get(14)).addNear(",");
	}

	public void initializeRaces() {
		Races = new ArrayList<Race>();
		Races.add(new Race("Amazon", 15, 6));
		Races.add(new Race("Elves", 11, 6));
		Races.add(new Race("Humans", 10, 6));
	}

	public void initializeSuperPowers() {
		superpowers = new LinkedList<Superpower>();
		superpowers.add(new Superpower("Alchemist", 4));
		superpowers.add(new Superpower("Merchant", 2));
		superpowers.add(new Superpower("Berserk", 4));
	}

	public void initializeCombos() {
		Iterator<Race> itRace = Races.iterator();
		combos = new ArrayList<Combo>();
		int i = 0;
		// création de la liste de combinaison piochable
		while (itRace.hasNext() && !superpowers.isEmpty() && i < 5) {
			combos.add(new Combo(itRace.next(), superpowers.removeFirst()));
		}
		// créattion du deck de combinaison
		while (itRace.hasNext() && !superpowers.isEmpty()) {
			comboDeck.push(new Combo(itRace.next(), superpowers.removeFirst()));
		}
	}

	public boolean conquers(int nRegion, TokenGroup invaders, Player player) {
		Region regionAimed = map.getRegion(nRegion);
		Debug.debug(player.getName() + " essaye de conquérir "
				+ regionAimed.name + " avec " + invaders.size() + " jetons");

		if (!regionAimed.isReachable())
			return false;

		// il faudra ajouter la 2 pion de base pour la conquée et la prise en
		// compte des forteresse et autres
		if (regionAimed.isOccupied()) {
			if (regionAimed.getOccupants().size() >= invaders.size()) {
				Debug.debug("Combat! occupants : "
						+ regionAimed.getOccupants().size()
						+ "/Envahisseurs : " + invaders.size());
				return false;
			}
		}

		Debug.debug(player.getName() + " conquiert " + regionAimed.name + "!");
		regionAimed.setOwner(player);
		map.putTokenOn(nRegion, invaders);
		return true;
	}

	public void spawnTokenOn(int nRegion, TokenGroup invaders) {
		map.putTokenOn(nRegion, invaders);
	}

	public String toString() {
		return map.toString();
	}

	public void start() {
		int nbTurns = 5;
		TokenGroup tokens = new TokenGroup();
		spawnTokenOn(1, tokens);
		System.out.println("Game's starting!\n");

		for (int i = 1; i < nbTurns; ++i) {
			System.out.println("\nDébut du tour " + i + " :");
			System.out.println("Etat de la map : " + this);
			for (Player currentPlayer : players) {
				currentPlayer.playsATurn(this);
				currentPlayer.earnCoins(goldToPerceiveFor(currentPlayer));
				System.out.println(currentPlayer);
			}
		}
	}

	public int goldToPerceiveFor(Player player) {
		int coins = 0;
		boolean isAlchemist = (player.getSuperPower().getLib() == "Alchemist");
		HashMap<Integer, Region> regions = map.getRegions();
		Iterator<Integer> it = regions.keySet().iterator();
		while (it.hasNext()) {
			Integer key = it.next();
			Region currentRegion = map.getRegion(key);
			// if (currentRegion.getOwner() != null)
			if (currentRegion.getOwner() == player) {
				coins++;
				if (isAlchemist)
					coins++;
			}
		}
		return coins;
	}

	public int getNRegions() {
		return map.getNRegions();
	}

	public static ArrayList<Race> GET_RACES() {
		return Races;
	}

	public ArrayList<ClickableElement> getCElements() {
		return cElements;
	}
}
