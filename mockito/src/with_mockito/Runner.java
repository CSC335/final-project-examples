package with_mockito;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Runner {

	public static void main(String[] args) {
		RandomMap map = new RandomMap(new Random());
		PokemonGenerator pokemonGenerator = new RandomPokemonGenerator(
				new Random(), Collections.unmodifiableList(Arrays.asList(
						new Pokemon("Squirtle"), new Pokemon("Mew"),
						new Pokemon("MissingNo."))));
		Game game = new Game(map, pokemonGenerator);
		System.out.println("The map:");
		System.out.println(game.getMapString());
		System.out.println("The pokemon you encountered:");
		System.out.println(game.getNextPokemon().getName());
		System.out.println("Can move left:");
		System.out.println(game.canMoveLeft());
	}
	
}
