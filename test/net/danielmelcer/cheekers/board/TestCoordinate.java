package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import net.danielmelcer.cheekers.board.Coordinate;

public class TestCoordinate {
	
	Coordinate c;

	@Before
	public void setUp() throws Exception {
		c = new Coordinate(3,5);
	}

	@Test
	public void testGetX() {
		assertTrue(c.getX() == 3);
	}

	@Test
	public void testGetY() {
		assertTrue(c.getY() == 5);
	}

}
