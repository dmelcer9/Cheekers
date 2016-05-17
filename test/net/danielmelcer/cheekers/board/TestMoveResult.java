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
		fail("Not yet implemented");
	}
	
	@Test
	public void testJump() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiJump() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testPieceIsKinged() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testNotKingedAtWrongEnd() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testKingedAfterJump() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testKingedAfterMultiJump() {
		fail("Not yet implemented");
	}

}
