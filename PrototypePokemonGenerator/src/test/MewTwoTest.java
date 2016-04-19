package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.Before;
import org.junit.Test;

import model.pokemon.MewTwo;
import model.pokemon.Pokemon;

@SuppressWarnings("javadoc")
public class MewTwoTest {

	private Pokemon firstInstance;
	private Pokemon secondInstance;

	@Before
	public void setUp() {
		this.firstInstance = new MewTwo();
		this.secondInstance = firstInstance.clone();
	}

	@Test
	public void testCloneConstructsNewObject() {
		// Note not using assertEquals here because we explicitly want to verify
		// that the object instances occupy different areas in memory.
		assertFalse(this.firstInstance == this.secondInstance);
	}

	@Test
	public void testCloneNameDoesNotChange() {
		this.firstInstance.setName("YOLO");
		this.secondInstance.setName("#RobAFootLocker");
		assertEquals("YOLO", this.firstInstance.getName());
		assertEquals("#RobAFootLocker", this.secondInstance.getName());
	}

	@Test
	public void testCloneHPDoesNotChange() {
		// It's over 9000!!!!!!
		this.firstInstance.setHp(9001);
		this.secondInstance.setHp(-9001);
		assertEquals(9001, this.firstInstance.getHp());
		assertEquals(-9001, this.secondInstance.getHp());
	}

}
