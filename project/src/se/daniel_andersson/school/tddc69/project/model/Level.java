/*
 * 
 */
package se.daniel_andersson.school.tddc69.project.model;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;

import se.daniel_andersson.school.tddc69.project.model.objects.FastBuff;
import se.daniel_andersson.school.tddc69.project.model.objects.GhostBuff;
import se.daniel_andersson.school.tddc69.project.model.objects.LevelPortal;
import se.daniel_andersson.school.tddc69.project.model.objects.Oil;
import se.daniel_andersson.school.tddc69.project.model.objects.Stone;
import se.daniel_andersson.school.tddc69.project.model.objects.Tree;
import se.daniel_andersson.school.tddc69.project.model.player.Player;

// TODO: Auto-generated Javadoc
/**
 * The Class Level.
 */
public class Level {

	/** The id. */
	private int ID;
	
	/** The screen height. */
	private final int screenHeight = 20;
	
	/** The inner tile. */
	private int innerTile = 0;
	
	/** The level width. */
	private int levelWidth;
	
	/** The level height. */
	private int levelHeight;
	
	/** The tile width. */
	private final int tileWidth = 20;
	
	/** The tile height. */
	private final int tileHeight = 30;
	
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
	Properties configFile = new Properties();

	/**
	 * Instantiates a new level.
	 *
	 * @param ID the id
	 */
	public Level(int ID) {
		this.ID = ID;

		try {
			parseMeta();
			map = new GameObject[levelHeight][levelWidth];
			parseMap();
			bottomIndex = levelHeight - 1;
			topIndex = levelHeight - screenHeight;
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Couldnt found the level!");
			System.exit(0);
		}
	}

	/**
	 * Collision.
	 *
	 * @param p the p
	 */
	public void collision(Player p) {
		int XMath = p.getXCoord() / tileWidth;
		int XMath2 = (p.getXCoord() + tileWidth - 1) / tileWidth;
		int YMath = bottomIndex - (p.getYCoord()) / tileHeight;
		int YMath2 = bottomIndex - (p.getYCoord() - tileHeight) / tileHeight;
		// TopLeft
		if (map[YMath][XMath] != null) {
			map[YMath][XMath].collision(p);
		}
		// TopRight
		else if (map[YMath][XMath2] != null) {
			map[YMath][XMath2].collision(p);
		}
		// LowerLeft
		else if (map[YMath2][XMath] != null) {
			map[YMath2][XMath].collision(p);
		}
		// LowerRight
		else if (map[YMath2][XMath2] != null) {
			map[YMath2][XMath2].collision(p);
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
	public int getID() {
		return ID;
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
		return screenHeight;
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
		return tileHeight;
	}

	/**
	 * Gets the tile width.
	 *
	 * @return the tile width
	 */
	public int getTileWidth() {
		return tileWidth;
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
		Scanner scan = new Scanner(ResourceHandler.getLevelFile(ID + ".map"));
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
		configFile.load(new FileInputStream(ResourceHandler.getLevelFile(ID
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
		if (innerTile >= tileHeight) {
			innerTile = 0;
			if (topIndex > 0) {
				topIndex--;
				bottomIndex--;
			}
		} else
			innerTile = innerTile + 10;
	}
}
