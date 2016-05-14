package net.danielmelcer.cheekers.board;

/**
 * This class represents a single point of time in the history of the board.
 * It contains the location of every piece, along with the next move performed.
 * @author Daniel Melcer
 *
 */
public class BoardHistory {
	
	private PieceType[][] board;
	private Move move;
	
	/**
	 * Constructs a BoardHistory object with a board and a move
	 * @param board The state of the board
	 * @param move The move performed directly after
	 */
	public BoardHistory(PieceType[][] board, Move move){
		this.board = board;
		this.move = move;
	}
	
	/**
	 * Returns the move that was stored
	 * @return The move following the board's state
	 */
	public Move getMove(){
		return move;
	}
	
	/**
	 * Returns the state of the board
	 * @return An array representing the state of the board
	 */
	public PieceType[][] getBoard(){
		return board;
	}
}
