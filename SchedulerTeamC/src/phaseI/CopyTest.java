package phaseI;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class CopyTest {

	public void printQueue(ArrayList<Process> q) {
		System.out.println("");
		for(int i = 0; i<q.size(); i++) {
			System.out.print(q.get(i).getType() + " ");
		}
	}
	
	@Test
	void test() {
		
		ArrayList<Process> firstList = ProcessGenerator.populateReady(200);
		printQueue(firstList);
		ArrayList<Process> copyList = Copy.copyProcesses(firstList);
		printQueue(firstList);
		printQueue(copyList);
	}

}
