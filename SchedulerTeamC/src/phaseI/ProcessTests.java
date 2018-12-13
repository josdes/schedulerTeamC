package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ProcessTests {

	@Test
	void test() {
		
		Process1 SampleProcessA = new Process1(1, 1);
		Process2 SampleProcessB = new Process2(2, 2);
		Process3 SampleProcessC = new Process3(3, 3);
		Process4 SampleProcessD = new Process4(4, 4);
		
		assertEquals(SampleProcessA.getType(), 1);
		assertTrue((25 <= (SampleProcessA.generateWork())) && SampleProcessA.generateWork() <= 75);
		

	}

}
