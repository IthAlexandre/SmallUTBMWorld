
public class Combo {
	public Combo(Race race, Superpower superpower){
		this.race = race;
		this.superpower = superpower;
	}
	private Race race;
	private Superpower superpower;
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
