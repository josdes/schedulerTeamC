package phaseI;

public class Process3 extends Process {	
	public Process3(int priority, int timeOn) {
		super(priority, timeOn);
	}
	
	public int getType() {
		return 2;
	}
	
	public int generateWork() { 
		return RandomNumberGenerator.random("workIII");
	}

	public void generateBlocks(int work) {  
		int i = RandomNumberGenerator.random("blockIII");
		while (i< work) {
			int interval = RandomNumberGenerator.random("blockIII");
			double resource = RandomNumberGenerator.random();
			if (resource < 0.5) {
				blockList.add(new BlockA(i));
			}
			else if (resource < 0.85) {
				blockList.add(new BlockB(i));
			}
			else {
				blockList.add(new BlockC(i));
			}
			i += interval;
		}
	}

}
