package using_inheritance;

import java.io.IOException;

import org.junit.Test;

public class PokemonTest extends SerializableTestCase {

	// We have a much simpler test case now because we have extracted common functionality to
	// an abstract class.
	@Test
	public void testPokemonSerializable() throws ClassNotFoundException, IOException {
		this.assertObjectSerializable(new Pokemon("mew"));
	}

}
