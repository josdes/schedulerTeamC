package phaseI;

import java.util.ArrayList;

public class Queue<X> { 
	public ArrayList<X> queue = new ArrayList<X>();
	public Pred<X> pred;

	public Queue(Pred<X> pred) {
		this.pred = pred;
	}
	
	public void addIn(X next) {
		int i = 0;
		if(isEmpty()) {
			addFront(next);
		}
		else {
			while(i<queue.size() && !pred.p(next, queue.get(i))) {
				i++;
			}
			if (i == queue.size()) {
				queue.add(next);
			}
			else {
				queue.add(i, next);
			}
		}
	}
	
	public void addFront(X next) {
		queue.add(0, next);
	}
	
	public boolean isEmpty() {
		return (queue.size() == 0);
	}

	public int getLength()
	{
		return queue.size();
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
