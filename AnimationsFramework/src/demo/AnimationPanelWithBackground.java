/**
 * 
 */
package demo;

import java.awt.Graphics;

import javax.swing.ImageIcon;

import animation.AnimationPanel;

/**
 * A panel that demonstrates using an animation with a background.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class AnimationPanelWithBackground extends AnimationPanel {

	private static final long serialVersionUID = 2203558841062938181L;
	
	private static final String BACKGROUND_LOCATION = "images/background.png";
	private ImageIcon background;
	
	/**
	 * 
	 */
	public AnimationPanelWithBackground() {
		this.background = new ImageIcon(BACKGROUND_LOCATION);
	}
	
	/* (non-Javadoc)
	 * @see animation.AnimationPanel#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// Draw the background first and then animate, otherwise the background
		// will move the animation!.
		g.drawImage(this.background.getImage(), 0, 0, null);
		super.paintComponent(g);
	}
}
