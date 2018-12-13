package phaseI;

public class leastWork implements Pred<Process> {

	public Boolean p(Process val1, Process val2) {
		return val1.getWork() <= val2.getWork();
	}

}
