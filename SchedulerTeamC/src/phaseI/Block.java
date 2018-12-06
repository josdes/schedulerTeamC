package phaseI;

public abstract class Block {
	int start;
	int length;
	String resource;
	
	public Block(int start) {
		this.start = start;
	}
	
	public int getLength() {
		return length;
	}
	
	public String getResource() {
		return resource;
	}
}
