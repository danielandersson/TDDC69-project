package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.player.Player;

/**
 * An general class for non-collision items that should affect the player. All liquids should be a subclass of this.
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
	public void collision(Player object) {
		System.out.println("Åker igenom vätska");
	}
}
