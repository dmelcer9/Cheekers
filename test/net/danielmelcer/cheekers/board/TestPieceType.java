package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.danielmelcer.cheekers.board.PieceType;

public class TestPieceType {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testKingBlack() {
		assertSame(PieceType.BLACK_KING, PieceType.BLACK.KingPiece());
	}
	
	@Test
	public void testKingRed(){
		assertSame(PieceType.RED_KING, PieceType.RED.KingPiece());
	}
	
	@Test
	public void noKingOthers(){
		assertSame(PieceType.NONE, PieceType.NONE.KingPiece());
		
		assertSame(PieceType.BLACK_KING, PieceType.BLACK_KING.KingPiece());
		
		assertSame(PieceType.RED_KING, PieceType.RED_KING.KingPiece());
	}

}
