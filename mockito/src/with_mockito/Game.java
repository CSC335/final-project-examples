package with_mockito;

public class Game {

	private Map map;
	private PokemonGenerator pokemonGenerator;
	
	public Game(Map map, PokemonGenerator pokemonGenerator) {
		this.map = map;
		this.pokemonGenerator = pokemonGenerator;
	}
	
	public String getMapString() {
		return this.map.toString();
	}
	
	public Pokemon getNextPokemon() {
		return this.pokemonGenerator.getPokemon();
	}
	
	public boolean canMoveLeft() {
		return this.map.canMoveLeft();
	}
}
