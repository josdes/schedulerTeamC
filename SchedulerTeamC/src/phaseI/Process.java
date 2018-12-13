package phaseI;

import java.util.ArrayList;

public abstract class Process {
    public int priority; 
	public int work; 
	public int workDone = 0;
	public int timeOn;
	public int finishTime;
	ArrayList<Block> blockList = new ArrayList<Block>();
	
	public Process(int p, int t) {
		priority = p;
		work = generateWork(); 
		timeOn = t;
		generateBlocks(work);
	}
	
	public abstract int generateWork(); 
	public abstract void generateBlocks(int w);
	public abstract int getType();
	
	public Boolean isDone() {
		return workDone == work;
	}
	
	public int getFinish() {
		return finishTime;
	}
	
	public void setFinish(int n) {
		finishTime = n;
	}
	
	public int getPriority() {
		return priority;
	}
	
	public int getTimeOn() {
		return timeOn;
	}

	public int getWork() {
		return work;
	}
	
	public void setWork(int w) {
		work = w;
	}
	
	public int getWorkDone() {
		return workDone;
	}
	
	public void setWorkDone(int n) {
		workDone = n;
	}
	
	public int getWorkLeft() {
		return getWork() - getWorkDone();
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
	
	public Boolean blocks() {
		return !blockList.isEmpty();
	}
	
	public Block getNextBlock() throws Exception { 
		if (blocks()) {
			return blockList.get(0); 
		}
		else {
			throw new Exception("blocklist is empty");
		}
		
	}
	
	public void updateWork(int num) { 
		workDone += num;
	}
	

	public String generateBlockReport() {
		String report = "Block Report \n";
		for(int i= 0; i<blockList.size(); i++) {
			report = report + blockList.get(i).generateReport() + "\n";
		}
		return report;
	} 
}
