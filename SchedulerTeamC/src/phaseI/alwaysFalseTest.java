package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class alwaysFalseTest {

	@Test
	void test() {
		alwaysFalse<Integer> L = new alwaysFalse<Integer>();
		
		assertEquals(L.p(1, 2), false);
	}

}
