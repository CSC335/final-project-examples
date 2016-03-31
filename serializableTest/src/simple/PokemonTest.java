package simple;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

public class PokemonTest {

	// A test the verifies that a Pokemon is serialized as we expect.
	// If the Pokemon class contains fields that are Serializable then this test case will fail.
	// A failure in the unit test is much better than a failure when your game is running.
	// To get the test case clean we can have a throws declaration. Unit tests wont be handling exceptions
	// so there is no reason for us to cleanly handle this exceptions with a try-catch.
	@Test
	public void testPokemonSerializable() throws IOException, ClassNotFoundException {
		Pokemon mew = new Pokemon("mew");
		// ByteArrayOuputStream lets create an input and output stream pair
		// without needing to rely on external resources.
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		ObjectOutputStream objectOut = new ObjectOutputStream(out);
		objectOut.writeObject(mew);
		InputStream in = new ByteArrayInputStream(out.toByteArray());
		ObjectInputStream objectIn = new ObjectInputStream(in);
		Pokemon actual = (Pokemon)objectIn.readObject();
		assertEquals(mew, actual);
	}

}
