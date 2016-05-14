package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestBoardHistory {
	
	BoardHistory b;
	PieceType[][] p = {
			{PieceType.BLACK,PieceType.NONE},
			{PieceType.NONE,PieceType.RED_KING}
	};
	
	Move m;

	@Before
	public void setUp() throws Exception {
		Coordinate c = new Coordinate(0,0);
		Coordinate d = new Coordinate(1,1);
		m = new Move(c,d);
		
		b = new BoardHistory(p,m);
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void testGetMove() {
		assertSame(b.getMove(),m);
	}

	@Test
	public void testGetBoard() {
		assertSame(b.getBoard(), p);
	}

}
