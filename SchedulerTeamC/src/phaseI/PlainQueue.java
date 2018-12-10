package phaseI;

public class PlainQueue<X> extends Queue<X> {
	
	public PlainQueue() {
		super();
	}
	
	public void sortQueue() {
	
	}
	
	public void add(X next) { 
		queue.add(next);
	}
	
	public PriorityQueue<X> transform(){
		PriorityQueue<X> newQueue = new PriorityQueue<X>();
		for(int i = 0; i < queue.size(); i++) {
			newQueue.add(queue.get(i));
		}
		return newQueue;
	}
	
}
