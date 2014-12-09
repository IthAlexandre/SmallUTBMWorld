


public class Player {
	Player(String n, Combo combo, GameController gameC){
		this(new TokenGroup(20, combo.getRace()), n, 5, combo, gameC);
	}
	Player(TokenGroup tokens, String name, int coins, Combo combo, GameController gameC){
		this.tokens = tokens;
		this.name = name;
		this.coins = coins;
		this.combo = combo;
		this.gameC = gameC;
	}
	public void playsATurn(Game game){
		this.playsRandomly(game);
	}
	public void playsRandomly(Game game){
		gameC.conquerRegion(tokens, this);
	}
	public String getName(){
		return this.name;
	}
	private TokenGroup tokens;
	private String name;
	private int coins;
	private Combo combo;
	private GameController gameC;
	public void earnCoins(int coins){
		if(coins > 0)
			this.coins += coins;
	}
	public Race getRace(){
		return combo.getRace();
	}
	public Superpower getSuperPower(){
		return combo.getSuperPower();
	}
	public String toString(){
		String toString = new String();
		toString += "(" + name + "/" + coins + " coins/" + combo;
		return toString + ")";
	}
}
