package phaseI;

public class Type2 extends Process {
	
	public Type2(int priority) {
		super(priority); 
	}
	
	public int getType() {
		return 2;
	}
 
	public int generateWork() { 
		return RandomNumberGenerator.random("workII");
	}

	public void generateBlocks() { 
		
	}

}
