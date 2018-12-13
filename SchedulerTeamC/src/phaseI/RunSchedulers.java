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
	
	public void generateBeginReport() {
		int totalRunning = 0;
		int totalBlocking = 0; 
		int type1Count = 0;
		int type2Count = 0;
		int type3Count = 0;
		int type4Count = 0;
		for (int i=0; i<startList.size(); i++)
		{ 
			System.out.println("Process ID: " + i);
			int tempType = startList.get(i).getType();
			System.out.println("Process Type: " + tempType);
			System.out.println("Process Arrival Time: " + startList.get(i).getTimeOn());
			int runTime = startList.get(i).getWork();
			System.out.println("Process Running Time: " + runTime);
			System.out.println(startList.get(i).generateBlockReport());
			int blockTime = startList.get(i).getBlockTotal();
			System.out.println("Total Block Time: " + blockTime);
			int totalTime = runTime+blockTime;
			System.out.println("Total Running Time: " + totalTime);
			totalRunning += runTime;
			totalBlocking += blockTime; 
			if(tempType == 1) {
				type1Count ++;
			}
			if(tempType == 2) {
				type2Count ++;
			}
			if(tempType == 3) {
				type3Count ++;
			}
			if(tempType == 4) {
				type4Count ++;
			}
		}

		int total = totalRunning + totalBlocking;
		System.out.println("");
		System.out.println("QUEUE SUMMARY");
		System.out.println("Running for Queue: " + totalRunning);
		System.out.println("Blocking for Queue: " + totalBlocking);
		System.out.println("Total Running for Queue: " + total);
		System.out.print("Processes of Type: 1 = " + type1Count +
				"     ---     2 = " + type2Count +
				"     ---     3 = " + type3Count +
				"     ---     4 = " + type4Count );
	}
	
	public void generateEndReport() {
		for(int i = 0; i < finishedProcesses.size(); i++) {
			Process current = finishedProcesses.get(i);
			System.out.println("Arrived at: " + current.timeOn);
			System.out.println("Finished at: " + current.finishTime);
			int tempWork = current.work;
			int tempBlock = current.getBlockTotal();
			int tempIdeal = tempWork + tempBlock;
			System.out.println("Ideal finished time: " + tempIdeal);
		}
	}
	
	public void runAll() {
		generateBeginReport();
		for(int i = 0; i<schedulers.length; i++) {
			processList = Copy.copyProcesses(startList);
			finishedProcesses = new ArrayList<Process>();
			run(schedulers[i]);
			generateEndReport();
		}
	}
	
	public void run(Scheduler scheduler) { 
		int clock = 0;  
		int timeSlice = 100;  
		while(!((scheduler.isDone()) && processList.isEmpty())) {  
			while(processList.get(0).getTimeOn()<= clock) {
				System.out.println("Adding process");
				scheduler.addIn(processList.get(0));
				processList.remove(0); 
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
						System.out.println("Next process on ready has block");
					}
				catch (Exception e0){
					//if there is no block, then we can just work through the process
					wL = process.getWorkLeft(); 
					blocks = false;
					System.out.println("Next process on ready does not have block");
				}
				
				//then we take the amount of work we can do before something goes wrong and
				// we act accordingly
				if(scheduler.slice && (wL > timeSlice)) {
					process.updateWork(timeSlice);
					scheduler.addIn(process);
					updateTime = timeSlice;
					System.out.println("Reducing work of processes by time Slice");
				}
				//otherwise the process is just done, and we can get rid of it  
				else {
					//add whatever blocked to the block queue and keep gong
					if(blocks) {
						System.out.println("Adding process to block queue");
						scheduler.addBlock(process);
					}
					else {
						System.out.println("Adding process to finished list");
						finishedProcesses.add(process); 
					}
					updateTime = wL;
				}
			}
			catch (Exception e){
				//if there is no next process then we just have to update by
				// the time it takes for the next process to get on the readyQueue
				// this can either be something coming off the blockQueue or 
				// something joining the ready queue
				int lowestTime = (int) Integer.MAX_VALUE; 
				try {
					int tempTimeOn = processList.get(0).getTimeOn();
					if (tempTimeOn < lowestTime) {
						lowestTime = tempTimeOn;
					}
				}
				catch (Exception eP) {
					System.out.println("No processes left in the list");
					//there were no processes left on the list, everything is on the block queues
				}
				ArrayList<Queue<Process>> r = scheduler.resources;
				System.out.println("Finding lowest time in blocks");
				for(int i = 0; i<r.size(); i++) {
					 try {
						 System.out.println(i);
						 Block first = r.get(i).getNext().getBlockList().get(0);
						 int temp = first.getStart();
						 if (temp < lowestTime) {
							 lowestTime = temp;
						 }
					 }
					 catch (Exception eB) {
						 System.out.println("Nothing on block: " + i);
					 }
				 }
				 if (lowestTime < (int) Integer.MAX_VALUE) {
					 updateTime = lowestTime - clock;
				 }
				 else {
					 System.out.println("HUGE PROBLEM");
				 }
			}  
			System.out.println("Updating blocks");
			// but we need to update the blocks by the amount of work we did
			scheduler.updateBlocks(updateTime); 
			//this should put blocks back on the ready queue, or let a process 
			// come off the process list when we loop
			System.out.println("Updating clock");
			clock += updateTime;
		}
	}
}
		