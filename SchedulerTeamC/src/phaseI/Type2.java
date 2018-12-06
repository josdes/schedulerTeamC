package phaseI;

import java.util.ArrayList;

public class Type2 extends Process {
	
	public Type2(int priority) {
		super(priority);
		work = generateWork();
	}
	
	public int getType() {
		return 2;
	}
 
	public int generateWork() { 
		return RandomNumberGenerator.random("WorkII");
	}

	public ArrayList<Block> generateBlocks() { 
		return null;
	}

}
