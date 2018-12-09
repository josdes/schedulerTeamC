package phaseI;

public class Process3 extends Process {
	public int interval = RandomNumberGenerator.random("blockIII");
	
	public Process3(int priority, int timeOn) {
		super(priority, timeOn);
	}
	
	public int getType() {
		return 2;
	}
	
	public int generateWork() { 
		return RandomNumberGenerator.random("workIII");
	}

	public void generateBlocks() { 
		int start = RandomNumberGenerator.random(0, interval);
		for (int i = start; i< work; i+=interval) {
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
		}
	}

}
