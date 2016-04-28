package drawable;
import java.awt.Color;
import java.awt.Graphics;

/**
 * 
 */

/**
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class FilledRectangle extends PolygonDrawableObject {

	/**
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * @param color
	 */
	public FilledRectangle(int x, int y, int height, int width, Color color) {
		super(x, y, height, width, color);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see DrawableObject#draw(java.awt.Graphics)
	 */
	@Override
	public void draw(Graphics g) {
		Color previousColor = g.getColor();
		g.setColor(this.getColor());
		g.fillRect(this.getX(), this.getY(), this.getWidth(), this.getHeight());
		g.setColor(previousColor);
	}

}
