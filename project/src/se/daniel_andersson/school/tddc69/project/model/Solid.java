package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

public abstract class Solid implements GameObject {

    protected Solid() {
    }

    public void collision(Player p) {
        p.takeDamage();
        System.out.println("Åker igenom solid");
    }
}
