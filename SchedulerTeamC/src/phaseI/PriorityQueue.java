package phaseI;

public class PriorityQueue<X> extends Queue<X> {
	
	public PriorityQueue() {
		super();
	}
	
	public void sortQueue() {
		
	}
	
	public void add(X next) {
		
	}
	
	public PlainQueue<X> transform(){
		PlainQueue<X> newQueue = new PlainQueue<X>();
		for(int i = 0; i < queue.size(); i++) {
			newQueue.add(queue.get(i));
		}
		return newQueue;
	}

}
