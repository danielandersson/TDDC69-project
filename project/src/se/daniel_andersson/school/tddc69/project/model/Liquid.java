/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Liquid.
 */
public abstract class Liquid implements GameObject {

	/**
	 * Instantiates a new liquid.
	 */
	protected Liquid() {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player p) {
		// Do nothing
		System.out.println("Åker igenom vätska");
	}
}
