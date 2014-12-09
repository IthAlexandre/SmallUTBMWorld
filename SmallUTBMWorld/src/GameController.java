
import java.util.Random;
import java.util.Stack;


public class GameController {
	public GameController(Game game){
		this.game = game;
	}
	private Game game;
	public boolean conquerRegion(TokenGroup tokens, Player player){
		if(tokens.size() <= 0) return false;
		Random rand = new Random();
		int r = rand.nextInt(tokens.size() - 1 + 1) + 1;
		TokenGroup tokensToInvade = tokens.split(r);
		boolean conquered = game.conquers(chooseNRegion(), tokensToInvade, player);
		if(!conquered)
			tokens.add(tokensToInvade);
		return conquered;
		/*
		nRegion = chooseNRegion();
		int nTokensRequired = ..;
		if tokens.size() > nTokensRequired
			conquered =
		 
		 */
	}
	public int chooseNRegion(){
		int nRegion = 0;
		/*while(nRegion < 0 || nRegion > game.getNRegions())*/
		Random rand = new Random();
		nRegion = rand.nextInt(3 - 1 + 1) + 1;
		return nRegion;
	}
}
