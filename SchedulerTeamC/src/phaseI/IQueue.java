package phaseI;

import java.util.ArrayList;

public interface IQueue {
	public Process getBottom() throws Exception;
	public ArrayList<Process> getQueue() throws Exception;
	public int totalQueue();
	public int totalBlock();
	public int totalRuntime();

}
