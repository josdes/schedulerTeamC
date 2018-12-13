package phaseI;

public abstract class Block {
	int start;
	int work;
	
	public abstract String getResource();
	
	public Block(int start) {
		this.start = start;
	}
	
	public int getWork() {
		return work;
	}
	
	public int getStart() {
		return start;
	}
	
	public void updateBlock(int num) {
		work -= num;
	}
	
	public String generateReport() {
		return "\n"+
				"Resource: " + getResource() + 
				" --- Block Length: " + getWork() +
				" --- Start Time: " + getStart();
	}
	
}
