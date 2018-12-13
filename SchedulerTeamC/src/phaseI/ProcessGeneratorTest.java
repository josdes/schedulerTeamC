package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ProcessGeneratorTest {
	
	public void printQueue(ArrayList<Process> q) {
		System.out.println("");
		for(int i = 0; i<q.size(); i++) {
			System.out.print(q.get(i).getType() + " ");
		}
	}
	
	@Test
	void testGenerateList() {
		ArrayList<Process> temp = ProcessGenerator.populateReady(20);
		printQueue(temp);
		assertTrue(ProcessGenerator.populateReady(20).size() > 0); 
		ArrayList<Process> temp0 = ProcessGenerator.populateReady(200);
		printQueue(temp0);
		assertTrue(temp0.size() > 0); 
		ArrayList<Process> temp1 = ProcessGenerator.populateReady(2000);
		printQueue(temp1);
		assertTrue(temp1.size() > 0); 
		
		Process aProcess = temp1.get(1);
		assertTrue(aProcess.getWork() > 0);
		int type = aProcess.getType();
		assertTrue(type == 1 || type == 2 || type == 3 || type == 4);
		int priority = aProcess.getPriority();
		assertTrue(priority == 1 
				|| priority == 2 
				|| priority == 3 
				|| priority == 4 
				|| priority == 5 
				|| priority == 6);
		int tempTimeOn = -1;
		Boolean good = true;
		for(int i = 0; i<temp1.size(); i++) {
			int timeOn = temp1.get(i).getTimeOn();
			if (timeOn > tempTimeOn) {
				tempTimeOn = timeOn;
			}
			else {
				good = false;
				break;
			}
		}
		assertTrue(good);
	}
	
	@Test
	void testGenerateProcess() {
		Process aProcess = ProcessGenerator.generateProcess(17);
	}

}
