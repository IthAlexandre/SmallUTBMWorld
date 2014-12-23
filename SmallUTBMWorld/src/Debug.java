
public class Debug {

	private static final boolean DEBUG = true;

	/**
	 * équivalent au printf, avec vérification de la valeur DEBUG
	 * @param s: chaine à afficher
	 */
	public static void debug( String s)
	{
		if (DEBUG)
			System.out.println(s);
	}
}
