package model.pokemon;

import java.io.Serializable;

import org.apache.commons.lang3.SerializationUtils;

/**
 * Represents a Pokemon that can be copied.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public abstract class Pokemon implements Cloneable, Serializable {

	private static final long serialVersionUID = 5337989256103828906L;

	private String name;
	private int hp;

	/**
	 * Constructs a Pokemon.
	 * 
	 * @param name
	 *            The name.
	 * @param hp
	 *            The hp.
	 */
	public Pokemon(String name, int hp) {
		this.name = name;
		this.hp = hp;
	}

	/**
	 * Get the name of the Pokemon.
	 * 
	 * @param name
	 *            the name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Get the HP of the Pokemon.
	 * 
	 * @param hp
	 *            the HP
	 */
	public void setHp(int hp) {
		this.hp = hp;
	}

	/**
	 * Get the name of the Pokemon.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the HP of the Pokemon.
	 * 
	 * @return the HP
	 */
	public int getHp() {
		return hp;
	}

	@Override
	public Pokemon clone() {
		// Perform a deep copy of all of the fields in this object.
		// Note that this class comes form Apache Commons and is not in the Java
		// standard library. Cloneable is very broken in Java, so this is a
		// reliable way to get a copy of this instance.
		return SerializationUtils.clone(this);
	}
}
