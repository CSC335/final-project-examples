package model.pokemon;

/**
 * Represents MewTwo.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class Caterpie extends Pokemon {
	private static final long serialVersionUID = 3324699524122967795L;
	private static final String DEFAULT_NAME = "Caterpie";
	private static final int DEFAULT_HP = 100;

	/**
	 * Constructs a MewTwo Pokemon with default values.
	 */
	public Caterpie() {
		super(DEFAULT_NAME, DEFAULT_HP);
	}
}
