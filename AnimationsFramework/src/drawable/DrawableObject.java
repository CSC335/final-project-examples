package drawable;
import java.awt.Graphics;

/**
 * An adaptor for objects that can be drawn.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public abstract class DrawableObject {
	private int x;
	private int y;
	
	public DrawableObject(int x, int y) {
		this.setX(x);
		this.setY(y);
	}
	
	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}
	
	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
	
	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}
	
	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}
	
	public abstract void draw(Graphics g);
	
	
}
