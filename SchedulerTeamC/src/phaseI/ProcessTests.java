package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class ProcessTests {
	
	@Test
	void test() {
		
		Process1 SampleProcessA = new Process1(1, 1);
		Process2 SampleProcessB = new Process2(2, 2);
		Process3 SampleProcessC = new Process3(3, 3);
		Process4 SampleProcessD = new Process4(4, 4);

		
		
		assertEquals(SampleProcessA.getType(), 1);
		assertTrue((25 <= (SampleProcessA.generateWork())) && SampleProcessA.generateWork() <= 75);
		assertEquals(SampleProcessB.getType(), 2);
		assertTrue(SampleProcessA.generateWork() <= 600);
		assertEquals(SampleProcessC.getType(), 3);
		assertTrue(SampleProcessC.generateWork() <= 500);
		assertEquals(SampleProcessD.getType(), 4);
		assertTrue((400 <= (SampleProcessD.generateWork())) && SampleProcessD.generateWork() <= 1000);
		
		int size1 = SampleProcessA.getBlockList().size();
		assertTrue(size1 == 0 || size1 == 1);
		int size2 = SampleProcessB.getBlockList().size();
		assertTrue(size2 == 0);
		int size3 = SampleProcessC.getBlockList().size();
		assertTrue(size3 > 0);
		int size4 = SampleProcessD.getBlockList().size();
		assertTrue(size4 > 0);
	}

}
