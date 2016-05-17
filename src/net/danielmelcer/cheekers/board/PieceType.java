package net.danielmelcer.cheekers.board;

/**
 * This enum represents an individual space on the game board.
 * @author Daniel Melcer
 * @see Board
 */
public enum PieceType {
	
	/**
	 * An empty square on the board
	 */
	NONE, 
	
	/**
	 * An unkinged red piece
	 */
	RED, 
	
	/**
	 * An unkinged black piece
	 */
	BLACK, 
	
	/**
	 * A kinged red piece
	 */
	RED_KING, 
	
	/**
	 * A kinged black piece
	 */
	BLACK_KING;
	
	/**
	 * Gives the kinged version of a given piece, or the same piece if it is already kinged. NONE becomes a NONE.
	 * @return The kinged version of a piece
	 */
	public PieceType KingPiece(){
		switch(this){
		case RED:
			return RED_KING;			
		case BLACK:
			return BLACK_KING;			
		default:
			return this;			
		}
	}
}
