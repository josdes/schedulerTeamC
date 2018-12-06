package phaseI;

import java.util.ArrayList;

public class Type1 extends Process {
	
	public Type1(int priority) {
		super(priority);
		work = generateWork();
	}
 
	public int generateWork() { 
		return RandomNumberGenerator.random(25, 75);
	}
 
	public ArrayList<Block> generateBlocks() { 
		return null;
	}

}
