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
