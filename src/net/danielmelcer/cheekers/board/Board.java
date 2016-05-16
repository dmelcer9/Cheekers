package net.danielmelcer.cheekers.board;

/**
 * 
 * The Board class represents a board that checkers is played on. This immutable class returns mutated
 * copies of itself when relavant methods are called. Since it is immutable, it is inherently thread-safe. Other classes can
 * manipulate copies of a Board, and the "official" board will be stored in a separate Controller class.
 * 
 * @author Daniel Melcer
 * @see Move 
 */
public class Board {
	
	private final PieceType[][] board;
	private final int sizex;
	private final int sizey;
	
	
	/**
	 * Construct a board with the desired Pieces.
	 * @param board This 2D array will be the extent of the board
	 */
	public Board(PieceType[][] board){
		if(board.length == 0 || board[0].length == 0) throw new IllegalArgumentException("Cannot construct empty board.");
		
		this.board = board;
		this.sizex = board[0].length;
		this.sizey = board.length;
	}
	
	/**
	 * Create a board from the specified String. N or n means None, r means Red, R is red king, b is black, and B is black king.
	 * @param s A String with the specified board.
	 * @return A board created from the String
	 */
	public static Board boardFromString(String s){
		String lines[] = s.split("\\r?\\n");
		
		int len = lines[0].length();
		
		PieceType[][] pieces = new PieceType[lines.length][len];
		
		for(int i = 0; i<lines.length; i++){
			String str = lines[i];
			for(int j = 0; i<str.length(); i++){
				switch(str.charAt(j)){
				case 'N': case 'n':
					pieces[i][j] = PieceType.NONE;
					break;
				case 'r':
					pieces[i][j] = PieceType.RED;
					break;
				case 'R':
					pieces[i][j] = PieceType.RED_KING;
					break;
				case 'b':
					pieces[i][j] = PieceType.BLACK;
					break;
				case 'B':
					pieces[i][j] = PieceType.BLACK_KING;
					break;
				default:
					pieces[i][j] = PieceType.NONE;
					break;
				}
			}
		}
		
		return new Board(pieces);
	}
	
	/**
	 * Returns if the contents of two boards are equal
	 * @param b The board to compare this board to
	 * @return If the two boards are equal
	 */
	public boolean contentsEqual(Board b){
		if((b.sizex != this.sizex)||(b.sizey!=this.sizey)) return false;
		
		for(int i = 0; i<sizey; i++){
			for(int j = 0; j<sizex; j++){
				if(this.board[i][j] != b.board[i][j]) return false;
			}
		}
		
		return true;
		
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
	 * Returns if it is possible to revert to a previous move. 
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
