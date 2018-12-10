package phaseI;

public abstract class Scheduler {
	public Queue<Process> readyQueue;
	public Queue<Block> A, B, C = new Queue<Block>();
	
	public Scheduler() { 
	}
}
