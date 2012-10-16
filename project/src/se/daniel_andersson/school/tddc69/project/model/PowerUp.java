package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

/**
 * An general class for non-collision items that should help the player. All power ups should be a subclass of this.
 */
public abstract class PowerUp implements GameObject {

	/**
	 * Instantiates a new power up.
	 */
	protected PowerUp() {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player object) {
		System.out.println("Tar en buff!");
	}

}
