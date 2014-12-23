import org.newdawn.slick.SlickException;

public class ClickableRegion extends ClickableElement {
	
	public ClickableRegion() throws SlickException {
		super(0, 0, 100, 100);
	}

	public ClickableRegion(int x, int y, int height, int width)
			throws SlickException {
		super(x, y, height, width);

	}

	public boolean collide(int xmouse, int ymouse) {
		if (xmouse < this.x)
			return false;
		if (xmouse >= (this.x + this.width))
			return false;
		if (ymouse < this.y)
			return false;
		if (ymouse >= (this.y + this.height))
			return false;
		return true;
	}

	public void HoverInteract() {
		System.out.println("Hovered\n");
	}

	public void ClickInteract(Game game) {
		System.out.println("Clicked!\n");
	}
}
