package se.daniel_andersson.school.tddc69.project;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Timer;

import se.daniel_andersson.school.tddc69.project.controller.Game;
import se.daniel_andersson.school.tddc69.project.view.GameFrame;


/**
 * This class is an old version of the game. Now it is just for showof the MVC structure.
 */
public class TestGame {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		final Game mainGame = new Game();
		final GameFrame gameFrame = new GameFrame(mainGame);
		gameFrame.setVisible(true);

		final Timer clockTimer;
		@SuppressWarnings("serial")
		final Action doOneStep = new AbstractAction() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (!mainGame.gameOver())
					mainGame.gameTick();
				gameFrame.repaint();
			}
		};
		clockTimer = new Timer(100, doOneStep);
		clockTimer.setCoalesce(true);
		clockTimer.start();
	}

	/**
	 * Instantiates a new test game.
	 */
	private TestGame() {
	}
}
