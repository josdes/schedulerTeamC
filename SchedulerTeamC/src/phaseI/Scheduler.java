package phaseI;

import java.util.ArrayList;

public class Scheduler {
	public Queue<Process> readyQueue;
	public Queue<Process> A, B, C = new Queue<Process>(RunSchedulers.falseProcess);
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
		return readyQueue.isEmpty() && A.isEmpty() && B.isEmpty() && C.isEmpty();
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
			resources.get(0).addIn(proc);
		}
		if(res == "C") {
			resources.get(0).addIn(proc);
		}
	}
	
	public void updateBlocks(int num) {
		for(int i = 0; i < resources.size(); i++) {
			int decrement = num;
			Boolean go = true; 
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
						decrement -= top.getWork();
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
		}
	}

	public void generateReadyQueueReport() throws Exception
	{
		ArrayList<Process> q = readyQueue.getQueue();

		for (int i=0; i<readyQueue.getLength(); i++)
		{
			System.out.println("Process ID: " + i);
			System.out.println("Process Type: " + q.get(i).getType());
			System.out.println("Process Arrival Time: " + q.get(i).getTimeOn());
			System.out.println("Process Running Time: " + q.get(i).getWork());
			System.out.println("Blocks: " + q.get(i).generateBlockReport());
			System.out.println("Total Block Time: " + q.get(i).getBlockTotal());
			System.out.println("Total Running Time: " + (q.get(i).getWork() + q.get(i).getBlockTotal()));
		}
	}
}
