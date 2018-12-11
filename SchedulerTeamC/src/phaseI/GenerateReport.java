package phaseI;

public class GenerateReport {
	
	//GenerateReport: prints a report on each process in the given ready queue
	public void GenerateReport(readyQueue) 
	{
		q = readyQueue.getQueue();

		for (i=0, i<q.getLength(), i++)
		{
			System.out.println("Process ID: " + i);
			System.out.println("Process Type: " + q[i].getType());
			System.out.println("Process Arrival Time: " + q[i].getTimeOn());
			System.out.println("Process Running Time: " + q[i].getWork());
			System.out.println("Process Time Running: " + q[i].getWorkDone());
			System.out.println("Process List of Blocks: " + q[i].getBlockList());
			System.out.println("Process Total Blocking Time: " + q[i].getBlockTotal());
		}
	}
}
