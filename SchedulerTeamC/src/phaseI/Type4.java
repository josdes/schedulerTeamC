package phaseI;

public class Type4 extends Process {
	
	public Type4(int priority) {
		super(priority);
	}
	
	public int getType() {
		return 2;
	}

	public int generateWork() { 
		return RandomNumberGenerator.random(400, 1000);
	}

	public void generateBlocks() { 
		 
	}

}
