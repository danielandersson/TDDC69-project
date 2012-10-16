package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.objects.*;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

/**
 * The Class Level.
 */
public class Level {
	private final int levelID;
	private static final int SCREEN_HEIGHT = 20;
	private int innerTile = 0;
	private int levelWidth;
	private int levelHeight;
	private static final int TILE_WIDTH = 20;
	private static final int TILE_HEIGHT = 30;
	private int startX; // Player start X tile
	private int startY; // Player start Y tile
	private int topIndex, bottomIndex; // The scrolling offsets
	private int nextLevel;
	private String bgColor;
	private GameObject[][] map;
    private final Properties configFile = new Properties();

	/**
	 * Instantiates a new level.
	 *
	 * @param levelID the id of the level
	 */
	public Level(int levelID) {
		this.levelID = levelID;

		try {
			parseMeta();
			map = new GameObject[levelHeight][levelWidth];
			parseMap();
			bottomIndex = levelHeight - 1;
			topIndex = levelHeight - SCREEN_HEIGHT;
		} catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Couldnt found the level!");
            System.exit(0);
        } catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldnt found the level!");
			System.exit(0);
		}
	}

    /**
     * Resets the current level
     *
     */
    public void reset(){
        bottomIndex = levelHeight - 1;
        topIndex = levelHeight - SCREEN_HEIGHT;
    }

	/**
	 * Checks collision with the player
	 *
	 * @param p the player
	 */
	public void collision(Player p) {
		int xMath = p.getxCoord() / TILE_WIDTH; // Top Left corner in the tile.
		int xMath2 = (p.getxCoord() + TILE_WIDTH - 1) / TILE_WIDTH; // Top right corner in the tile.
		int yMath = bottomIndex - (p.getyCoord()) / TILE_HEIGHT; // Bottom Left corner in the tile.
		int yMath2 = bottomIndex - (p.getyCoord() - TILE_HEIGHT) / TILE_HEIGHT; // Bottom right corner in the tile.
		// TopLeft
		if (map[yMath][xMath] != null) {
			map[yMath][xMath].collision(p);
		}
		// TopRight
		else if (map[yMath][xMath2] != null) {
			map[yMath][xMath2].collision(p);
		}
		// LowerLeft
		else if (map[yMath2][xMath] != null) {
			map[yMath2][xMath].collision(p);
		}
		// LowerRight
		else if (map[yMath2][xMath2] != null) {
			map[yMath2][xMath2].collision(p);
		}
	}

	/**
	 * Gets the background color.
	 *
	 * @return the background color
	 */
	public String getBgColor() {
		return bgColor;
	}

	/**
	 * Gets the bottom index.
	 *
	 * @return the bottom index
	 */
	public int getBottomIndex() {
		return bottomIndex;
	}

	/**
	 * Gets the inner tile.
	 *
	 * @return the inner tile
	 */
	public int getInnerTile() {
		return innerTile;
	}

	/**
	 * Gets the level height.
	 *
	 * @return the level height
	 */
	public int getLevelHeight() {
		return levelHeight;
	}

	/**
	 * Gets the level width.
	 *
	 * @return the level width
	 */
	public int getLevelWidth() {
		return levelWidth;
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public GameObject[][] getMap() {
		return map;
	}

	/**
	 * Gets the next level.
	 *
	 * @return the next level
	 */
	public int getNextLevel() {
		return nextLevel;
	}

	/**
	 * Gets the screen height.
	 *
	 * @return the screen height
	 */
	public int getScreenHeight() {
		return SCREEN_HEIGHT;
	}

	/**
	 * Gets the player start x tile.
	 *
	 * @return the start x
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * Gets the player start y tile.
	 *
	 * @return the start y
	 */
	public int getStartY() {
		return startY;
	}

	/**
	 * Gets the tile height.
	 *
	 * @return the tile height
	 */
	public int getTileHeight() {
		return TILE_HEIGHT;
	}

	/**
	 * Gets the tile width.
	 *
	 * @return the tile width
	 */
	public int getTileWidth() {
		return TILE_WIDTH;
	}

	/**
	 * Gets the top index.
	 *
	 * @return the top index
	 */
	public int getTopIndex() {
		return topIndex;
	}

	/**
	 * Parses the meta information for the map.
	 *
	 * @throws IOException Signals that an I/O exception has occurred.
	 * @throws FileNotFoundException the file not found exception
	 */
	private void parseMeta() throws IOException, FileNotFoundException {
        // ResourceHandler checks if the file exists.
        configFile.load(new FileInputStream(ResourceHandler.getLevelFile(levelID
                + ".meta")));

        levelWidth = Integer.parseInt(configFile.getProperty("WIDTH"));
		levelHeight = Integer.parseInt(configFile.getProperty("HEIGHT"));

		startX = Integer.parseInt(configFile.getProperty("STARTX"));
		startY = Integer.parseInt(configFile.getProperty("STARTY"));
		bgColor = configFile.getProperty("BG");
		if (configFile.getProperty("NEXT").equals("END"))
			nextLevel = 0;
		else
			nextLevel = Integer.parseInt(configFile.getProperty("NEXT"));
	}

    // TODO: Fix the IF statement
    /**
     * Parses the map.
     *
     * @throws FileNotFoundException the file not found exception
     */
    private void parseMap() throws FileNotFoundException {
        Scanner scan = new Scanner(ResourceHandler.getLevelFile(levelID + ".map"));
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
                else if (text.equals("T"))
                    map[i][j] = new Tree();
            }
        }
        scan.close();
    }

	/**
	 * Reached end.
	 *
	 * @return true, if successful
	 */
	public boolean reachedEnd() {
		return topIndex <= 0;
	}

	/**
	 * Update level index.
	 */
	public void updateLevelIndex() {
		if (innerTile >= TILE_HEIGHT) {
			innerTile = 0;
			if (topIndex > 0) {
				topIndex--;
				bottomIndex--;
			}
		} else
			innerTile = innerTile + 10;
	}
}
