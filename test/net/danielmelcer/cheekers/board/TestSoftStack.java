package net.danielmelcer.cheekers.board;

import static org.junit.Assert.*;

import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;

public class TestSoftStack {

	SoftStack<Integer> ss;
	
	@Before
	public void setUp(){
		ss = new SoftStack<>(3);
	}
	
	@Test
	public void testNoneAvailableAtStart() {
		assertFalse(ss.available());
	}
	
	@Test
	public void testReturnsNullWhenNoneAvailable() {
		assertNull(ss.pop());		
	}
	
	@Test
	public void testAvailableAfterPush() {
		ss.push(5);
		assertTrue(ss.available());
		
		assertTrue(ss.pop() == 5);
		
		assertFalse(ss.available());
		
		assertNull(ss.pop());
	}
	
	@Test
	public void testPopOutOfSoftReference() {
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(5);
		
		assertTrue(ss.pop() == 5);
		assertTrue(ss.pop() == 4);
		assertTrue(ss.pop() == 3);
		
		assertTrue(ss.available());
		
		assertTrue(ss.pop() == 2);
		assertTrue(ss.pop() == 1);
		
		assertFalse(ss.available());
		
		assertNull(ss.pop());
	}
	
	@Test
	public void testOutOfMemory() {
		ss.push(1);
		ss.push(2);
		ss.push(3);
		ss.push(4);
		ss.push(5);
		
		OOM();
		
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		System.out.println(ss.pop());
		
		//assertTrue(ss.pop() == 5);
		//assertTrue(ss.pop() == 4);
		//assertTrue(ss.pop() == 3);
		
		//assertFalse(ss.available());
		//assertNull(ss.pop());
	}
	
	public void OOM(){
		try {
	        final LinkedList<Object[]> allocations = new LinkedList<Object[]>();
	        int size;
	        while( (size = Math.min(Math.abs((int)Runtime.getRuntime().freeMemory()),Integer.MAX_VALUE))>0 )
	            allocations.add( new Object[size] );
	    } catch( OutOfMemoryError e ) {
	        // great!
	    }
	}

}
