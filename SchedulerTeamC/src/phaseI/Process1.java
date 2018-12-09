package phaseI;

public class Process1 extends Process {
	
	public Process1(int priority, int timeOn) {
		super(priority, timeOn);
	}
	
	public int getType() {
		return 1;
	}
 
	public int generateWork() { 
		return RandomNumberGenerator.random(25, 75);
	}
 
	public void generateBlocks() { 
		double block = RandomNumberGenerator.random();
		if (block < 0.40) {
			
		}
		else {
			int start = RandomNumberGenerator.random(1, this.getWork()-1);
			double resource = RandomNumberGenerator.random();
			if (resource < 0.50) {
				blockList.add(new BlockA(start)); 
				}
			else {
				blockList.add(new BlockB(start));
			}
		}
	}

}
