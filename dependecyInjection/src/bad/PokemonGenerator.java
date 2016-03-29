package bad;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PokemonGenerator {
	
	private Random random;
	private List<Pokemon> pokemon;
	
	public PokemonGenerator() {
		// Bad because I am creating an object instead of injecting it
		// you are familiar with how difficult this can make testing
		this.random = new Random();
		
		// This is a bad way to get pokemon randomly, but it is instructive.
		this.pokemon = Collections.unmodifiableList(
				Arrays.asList(
						new Pokemon("Squirtle"),
						new Pokemon("Mew"),
						new Pokemon("MissingNo.")
				));
	}
	
	public Pokemon getPokemon() {
		return this.pokemon.get(this.random.nextInt(this.pokemon.size()));
	}

}
