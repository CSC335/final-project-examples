# Testing Serializable
In this example we test that a Class is Serializable by writing to an OutputStream and reading it back in using an InputStream.

The Streams in the test case make a Byte array in memory to store the data for the Object instead of relying on external files, this represents good design as unit tests should not depend on external resources.

In the simple package you will find a PokemonTest class that tests that Pokemon is Serializable in one unit test.

In the using_inheritance package you will find an example of using an abstract class in your tests to capture the common functionality of multiple test cases that will need to test that a Class is Serializable.