package com.Melcer.cheekers.board;

public enum PieceType {
	NONE, RED, BLACK, RED_KING, BLACK_KING;
	
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
