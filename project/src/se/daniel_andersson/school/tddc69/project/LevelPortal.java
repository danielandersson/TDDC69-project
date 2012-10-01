package se.daniel_andersson.school.tddc69.project;


import java.awt.*;

public class LevelPortal extends GameObject {

    public LevelPortal() {

    }

    @Override
    public void collision(Player p) {
        p.setLevelAdvance(true);
    }

    @Override
    public Color paintColor() {
        return Color.CYAN;
    }
}
