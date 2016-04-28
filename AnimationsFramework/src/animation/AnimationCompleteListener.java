/**
 * 
 */
package animation;

/**
 * A listener that is notified when an Animation is complete.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public interface AnimationCompleteListener {
	/**
	 * Notify the listener that the animation is complete.
	 * @param animation the animation that has finished.
	 */
	public void animationComplete(Animation animation);
}
