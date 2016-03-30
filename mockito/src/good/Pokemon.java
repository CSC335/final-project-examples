package good;

public class Pokemon {
	private String name;
	
	// This is not the best way to create the hierarchy
	// but this is just the least possible to demonstrate.
	public Pokemon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
}
