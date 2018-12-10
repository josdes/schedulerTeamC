package phaseI;

import java.util.ArrayList;

public class RunSchedulers {
	public static alwaysFalse<Process> falseProcess = new alwaysFalse<Process>();
	public static alwaysFalse<Block> falseBlock = new alwaysFalse<Block>();
	public static leastWork leastW = new leastWork();
	public static leastLeft leastL = new leastLeft();
	public static leastDone leastD = new leastDone();
	public int timeLimit = 25000;
	public int clock = 0; 
	public ArrayList<Process> processList = ProcessGenerator.populateReady(timeLimit);
	
	public Scheduler fifo = new Scheduler(falseProcess, false);
	public Scheduler rr = new Scheduler(falseProcess, true);
	public Scheduler shortest = new Scheduler(leastW, false);
	public Scheduler left = new Scheduler(leastL, true);
	public Scheduler done = new Scheduler(leastD, true);
	
	public void run() {
		while(!(fifo.isDone() &&
				rr.isDone() &&
				shortest.isDone() &&
				left.isDone() &&
				done.isDone())) {
			
		}
	}

}