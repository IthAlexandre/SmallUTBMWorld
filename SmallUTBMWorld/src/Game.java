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
	public Game() throws SlickException{
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
		cElements = new ArrayList<ClickableElement>();
		cElements.add(new ClickableRegion());
		cElements.add(new ClickableRegion(400,0,100,100));
		cElements.add(new ClickableRegion(800,0,100,100));
	}
	public void initializeMap(){
		map = new Map();
	}
	public void initializeRaces(){
		Races = new ArrayList<Race>();
		Races.add(new Race("Amazon", 15, 6));
		Races.add(new Race("Elves", 11, 6));
		Races.add(new Race("Humans", 10, 6));
	}
	public void initializeSuperPowers(){
		superpowers = new LinkedList<Superpower>();
		superpowers.add(new Superpower("Alchemist", 4));
		superpowers.add(new Superpower("Merchant", 2));
		superpowers.add(new Superpower("Berserk", 4));
	}
	public void initializeCombos(){
		Iterator<Race> itRace = Races.iterator();
		combos = new ArrayList<Combo>();
		int i = 0;
		while(itRace.hasNext() && !superpowers.isEmpty() && i < 5){
			combos.add(new Combo(itRace.next(), superpowers.removeFirst()));
		}
		while(itRace.hasNext() && !superpowers.isEmpty()){
			comboDeck.push(new Combo(itRace.next(), superpowers.removeFirst()));
		}
	}
	public boolean conquers(int nRegion, TokenGroup invaders, Player player){
		Region regionAimed = map.getRegion(nRegion);
		System.out.println(player.getName() + " essaye de conquérir " + regionAimed.name + " avec " + invaders.size() + " jetons");
		if(!regionAimed.isReachable()) return false;
		if(regionAimed.isOccupied()) {
			if(regionAimed.getOccupants().size() >= invaders.size()){
				System.out.println("Combat! occupants : " + regionAimed.getOccupants().size() + "/Envahisseurs : " + invaders.size());
				return false;
			}
		}
		System.out.println(player.getName() + " conquiert " + regionAimed.name +"!");
		regionAimed.setOwner(player);
		map.putTokenOn(nRegion, invaders);
		return true;
	}
	public void spawnTokenOn(int nRegion, TokenGroup invaders){
		map.putTokenOn(nRegion, invaders);
	}
	public String toString(){
		return map.toString();
	}
	public void start(){
		int nbTurns = 5;
		TokenGroup tokens = new TokenGroup();
		spawnTokenOn(1, tokens);
		System.out.println("Game's starting!\n");
		for(int i = 1; i < nbTurns ; ++i){
			System.out.println("\nDébut du tour " + i + " :");
			System.out.println("Etat de la map : " + this);
			for(Player currentPlayer : players){
				currentPlayer.playsATurn(this);
				currentPlayer.earnCoins(goldToPerceiveFor(currentPlayer));
				System.out.println(currentPlayer);
			}
		}
	}
	public int goldToPerceiveFor(Player player){
		int coins = 0;
		boolean isAlchemist = (player.getSuperPower().getLib() == "Alchemist");
		HashMap<Integer, Region> regions = map.getRegions(); 
		Iterator<Integer> it = regions.keySet().iterator();
		while(it.hasNext()){
			Integer key = it.next();
			Region currentRegion = map.getRegion(key);
			if(currentRegion.getOwner() != null)
				if(currentRegion.getOwner() == player){
					coins++;
					if(isAlchemist)
						coins++;
				}
		}
		return coins;
	}
	public int getNRegions() {
		return map.getNRegions();
	}
	public static ArrayList<Race> GET_RACES(){
		return Races;
	}
	public ArrayList<ClickableElement> getCElements(){
		return cElements;
	}
}
