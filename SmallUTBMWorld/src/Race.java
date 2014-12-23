
public class Race {
	
	public static enum RACE_ID{ AMAZON, ELF, HUMAN };
	private int nTokensTotal;
	private int nTokensToHire;
	private String lib;
	
	/**
	 * Initialise une race avec son nombre de jetons
	 * @param lib: String du chemin d'accès
	 * @param nTokensTotal: nombre totale de jetons 
	 * @param nTokensToHire: nombre de jeton utilisatable
	 */
	public Race( String lib, int nTokensTotal, int nTokensToHire){
		this.lib = lib;
		this.nTokensTotal = nTokensTotal;
		this.nTokensToHire = nTokensToHire;
	}
	
	/**
	 * 
	 * @return le chemin d'accés
	 */
	public String getLib(){
		return lib;
	}

	/**
	 * @return the nTokensTotal
	 */
	public int getnTokensTotal() {
		return nTokensTotal;
	}
	
	/**
	 * @return nTokensToHire
	 */
	public int getnTokensToHire() {
		return nTokensToHire;
	}
}
