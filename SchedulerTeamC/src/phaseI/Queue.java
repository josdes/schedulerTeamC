package phaseI;

import java.util.ArrayList;

public class Queue<X> {
	public X bottom = null;
	public ArrayList<X> queue = new ArrayList<X>();

	public Queue() {
	}
	
	public boolean isEmpty() {
		return (queue.size() == 0 && bottom == null);
	}
	
	public void add(X next) { 
		if (this.isEmpty()) {
			bottom = next;
		}
		else {
			ArrayList<X> temp = new ArrayList<X>();
			temp.add(bottom);
			temp.addAll(queue);
			bottom = next;
			queue = temp;
		}
	}
	
	public X getBottom() throws Exception {
		//effect statement: also removes the bottom from the queue
		//                   in doing this, everything shifts
		X temp = bottom;
		bottom = queue.get(0);
		queue.remove(0);
		return temp;
	} 
	
	public ArrayList<X> getQueue() throws Exception {
		return queue;
	}
}
