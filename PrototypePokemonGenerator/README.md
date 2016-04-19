# Prototype Design Pattern Example
Don't import this project, instead create a new project and set the location to be this folder.
This example makes use of the [Apache Commons Lang Library](http://central.maven.org/maven2/org/apache/commons/commons-lang3/3.4/commons-lang3-3.4.jar) library.
To compile this example please do the following:

1. Download the Apache Commons Lang Library from the link above.
2. Add the Apache Commons Lang Library to your build path:
  1. Move the the Apache Commons Lang Library jar into your project.
  2. Rick click on your Project in Eclipse.
  3. Click Build Path... -> Configure Build Path.
  4. Switch to the libraries tab.
  5. Click Add JARs...
  6. Locate your JAR, highlight it, and click OK
  7. Click OK

In this example we show how you can use the Prototype design pattern to create new instances of Pokemon objects from existing objects using the clone method.
We have choosen to use the Apache Commons Lang library so that we can use SerializationUtils which allows us to clone Object instances.
Java's Cloneable interface is very flawed and makes creating real clones of Objects difficult. SerializationUtils guarantees that Objects will be cloned correctly.
However, SerializationUtils expects that the Object being cloned is Serializable and is a very slow method of cloning.
For this reason we presented the Reflection method first.

The Prototype Design Pattern is shown through the use of Cloneable in the inharitence hierarchy of Pokemon and in the Pokemon generator.
Pokemon is an abstract class that implements Cloneable and overrides Objects clone method, returning a deep copy instance of this Pokemon.
The concrete classes are what are cloned.
The Pokemon generator makes use of this by returning a Pokemon instance that cloned from a instance in a list passed in.
This way we prevent the Pokemon in the generator from being impacted by changes to instances perviously generated.
