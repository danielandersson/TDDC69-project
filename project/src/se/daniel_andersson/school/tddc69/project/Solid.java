package se.daniel_andersson.school.tddc69.project;


public abstract class Solid extends GameObject {

    private int XCoord, YCoord;

    public Solid() {

    }

    public Solid(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
    }

    public void collision() {
       //player.die();
    }



    public int getXCoord() {
        return XCoord;
    }
    public int getYCoord() {
        return YCoord;
    }

}
