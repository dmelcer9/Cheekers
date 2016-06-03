package net.danielmelcer.cheekers.board;
import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * A move object represents a single turn of the game. It is an immutable object and can hold a sequence of positions
 * (if needed for jumps)
 * @author Daniel Melcer
 * 
 * @see Coordinate
 */
public class Move implements Iterable<Coordinate>, java.io.Serializable{
	
	
	private Coordinate[] coordinates;
	/**
	 * Constructs a Move with the selected coordinates. 
	 * @param coordinates A list of coordinates involved in the move, starting with the initial position.
	 */
	public Move(Coordinate... coordinates){
		//if(coordinates.length < 2) throw new IllegalArgumentException("Moves must have a length of greater than two");
		
		this.coordinates = coordinates;	
	}
	
	/**
	 * Returns the length of the move
	 * @return The number of coordinates
	 */
	public int getLength(){
		return coordinates.length;
	}
	
	/**
	 * Returns an iterator which iterates through the coordinates contained within the move
	 * @return An iterator containing a list of coordinates
	 */
	public Iterator<Coordinate> iterator(){		
		return new MoveIterator(coordinates);
	}
	
	private static class MoveIterator implements Iterator<Coordinate>{

		private Coordinate[] c;
		
		int next = 0;
		
		public MoveIterator(Coordinate[] c){
			this.c = c;
		}
		
		@Override
		public boolean hasNext() {
			return (next < c.length);
		}

		@Override
		public Coordinate next() {
			if(!hasNext()) throw new NoSuchElementException("Reached end of iterator");
			return c[next++];
		}
		
	}
	
	/**
	 * Get the starting coordinate of the move
	 * @return The initial coordinate represented by the move
	 */
	public Coordinate getStartingPosition(){
		return coordinates[0];
	}
	
	/**
	 * Returns an array of the Coordinates represented by the move
	 * @return The coordinates in the move
	 */
	public Coordinate[] getMoves(){
		return Arrays.copyOf(coordinates, coordinates.length);
	}
	
}
