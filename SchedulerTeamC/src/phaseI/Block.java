package phaseI;

public abstract class Block {
	int start;
	int length;
	
	public abstract String getResource();
	
	public Block(int start) {
		this.start = start;
	}
	
	public int getLength() {
		return length;
	}
	
}
