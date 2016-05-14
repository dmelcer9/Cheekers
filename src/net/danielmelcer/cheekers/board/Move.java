package net.danielmelcer.cheekers.board;
import java.util.Iterator;

/**
 * A move object represents a single turn of the game. It is an immutable object and can hold a sequence of positions
 * (if needed for jumps)
 * @author Daniel Melcer
 * 
 * @see Coordinate
 */
public class Move implements Iterable<Coordinate>{
	
	/**
	 * Constructs a Move with the selected coordinates. 
	 * @param coordinates A list of coordinates involved in the move, starting with the initial position.
	 */
	public Move(Coordinate... coordinates){
		//TODO: Implement
		
	}
	
	/**
	 * Returns an iterator which iterates through the coordinates contained within the move
	 * @return An iterator containing a list of coordinates
	 */
	public Iterator<Coordinate> iterator(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Get the starting coordinate of the move
	 * @return The initial coordinate represented by the move
	 */
	public Coordinate getStartingPosition(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Returns an array of the Coordinates represented by the move
	 * @return The coordinates in the move
	 */
	public Coordinate[] getMoves(){
		//TODO: Implement
		return null;
	}
	
}
