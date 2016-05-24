package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLegalMoves {

	@Test
	public void basicMove() {
		Board b = Board.boardFromString("nn\nrn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testNotDiagnol(){
		Board b = Board.boardFromString("nn\nrn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(0,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMoveOffSideEdge() {
		Board b = Board.boardFromString("nn\nnr");
		
		Move m = new Move(new Coordinate(1,1),new Coordinate(2,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMoveOffTopEdge() {
		Board b = Board.boardFromString("nr\nnn");
		
		Move m = new Move(new Coordinate(1,0),new Coordinate(0,-1));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBackwardsRedMove() {
		Board b = Board.boardFromString("nr\nnn");
		
		Move m = new Move(new Coordinate(1,0),new Coordinate(0,1));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBackwardsBlackMove() {
		Board b = Board.boardFromString("nn\nbn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.BLACK));
	}
	
	@Test
	public void testBackwardsRedKingMove() {
		Board b = Board.boardFromString("nR\nnn");
		
		Move m = new Move(new Coordinate(1,0),new Coordinate(0,1));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBackwardsBlackKingMove() {
		Board b = Board.boardFromString("nn\nBn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertTrue(b.isLegal(m, SelectingPlayer.BLACK));
	}
	
	@Test
	public void testLandOnOtherPieces() {
		Board b = Board.boardFromString("nb\nrn");
		
		Move m = new Move(new Coordinate(0,1),new Coordinate(1,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBasicJump() {
		Board b = Board.boardFromString("nnn\nnbn\nrnn");
		Move m = new Move(new Coordinate(0,2), new Coordinate(2,0));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMultiJump() {
		Board b = Board.boardFromString("nnnnn\nnnnbn\nnnnnn\nnbnnn\nrnnnn");
		
		Move m = new Move(new Coordinate(0,4), new Coordinate(2,2), new Coordinate(4,0));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBackwardsJumpNotKing() {
		Board b = Board.boardFromString("nnr\nnbn\nnnn");
		
		Move m = new Move(new Coordinate(2,0), new Coordinate(0,2));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testBackwardsJumpKing() {
		Board b = Board.boardFromString("nnR\nnbn\nnnn");
		
		Move m = new Move(new Coordinate(2,0), new Coordinate(0,2));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMultiBackwardsJumpNotKing() {
		Board b = Board.boardFromString("nnnnn\nnbnbn\nrnnnn");
		
		Move m = new Move(new Coordinate(0,2), new Coordinate(2,0), new Coordinate(4,2));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMultiBackwardsJumpKing() {
		Board b = Board.boardFromString("nnnnn\nnbnbn\nRnnnn");
		
		Move m = new Move(new Coordinate(0,2), new Coordinate(2,0), new Coordinate(4,2));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testJumpOwnPiece() {
		Board b = Board.boardFromString("nnn\nnrn\nrnn");
		
		Move m = new Move(new Coordinate(0,2), new Coordinate(2,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMultiJumpOwnPiece() {
		Board b = Board.boardFromString("nnnnn\nnrnnn\nnnnnn\nnnnbn\nnnnnr");
		
		Move m = new Move(new Coordinate(4,4), new Coordinate(2,2), new Coordinate(0,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testMultiJumpAvailable() {
		Board b = Board.boardFromString("nnnnn\nnbnnn\nnnnnn\nnnnbn\nnnnnr");

		
		Move m = new Move(new Coordinate(4,4), new Coordinate(2,2));
		
		assertTrue(b.isLegal(m, SelectingPlayer.RED));
	}
	
	@Test
	public void testWrongSelectingPlayerRed(){
		Board b = Board.boardFromString("nn\nrn");
		
		Move m = new Move(new Coordinate(0,1), new Coordinate(1,0));
		
		assertFalse(b.isLegal(m, SelectingPlayer.BLACK));
		assertTrue(b.isLegal(m,  SelectingPlayer.RED));
	}
	
	@Test
	public void testWrongSelectingPlayerBlack(){
		Board b = Board.boardFromString("bn\nnn");
		
		Move m = new Move(new Coordinate(0,0), new Coordinate(1,1));
		
		assertTrue(b.isLegal(m, SelectingPlayer.BLACK));
		assertFalse(b.isLegal(m,  SelectingPlayer.RED));
	}
	

}
