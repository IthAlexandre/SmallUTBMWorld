/*
 repasser a private region.name
 add Bank?
 stocker les données du jeu en dur ou fichier?
 fabrique de jetons?
 */

import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.command.Command;
import org.newdawn.slick.command.InputProvider;
import org.newdawn.slick.command.InputProviderListener;

public class GameHolder extends BasicGame implements InputProviderListener {

	private Game game;

	/**
	 * The input provider abstracting input
	 */
	private InputProvider provider;

	/**
	 * image de la carte
	 */
	private Image img;
	private Image img2;
	private Image currentImage;

	private int yMouse;

	private int xMouse;

	private ClickableElement regionD;

	private ClickableElement regionA;

	private Image img3;

	private boolean firstSelect;

	public GameHolder(String gamename) {
		super(gamename);
	}

	@Override
	public void init(GameContainer gc) throws SlickException {
		provider = new InputProvider(gc.getInput());
		provider.addListener(this);
		img = new Image("SW_6player_surface2.jpg");
		img2 = new Image("cible.png");
		img3 = new Image("cible2.png");
		currentImage = img;
		game = new Game();
		game.start();
	}

	@Override
	public void update(GameContainer gc, int i) throws SlickException {

		if (firstSelect) {
			firstSelect = false;

			int option = JOptionPane
					.showConfirmDialog(null,
							"Voulez vous attaquer cette région ?",
							"Attaque", JOptionPane.YES_NO_OPTION,
							JOptionPane.QUESTION_MESSAGE);

			if (option == JOptionPane.YES_OPTION) {
				// action en cas d'attaque
			} else {
				regionA = null;
			}
		}
	}

	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		g.drawImage(currentImage, 0, 0);
		for (ClickableElement cE : game.getCElements()) {
			renderCElement(cE, g);
		}
		
		g.drawString("x: " + xMouse + "  y: " + yMouse, 10, 25);
		if (regionD != null)
			g.drawString("depart :" + regionD.id, 10, 55);
		else
			g.drawString("depart : null", 10, 55);
		if (regionA != null)
			g.drawString("arriver :" + regionA.id, 10, 70);
		else
			g.drawString("arriver : null", 10, 70);
	}

	public void renderCElement(ClickableElement cE, Graphics g)
			throws SlickException {
		if (regionD != null && cE.getId() == regionD.getId())
			g.drawImage(img3, cE.getPosX(), cE.getPosY());
		else if (regionA != null && cE.getId() == regionA.getId()) {
			g.drawImage(img2, cE.getPosX(), cE.getPosY());
			
		} else
			g.drawImage(cE.getImg(), cE.getPosX(), cE.getPosY());
		if (cE.isSelection())
			g.drawString("selection :" + cE.id, 10, 40);
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

		boolean clear = true;
		for (ClickableElement cE : game.getCElements()) {
			if (cE.collide(x, y)) {
				cE.setSelection(!cE.isSelection());
				if (cE.isSelection() && (regionD == null))
					regionD = cE;
				else if (((ClickableRegion) regionD)
						.near(((ClickableElement) cE).getId())) {
					regionA = cE;
					firstSelect = true;
				} else {
					regionD = cE;
					regionA = null;
				}
			} else {
				currentImage = img;
				cE.setSelection(false);
			}
			if (cE.isSelection())
				clear = false;
		}
		if (clear) {
			regionD = null;
			regionA = null;
		}
	}

	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		// changement d'image quand on survole un element
		ArrayList<ClickableElement> cEs = game.getCElements();
		Image imgNew = img;
		for (ClickableElement cE : cEs) {
			if (cE.collide(newx, newy))
				// imgNew = img2;
				;
		}
		currentImage = imgNew;
		xMouse = newx;
		yMouse = newy;
	}

}