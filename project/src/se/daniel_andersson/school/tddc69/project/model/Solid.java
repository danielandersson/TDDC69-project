/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Solid.
 */
public abstract class Solid implements GameObject {

	/**
	 * Instantiates a new solid.
	 */
	protected Solid() {
	}

	/* (non-Javadoc)
	 * @see se.daniel_andersson.school.tddc69.project.model.GameObject#collision(se.daniel_andersson.school.tddc69.project.model.player.Player)
	 */
	@Override
	public void collision(Player object) {
		object.takeDamage();
		System.out.println("Åker igenom solid");
	}
}
