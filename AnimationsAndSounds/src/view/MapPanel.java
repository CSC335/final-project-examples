package view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * A demonstration of a fade animation. Note that this is not synchronized in
 * anyway, this code will break if fadeIn and fadeOut are called simultaneously,
 * if your project requires this it will be up to you to ensure that methods
 * like this cannot be called at the same time.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 */
public class MapPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private static final String MAP_LOCATION = "images/map.jpg";
	private static final int DURATION = 50;
	private static final int DELTA = 10;
	private static final int MAX_ALPHA = 255;
	private static final int MIN_ALPHA = 0;

	private ImageIcon mapImage;
	private int transitionRectangleAlpha;
	private Timer fadeInTimer;
	private Timer fadeOutTimer;

	/**
	 * Initializes the MapPanel by loading the map image and creating timers for
	 * fading in and out.
	 */
	public MapPanel() {
		this.mapImage = new ImageIcon(MAP_LOCATION);
		this.transitionRectangleAlpha = MIN_ALPHA;
		// Create the timers for the animations, note that they are not started.
		// Also note that use of lambdas here.
		this.fadeInTimer = new Timer(DURATION, null);
		this.fadeInTimer.addActionListener((e) -> {
			MapPanel.this.transitionRectangleAlpha -= DELTA;
			if (MapPanel.this.transitionRectangleAlpha <= MIN_ALPHA) {
				MapPanel.this.transitionRectangleAlpha = MIN_ALPHA;
				MapPanel.this.fadeInTimer.stop();
			}
			MapPanel.this.repaint();

		});
		this.fadeOutTimer = new Timer(DURATION, null);
		this.fadeOutTimer.addActionListener((e) -> {
			MapPanel.this.transitionRectangleAlpha += DELTA;
			if (MapPanel.this.transitionRectangleAlpha >= MAX_ALPHA) {
				MapPanel.this.transitionRectangleAlpha = MAX_ALPHA;
				MapPanel.this.fadeOutTimer.stop();
			}
			MapPanel.this.repaint();

		});
	}

	/**
	 * Fades in the map image, note that this will break if fadeOut is called at
	 * the same time.
	 */
	public void fadeIn() {
		this.fadeInTimer.restart();
	}

	/**
	 * Fades out the map image, note that this will break if fadeIn is called at
	 * the same time.
	 */
	public void fadeOut() {
		this.fadeOutTimer.restart();
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(this.mapImage.getImage(), 0, 0, null);
		// Make a semi-transparent black color, BLACK is 0, 0, 0, the
		// transparency is the 4th argument.
		Color transitionRectangleColor = new Color(0, 0, 0, this.transitionRectangleAlpha);
		g.setColor(transitionRectangleColor);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
}
