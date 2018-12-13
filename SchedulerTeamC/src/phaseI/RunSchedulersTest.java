package phaseI;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class RunSchedulersTest {
	
	@Test
	void test() {
		RunSchedulers testRun = new RunSchedulers();
		testRun.runAll();
		Scheduler[] testList = testRun.schedulers;
		Boolean temp = true;
		for(int i = 0; i<testList.length; i++) {
			if (temp && testList[i].isDone()) {
				
			}
			else {
				temp = false;
			}
		}
		assertTrue(temp);
		
		testRun.processList = ProcessGenerator.populateReady(200);
		testRun.run(testRun.fifo);
		
	}

}
