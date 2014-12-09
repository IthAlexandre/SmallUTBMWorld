
/*
	repasser a private region.name
	add Bank?
	stocker les données du jeu en dur ou fichier?
	fabrique de jetons?
*/

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.BasicCommand;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.ControllerButtonControl;
import org.newdawn.slick.command.ControllerDirectionControl;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;
import org.newdawn.slick.command.KeyControl;
import org.newdawn.slick.command.MouseButtonControl;

public class GameHolder extends BasicGame implements InputProviderListener
{
	/** The input provider abstracting input */
	private Game game;
	private InputProvider provider;
	private Image img;
	private Image img2;
	private Image currentImage;
	
	public GameHolder(String gamename)
	{
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		img = new Image("SW_6player_surface.jpg");
		img2 = new Image("Photo d'identité.png");
		currentImage = img;
		game = new Game();
		game.start();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {
		
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException
	{
		g.drawImage(currentImage, 0, 0);
		for(ClickableElement cE : game.getCElements()){
			renderCElement(cE, g);
		}
		g.drawString("Howdy!", 100, 100);
	}
	public void renderCElement(ClickableElement cE, Graphics g){
		g.drawImage(cE.getImg(), cE.getPosX(), cE.getPosY());
	}
	@Override
	public void controlPressed(Command command) {
		// TODO Auto-generated method stub
	}

	@Override
	public void controlReleased(Command arg0) {
		// TODO Auto-generated method stub
		
	}
	public void mousePressed(int button, int x, int y) {
		for(ClickableElement cE : game.getCElements()){
			if(cE.collide(x, y))
				currentImage = img2;
			else
				currentImage = img;
		}
	}
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		ArrayList<ClickableElement> cEs = game.getCElements();
		Image imgNew = img;
		for(ClickableElement cE : cEs){
			if(cE.collide(newx, newy))
				imgNew = img2;
		}
		currentImage = imgNew;
	}
}