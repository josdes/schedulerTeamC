package phaseI;

import java.util.ArrayList;

public class Type4 extends Process {
	
	public Type4(int priority) {
		super(priority);
		work = generateWork();
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
