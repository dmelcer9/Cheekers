package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import javax.naming.OperationNotSupportedException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.CoreMatchers.*;

public class TestMove {
	
	@Test(expected=IllegalArgumentException.class)
	public void testNoMove(){
		Move m = new Move();
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void testOneMove(){
		Move m = new Move(new Coordinate(1,1));
	}
	
	@Test
	public void testTwoMoves(){
		Move m = new Move(new Coordinate(1,1), new Coordinate(1,1));
	}

	@Test
	public void testIterator() {
		Coordinate c1 = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(2,2);
		Coordinate c3 = new Coordinate(3,3);
		
		Move m = new Move(c1,c2,c3);
		
		Iterator<Coordinate> i = m.iterator();
		
		assertTrue(i.hasNext());
		assertThat(c1, is(i.next()));
		
		assertTrue(i.hasNext());
		assertThat(c2, is(i.next()));
		
		assertTrue(i.hasNext());
		assertThat(c3, is(i.next()));
		
		assertFalse(i.hasNext());
	}
	
	@Test(expected=UnsupportedOperationException.class)
	public void testRemoveIterator(){
		Move m = new Move(new Coordinate(1,1), new Coordinate(2,2));
		
		Iterator<Coordinate> i = m.iterator();
		
		i.next();
		i.remove();
	}
	
	@Test(expected=NoSuchElementException.class)
	public void testEndOfIterator(){
		Coordinate c1 = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(2,2);
		Coordinate c3 = new Coordinate(3,3);
		
		Move m = new Move(c1,c2,c3);
		Iterator<Coordinate> i = m.iterator();
		
		i.next();
		i.next();
		i.next();
		i.next();
	}

	@Test
	public void testGetStartingPosition() {
		Coordinate c1 = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(2,2);
		Coordinate c3 = new Coordinate(3,3);
		
		Move m = new Move(c1,c2,c3);
		
		assertThat(m.getStartingPosition(), is(c1));
	}

	@Test
	public void testGetMoves() {
		Coordinate c1 = new Coordinate(1,1);
		Coordinate c2 = new Coordinate(2,2);
		Coordinate c3 = new Coordinate(3,3);
		
		Move m = new Move(c1,c2,c3);
		
		Coordinate[] arr = {c1,c2,c3};
		
		assertArrayEquals(arr, m.getMoves());
	}

}
