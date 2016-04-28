package drawable;
import java.awt.Color;

/**
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public abstract class PolygonDrawableObject extends DrawableObject {

	private int height;
	private int width;
	private Color color;
	/**
	 * @param x
	 * @param y
	 * @param height
	 * @param width
	 * @param color
	 */
	public PolygonDrawableObject(int x, int y, int height, int width, Color color) {
		super(x, y);
		this.setHeight(height);
		this.setWidth(width);
		this.setColor(color);
	}
	
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	
	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		this.width = width;
	}
	
	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	
	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}
	
	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

}
