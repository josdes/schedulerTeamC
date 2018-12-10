package phaseI;

import java.util.ArrayList;

public abstract class Process {
    int priority; 
	int work; 
	int workDone = 0;
	int timeOn;
	ArrayList<Block> blockList = new ArrayList<Block>();
	
	public Process(int p, int t) {
		priority = p;
		work = generateWork(); 
		timeOn = t;
		generateBlocks();
	}
	
	public abstract int generateWork(); 
	public abstract void generateBlocks();
	public abstract int getType();
	
	public Boolean isDone() {
		return workDone == work;
	}
	
	public int getPriority() {
		return priority;
	}

	public int getWork() {
		return work;
	}
	
	public int getWorkDone() {
		return workDone;
	}
	
	public int getBlockTotal() {
		if (this.getType() == 2) {
			return 0;
		}
		else {
			int sum = 0;
			for(int i = 0; i< blockList.size(); i++) {
				sum += blockList.get(i).getWork();
			}
			return sum;
		}
		
	}
	public ArrayList<Block> getBlockList(){
		return blockList;
	}
	
	public void updateWork(int num) { 
		workDone += num;
	}
	
}
