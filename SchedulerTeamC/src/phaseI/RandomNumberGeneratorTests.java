package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTests {

	@Test
	void test() {

		assertTrue((1 <= RandomNumberGenerator.random(1, 5)) && (RandomNumberGenerator.random(1, 5) <= 5));
		assertTrue((200 <= RandomNumberGenerator.random("workII")) && (RandomNumberGenerator.random("workII") <= 600));
		assertTrue((150 <= RandomNumberGenerator.random("workIII")) && (RandomNumberGenerator.random("workIII") <= 500));
		assertTrue((25 <= RandomNumberGenerator.random("blockIII")) && (RandomNumberGenerator.random("blockIII") <= 75));
		assertTrue((100 <= RandomNumberGenerator.random("workC")) && (RandomNumberGenerator.random("workC") <= 400));
		assertEquals(RandomNumberGenerator.random("Hello"), -1);
		assertTrue((1 <= RandomNumberGenerator.nonUniform(1, 5, 1/2)) && (RandomNumberGenerator.nonUniform(1, 5, 1/2) <= 5));
	}

}
