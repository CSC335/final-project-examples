# Animations example
Don't import this project, instead create a new project and set the location to be this folder.

In this example we show one way to get extensible animations.
First we make an adaptor for the various things that can be drawn, like in Netpaint, these can be found in drawable.
Second, we make some Animations, these are classes that use a timer to adjust some property of a DrawableObject. Animations have Step Listeners and Complete Lsiteners. When a step of the animation is complete, such as incrementally changing the position of a rectangle, the Step Listner is notified. When the animation is complete the Complete Listener is notified. One animation is complete, the TranslationAnimation which alters the x and y position of a DrawableObject over time.
Note that since positions are integer based some error can be introduced from the division in TranslationAnimation.
Finally, we make use of the Animations in AnimationPanel, which is an extension of JPanel that has support for adding and playing Animations. If you are to use this, then you would have your own class extend AnimationPanel, if you override paintComponent you need to pay special attention to the order of calling super, since all of the animating is done in the paintComponent of AnimationPanel.

In Demo you can find a working demo of this framework.
As always you may use any code you want from here.