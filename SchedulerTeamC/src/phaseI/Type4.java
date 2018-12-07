package phaseI;

public class Type4 extends Process {
	
	int interval = RandomNumberGenerator.random(40, 120);
	
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
		int start = RandomNumberGenerator.random(0, interval);
		for (int i = start; i< work; i+=interval) {
			double resource = RandomNumberGenerator.random();
			if (resource < 0.5) { 
				blockList.add(new BlockB(i));
			}
			else {
				blockList.add(new BlockC(i));
			}
		}
	}

}
