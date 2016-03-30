package with_mockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

// The purpose of this test is to test that the Game is using it's objects correctly.
// We don't care if the generation of the Map is random or not, if the PokemonGenerator
// is generating pokemon randomly. The responsibility of Game is to provide an API
// for interacting with the game by using the objects passed into it.
// This way in the test we don't have to worry about the implementation of any of the
// dependencies is correct which makes it easier to determine where bugs are happening.

// This line causes the test case to be run with JUnit and Mockito
// Mockito will initialize the objects annotated with @Mock, JUnit will run the tests.
@RunWith(MockitoJUnitRunner.class)
public class GameTest {
	
	// We create a mock Pokemon object, by doing this we can verify that
	// certain methods are called without having to write a mock class ourself.
	// We can also at runtime specifiy what methods return.
	@Mock
	private Pokemon mockPokemon;
	
	// Mock out a map, we don't need a real map to test the Game, we just need
	// a map that returns a specific value that exposes a situation .
	@Mock
	private Map mockMap;
	
	// Mock out a PokemonGenerator, we don't need a real PokemonGenerator
	// we just need a PokemonGenerator that returns a specific value to expose a situation.
	@Mock
	private PokemonGenerator mockGenerator;
	
	// The @Before annotation has nothing to do with Mockito.
	// Any method annotated with @Before is run before every method
	// annotated with @Test.
	@Before
	public void setUp() {
		when(this.mockGenerator.getPokemon()).thenReturn(this.mockPokemon);
	}

	@Test
	public void testGetNextPokemon() {
		Game game = new Game(this.mockMap, this.mockGenerator);
		Pokemon actual = game.getNextPokemon();
		assertEquals(this.mockPokemon, actual);
		// Verify with no arguments assumes that the method is called exactly once.
		// In this case we only need to verify that the PokemonGenerator is used to
		// get the next Pokemon.
		verify(this.mockGenerator).getPokemon();
	}
	
	@Test
	public void testCanMoveLeftTrue() {
		// In this case we configure the mockMap to always allow a move left
		when(this.mockMap.canMoveLeft()).thenReturn(true);
		Game game = new Game(this.mockMap, this.mockGenerator);
		assertTrue(game.canMoveLeft());
		// Make sure the map is used to determine if the trainer can move left.
		verify(this.mockMap).canMoveLeft();
	}
}
