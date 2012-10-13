/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import se.daniel_andersson.school.tddc69.project.model.objects.*;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

// TODO: Auto-generated Javadoc
/**
 * The Class Level.
 */
public class Level {

	/** The id. */
	private final int levelID;
	
	/** The screen height. */
	private static final int SCREEN_HEIGHT = 20;
	
	/** The inner tile. */
	private int innerTile = 0;
	
	/** The level width. */
	private int levelWidth;
	
	/** The level height. */
	private int levelHeight;
	
	/** The tile width. */
	private static final int TILE_WIDTH = 20;
	
	/** The tile height. */
	private static final int TILE_HEIGHT = 30;
	
	/** The start x. */
	private int startX;
	
	/** The start y. */
	private int startY;
	
	/** The bottom index. */
	private int topIndex, bottomIndex;

	/** The next level. */
	private int nextLevel;
	
	/** The bg color. */
	private String bgColor;
	
	/** The map. */
	private GameObject[][] map;
	
	/** The config file. */
    private final Properties configFile = new Properties();

	/**
	 * Instantiates a new level.
	 *
	 * @param levelID the id
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


    public void reset(){
        bottomIndex = levelHeight - 1;
        topIndex = levelHeight - SCREEN_HEIGHT;
    }

	/**
	 * Collision.
	 *
	 * @param p the p
	 */
	public void collision(Player p) {
		int xMath = p.getxCoord() / TILE_WIDTH;
		int xMath2 = (p.getxCoord() + TILE_WIDTH - 1) / TILE_WIDTH;
		int yMath = bottomIndex - (p.getyCoord()) / TILE_HEIGHT;
		int yMath2 = bottomIndex - (p.getyCoord() - TILE_HEIGHT) / TILE_HEIGHT;
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
	 * Gets the bg color.
	 *
	 * @return the bg color
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
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getLevelID() {
		return levelID;
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
	 * Gets the start x.
	 *
	 * @return the start x
	 */
	public int getStartX() {
		return startX;
	}

	/**
	 * Gets the start y.
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
	 * Parses the meta.
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
