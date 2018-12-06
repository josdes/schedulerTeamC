package phaseI;

import java.util.ArrayList;

public class Type3 extends Process {

	public Type3(int priority) {
		super(priority);
		work = generateWork();
	}
	
	public int generateWork() { 
		return RandomNumberGenerator.random("WorkIII");
	}

	public ArrayList<Block> generateBlocks() { 
		return null;
	}

}
