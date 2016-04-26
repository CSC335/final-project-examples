package controller;

import javax.swing.SwingUtilities;

import view.GameFrame;

/**
 * Runs the GUI
 * 
 * @author Jeremy Mowery (jermowery@email.arizona.edu)
 *
 */
public class Runner {
	@SuppressWarnings("javadoc")
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			new GameFrame().setVisible(true);
		});
	}
}
