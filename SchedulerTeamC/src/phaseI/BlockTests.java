package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlockTests {

	@Test
	void test() {
		BlockA BA = new BlockA(5); 
		BlockB BB = new BlockB(6);
		BlockC BC = new BlockC(7);
		
		assertEquals(BC.getResource(), "C");
		assertEquals(BB.getResource(), "B");
		assertEquals(BA.getResource(), "A");
		assertEquals(BA.getStart(), 5);
		assertEquals(BB.getStart(), 6);
		assertEquals(BC.getStart(), 7);
	}

}
