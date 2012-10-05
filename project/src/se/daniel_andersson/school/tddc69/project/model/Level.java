package se.daniel_andersson.school.tddc69.project.model;


import se.daniel_andersson.school.tddc69.project.model.objects.*;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

public class Level {

    private int ID;

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getInnerTile() {
        return innerTile;
    }

    private final int screenHeight = 20;

    private int innerTile = 0;

    private int levelWidth;
    private int levelHeight;

    private final int tileWidth = 20;
    private final int tileHeight = 30;


    private int startX;

    public int getStartX() {
        return startX;
    }

    public int getStartY() {
        return startY;
    }

    private int startY;

    private int topIndex, bottomIndex;

    private GameObject[][] map;

    Properties configFile = new Properties();

    public Level(int ID){
        this.ID = ID;


        try {
            parseMeta();
            map = new GameObject[levelHeight][levelWidth];
            parseMap();
            bottomIndex = levelHeight-1;
            topIndex = levelHeight - screenHeight;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Couldnt found the level!");
            System.exit(0);
        }
    }

    public int getTileWidth() {
        return tileWidth;
    }

    public int getTileHeight() {
        return tileHeight;
    }


    public void collision(Player p) {
        int XMath = p.getXCoord()/tileWidth;
        int XMath2 = (p.getXCoord()+tileWidth-1)/tileWidth;
        int YMath = bottomIndex - (p.getYCoord())/tileHeight;
        int YMath2 = bottomIndex - (p.getYCoord()-tileHeight)/tileHeight;
        //TopLeft
        if (map[YMath][XMath] != null) {
            map[YMath][XMath].collision(p);
        }
        //TopRight
        else if (map[YMath][XMath2] != null) {
            map[YMath][XMath2].collision(p);
        }
        //LowerLeft
        else if (map[YMath2][XMath] != null) {
            map[YMath2][XMath].collision(p);
        }
        //LowerRight
        else if (map[YMath2][XMath2] != null) {
            map[YMath2][XMath2].collision(p);
        }
    }


    public boolean reachedEnd() {
        return topIndex <= 0;
    }

    public void updateLevelIndex(){
        if (innerTile >= tileHeight){
            innerTile = 0;
            if (topIndex > 0){
                topIndex--;
                bottomIndex--;
            }
        }
        else
            innerTile = innerTile +10;
    }


    public int getLevelWidth() {
        return levelWidth;
    }

    public int getLevelHeight() {
        return levelHeight;
    }

    public int getTopIndex() {
        return topIndex;
    }

    public int getBottomIndex() {
        return bottomIndex;
    }

    public GameObject [][] getMap(){
        return map;
    }

    private void parseMeta() throws IOException, FileNotFoundException {
        File file = new File("level/"+ID+".meta");
        System.out.println(file.getAbsolutePath());
        if (!file.exists()) {
            throw new IOException("Coundnt read "+ID+".meta");
        }
        configFile.load(new FileInputStream(file));
        System.out.println("Loaded meta info from file: "+file.getAbsolutePath());

        levelWidth = Integer.parseInt(configFile.getProperty("WIDTH"));
        levelHeight = Integer.parseInt(configFile.getProperty("HEIGHT"));

        startX = Integer.parseInt(configFile.getProperty("STARTX"));
        startY = Integer.parseInt(configFile.getProperty("STARTY"));

    }
    private void parseMap() throws FileNotFoundException {
        Scanner scan = new Scanner(new File("level/"+ID+".map"));
        for (int i = 0; i < levelHeight; i++) {
            for (int j = 0; j < levelWidth; j++) {
                String text = scan.next();
                if (text.equals("#"))
                    map[i][j] = new Stone();
                else if (text.equals("&"))
                    map[i][j] = new Oil();
                else if (text.equals("+"))
                    map[i][j] = new LevelPortal();
                else if (text.equals("S"))
                    map[i][j] = new FastBuff();
                else if (text.equals("G"))
                    map[i][j] = new GhostBuff();
            }
        }
        scan.close();
    }
}
