
public class Combo {
	private Race race;
	private Superpower superpower;
	
	public Combo(Race race, Superpower superpower){
		this.race = race;
		this.superpower = superpower;
	}
	
	public Race getRace(){
		return race;
	}
	
	public Superpower getSuperPower(){
		return superpower;
	}
	
	public String toString(){
		String toString = new String();
		toString += race.getLib() + "/" + superpower.getLib();
		return toString;
	}
}
