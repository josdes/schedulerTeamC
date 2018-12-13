package phaseI;

public class Process4 extends Process {
	
	public Process4(int priority, int timeOn) {
		super(priority, timeOn);
	}
	
	public int getType() {
		return 4;
	}

	public int generateWork() { 
		return RandomNumberGenerator.random(400, 1000);
	}

	public void generateBlocks(int work) {  
		int i = RandomNumberGenerator.random(40, 120);
		while (i< work) {
			int interval = RandomNumberGenerator.random(40, 120);
			double resource = RandomNumberGenerator.random();
			if (resource < 0.5) { 
				blockList.add(new BlockB(i));
			}
			else {
				blockList.add(new BlockC(i));
			}
			i += interval;
		}
	}

}
