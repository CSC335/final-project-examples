package bad;

public class Game {

	private Map map;
	private PokemonGenerator pokemonGenerator;
	
	public Game() {
		this.map = new Map();
		this.pokemonGenerator = new PokemonGenerator();
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
