package test;

import static calculator.Operation.*;
import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import calculator.Stack;

public class TestStack {
	Stack s;
	
	@Before
	public void setUp() throws Exception {
		s = new Stack();
	}
	
	@After
	public void tearDown() throws Exception {
		s = null;
	}

	@Test
	public void testConstructor() {
		assertEquals("Wrong size of stack array", 4, s.size());
		assertStack(0,0,0,0);
	}

	@Test
	public void zeroPlusZero() {
		s.execute(ZERO);
		s.execute(ENTER);
		s.execute(ZERO);
		s.execute(PLUS);
		
		assertEquals(0, s.getElement(0));
	}
	
	@Test
	public void testAddNumberToStack() {
		s.execute(ZERO);
		s.execute(ONE);
		s.execute(TWO);
		s.execute(THREE);
		s.execute(FOUR);
		s.execute(FIVE);
		s.execute(SIX);
		s.execute(SEVEN);
		s.execute(EIGHT);
		s.execute(NINE);
		s.execute(ZERO);
		
		assertEquals(1234567890, s.getElement(0));
	}
	
	@Test
	public void testEnter() {
		s.execute(ONE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(ENTER);
		s.execute(THREE);
		s.execute(ENTER);
		s.execute(FOUR);
		s.execute(FIVE);
		s.execute(ENTER);
		
		assertStack(45,45,3,2);
	}
	
	@Test
	public void testChs() {
		s.execute(CHS);
		assertEquals(0, s.getElement(0));
		
		s.execute(ONE);
		s.execute(CHS);
		assertEquals(-1, s.getElement(0));
		
		s.execute(CHS);
		assertEquals(1, s.getElement(0));
	}
	
	@Test
	public void testAddNumberAfterChs() {
		s.execute(ONE);
		s.execute(CHS);
		s.execute(TWO);
		
		assertEquals(-12, s.getElement(0));
	}
	
	@Test
	public void testClearStack() {
		s.execute(ONE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(ENTER);
		s.execute(THREE);
		s.execute(ENTER);
		s.execute(FOUR);
		s.execute(CLEARSTACK);
		
		assertStack(0,0,0,0);
		
		s.execute(THREE);
		assertEquals(3, s.getElement(0));
	}
	
	@Test
	public void testClear() {
		s.execute(ONE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(ENTER);
		s.execute(THREE);
		s.execute(ENTER);
		s.execute(FOUR);
		s.execute(CLEAR);
		
		assertStack(3,2,1,1);
	}
	
	@Test
	public void testPlus() {
		s.execute(THREE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(ENTER);
		s.execute(ONE);
		s.execute(PLUS);
		
		assertStack(3,3,0,0);	
	}
	
	@Test
	public void testMinus() {
		s.execute(ONE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(MINUS);
		
		assertEquals(-1, s.getElement(0));
		assertEquals(0, s.getElement(1));
	}
	
	@Test
	public void testTimes() {
		s.execute(TWO);
		s.execute(ENTER);
		s.execute(THREE);
		s.execute(CHS);
		s.execute(TIMES);
		
		assertEquals(-6, s.getElement(0));
		assertEquals(0, s.getElement(1));
	}
	
	@Test
	public void testDividesEvenNumbers() {
		s.execute(FOUR);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(DIVIDES);

		assertEquals(2, s.getElement(0));
		assertEquals(0, s.getElement(1));
	}
	
	@Test
	public void testDividesZeroByNumber() {
		s.execute(FOUR);
		s.execute(DIVIDES);

		assertEquals(0, s.getElement(0));
	}
	
	@Test
	public void testDividesNumberByZero() {
		s.execute(FOUR);
		s.execute(ENTER);
		s.execute(ZERO);
		s.execute(DIVIDES);

		assertEquals(0, s.getElement(0));
		assertEquals(4, s.getElement(1));
	}
	
	@Test
	public void testStackUpdateAfterOperation() {
		s.execute(ONE);
		s.execute(ENTER);
		s.execute(TWO);
		s.execute(PLUS);
		s.execute(FOUR);
		
		assertEquals(4, s.getElement(0));
		assertEquals(3, s.getElement(1));
		assertEquals(0, s.getElement(2));
		assertEquals(0, s.getElement(3));
	}
	
	private void assertStack(int ... expected) {
		for (int i = 0; i < expected.length; i++) {
			assertEquals(expected[i], s.getElement(i));
		}
	}
	
}
