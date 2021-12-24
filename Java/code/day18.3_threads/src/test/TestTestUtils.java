package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.TestUtils;

class TestTestUtils {

	@Test
	void testCalc() {
		assertEquals(14,TestUtils.calc(3, 4));
	}

}
