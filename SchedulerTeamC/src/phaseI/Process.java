package phaseI;

import java.util.ArrayList;

public abstract class Process {
    int priority; 
	int work;
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
	
	public int getPriority() {
		return priority;
	}

	public int getWork() {
		return work;
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
	
	public void reduceWork(int num) {
		work = work - num;
	}
	
}
