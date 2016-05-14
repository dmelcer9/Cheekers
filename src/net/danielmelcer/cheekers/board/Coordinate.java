package net.danielmelcer.cheekers.board;


/**
 * 
 * This class represents a 2D Coordinate on a game board. Coordinates are integer variables.
 * 
 * @author Daniel Melcer
 *
 */
public class Coordinate {
	
	private int x;
	private int y;
	
	/**
	 * Construct a new Coordinate with a specific position
	 * 
	 * @param x The x position of the coordinate
	 * @param y The y position of the coordinate
	 */
	public Coordinate(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	/**
	 * Get the x position
	 * 
	 * @return The x position of the coordinate
	 */
	public int getX(){
		return x;
	}
	
	/**
	 * Get the y position
	 * 
	 * @return The y position of the coordinate
	 */
	public int getY(){
		return y;
	}
}
