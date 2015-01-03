import java.util.Stack;

public class Region {
	
	private Player owner;
	public String name;
	private boolean spawnable;
	private boolean reachable;
	private TokenGroup occupants;
	private int id;

	public Region(String name, boolean spawnable) {
		this(null, name, spawnable, true, new TokenGroup());
	}

	public Region(Player owner, String name, boolean spawnable,
			boolean reachable, TokenGroup occupants) {
		this.owner = owner;
		this.name = name;
		this.spawnable = spawnable;
		this.reachable = reachable;
		this.occupants = occupants;
	}

	public String toString() {
		String toString = new String();
		toString += "(" + name + "/";
		if (this.spawnable)
			toString += "spawnable/";
		else
			toString += "non spawnable/";
		toString += occupants.size() + " occupants/";
		if (owner == null)
			toString += "Pas de propriétaire!";
		else
			toString += "Mon propriétaire est " + owner.getName();
		toString += ")";
		return toString;
	}

	public void setOccupants(TokenGroup invaders) {
		occupants = invaders;
	}

	public boolean isReachable() {
		return reachable;
	}

	public void setOwner(Player player) {
		this.owner = player;
	}

	public Player getOwner() {
		return this.owner;
	}

	public boolean isOccupied() {
		return (occupants.size() > 0);
	}

	public TokenGroup getOccupants() {
		return occupants;
	}
}
