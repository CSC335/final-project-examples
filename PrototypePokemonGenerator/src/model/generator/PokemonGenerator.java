package model.generator;

import model.pokemon.Pokemon;

/**
 * Generates pokemon.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public interface PokemonGenerator {
	/**
	 * Gets the next Pokemon for this generator.
	 * 
	 * @return A unique Pokemon instance.
	 */
	public Pokemon getNextPokemon();
}
