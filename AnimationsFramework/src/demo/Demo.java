/**
 * 
 */
package demo;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import animation.Animation;
import animation.AnimationCompleteListener;
import animation.AnimationPanel;
import animation.TranslationAnimation;
import drawable.DrawableObject;
import drawable.FilledRectangle;

/**
 * Demonstrates animations.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class Demo extends JFrame implements AnimationCompleteListener {

	private static final long serialVersionUID = 4264875008902899547L;
	
	private final static int INITIAL_X = 68;
	private final static int INITIAL_Y = 243;
	private final static int FINAL_X = 247;
	private final static int FINAL_Y = 65;
	private final static int DURATION = 1000;
	
	private JButton animateButton;
	private AnimationPanel animationPanel;
	private DrawableObject rectangle;
	private boolean isAtEnd;
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new Demo().setVisible(true);
		});
	}
	
	public Demo() {
		this.setTitle("Demo");
		this.setSize(600, 600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.rectangle = new FilledRectangle(INITIAL_X, INITIAL_Y, 50, 70, Color.PINK);
		this.animationPanel = new AnimationPanelWithBackground();
		this.animateButton = new JButton("Aniamte");
		this.animateButton.addActionListener((e) -> {
			// Depening on when we press the button we animation in a different direction
			this.animateButton.setEnabled(false);
			Animation animation = null;
			if (Demo.this.isAtEnd) {
				animation = new TranslationAnimation(this.rectangle, DURATION, INITIAL_X, INITIAL_Y);
			} else {
				animation = new TranslationAnimation(this.rectangle, DURATION, FINAL_X, FINAL_Y);
			}
			// Note that this JFrame will be notified when the animation is complete
			animation.setCompleteListener(this);
			this.animationPanel.setAnimation(animation);
			this.animationPanel.playAnimation();
		});
		this.add(this.animationPanel, BorderLayout.CENTER);
		this.add(this.animateButton, BorderLayout.WEST);
	}
	
	/* (non-Javadoc)
	 * @see animation.AnimationCompleteListener#animationComplete(animation.Animation)
	 */
	@Override
	public void animationComplete(Animation animation) {
		// Reenable the button
		this.isAtEnd = !this.isAtEnd;
		this.animateButton.setEnabled(true);
	}

}
