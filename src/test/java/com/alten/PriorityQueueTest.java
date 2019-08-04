package com.alten;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PriorityQueueTest {
	
	private PriorityQueue<Integer> priorityQueue = null;
	
	/**
	 * It is run every time a new test method begins
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		priorityQueue = new PriorityQueue<>();
		priorityQueue.add(1, null);
		priorityQueue.add(2, null);
		priorityQueue.add(3, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test for the PriorityQueue "get" method.
	 */
	@Test
	public void testGet() {
		assertTrue(priorityQueue.get() == 1);
		assertTrue(priorityQueue.get() == 2);
		assertTrue(priorityQueue.get() == 3);
		assertTrue(priorityQueue.get() == null);
		assertTrue(priorityQueue.get() == null);
	}
	
	/**
	 * Test for the PriorityQueue "add" method, with a custom priority set.
	 */
	@Test
	public void testAddWithPriority() {
		priorityQueue.add(4, 0); // add a new element having the highest priority

		assertTrue(priorityQueue.get() == 4); // verify if the newly added element has the top highest priority 
		assertTrue(priorityQueue.get() == 1);
		assertTrue(priorityQueue.get() == 2);
		assertTrue(priorityQueue.get() == 3);
		assertTrue(priorityQueue.get() == null);
	}
	
	/**
	 * Test for the PriorityQueue "add" method, without a custom priority set.
	 */	
	@Test
	public void testAddWithouthPriority() {
		priorityQueue.add(4, null); // add a new element to the end of the queue, so with the lowest priority

		assertTrue(priorityQueue.get() == 1);
		assertTrue(priorityQueue.get() == 2);
		assertTrue(priorityQueue.get() == 3);
		assertTrue(priorityQueue.get() == 4);
		assertTrue(priorityQueue.get() == null);
	}	

	/**
	 * Test for the PriorityQueue "changePriority" method.
	 */	
	@Test
	public void testChangePriority() {
		priorityQueue.changePriority(priorityQueue.length()-1, 0); // change the lowest priority element to be the highest priority element
		
		assertTrue(priorityQueue.get() == 3);
		assertTrue(priorityQueue.get() == 1);
		assertTrue(priorityQueue.get() == 2);
		assertTrue(priorityQueue.get() == null);
	}

	/**
	 * Test for the PriorityQueue "length" method.
	 */
	@Test
	public void testLength() {
		assertTrue(priorityQueue.length() == 3);
		priorityQueue.get();
		assertTrue(priorityQueue.length() == 2);
		priorityQueue.get();
		assertTrue(priorityQueue.length() == 1);
		priorityQueue.get();
		assertTrue(priorityQueue.length() == 0);
		priorityQueue.get();
		assertTrue(priorityQueue.length() == 0);
	}
	
	

}
