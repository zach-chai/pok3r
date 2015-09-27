package test;

import static org.junit.Assert.*;

import org.junit.Test;

import main.Utilities;

public class UtilitiesTest {

	@Test
	public void testLastCapitalIndex() throws Exception {
		assertEquals(2, Utilities.lastCapitalIndex("abC"));
		assertEquals(3, Utilities.lastCapitalIndex("AbcDe"));
	}

}
