package bad;

/**
 * A simple Pokemon class at the root of the hierarchy.
 * Not the best design for the hierarchy, but it does serve as a good example.
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 */
public abstract class Pokemon {
	
	// Always us a constant for magic numbers.
	private static final int INITIAL_HP = 100;
	private String name;
	private int hP;
	
	public Pokemon(String name) {
		this.name = name;
		this.setHP(INITIAL_HP);
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setHP(int hP) {
		this.hP = hP;
	}
	
	public int getHP() {
		return this.hP;
	}
}
