package with_mockito;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

// This line causes the test case to be run with JUnit and Mockito
// Mockito will initialize the objects annotated with @Mock, JUnit will run the tests.
@RunWith(MockitoJUnitRunner.class)
public class RandomPokemonGeneratorTest {

	// We create a mock Pokemon object, by doing this we can verify that
	// certain methods are called without having to write a mock class ourself.
	// We can also at runtime specify what methods return.
	@Mock
	private Pokemon mockPokemon;

	// We create a mock List object, by doing this we can verify that
	// certain methods are called without having to write a mock class ourself.
	// We can also at runtime specify what methods return.
	@Mock
	private List<Pokemon> mockPokemonList;

	// An object that is a spy will behave like the actual object but
	// we can verify that certain methods are called.
	@Spy
	private Random mockRandom;

	
	// The @Before annotation has nothing to do with Mockito.
	// Any method annotated with @Before is run before every method
	// annotated with @Test.
	@Before
	public void setUp() {
		// Since our List is a Mock we need to specify what happens
		// when we called get on the list. If we don't then get will return
		// null which we don't want. The Object returned from anyInt here is a matcher
		// by passing it in here we indicate that we return mockPokemon
		// when any integer value is passed into get.
		when(this.mockPokemonList.get(anyInt())).thenReturn(this.mockPokemon);
		// Our code calls the size method for the random, so we need a value to be returned here.
		// We can just return an arbitrary number so we return 5.
		when(this.mockPokemonList.size()).thenReturn(5);

	}

	@Test
	public void testGetsPokemonRandomly() {
		// Initialize the PokemonGenerator using the mocks we created.
		// These objects will be initialized because of the @RunWith annotation
		// on the class.
		PokemonGenerator randomPokemonGenerator = new RandomPokemonGenerator(
				this.mockRandom, this.mockPokemonList);
		Pokemon actual = randomPokemonGenerator.getPokemon();
		assertEquals(mockPokemon, actual);
		// Mockito lets us verify that a method is called on a mock
		// or spy a certain number of times with particular parameters.
		// In this case we verify that the nextInt method is called
		// on mockRandom exactly once with the parameter 5.
		verify(mockRandom, times(1)).nextInt(5);
		actual = randomPokemonGenerator.getPokemon();
		assertEquals(mockPokemon, actual);
		// In this case we verify that the nextInt method is called
		// on mockRandom exactly two times with the parameter 5.
		verify(mockRandom, times(2)).nextInt(5);
		actual = randomPokemonGenerator.getPokemon();
		assertEquals(mockPokemon, actual);
		// In this case we verify that the nextInt method is called
		// on mockRandom exactly three times with the parameter 5.
		verify(mockRandom, times(3)).nextInt(5);
	}

	// More tests

}
