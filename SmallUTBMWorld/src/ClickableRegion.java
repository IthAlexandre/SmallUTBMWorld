
import java.util.ArrayList;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class ClickableRegion extends ClickableElement {
	
	private ArrayList<Integer> near;
	
	public ClickableRegion() throws SlickException {
		super(0, 0, 100, 100);
		near = new ArrayList<Integer>();
	}

	public ClickableRegion(int x, int y, int height, int width)
			throws SlickException {
		super(x, y, height, width);
		near = new ArrayList<Integer>();
	}	
	
	public ClickableRegion(int id, int x, int y, int size, String string)
			throws SlickException {
		super(x, y, size, string);
		this.id= id;
		near = new ArrayList<Integer>();
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
	
	public void addNear(int id){
		near.add(id);
	}
	
	public void addNear(String s){
		while(!s.isEmpty())
		{
			int i =s.indexOf(',');
			int id = Integer.parseInt(s.substring(0, i));
			near.add(id);
			s = s.substring(i+1);
		}
	}
	
	public boolean near(int id){
		if(near.contains(id))
			return true;
		else
			return false;
	}
}
