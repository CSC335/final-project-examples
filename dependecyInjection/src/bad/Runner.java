package bad;

public class Runner {

	public static void main(String[] args) {
		Game game = new Game();
		System.out.println("The map:");
		System.out.println(game.getMapString());
		System.out.println("The pokemon you encountered:");
		System.out.println(game.getNextPokemon().getName());
		System.out.println("Can move left:");
		System.out.println(game.canMoveLeft());
	}

}
