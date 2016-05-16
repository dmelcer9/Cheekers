package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoard {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

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
	public void testMakeMove() {
		Board b = Board.boardFromString("nn\nBn");
		
		Coordinate c1 = new Coordinate(0,1);
		Coordinate c2 = new Coordinate(1,0);
		
		Move m = new Move(c1,c2);
		
		b.makeMove();
		
		Board expected = Board.boardFromString("nB\nnn");
		
		for(int i = 0; i<b.)
		//TODO
	}

	@Test
	public void testUndoMove() {
		fail("Not yet implemented");
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
