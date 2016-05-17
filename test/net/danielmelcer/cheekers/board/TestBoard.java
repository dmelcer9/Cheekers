package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {


	@Test(expected=IllegalArgumentException.class)
	public void testEmptyBoard() {
		PieceType[][] b = {};
		new Board(b);
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testEmptyRow() {
		PieceType[][] b = {{},{}};
		new Board(b);
	}
	
	@Test
	public void testNormalBoard(){
		PieceType[][] b = {{PieceType.BLACK}};
		new Board(b);
	}

	
	@Test
	public void testBoardFromString(){
		Board b = Board.boardFromString("nNbBrR");
		
		PieceType[][] pieces = b.getBoard();
		
		assertTrue(pieces.length==1);
		
		PieceType[] row = pieces[0];
		
		assertTrue(row.length == 6);
		
		PieceType[] expected = {PieceType.NONE, PieceType.NONE, PieceType.BLACK, PieceType.BLACK_KING, PieceType.RED, PieceType.RED_KING};
		
		assertArrayEquals(row, expected);
	}
	
	@Test
	public void testContentsEqual(){
		Board b = Board.boardFromString("nn\nBn");
		Board b2 = Board.boardFromString("nn\nBn");
		
		assertTrue(b.contentsEqual(b2));
	}
	
	@Test
	public void testContentsNotEqual(){
		Board b = Board.boardFromString("nn\nBn");
		Board b2 = Board.boardFromString("nn\nBB");
		
		assertFalse(b.contentsEqual(b2));
	}
	
	@Test
	public void testMakeMove() {
		Board b = Board.boardFromString("nn\nBn");
		
		Coordinate c1 = new Coordinate(0,1);
		Coordinate c2 = new Coordinate(1,0);
		
		Move m = new Move(c1,c2);
		
		b = b.makeMove(m);
		
		Board expected = Board.boardFromString("nB\nnn");
		
		assertTrue(b.contentsEqual(expected));
	
	}

	@Test
	public void testUndoMove() {
		Board b = Board.boardFromString("nn\nBn");
		
		Move m = new Move(new Coordinate(0,1), new Coordinate(1,0));
		
		Board newBoard = b.makeMove(m);
		
		assertFalse(b.contentsEqual(newBoard));
		
		assertTrue(newBoard.undoMove().contentsEqual(b));
		
	}

	@Test
	public void testGetBoard() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPieceAtCoordinate() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testRedWin() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBlackWin() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testNoWin() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUndoMoveNotAvailableInit() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testUndoMoveAvailable() {
		fail("Not yet implemented");
	}
	
	

}
