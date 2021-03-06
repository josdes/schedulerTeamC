package phaseI;

import java.util.ArrayList;

public class Scheduler {
	public Queue<Process> readyQueue;
	public Queue<Process> A = new Queue<Process>(RunSchedulers.falseProcess);
	public Queue<Process> B = new Queue<Process>(RunSchedulers.falseProcess);
	public Queue<Process> C = new Queue<Process>(RunSchedulers.falseProcess);
	public ArrayList<Queue<Process>> resources = new ArrayList<Queue<Process>>();
	public Boolean slice;
	public Pred<Process> pred;
	
	public Scheduler(Pred<Process> pred, Boolean slice) {
		this.slice = slice;
		this.pred = pred;
		readyQueue = new Queue<Process>(pred);
		resources.add(A);
		resources.add(B);
		resources.add(C);
	}
	
	public void addIn(Process next) {
		readyQueue.addIn(next);
	}
	
	public void addFront(Process next) {
		readyQueue.addFront(next);
	}
	
	public Boolean isDone() {
		return (readyQueue.isEmpty() && A.isEmpty() && B.isEmpty() && C.isEmpty());
	}
	
	public Process getNext() throws Exception{
		if(isDone()) {
			throw new Exception("queue is empty");
		}
		else {
			try{
				return readyQueue.pop();
			}
			catch (Exception e){
				throw new Exception(e.getMessage());
			}
		}
	}
	
	public Queue<Process> getReady(){
		return readyQueue;
	}
	
	public void addBlock(Process proc) {
		String res = proc.blockList.get(0).getResource();
		if(res == "A") {
			resources.get(0).addIn(proc);
		}
		if(res == "B") {
			resources.get(1).addIn(proc);
		}
		if(res == "C") {
			resources.get(2).addIn(proc);
		}
	}
	public void addBlockFront(Process proc) {
		String res = proc.blockList.get(0).getResource();
		if(res == "A") {
			resources.get(0).addFront(proc);
		}
		if(res == "B") {
			resources.get(1).addFront(proc);
		}
		if(res == "C") {
			resources.get(2).addFront(proc);
		}
	}
	
	public void updateBlocks(int num, String skipFirst) {
		for(int i = 0; i < resources.size(); i++) { 
			int decrement = num;
			Boolean go = true; 
			Process hold = new Process1(-1, -1);
			if((skipFirst == "A" && i == 0) ||
				(skipFirst == "B" && i == 1) ||
				(skipFirst == "C" && i ==2)) {
				try {
					hold = resources.get(i).pop();
				} catch (Exception e) {  
					System.out.println("MAJOR PROBLEM");
				}
			}
			while(go) {
				try {
					//remove the first process from the block dude
					Process top = resources.get(i).pop();
					//we know for a fact it has a next block but we have to do this
					//get the next block from the process and remove it
					Block nextBlock = top.getNextBlock(); 
					top.blockList.remove(0);
					//if the block is not removed completely, then we need to update
					//   the block, then add it back to the front of the block list
					//   and then add the updated process back onto the resource queue
					//   and make sure that we stop trying to decrement things because
					//   we've used up our number
					if(nextBlock.getWork() > decrement) {
						nextBlock.updateBlock(decrement);
						top.blockList.add(0, nextBlock);
						resources.get(i).addFront(top);
						go = false;
					}
					else {
						//otherwise we want to lower the number by the amount of work we did
						decrement -= nextBlock.getWork();
						//we want to get rid of that block
						top.blockList.remove(0);
						//and we want to add the blocked item back into the readyQUeue
						readyQueue.addIn(top);
						//and we want to keep going
					}
				}
			
				catch (Exception e) {
				//if there's nothing on the resource queue then
				// there's nothing we can do and nothing we should do
				// we just keep going
					go = false;
				}
			}
			if(!(hold.getTimeOn() == -1)) {
				addBlockFront(hold);
			}
		}
	}
}
