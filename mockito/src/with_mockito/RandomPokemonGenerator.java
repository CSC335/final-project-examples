package with_mockito;

import java.util.List;
import java.util.Random;

public class RandomPokemonGenerator implements PokemonGenerator {

	private Random random;
	private List<Pokemon> pokemon;
	
	public RandomPokemonGenerator(Random random, List<Pokemon> list) {
		this.random = random;
		this.pokemon = list;
	}
	
	@Override
	public Pokemon getPokemon() {
		return this.pokemon.get(this.random.nextInt(this.pokemon.size()));
	}

}
