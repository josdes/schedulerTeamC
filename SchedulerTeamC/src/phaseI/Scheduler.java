package phaseI;

public class Scheduler {
	public Queue<Process> readyQueue;
	public Queue<Block> A, B, C = new Queue<Block>(RunSchedulers.falseBlock);
	public Boolean slice;
	public Test<Process> pred;
	
	public Scheduler(Test<Process> pred, Boolean slice) {
		this.slice = slice;
		this.pred = pred;
		readyQueue = new Queue<Process>(pred);
	}
	
	public void addIn(Process next) {
		readyQueue.add(next);
	}
	
	public void addFront(Process next) {
		readyQueue.addFront(next);
	}
	
	public Boolean isDone() {
		return readyQueue.isEmpty() && A.isEmpty() && B.isEmpty() && C.isEmpty();
	}
}
