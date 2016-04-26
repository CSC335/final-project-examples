package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.file.Paths;

import javax.swing.JButton;
import javax.swing.JFrame;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * A basic and ugly frame. Note that we create an empty and useless looking
 * JFXPanel. This JFXPanel is used for JavaFX's MediaPlayer, we need to do a bit
 * of setup to get this to work.
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class GameFrame extends JFrame {

	private static final long serialVersionUID = 60857474180341454L;

	// The media player expects a String in the form of a URL, so we use Paths
	// here to convert to a URL.
	private static final String SONG_ONE = Paths.get("songs/GoldenRodCity.mp3").toUri().toString();
	private static final String SONG_TWO = Paths.get("songs/FinalExamAnswers.mp3").toUri().toString();
	private static final String FADE_OUT = "Fade out";
	private static final String FADE_IN = "Fade in";
	private MapPanel mapPanel;
	private JButton fadeButton;
	private JButton changeMusicButton;
	private boolean isFadeOut;
	private JFXPanel fxPanel;
	private MediaPlayer mediaPlayer;
	private boolean isPlayingSongOne;

	/**
	 * Constructs the Frame.
	 */
	public GameFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("Animations and music demo");
		this.mapPanel = new MapPanel();
		this.setSize(815, 530);
		this.mapPanel.setPreferredSize(new Dimension(500, 500));
		this.fadeButton = new JButton(FADE_OUT);
		this.isFadeOut = true;
		this.fadeButton.addActionListener((e) -> {
			if (GameFrame.this.isFadeOut) {
				GameFrame.this.fadeButton.setText(FADE_IN);
				GameFrame.this.mapPanel.fadeOut();
				GameFrame.this.isFadeOut = false;
			} else {
				GameFrame.this.fadeButton.setText(FADE_OUT);
				GameFrame.this.mapPanel.fadeIn();
				GameFrame.this.isFadeOut = true;
			}
		});
		this.fadeButton.setPreferredSize(new Dimension(150, 100));
		this.changeMusicButton = new JButton("Change music");
		this.changeMusicButton.addActionListener((e) -> {
			Platform.runLater(() -> {
				if (GameFrame.this.isPlayingSongOne) {
					GameFrame.this.playSong(SONG_TWO);
				} else {
					GameFrame.this.playSong(SONG_ONE);
				}
				GameFrame.this.isPlayingSongOne = !GameFrame.this.isPlayingSongOne;
			});
		});
		this.changeMusicButton.setPreferredSize(new Dimension(150, 100));
		this.fxPanel = new JFXPanel();
		// JavaFX runs on a different thread, to make sure it works correctly we
		// need to do this.
		Platform.runLater(() -> {
			fxPanel.setScene(new Scene(new Group()));
			// Initial media player
			GameFrame.this.playSong(SONG_ONE);
			GameFrame.this.isPlayingSongOne = true;
		});
		this.add(this.mapPanel, BorderLayout.CENTER);
		this.add(this.fadeButton, BorderLayout.EAST);
		this.add(this.changeMusicButton, BorderLayout.WEST);
	}

	private void playSong(String location) {
		if (this.mediaPlayer != null) {
			this.mediaPlayer.stop();
			this.mediaPlayer.dispose();
		}
		Media song = new Media(location);
		this.mediaPlayer = new MediaPlayer(song);
		// The song will repeat forever
		this.mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
		this.mediaPlayer.play();
	}

}
