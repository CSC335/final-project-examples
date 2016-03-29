package bad;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameTest {

	// I can't test game!
	// Game now creates two objects itself, both of which I have no control over.
	// Moreover, each one of those objects creates a Random by itself, so I have
	// no ability to predict the output.
	// When you don't use dependency injection your problems will cascade!

}
