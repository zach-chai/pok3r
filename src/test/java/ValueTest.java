

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ValueTest {
	
	@Test
	public void testName() throws Exception {
		
		assertEquals("Ace", Value.ACE.toString());
		assertEquals("King", Value.KING.toString());
		assertEquals("Ten", Value.TEN.toString());
	}

}
