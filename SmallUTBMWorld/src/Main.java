
/*
	repasser a private region.name
	add Bank?
	stocker les donn�es du jeu en dur ou fichier?
	fabrique de jetons?
	reste:
		map(inclure nouvelles r�gions, inclure le graphe deplacements)
		player choix combo
*/

import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Main
{

	public static void main(String[] args)
	{
		try
		{
			AppGameContainer appgc;
			appgc = new AppGameContainer(new GameHolder("Simple Slick Game"));
			appgc.setTargetFrameRate(60);
			appgc.setDisplayMode(1366,768,false);
			appgc.start();
			
		}
		catch (SlickException ex)
		{
			Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}