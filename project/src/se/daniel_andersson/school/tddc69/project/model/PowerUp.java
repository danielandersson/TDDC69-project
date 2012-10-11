/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class PowerUp.
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
