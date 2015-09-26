

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class UtilitiesTest {

	@Test
	public void testLastCapitalIndex() throws Exception {
		assertEquals(2, Utilities.lastCapitalIndex("abC"));
		assertEquals(3, Utilities.lastCapitalIndex("AbcDe"));
	}

}
