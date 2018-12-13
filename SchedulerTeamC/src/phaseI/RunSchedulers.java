package phaseI;

import java.util.ArrayList;

public class RunSchedulers {
	public static alwaysFalse<Process> falseProcess = new alwaysFalse<Process>();
	public static alwaysFalse<Block> falseBlock = new alwaysFalse<Block>();
	public static leastWork leastW = new leastWork();
	public static leastLeft leastL = new leastLeft();
	public static leastDone leastD = new leastDone();
	public int timeLimit = 25000;
	public ArrayList<Process> startList = ProcessGenerator.populateReady(timeLimit);
	public ArrayList<Process> processList;
	public ArrayList<Process> finishedProcesses = new ArrayList<Process>();
	
	public Scheduler fifo = new Scheduler(falseProcess, false);
	public Scheduler rr = new Scheduler(falseProcess, true);
	public Scheduler shortest = new Scheduler(leastW, false);
	public Scheduler left = new Scheduler(leastL, true);
	public Scheduler done = new Scheduler(leastD, true);
	
	public Scheduler[] schedulers = {fifo, rr, shortest, left, done};
	
	public void runAll() {
		for(int i = 0; i<schedulers.length; i++) {
			processList = Copy.copyProcesses(startList);
			finishedProcesses = new ArrayList<Process>();
			run(schedulers[i]);
			
		}
	}
	
	public void run(Scheduler scheduler) { 
		int clock = 0;  
		int timeSlice = 40; 
		while(!scheduler.isDone() && !(clock == 0)) {  
			int index = 0;
			while(processList.get(index).getTimeOn()<= clock) {
				scheduler.addIn(processList.get(index));
				index++;
			}
			
			int updateTime = 0;
			try{
				Process process = scheduler.getNext();
				int wL;
				Boolean blocks;
				//at this point we know there is a next process so we have to treat
				// that process in the way that we should
				try {
					Block block = process.getNextBlock();
					// if there is a block we need to see how long it takes the process
					// to get to that block
						wL = block.getStart() - process.getWorkDone();
						blocks = true;
					}
				catch (Exception e0){
					//if there is no block, then we can just work through the process
					wL = process.getWorkLeft(); 
					blocks = false;
				}
				
				//then we take the amount of work we can do before something goes wrong and
				// we act accordingly
				if(scheduler.slice && (wL >= timeSlice)) {
					process.updateWork(timeSlice);
					scheduler.addIn(process);
					updateTime = timeSlice;
				}
				//otherwise the process is just done, and we can get rid of it  
				else {
					finishedProcesses.add(process);
					updateTime = wL;
					//add whatever blocked to the block queue and keep gong
					if(blocks) {
						scheduler.addBlock(process);
					}
				}
			}
			catch (Exception e){
				//if there is no next process then we just have to update by
				// the time it takes for the next process to get on the readyQueue
				// this can either be something coming off the blockQueue or 
				// something joining the ready queue
				int lowestTime = (int) Integer.MIN_VALUE; 
				try {
					int temp = processList.get(0).getTimeOn();
					if (temp < lowestTime) {
						lowestTime = temp;
					}
				}
				catch (Exception eP) { 
				}
				 ArrayList<Queue<Process>> r = scheduler.resources;
				 for(int i = 0; i<r.size(); i++) {
					 try {
						 Block first = r.get(i).getNext().getBlockList().get(0);
						 int temp = first.getStart();
						 if (temp < lowestTime) {
							 lowestTime = temp;
						 }
					 }
					 catch (Exception eB) {
					 }
				 }
				 updateTime = lowestTime; 
			}  

			// but we need to update the blocks by the amount of work we did
			scheduler.updateBlocks(updateTime);
			clock += updateTime;
		}
	}
}
		