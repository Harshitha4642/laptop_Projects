package bigproblems;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

class odotest {
	private Odometer o;
	
	@Before
	void setUp() {
	o = new Odometer();
	}
		
	@Test
	void nextReading()
	{
		assertEquals(489, o.nextReading(479));
	}
	
	@Test
	void prevReading()
	{
		assertEquals(369, o.prevReading(378));
	}
	
	@Test
	void nextKthReading()
	{
		assertEquals(348,o.nextKthReading(345, 3));
	}
	
	@Test
	void prevKthReading()
	{
		assertEquals(456, o.prevKthReading(379, 2));
	}
	
	@Test
	void distanceBetween()
	{
		assertEquals(2, o.distanceBetween(234, 236));
	}
}

