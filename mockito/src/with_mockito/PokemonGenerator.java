package with_mockito;


// An interface for a PokemonGenerator
// In the project I only need on PokemonGenerator so I am tempted to just make a class for it
// but by having an interface I can implement any PokemonGenerator I want to pass it in
// with dependency injection to any class that needs a PokemonGenerator
// this way I can make tests for other classes without worrying about a specific PokemonGenerator instance.
// See the game class for the benefits.
public interface PokemonGenerator {
	
	// Any PokemonGenerator will need to have some method of getting a Pokemon
	public Pokemon getPokemon();
}
