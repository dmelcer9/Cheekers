package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLegalMoves {

	@Test
	public void basicMove() {
		Board b = Board.boardFromString("nn\nrn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertTrue(b.isLegal(m));
	}
	
	@Test
	public void testNotDiagnol(){
		Board b = Board.boardFromString("nn\nrn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(0,0));
		
		assertFalse(b.isLegal(m));
	}
	
	@Test
	public void testMoveOffSideEdge() {
		Board b = Board.boardFromString("nn\nnr");
		
		Move m = new Move(new Coordinate(1,1),new Coordinate(2,0));
		
		assertFalse(b.isLegal(m));
	}
	
	@Test
	public void testMoveOffTopEdge() {
		Board b = Board.boardFromString("nr\nnn");
		
		Move m = new Move(new Coordinate(1,0),new Coordinate(0,-1));
		
		assertFalse(b.isLegal(m));
	}
	
	@Test
	public void testBackwardsRedMove() {
		Board b = Board.boardFromString("nr\nnn");
		
		Move m = new Move(new Coordinate(1,0),new Coordinate(0,1));
		
		assertFalse(b.isLegal(m));
	}
	
	@Test
	public void testBackwardsBlackMove() {
		Board b = Board.boardFromString("nn\nbn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertFalse(b.isLegal(m));
	}
	
	@Test
	public void testBackwardsRedKingMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBackwardsBlackKingMove() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testLandOnOtherPieces() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBasicJump() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiJump() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBackwardsJumpNotKing() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testBackwardsJumpKing() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiBackwardsJumpNotKing() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiBackwardsJumpKing() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testJumpOwnPiece() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiJumpOwnPiece() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testMultiJumpAvailable() {
		fail("Not yet implemented");
	}
	

}
