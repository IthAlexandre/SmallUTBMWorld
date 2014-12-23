
public class Superpower {
	
	private int nTokensToHire;

	private String lib;
	
	/**
	 * D�fini un superpower
	 * @param lib: chemin d'acc�s
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
