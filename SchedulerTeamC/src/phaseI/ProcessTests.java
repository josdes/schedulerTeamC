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
		
		//assertEquals(ProcessGenerator.populateReady(0), ArrayList<Process>()); I don't know why it isn't letting me return an empty ArrayList<Process>. They're everywhere.
		
		
		
		
		
		

	}

}
