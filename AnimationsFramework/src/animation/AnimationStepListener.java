/**
 * 
 */
package animation;

/**
 * Notifies a listener that a step is complete.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public interface AnimationStepListener {
	/**
	 * Notify the listener that a step is complete for the animation.
	 * @param animation the animation with a completed step.
	 */
	public void stepComplete(Animation animation);
}
