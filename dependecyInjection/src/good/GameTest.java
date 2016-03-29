package good;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

// The purpose of this test is to test that the Game is using it's objects correctly.
// We don't care if the generation of the Map is random or not, if the PokemonGenerator
// is generating pokemon randomly. The responsibility of Game is to provide an API
// for interacting with the game by using the objects passed into it.
// This way in the test we don't have to worry about the implementation of any of the
// dependencies is correct which makes it easier to determine where bugs are happening.
public class GameTest {
	
	private static final List<Pokemon> POKEMON = Collections
			.unmodifiableList(Arrays.asList(new Pokemon("Squirtle"),
					new Pokemon("Mew"), new Pokemon("MissingNo.")));
	
	private static final Map CANNOT_MOVE_LEFT = new TestMap(false);
	private static final Map CAN_MOVE_LEFT = new TestMap(true);
	private static final PokemonGenerator LIST_BASED_GENERATOR = new TestPokemonGenerator(POKEMON);

	@Test
	public void testGetNextPokemon() {
		Game game = new Game(CANNOT_MOVE_LEFT, LIST_BASED_GENERATOR);
		String actual = game.getNextPokemon().getName();
		assertEquals("Squirtle", actual);
		actual = game.getNextPokemon().getName();
		assertEquals("Mew", actual);
		actual = game.getNextPokemon().getName();
		assertEquals("MissingNo.", actual);
	}
	
	@Test
	public void testCanMoveLeftTrue() {
		Game game = new Game(CAN_MOVE_LEFT, LIST_BASED_GENERATOR);
		assertTrue(game.canMoveLeft());
	}
	
	// A PokemonGenerator that I have complete control over.
	// Thanks to polymorphism with the PokemonGenerator interface, I can use this
	// with my game to "mock" a PokemonGenerator. This is better than extending the class
	// because I don't have to worry about the other functionality I would inherit.
	private static class TestPokemonGenerator implements PokemonGenerator {

		private List<Pokemon> pokemon;
		private int current;
		
		public TestPokemonGenerator(List<Pokemon> pokemon) {
			this.pokemon = pokemon;
			this.current = 0;
		}
		
		@Override
		public Pokemon getPokemon() {
			Pokemon result = this.pokemon.get(this.current);
			this.current++;
			return result;
			
		}
	}
	
	// A Map I have complete control over.
	// I don't care so much about the actual map in this test, just the value it returns from canMoveLeft
	// In a real implementation of Game the ability to move left would be important
	// Also weather or not the trainer can move left will change what other methods return.
	// So by "mocking" this out I can simulate various situations.
	private static class TestMap implements Map {
		private boolean canMoveLeft;
		
		public TestMap(boolean canMoveLeft) {
			this.canMoveLeft = canMoveLeft;
		}
		
		public boolean canMoveLeft() {
			return this.canMoveLeft;
		}
	}

}
