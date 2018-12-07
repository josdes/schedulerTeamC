package phaseI;

import java.util.ArrayList;

public class Queue {
	public Process bottom;
	public ArrayList<Process> queue = new ArrayList<Process>();

	public Queue(Process next, ArrayList<Process> base) {
		bottom = next;
		queue = base;
	}
	
	public Queue add(Process next) { 
		queue.add(bottom);
		return new Queue(next, queue); 
	}
	
	public Process getBottom() throws Exception {
		return bottom;
	} 
	
	public ArrayList<Process> getQueue() throws Exception {
		return queue;
	}
 
	public int totalQueue() {
		return totalBlock() + totalWork();
	} 
	
	public int totalBlock() {
		int sum = bottom.getBlockTotal();
		for(int i = 0; i < queue.size(); i++) {
			sum += queue.get(i).getBlockTotal();
		}
		return sum;
	}

	public int totalWork() {
		int sum = bottom.getWork();
		for(int i = 0; i < queue.size(); i++) {
			sum += queue.get(i).getWork();
		}
		return sum;
	}
}
