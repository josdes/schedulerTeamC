package phaseI;

import java.util.ArrayList;

public class Queue<X> { 
	public ArrayList<X> queue = new ArrayList<X>();
	public Test<X> pred;

	public Queue(Test<X> pred) {
		this.pred = pred;
	}
	
	public void addIn(X next) {
		int i = 0;
		while(!(pred.p(next, queue.get(i))) && i<=queue.size()) {
			i++;
		}
		queue.add(i, next);
	}
	
	public void addFront(X next) {
		queue.add(0, next);
	}
	
	public boolean isEmpty() {
		return (queue.size() == 0);
	}
	
	public X pop() throws Exception {
		//effect statement: also removes the bottom from the queue
		//                   in doing this, everything shifts
		if (queue.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		else {
			X temp = queue.get(0);
			queue.remove(0);
			return temp;
		}
	} 
	
	public ArrayList<X> getQueue() throws Exception {
		return queue;
	}
	
	public X getNext() throws Exception {
		if (queue.isEmpty()) {
			throw new Exception("Queue is empty");
		}
		else {
			return queue.get(0);
		}
	}
}
