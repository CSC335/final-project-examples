package good;

import java.util.List;
import java.util.Random;

/**
 * A PokemonGenerator that generates pokemon randomly.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 */
public class RandomPokemonGenerator implements PokemonGenerator {
	
	// The syntax here might seem odd, but this means that the type of pokemon
	// is a List of Class objects that are for classes the Pokemon class.
	// Class is a generic class, ? as with any generic class means any type
	// the extends Pokemon piece means that the type must extend the Pokemon class.
	private List<Class<? extends Pokemon>> pokemon;
	private Random random;
	
	public RandomPokemonGenerator(List<Class<? extends Pokemon>> pokemon, Random random) {
		this.pokemon = pokemon;
		this.random = random;
	}

	@Override
	public Pokemon getPokemon() {
		Class<? extends Pokemon> clazz = this.pokemon.get(this.random.nextInt(this.pokemon.size()));
		try {
			// Create a new instance of the Class in the list
			// Note that this will only work because we have a 0 argument constructor.
			// For anything more complicated we can could use:
			// Constructor<? extends Pokemon> constructor = 
			// clazz.getConstrcutor(classObjectsInOrderThatTheyAreDeclaredInTheConstructor)
			// constructor.newInstance(paramterValuesInOrder)
			return clazz.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return null;
		}
	}

}
