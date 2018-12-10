package phaseI;

public class leastLeft implements Test<Process>{
	
	public Boolean p(Process val1, Process val2) {
		return (val1.getWork() - val1.getWorkDone())
				<= 
				(val2.getWork() - val2.getWorkDone());
	}
}
