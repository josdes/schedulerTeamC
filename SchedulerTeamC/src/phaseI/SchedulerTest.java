package phaseI;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class SchedulerTest {
	public void printQueue(ArrayList<Process> q) {
		System.out.println("");
		for(int i = 0; i<q.size(); i++) {
			System.out.print(q.get(i).getType() + " ");
		}
	}
	
	RunSchedulers runIt = new RunSchedulers();
	
	Pred<Process> aFalse = runIt.falseProcess;
	Pred<Process> lWork = runIt.leastW;
	Pred<Process> lDone = runIt.leastD;
	Pred<Process> lLeft = runIt.leastL;
	
	Scheduler fifo = runIt.fifo;
	Scheduler rr = runIt.rr;
	Scheduler shortest = runIt.shortest;
	Scheduler left = runIt.left;
	Scheduler done = runIt.done;

	@Test
	void test() {
		assertTrue(fifo.isDone());
		fifo.addIn(ProcessGenerator.generateProcess(5));
		fifo.addIn(ProcessGenerator.generateProcess(6));
		assertTrue(fifo.readyQueue.queue.size() == 2);
		assertTrue(fifo.readyQueue.queue.get(0).getTimeOn() == 5);
		assertTrue(fifo.readyQueue.queue.get(1).getTimeOn() == 6);
		
		rr.addIn(ProcessGenerator.generateProcess(5));
		rr.addIn(ProcessGenerator.generateProcess(6));
		assertTrue(rr.readyQueue.queue.size() == 2);
		assertTrue(rr.readyQueue.queue.get(0).getTimeOn() == 5);
		assertTrue(rr.readyQueue.queue.get(1).getTimeOn() == 6);
		
		Process temp1 = ProcessGenerator.generateProcess(5);
		Process temp2 = ProcessGenerator.generateProcess(6);
		temp1.setWork(50);
		temp2.setWork(30);
		shortest.addIn(temp1);
		shortest.addIn(temp2);
		assertTrue(shortest.readyQueue.queue.size() == 2);
		assertTrue(shortest.readyQueue.queue.get(0).getTimeOn() == 6);
		assertTrue(shortest.readyQueue.queue.get(1).getTimeOn() == 5);
		
		Block block1 = new BlockA(1);
		block1.work = 20;
		Block block2 = new BlockA(2);
		block2.work = 30;
		Block block3 = new BlockB(3);
		block3.work = 30;
		Block block5 = new BlockB(5);
		block5.work = 10;
		Block block4 = new BlockC(4);
		block4.work = 60;
		
		ArrayList<Block> blockArray = new ArrayList<Block>();
		blockArray.add(block1);
		blockArray.add(block2);
		blockArray.add(block3);
		blockArray.add(block4);
		blockArray.add(block5);
		temp1.blockList = blockArray;
		left.addBlock(temp1); 
		
		try {
			assertTrue(left.A.getNext() == temp1);
		}
		catch (Exception e) {
			System.out.println(" ");
		}
		
		left.updateBlocks(10, "D");   
		try { 
			assertTrue(left.A.getNext() == temp1);
		}
		catch (Exception e) {
			System.out.println(" ");
		}
		
		left.updateBlocks(10, "D"); 
		try {  
			assertTrue(left.readyQueue.getNext().getTimeOn() == temp1.getTimeOn());
		}
		catch (Exception e) {
			System.out.println(" ");
		}
	}

}
