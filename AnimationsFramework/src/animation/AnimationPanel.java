/**
 * 
 */
package animation;

import java.awt.Graphics;

import javax.swing.JPanel;

/**
 * A JPanel that contains support for animations.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class AnimationPanel extends JPanel implements AnimationStepListener {

	private static final long serialVersionUID = -9207716220724837508L;
	
	private Animation animation;
	
	/**
	 * @param animation the animation to set
	 */
	public void setAnimation(Animation animation) {
		this.animation = animation;
	}
	
	/**
	 * @return the animation
	 */
	public Animation getAnimation() {
		return animation;
	}
	
	public void playAnimation() {
		if (this.animation != null) {
			this.animation.setStepListener(this);
			this.animation.start();
		}
	}
	
	/* (non-Javadoc)
	 * @see animation.AnimationStepListener#stepComplete(animation.Animation)
	 */
	@Override
	public void stepComplete(Animation animation) {
		this.repaint();
	}
	
	
	/* (non-Javadoc)
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(Graphics g) {
		// Draw the animating object.
		if (this.animation != null) {
			this.animation.getTarget().draw(g);
		}
		
	}
}
