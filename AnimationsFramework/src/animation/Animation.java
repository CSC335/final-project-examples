/**
 * 
 */
package animation;

import drawable.DrawableObject;

/**
 * The animation class provides simple methods for
 * getting the target and for adding listeners for events.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public abstract class Animation {
	private DrawableObject target;
	private int duration;
	private AnimationStepListener stepListener;
	private AnimationCompleteListener completeListener;
	
	
	public Animation(DrawableObject target, int duration) {
		this.target = target;
		this.duration = duration;
	}
	
	/**
	 * @return the target
	 */
	public DrawableObject getTarget() {
		return target;
	}
	
	/**
	 * @return the duration
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * @return the stepListener
	 */
	public AnimationStepListener getStepListener() {
		return stepListener;
	}
	
	/**
	 * @return the completeListener
	 */
	public AnimationCompleteListener getCompleteListener() {
		return completeListener;
	}
	
	/**
	 * @param stepListener the stepListener to set
	 */
	public void setStepListener(AnimationStepListener stepListener) {
		this.stepListener = stepListener;
	}
	
	/**
	 * @param completeListener the completeListener to set
	 */
	public void setCompleteListener(AnimationCompleteListener completeListener) {
		this.completeListener = completeListener;
	}
	
	public abstract void start();
	
}
