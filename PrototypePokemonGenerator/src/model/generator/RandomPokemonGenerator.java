package model.generator;

import java.util.List;
import java.util.Random;

import model.pokemon.Pokemon;

/**
 * Randomly generates new Pokemon instances.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class RandomPokemonGenerator implements PokemonGenerator {

	private Random random;
	private List<Pokemon> pokemon;

	/**
	 * Constructs a RandomPokemonGenerator.
	 * 
	 * @param random
	 *            The Random to use.
	 * @param pokemon
	 *            The list of Pokemon to choose from, it is assumed that this
	 *            list is filled with pokemon instances in the correct such that
	 *            a uniform distription will choose common pokemon more often.
	 */
	public RandomPokemonGenerator(Random random, List<Pokemon> pokemon) {
		this.random = random;
		this.pokemon = pokemon;
	}

	@Override
	public Pokemon getNextPokemon() {
		return this.pokemon.get(this.random.nextInt(this.pokemon.size())).clone();
	}

}
