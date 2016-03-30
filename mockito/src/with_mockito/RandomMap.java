/**
 * Represents a Map.
 */
package with_mockito;

import java.util.Random;

/**
 * @author Jeremy
 *
 */
public class RandomMap implements Map {
	 
	private static final int MAP_WIDTH = 5;
	private static final int MAP_HEIGHT = 5;
	private static final int NUM_BOULDERS = 5;
	private static final int STEP_AMMOUNT = 1;
	
	private static final char BOULDER = 'B';
	private static final char TRAINER = 'T';
	private static final char EMPTY = ' ';
	
	private char[][] map;
	private int trainerRow;
	private int trainerCol;
	private Random r;
	
	public RandomMap(Random r) {
		this.r = r;
		this.map = new char[MAP_HEIGHT][MAP_WIDTH];
		this.generateMap();
	}
	
	/**
	 * Generates the 2d array of chars used to represent the map.
	 */
	private void generateMap() {
		// Set up the initial map with blank chars to represent empty spaces.
		for (int i = 0; i < MAP_HEIGHT; i++) {
			for (int j = 0; j < MAP_WIDTH; j++) {
				this.map[i][j] = EMPTY;
			}
		}
		generateBoulders();
		placeTrainer();
	}

	/**
	 * Places boulders on the map randomly.
	 */
	private void generateBoulders() {
		for (int i = 0; i < NUM_BOULDERS; i++) {
			// Generate random numbers until we get a valid place to but a boulder.
			int row;
			int col;
			do {
				row = r.nextInt(MAP_HEIGHT);
				col = r.nextInt(MAP_WIDTH);
			} while (this.map[row][col] != EMPTY);
			this.map[row][col] = BOULDER;
		}
	}
	
	/**
	 * Places the trainer at a random valid position on the map and sets the location in instance variables.
	 */
	private void placeTrainer() {
		int row;
		int col;
		do {
			row = r.nextInt(MAP_HEIGHT);
			col = r.nextInt(MAP_WIDTH);
		} while (this.map[row][col] != EMPTY);
		this.map[row][col] = TRAINER;
		this.trainerRow = row;
		this.trainerCol = col;
	}
	
	/**
	 * Determines if the trainer can be moved to the left.
	 * @return true if the space to the left of the trainer is open and >= 0 false otherwise.
	 */
	public boolean canMoveLeft() {
		int newCol = this.trainerCol == 0 ? 
				0 : this.trainerCol - STEP_AMMOUNT;
		return this.map[this.trainerRow][newCol] == EMPTY;
	}
	
	/**
	 * Gets the underlying char array for this map.
	 * @return A clone of the uderlying char array.
	 */
	public char[][] getCharArray() {
		return this.map.clone();
	}
	
	@Override
	public String toString() {
		String result = "";
		// Create the header.
		for (int i = 0; i < MAP_WIDTH; i++) {
			result += "-";
		}
		result += "\n";
		for (int i = 0; i < MAP_HEIGHT; i++) {
			for (int j = 0; j < MAP_WIDTH; j++) {
				result += this.map[i][j] + "";
			}
			result += "\n";
		}
		// Create the footer.
		for (int i = 0; i < MAP_WIDTH; i++) {
			result += "-";
		}
		result += "\n";
		return result;
	}

}
