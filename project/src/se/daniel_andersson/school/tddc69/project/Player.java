package se.daniel_andersson.school.tddc69.project;


public class Player {

    private int XCoord;
    private int YCoord;

    public Player(int XCoord) {
        this.XCoord = XCoord;
        this.YCoord = 0;
    }

    public Player(int XCoord, int YCoord) {
        this.XCoord = XCoord;
        this.YCoord = YCoord;
    }


    public int getXCoord() {
        return XCoord;
    }
    public int getYCoord() {
        return YCoord;
    }
    public void moveRight() {
        XCoord++;
    }
    public void moveLeft() {
        XCoord--;
    }
    public void moveUp() {
        YCoord++;
    }
}
