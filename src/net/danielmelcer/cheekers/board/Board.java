package net.danielmelcer.cheekers.board;

/**
 * 
 * The Board class represents a board that checkers is played on. This immutable class returns mutated
 * copies of itself when relavant methods are called. Since it is immutable, it is inherently thread-safe. Other classes can
 * manipulate copies of a Board, and the "official" board will be stored in a separate Controller class.
 * 
 * @author Daniel Melcer
 *
 */
public class Board {
	
	/**
	 * Construct a board with the desired Pieces.
	 * @param board This 2D array will be the extent of the board
	 */
	public Board(PieceType[][] board){
		//TODO: Implement
	}
	
	/**
	 * Create a default board for checkers
	 * @return A board with the standard starting position of checkers
	 */
	public static Board getDefaultBoard(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Check if a move is legal in the context of this board
	 * @return A boolean value indicating if a given move is legal
	 */
	public boolean isLegal(){
		//TODO: Implement
		return false;
	}
	
	/**
	 * Returns a board with the move
	 * @return A modified board where the move has been performed
	 */
	public Board makeMove(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Returns a board with the state of the previous move. The previous 5 BoardHistories are stored in strong references,
	 * while moves prior to that are stored in SoftReferences
	 * @return The previous state of the board
	 */
	public Board undoMove(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Returns if it is possible to revert to a previous move. Note that if the JVM runs low on memory, previous moves
	 * start to get deleted
	 * @return If a previous board state is available
	 */
	public boolean undoMoveAvailable(){
		//TODO: Implement
		return false;
	}
	
	/**
	 * Returns a copy of the current state of the board
	 * @return A copy of the board
	 */
	public PieceType[][] getBoard(){
		//TODO: Implement
		return null;
	}
	
	/**
	 * Gets the piece associated with a coordinate
	 * @param c The coordinate to search
	 * @return The piece at the coordinate
	 */
	public PieceType getPieceAtCoordinate(Coordinate c){
		//TODO: Implement
		return null;
	}
	
}
