package se.daniel_andersson.school.tddc69.project;


public abstract class Solid extends GameObject {


    public Solid() {
    }

    public void collision(Player p) {
       p.die();
        System.out.println("Åker igenom solid");
    }
}
