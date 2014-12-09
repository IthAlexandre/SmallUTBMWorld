import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;


public abstract class ClickableElement {
	private Image img;
	public ClickableElement(int x, int y, int height, int width) throws SlickException{
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		img = new Image("testbutton.jpg");
	}
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	public abstract boolean collide(int xmouse, int ymouse);
	public abstract void HoverInteract();
	public abstract void ClickInteract(Game game);
	public Image getImg(){
		return img;
	}
	public int getPosX(){
		return x;
	}
	public int getPosY(){
		return y;
	}
}
