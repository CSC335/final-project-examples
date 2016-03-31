package bad;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class RandomPokemonGeneratorTest {

	@Test
	public void testNewPokemonAlwaysInitialHP() {
		// In this test we just need use a list of just one Pokemon
		// because we are just testing that if the same Pokemon is
		// returned that we can modify it without changing any new instance.
		List<Pokemon> pokemon = new ArrayList<>();
		pokemon.add(new Bulbasaur());
		PokemonGenerator generator = new RandomPokemonGenerator(pokemon, new Random());
		Pokemon actual = generator.getPokemon();
		assertEquals(100, actual.getHP());
		// Modify the HP of the Pokemon we got back from the generator
		// the next time we get a Pokemon it should have the initial HP
		actual.setHP(50);
		assertEquals(50, actual.getHP());
		actual = generator.getPokemon();
		assertEquals(100, actual.getHP()); // Failure here because the RandomPokemonGenerator uses the same instances!
	}

}
