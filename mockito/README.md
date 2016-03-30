# Mockito example
Don't import this project, instead create a new project and set the location to be this folder.
This example makes use of the [Mockito](http://central.maven.org/maven2/org/mockito/mockito-all/1.10.19/mockito-all-1.10.19.jar) library.
To compile this example please do the following:

1. Download Mockito from the link above.
2. Add Mockito to your build path:
..1. Move the Mockito jar into your project.
..2. Rick click on your Project in Eclipse.
..3. Click Build Path... -> Configure Build Path.
..4. Switch to the libraries tab.
..5. Click Add JARs...
..6. Locate your JAR, highlight it, and click OK
..7. Click OK

In this example we take the Dependency Injection example and refactor the code from the good package to use Mockito.
By using Mockito we avoid writing our own classes to mock out functionality.
We are able to easily initialize and configure mock Objects with Mockito.
We can make instances of Objects without writing the class ourselves and change at runtime what the methods return.