package com.Melcer.cheekers.board;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestCoordinate {
	
	Coordinate c;

	@Before
	public void setUp() throws Exception {
		c = new Coordinate(3,5);
	}

	@After
	public void tearDown() throws Exception {
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
