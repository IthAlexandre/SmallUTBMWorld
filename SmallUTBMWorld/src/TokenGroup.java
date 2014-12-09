


public class TokenGroup {
	public TokenGroup(){
		this(1, Game.GET_RACES().get(0));
		
	}
	public TokenGroup(int size, Race race){
		this.size = size;
		this.race = race;
	}
	private int size;
	private Race race;
	public int size(){
		return size;
	}
	public TokenGroup resize(int n){
		size = n;
		return this;
	}
	public TokenGroup split(int n){
		TokenGroup newGroup = new TokenGroup(n, this.race);
		this.size -= n;
		return newGroup;
	}
	public void add(TokenGroup tg){
		if(tg.race == this.race){
			this.size += tg.size;
		}
	}
}
