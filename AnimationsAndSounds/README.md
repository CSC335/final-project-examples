# Transition animations and MediaPlayer example
Don't import this project, instead create a new project and set the location to be this folder.
This example makes use of JavaFX by default Java 8 will add JavaFX to your classpath, if this is not the case for you
you can find the jar in the same directory where Java is installed and you can add it to your build path manually.

In this example you will see how you can use the MediaPlayer class in JavaFX to play audio files. MediaPlayer has many benefits over the SongPlayer that Rick made for Jukebox. First MediaPlayer supports all of the functionality of Rick's SongPlayer, you can add listeners for certain events and you can easily play audio files. Secondly, MediaPlayer adds additional features like looping controller, pausing, and stopping. You will find all of the code for using a MediaPlayer in view.GameFrame, pay special attention to the use of Platform.runLater(). This method is necessary because JavaFX uses it's own thread.

In this example you will see how to fade in and out. This is accomplished by using a timer that adjusts the alpha level for a black rectangle drawn on top of an image in a JPanel. Note that these transitions are very fragile, they will break if you click the fade in/out button two quickly consecutively. It is your job to figure out how to synchronize animations correctly if you need to do so.