package simple;

import java.io.Serializable;

/**
 * A simple Serializable class.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 */
public class Pokemon implements Serializable {
	
	private static final long serialVersionUID = 4620423706194030846L;
	
	private String name;
	
	public Pokemon(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}
	
	@Override
	public boolean equals(Object other) {
		// In an equals method you should always confirm that the instance of the Object
		// is the type you are looking for.
		if (!(other instanceof Pokemon)) {
			return false;
		} else {
			Pokemon otherPokemon = (Pokemon)other;
			return this.name.equals(otherPokemon.getName());
		}
	}

}
