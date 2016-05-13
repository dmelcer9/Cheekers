package com.Melcer.cheekers.board;
import java.util.Iterator;

/**
 * A move object represents a single turn of the game. It is an immutable object and can hold a sequence of positions
 * (if needed for jumps)
 * @author Daniel Melcer
 *
 */
public class Move implements Iterable<Coordinate>{
	
	/**
	 * Constructs a Move with the selected coordinates. 
	 * @param coordinates A list of coordinates involved in the move, starting with the initial position.
	 */
	public Move(Coordinate... coordinates){
		//TODO: Implement
		
	}
	
	public Iterator<Coordinate> iterator(){
		//TODO: Implement
		return null;
	}
	
	public Coordinate getStartingPosition(){
		//TODO: Implement
		return null;
	}
	
	public Coordinate[] getMoves(){
		//TODO: Implement
		return null;
	}
	
}
