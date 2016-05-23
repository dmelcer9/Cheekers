package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestMoveResult {

	@Test
	public void testNormalMove() {
		Board b = Board.boardFromString(
				  "nnnn\n"
				+ "nnnn\n"
				+ "nBnn\n"
				+ "nnnn");
		
		Board result = b.makeMove(new Move(new Coordinate(1,2), new Coordinate(2,3)));
		
		Board expected = Board.boardFromString(
				"nnnn\n"
				+ "nnnn\n"
				+ "nnnn\n"
				+ "nnBn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testKingBackwardsMove() {
		Board b = Board.boardFromString("nnnn\nnnnn\nnBnn\nnnnn");
		
		Board result = b.makeMove(new Move(new Coordinate(1,2), new Coordinate(2,1)));
		
		Board expected = Board.boardFromString("nnnn\nnnBn\nnnnn\nnnnn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testJump() {
		Board b = Board.boardFromString("nnnn\nnnrn\nnBnn\nnnnn");
		
		Board result = b.makeMove(new Move(new Coordinate(1,2), new Coordinate(3,0)));
		
		Board expected = Board.boardFromString("nnnB\nnnnn\nnnnn\nnnnn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testMultiJump() {
		Board b = Board.boardFromString("nnnnn\nnBnnn\nnnnnn\nnnnbn\nnnnnR");
		
		Board result = b.makeMove(new Move(new Coordinate(4,4), new Coordinate(2,2), new Coordinate(0,0)));
		
		Board expected = Board.boardFromString("Rnnnn\nnnnnn\nnnnnn\nnnnnn\nnnnnn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testRedPieceIsKinged() {
		Board b = Board.boardFromString("nn\nrn");
		
		Board result = b.makeMove(new Move(new Coordinate(0,1), new Coordinate(1,0)));
		
		Board expected = Board.boardFromString("nR\nnn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testBlackPieceKinged() {
		Board b = Board.boardFromString("nb\nnn");
		
		Board result = b.makeMove(new Move(new Coordinate(1,0), new Coordinate(0,1)));
		
		Board expected = Board.boardFromString("nn\nBn");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testKingedAfterJump() {
		Board b = Board.boardFromString("bnn\nnrn\nnnn");
		
		Board result = b.makeMove(new Move(new Coordinate(0,0), new Coordinate(2,2)));
		
		Board expected = Board.boardFromString("nnn\nnnn\nnnB");
		
		assertTrue(result.contentsEqual(expected));
	}
	
	@Test
	public void testKingedAfterMultiJump() {
		Board b = Board.boardFromString("nnnnn\nnbnnn\nnnnnn\nnnnbn\nnnnnr");
		
		Board result = b.makeMove(new Move(new Coordinate(4,4), new Coordinate(2,2), new Coordinate(0,0)));
		
		Board expected = Board.boardFromString("Rnnnn\nnnnnn\nnnnnn\nnnnnn\nnnnnn");
		
		assertTrue(result.contentsEqual(expected));
	}

}
