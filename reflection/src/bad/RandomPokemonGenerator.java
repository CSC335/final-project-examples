package bad;

import java.util.List;
import java.util.Random;

/**
 * A PokemonGenerator that generates pokemon randomly.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 */
public class RandomPokemonGenerator implements PokemonGenerator {
	
	private List<Pokemon> pokemon;
	private Random random;
	
	public RandomPokemonGenerator(List<Pokemon> pokemon, Random random) {
		this.pokemon = pokemon;
		this.random = random;
	}

	@Override
	public Pokemon getPokemon() {
		return this.pokemon.get(this.random.nextInt(this.pokemon.size()));
	}

}
