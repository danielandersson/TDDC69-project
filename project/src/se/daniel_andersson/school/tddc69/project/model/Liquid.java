package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

public abstract class Liquid implements GameObject {

    protected Liquid() {
    }

    public void collision(Player p) {
        //Do nothing
        System.out.println("Åker igenom vätska");
    }
}
