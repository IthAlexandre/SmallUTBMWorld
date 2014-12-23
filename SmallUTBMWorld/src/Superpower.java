
public class Superpower {
	
	private int nTokensToHire;

	private String lib;
	
	/**
	 * Défini un superpower
	 * @param lib: chemin d'accès
	 * @param nTokensToHire: nombre de pions pour la combinaison
	 */
	public Superpower(String lib, int nTokensToHire){
		this.lib = lib;
		this.nTokensToHire = nTokensToHire;
	}
	
	public String getLib(){
		return lib;
	}
	
	public int getnTokensToHire() {
		return nTokensToHire;
	}
}
