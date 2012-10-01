package se.daniel_andersson.school.tddc69.project;


public abstract class Liquid extends GameObject {

    public Liquid() {

    }

    public void collision(Player p) {
        //Do nothing
        System.out.println("Åker igenom vätska");
    }
}
