package phaseI;

public class Fifo extends Scheduler {
	public Fifo(PlainQueue<Process> queue) {
		readyQueue = queue;
	}
}
