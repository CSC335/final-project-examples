/**
 * 
 */
package animation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import drawable.DrawableObject;

/**
 * Allows objects to be translated.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class TranslationAnimation extends Animation {

	private static final int NUM_FRAMES = 30;
	private Timer timer;
	private int endX;
	private int endY;
	private int xDelta;
	private int yDelta;

	/**
	 * @param target
	 * @param duration
	 */
	public TranslationAnimation(DrawableObject target, int duration, int endX, int endY) {
		super(target, duration);
		this.setEndX(endX);
		this.setEndY(endY);
		this.timer = new Timer(this.getDuration() / NUM_FRAMES, new TimerListener());
		this.xDelta = (this.getEndX() - this.getTarget().getX()) / NUM_FRAMES;
		this.yDelta = (this.getEndY() - this.getTarget().getY()) / NUM_FRAMES;
	}

	/**
	 * @return the endX
	 */
	public int getEndX() {
		return endX;
	}

	/**
	 * @return the endY
	 */
	public int getEndY() {
		return endY;
	}

	/**
	 * @param endX
	 *            the endX to set
	 */
	public void setEndX(int endX) {
		this.endX = endX;
	}

	/**
	 * @param endY
	 *            the endY to set
	 */
	public void setEndY(int endY) {
		this.endY = endY;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see animation.Animation#start()
	 */
	@Override
	public void start() {
		this.timer.restart();

	}

	/**
	 * Inner class for the TimerListener that will fire for every frame. When it
	 * is complete the timer is stopped and the completeListener notified. At
	 * each step if the step listener exists it will be notified.
	 * 
	 * @author Jeremy Mowery (jermowery@email.arizona.edu)
	 *
	 */
	private class TimerListener implements ActionListener {


		/*
		 * (non-Javadoc)
		 * 
		 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.
		 * ActionEvent)
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			TranslationAnimation animation = TranslationAnimation.this;
			DrawableObject target = animation.getTarget();
			boolean shouldContinue = false;
			shouldContinue = shouldContinue || (animation.xDelta > 0 ? target.getX() < animation.endX : target.getX() > animation.endX);
			shouldContinue = shouldContinue || (animation.yDelta > 0 ? target.getY() < animation.endY : target.getY() > animation.endY);
			if (shouldContinue) {
				animation.getTarget().setX(animation.getTarget().getX() + animation.xDelta);
				animation.getTarget().setY(animation.getTarget().getY() + animation.yDelta);
				if (animation.getStepListener() != null) {
					animation.getStepListener().stepComplete(animation);
				}
			} else {
				animation.timer.stop();
				animation.getTarget().setX(animation.endX);
				animation.getTarget().setY(animation.endY);
				if (animation.getCompleteListener() != null) {
					animation.getCompleteListener().animationComplete(animation);
				}
			}

		}

	}

}
