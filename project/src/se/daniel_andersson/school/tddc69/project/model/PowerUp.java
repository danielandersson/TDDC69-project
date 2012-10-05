package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

public abstract class PowerUp implements GameObject {

    protected PowerUp() {
    }

    public void collision(Player p) {
        System.out.println("Tar en buff!");
    }

}
