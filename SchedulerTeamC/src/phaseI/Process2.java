package phaseI;

public class Process2 extends Process {
	
	public Process2(int priority, int timeOn) {
		super(priority, timeOn);
	}
	
	public int getType() {
		return 2;
	}
 
	public int generateWork() { 
		return RandomNumberGenerator.random("workII");
	}

	public void generateBlocks(int work) { 
		
	}

}
