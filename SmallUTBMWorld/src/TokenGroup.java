
public class TokenGroup {

	/**
	 * nombre d'unité
	 */
	private int size;
	
	private Race race;

	public TokenGroup() {
		this(1, Game.GET_RACES().get(0));
	}

	public TokenGroup(int size, Race race) {
		this.size = size;
		this.race = race;
	}

	public int size() {
		return size;
	}

	public TokenGroup resize(int n) {
		size = n;
		return this;
	}

	public TokenGroup split(int n) {
		TokenGroup newGroup;
		if(size <= n){
			newGroup = new TokenGroup(n, this.race);
			this.size -= n;
		}
		else
		{
			newGroup = new TokenGroup(size, this.race);
			this.size = 0;
		}
		return newGroup;
	}

	public void add(TokenGroup tg) {
		if (tg.race == this.race) {
			this.size += tg.size;
		}
	}
}
