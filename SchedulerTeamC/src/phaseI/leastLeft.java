package phaseI;

public class leastLeft implements Test<Process>{
	
	public Boolean p(Process val1, Process val2) {
		return (val1.getWorkLeft() <= val2.getWorkLeft());
	}
}