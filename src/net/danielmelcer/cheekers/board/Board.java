package net.danielmelcer.cheekers.board;

import java.util.Iterator;
import java.util.Stack;

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
	
	private final Stack<PieceType[][]> prevBoards;
	
	
	/**
	 * Construct a board with the desired Pieces.
	 * @param board This 2D array will be the extent of the board
	 */
	public Board(PieceType[][] board){
		this(board, new Stack<>());
	}
	
	private Board(PieceType[][] board, Stack<PieceType[][]> prevBoards){

		if(board.length == 0 || board[0].length == 0) throw new IllegalArgumentException("Cannot construct empty board.");
		
		this.board = board;
		this.sizex = board[0].length;
		this.sizey = board.length;
		
		this.prevBoards = prevBoards;
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
			
			for(int j = 0; j<str.length(); j++){
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
		return Board.boardFromString("bnbnbnbn\nnbnbnbnb\nbnbnbnbn\nnnnnnnnn\nnnnnnnnn\nnrnrnrnr\nrnrnrnrn\nnrnrnrnr");
	}
	
	/**
	 * Check if a move is legal in the context of this board
	 * @param move The move to check if legal
	 * @param sp TODO
	 * @return A boolean value indicating if a given move is legal
	 */
	public boolean isLegal(Move move, SelectingPlayer sp){
		Iterator<Coordinate> m = move.iterator();
		
		if(move.getLength() <2) return false;
		Coordinate starting = m.next();
		PieceType piece = this.getPieceAtCoordinate(starting);
		
		if(piece == PieceType.NONE) return false;
		
		
		switch(sp){
		case RED:
			if(piece==PieceType.BLACK_KING||piece==PieceType.BLACK) return false;
			break;
		case BLACK:
			if(piece==PieceType.RED||piece==PieceType.RED_KING) return false;
			break;
		}
		
		
		boolean[][] jumpedPieces = new boolean[board.length][board[0].length];
		
		boolean isFirstMove = true;
		boolean firstMoveIsJump = false;
		
		while(m.hasNext()){
			Coordinate nextMove = m.next();
			
			//Check if move is in bounds
			if(nextMove.getX()<0 || nextMove.getY()<0) return false;
			if(nextMove.getX()>=board[0].length || nextMove.getY()>= board.length) return false;
			
			//No multi moves if there wasn't a jump
			if(!isFirstMove && !firstMoveIsJump) return false; //If is second move, check if both moves are a jump
			
			//Check if move is backwards && not king
			boolean goingUp = false;
			if(starting.getY() > nextMove.getY()) goingUp = true;
			
			if(goingUp && piece == PieceType.BLACK) return false;
			if(!goingUp && piece == PieceType.RED) return false;
			
			boolean isDiagnol = ((Math.abs(nextMove.getX()-starting.getX()))==(Math.abs(nextMove.getY()-starting.getY())));
			boolean staysInPlace = (Math.abs(nextMove.getX()-starting.getX())==0);//Check if orthogonal move
			
			if(!isDiagnol || staysInPlace) return false;
			
			boolean isJump = ((Math.abs(nextMove.getX()-starting.getX())==2)&&(Math.abs(nextMove.getY()-starting.getY())==2));
			
			if(isJump && !isFirstMove && firstMoveIsJump) return false;
			
			if(isJump && isFirstMove) firstMoveIsJump = true;
			
			if(this.getPieceAtCoordinate(nextMove) != PieceType.NONE) return false; //Check if landing on piece
			
			if(isJump){
				int jumpx = (nextMove.getX() + starting.getX())/2;
				int jumpy = (nextMove.getY() + starting.getY())/2;
				
				if(jumpedPieces[jumpy][jumpx]) return false;
				
				jumpedPieces[jumpy][jumpx] = true;
				
				//Check if jumping own piece
				PieceType jumpedPiece = getPieceAtCoordinate(new Coordinate(jumpx, jumpy));
				
				if((piece == PieceType.BLACK)||(piece == PieceType.BLACK_KING)){
					if((jumpedPiece == PieceType.BLACK)||(jumpedPiece == PieceType.BLACK_KING)){
						return false;
					}
				}
				
				if((piece == PieceType.RED)||(piece == PieceType.RED_KING)){
					if((jumpedPiece == PieceType.RED)||(jumpedPiece == PieceType.RED_KING)){
						return false;
					}
				}
			}
			
			starting = nextMove;
			
		}
		return true;
	}
	
	/**
	 * Returns a board with the move
	 * @param move The move to check if legal
	 * @param player TODO
	 * @return A modified board where the move has been performed
	 */
	public Board makeMove(Move move, SelectingPlayer player){
		if(!isLegal(move, player)){
			throw new IllegalArgumentException("Move is not legal");
		}
		
		Iterator<Coordinate> it = move.iterator();
		
		PieceType[][] newBoard = this.getBoard();
		
		Coordinate InitCoord = it.next();
		
		
		int pieceX = InitCoord.getX();
		int pieceY = InitCoord.getY();
		
		while(it.hasNext()){
			Coordinate c = it.next();
			
			int newX = c.getX();
			int newY = c.getY();
			
			if(Math.abs(newX-pieceX)==2 && Math.abs(newY-pieceY) == 2){
				newBoard[(newY+pieceY)/2][(newX+pieceX)/2] = PieceType.NONE;
			}
			
			newBoard[newY][newX] = newBoard[pieceY][pieceX];
			
			newBoard[pieceY][pieceX] = PieceType.NONE;
			
			pieceX = newX;
			pieceY = newY;
			
			if(atKingEdge(new Coordinate(pieceX, pieceY), newBoard)){
				newBoard[pieceY][pieceX] = newBoard[pieceY][pieceX].KingPiece();
			}
		}
		
		Stack<PieceType[][]> newStack = (Stack<PieceType[][]>) this.prevBoards.clone();
		
		newStack.push(this.getBoard());
		
		return new Board(newBoard, newStack);
	}
	
	private static boolean atKingEdge(Coordinate c, PieceType[][] board){
		PieceType p = board[c.getY()][c.getX()];
		
		switch(p){
		case RED:
			if(c.getY()==0) return true;
			break;
		case BLACK:
			if(c.getY() == (board.length-1)) return true;
			break;
		default:
			return false;
		}
		
		return false;
	}
	
	/**
	 * Returns a board with the state of the previous move. 
	 * @return The previous state of the board
	 */
	public Board undoMove(){
		if(!undoMoveAvailable()) throw new IllegalStateException("Cannot undo move");
		
		Stack<PieceType[][]> st = (Stack<PieceType[][]>) this.prevBoards.clone();
		
		Board b = new Board(st.pop(), st);
		
		return b;
		
		
	}
	
	/**
	 * Returns if it is possible to revert to a previous move. 
	 * @return If a previous board state is available
	 */
	public boolean undoMoveAvailable(){
		return !prevBoards.isEmpty();
	}
	
	/**
	 * Returns a copy of the current state of the board
	 * @return A copy of the board
	 */
	public PieceType[][] getBoard(){
		PieceType[][] newBoard = new PieceType[board.length][board[0].length];
		
		for(int i = 0; i<newBoard.length; i++){
			for(int j = 0; j<newBoard[0].length; j++){
				newBoard[i][j] = board[i][j];
			}
		}
		
		return newBoard;
	}
	
	/**
	 * Gets the piece associated with a coordinate
	 * @param c The coordinate to search
	 * @return The piece at the coordinate
	 */
	public PieceType getPieceAtCoordinate(Coordinate c){
		if(c.getX()>=this.sizex || c.getY() >= this.sizey) throw new IllegalArgumentException("Coordinate is out of range.");
		
		if(c.getX()<0||c.getY()<0) throw new IllegalArgumentException("Coordinate cannot be negative");
		
		return board[c.getY()][c.getX()];
	}
	
	/**
	 * Tests if a given color has won the game
	 * @return The win state of the game
	 */
	public WinState getWinState(){
		boolean hasBlack = false;
		boolean hasRed = false;
		
		for(PieceType[] row : this.board){
			for(PieceType pt : row){
				switch(pt){
				case BLACK: case BLACK_KING:
					hasBlack = true;
					break;
				case RED: case RED_KING:
					hasRed = true;
					break;
				default:
					//Do nothing
					break;
				}
			}
		}
		
		if(!hasBlack && !hasRed){
			return WinState.EMPTY;
		}
		else if(hasBlack&&!hasRed){
			return WinState.BLACK_WIN;
		}
		else if(!hasBlack && hasRed){
			return WinState.RED_WIN;
		}
		else{
			return WinState.NEITHER_WIN;
		}
	}
	
}
