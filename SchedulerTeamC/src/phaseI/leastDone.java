package phaseI;

public class leastDone implements Pred<Process> {
	
	public Boolean p(Process val1, Process val2) {
		return val1.getWorkDone() <= val2.getWorkDone();
	}
}
