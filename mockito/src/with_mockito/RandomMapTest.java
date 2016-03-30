package with_mockito;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class RandomMapTest {
	
	private static final List<Integer> VALID_SEQUENCE = Collections.unmodifiableList(Arrays.asList(
			/* First ten are the boulders */
			0, 0,
			1, 0,
			2, 0,
			3, 0,
			4, 0,
			/* Last two are the trainers */
			3, 3
	));
	
	private static final List<Integer> AT_THE_EDGE_SEQUENCE = Collections.unmodifiableList(Arrays.asList(
			/* First ten are the boulders */
			0, 1,
			0, 2,
			0, 3,
			0, 4,
			0, 0,
			/* Last two are the trainers */
			1, 0
	));
	
	private static final List<Integer> NEXT_TO_BOULDER_SEQUENCE = Collections.unmodifiableList(Arrays.asList(
			/* First ten are the boulders */
			0, 0,
			0, 2,
			0, 3,
			0, 4,
			1, 0,
			/* Last two are the trainers */
			0, 1
	));
	
	/**
	 * A test case to verify that the trainer can move left when the left square is >=0 and it is open.
	 */
	@Test
	public void testCanMoveLeftWhenValid() {
		RandomMap m = new RandomMap(new TestRandom(VALID_SEQUENCE));
		assertTrue(m.canMoveLeft());
	}
	
	/**
	 * Test that the trainer cannot move left when the trainer is on the left edge
	 */
	@Test
	public void testCannotMoveLeftWhenOutOfBounds() {
		// Randomly generate maps until the trainer is in the right spot
		RandomMap m = new RandomMap(new TestRandom(AT_THE_EDGE_SEQUENCE));
		assertFalse(m.canMoveLeft());
	}
	
	/**
	 * Test that the trainer cannot move left when a boulder is to the left of the trainer
	 */
	@Test
	public void testCannotMoveLeftWhenNextToBoulder() {
		RandomMap m = new RandomMap(new TestRandom(NEXT_TO_BOULDER_SEQUENCE));
		assertFalse(m.canMoveLeft());
	}

}
