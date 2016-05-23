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
		
		assertArrayEquals(expected, row);
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
		PieceType[][] pt = {
				{PieceType.BLACK, PieceType.NONE},
				{PieceType.RED, PieceType.BLACK_KING}
		};
		
		Board b = new Board(pt);
		
		PieceType[][] actual = b.getBoard();
		
		assertArrayEquals(pt[0], actual[0]);
		assertArrayEquals(pt[1], actual[1]);
	}
	
	@Test
	public void testGetBoardRect(){
		PieceType[][] pt = {
				{PieceType.BLACK, PieceType.NONE, PieceType.RED, PieceType.BLACK_KING}
		};
		
		Board b = new Board(pt);
		
		PieceType[][] actual = b.getBoard();
		
		assertTrue(actual.length == 1);
		assertTrue(actual[0].length == 4);
		
		assertArrayEquals(pt[0], actual[0]);
		
	}

	@Test
	public void testGetPieceAtCoordinate() {
		PieceType[][] pt = {
				{PieceType.BLACK, PieceType.NONE},
				{PieceType.RED, PieceType.BLACK_KING}
		};
		
		Board b = new Board(pt);
		
		assertEquals(b.getPieceAtCoordinate(new Coordinate(0,0)),pt[0][0]);
		assertEquals(b.getPieceAtCoordinate(new Coordinate(1,0)),pt[0][1]);
		assertEquals(b.getPieceAtCoordinate(new Coordinate(0,1)),pt[1][0]);
		assertEquals(b.getPieceAtCoordinate(new Coordinate(1,1)),pt[1][1]);
	}
	
	@Test
	public void testRedWin() {
		Board b = Board.boardFromString("nNr\nRnn\nRrn");
		
		assertEquals(b.getWinState(), WinState.RED_WIN);
		
	}
	
	@Test
	public void testBlackWin() {
		Board b = Board.boardFromString("Bbn\nBnn\nNNb");
		
		assertEquals(b.getWinState(), WinState.BLACK_WIN);
	}
	
	
	@Test
	public void testNoWin() {
		
		Board b = Board.boardFromString("Bbn\nBrn\nNNb");
		
		assertEquals(b.getWinState(), WinState.NEITHER_WIN);
	}
	
	@Test
	public void testEmptyWin() {
		
		Board b = Board.boardFromString("nnn\nNNN\nnNn");
		
		assertEquals(b.getWinState(), WinState.EMPTY);
	}
	
	@Test
	public void testUndoMoveNotAvailableInit() {
		Board b = Board.boardFromString("br");
		
		assertFalse(b.undoMoveAvailable());
	}
	
	@Test
	public void testUndoMoveAvailable() {
		
		Board b = Board.boardFromString("nn\nBn");
		
		Move m = new Move(new Coordinate(0,1), new Coordinate(1,0));
		
		Board newBoard = b.makeMove(m);
		
		assertTrue(newBoard.undoMoveAvailable());
		
		assertFalse(newBoard.undoMove().undoMoveAvailable());
	}
	
	

}
