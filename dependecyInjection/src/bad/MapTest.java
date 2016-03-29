package bad;

import static org.junit.Assert.*;

import org.junit.Test;

public class MapTest {
	
	/**
	 * A test case to verify that the trainer can move left when the left square is >=0 and it is open.
	 */
	@Test
	public void testCanMoveLeftWhenValid() {
		// Randomly generate maps until the trainer is in the right spot
		Map m;
		char characterLeftOfTrainer = '\0';
		do {
			m = new Map();
			char[][] array = m.getCharArray();
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					if (array[i][j] == 'T') {
						// Check to the left
						if (j == 0) {
							continue;
						} else {
							characterLeftOfTrainer = array[i][j - 1];
						}
					}
				}
			}
		} while (characterLeftOfTrainer != ' ');
		// Finally we have a map set up like we want!
		assertTrue(m.canMoveLeft());
	}
	
	/**
	 * Test that the trainer cannot move left when the trainer is on the left edge
	 */
	@Test
	public void testCanNotMoveLeftWhenOutOfBounds() {
		// Randomly generate maps until the trainer is in the right spot
		Map m;
		while (true) {
			m = new Map();
			boolean shouldExit = false;
			char[][] array = m.getCharArray();
			for (int i = 0; i < 5; i++) {
				if (array[i][0] == 'T') {
					shouldExit = true;
					break;
				}
			}
			if (shouldExit) {
				break;
			}
		}
		
		// Finally we have a map set up like we want!
		assertFalse(m.canMoveLeft());
	}

}
