
public class Race {
	public Race( String lib, int nTokensTotal, int nTokensToHire){
		this.lib = lib;
		this.nTokensTotal = nTokensTotal;
		this.nTokensToHire = nTokensToHire;
	}
	public static enum RACE_ID{ AMAZON, ELF, HUMAN };
	private int nTokensTotal;
	private int nTokensToHire;
	private String lib;
	public String getLib(){
		return lib;
	}
}
