
public class Debug {

	private static final boolean DEBUG = true;

	/**
	 * �quivalent au printf, avec v�rification de la valeur DEBUG
	 * @param s: chaine � afficher
	 */
	public static void debug( String s)
	{
		if (DEBUG)
			System.out.println(s);
	}
}
