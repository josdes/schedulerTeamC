package phaseI;

import java.util.ArrayList;

public abstract class Queue<X> { 
	public ArrayList<X> queue = new ArrayList<X>();

	public Queue() {
	}
	
	public abstract void sortQueue();
	public abstract void add(X next);
	
	public boolean isEmpty() {
		return (queue.size() == 0);
	}
	
	
	public X pop() throws Exception {
		//effect statement: also removes the bottom from the queue
		//                   in doing this, everything shifts
		X temp = queue.get(0);
		queue.remove(0);
		return temp;
	} 
	
	public ArrayList<X> getQueue() throws Exception {
		return queue;
	}
}
