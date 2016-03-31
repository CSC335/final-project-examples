package good;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		List<Class<? extends Pokemon>> pokemon = Collections.unmodifiableList(Arrays.asList(
				Bulbasaur.class,
				MissingNo.class,
				Mew.class
		));
		PokemonGenerator generator = new RandomPokemonGenerator(pokemon, new Random());
		System.out.println("5 pokemon encountered:");
		for (int i = 1; i <= 5; i++) {
			Pokemon encountered = generator.getPokemon();
			System.out.println(i + ". Name: " + encountered.getName() + ", HP: " + encountered.getHP());
		}

	}

}
