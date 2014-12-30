import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public abstract class ClickableElement {

	protected int id;
	protected int x;
	protected int y;
	protected int height;
	protected int width;
	private Image img;
	protected boolean selection = false;

	public abstract boolean collide(int xmouse, int ymouse);

	public abstract void HoverInteract();

	public abstract void ClickInteract(Game game);


	public ClickableElement(int x, int y, int height, int width)
			throws SlickException {
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		img = new Image("testbutton.jpg");
	}
	
	public ClickableElement(int x, int y, int size , String url)
			throws SlickException {
		this.x = x-size/2;
		this.y = y-size/2;
		this.height = size;
		this.width = size;
		this.img = new Image(url);
	}


	public Image getImg() {
		return img;
	}

	public int getPosX() {
		return x;
	}

	public int getPosY() {
		return y;
	}
	
	public boolean isSelection() {
		return selection;
	}

	public void setSelection(boolean selection) {
		this.selection = selection;
	}

	public int getId() {
		return id;
	}

}
