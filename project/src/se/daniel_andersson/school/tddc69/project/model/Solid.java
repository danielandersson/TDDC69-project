package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.player.Player;

public abstract class Solid extends GameObject {


    public Solid() {
    }

    public void collision(Player object) {
        object.takeDamage();
        System.out.println("Åker igenom solid");
    }
}
