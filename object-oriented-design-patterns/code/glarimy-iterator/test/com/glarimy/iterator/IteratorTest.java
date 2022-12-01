package com.glarimy.iterator;

import static org.junit.Assert.*;

import org.junit.Test;

public class IteratorTest {

	@Test
	public void testAdd() {
		Aggregate<Integer> integers = new ConcreteAggregate<Integer>(3);
		integers.add(100);
		integers.add(200);
		integers.add(300);

		try {
			integers.add(400);
			fail();
		} catch (RuntimeException rte) {

		}
	}

	@Test
	public void testHasNext() {
		Aggregate<Integer> integers = new ConcreteAggregate<Integer>(3);
		Iterator<Integer> iterator = integers.getIterator();
		assertFalse(iterator.hasNext());
		
		integers.add(100);
		integers.add(200);
		integers.add(300);

		iterator = integers.getIterator();
		assertTrue(iterator.hasNext());
	}

	
	@Test
	public void testFirst() {
		Aggregate<Integer> integers = new ConcreteAggregate<Integer>(3);
		Iterator<Integer> iterator = integers.getIterator();
		try {
			System.out.println(iterator.first());
			iterator.first();
			fail();
		}catch(RuntimeException rte) {
			
		}
		
		integers.add(100);

		iterator = integers.getIterator();
		try {
			System.out.println(iterator.first());
			assertTrue(iterator.first() == 100);
		}catch(RuntimeException rte) {
			fail();			
		}
		
		integers.add(200);
		integers.add(300);

		iterator = integers.getIterator();
		try {
			System.out.println(iterator.first());
			assertTrue(iterator.first() == 100);
		}catch(RuntimeException rte) {
			fail();			
		}
	}
	
	@Test
	public void testLast() {
		Aggregate<Integer> integers = new ConcreteAggregate<Integer>(3);
		Iterator<Integer> iterator = integers.getIterator();
		try {
			iterator.last();
			fail();
		}catch(RuntimeException rte) {
			
		}
		
		integers.add(100);
		
		iterator = integers.getIterator();
		try {
			assertTrue(iterator.last() == 100);
		}catch(RuntimeException rte) {
			fail();			
		}
		
		integers.add(200);
		integers.add(300);

		iterator = integers.getIterator();
		try {
			assertTrue(iterator.last() == 300);
		}catch(RuntimeException rte) {
			fail();			
		}
	}

}
