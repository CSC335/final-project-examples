package good;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class RandomPokemonGeneratorTest {

	// Now I can actually test this, to verify that RandomPokemonGenerator is
	// actually returning pokemon based
	// on it's Random.
	// Note that we aren't testing Randomness here, Random we can trust is
	// implemented correctly
	// we just want to make sure that out RandomPokemonGenerator is using the
	// Random instance correctly.
	// We can accomplish this by setting what the Random will return.

	private static final List<Pokemon> POKEMON = Collections
			.unmodifiableList(Arrays.asList(new Pokemon("Squirtle"),
					new Pokemon("Mew"), new Pokemon("MissingNo.")));

	private static final List<Integer> IN_ORDER = Collections
			.unmodifiableList(Arrays.asList(0, 1, 2));
	
	@Test
	public void testGetsPokemonRandomly() {
		PokemonGenerator randomPokemonGenerator = new RandomPokemonGenerator(new TestRandom(IN_ORDER), POKEMON);
		String actual = randomPokemonGenerator.getPokemon().getName();
		assertEquals("Squirtle", actual);
		actual = randomPokemonGenerator.getPokemon().getName();
		assertEquals("Mew", actual);
		actual = randomPokemonGenerator.getPokemon().getName();
		assertEquals("MissingNo.", actual);
	}
	
	// More tests

}
