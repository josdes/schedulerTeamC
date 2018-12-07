package phaseI;

public class BlockB extends Block {

	public BlockB(int start) {
		super(start); 
		work = RandomNumberGenerator.random(75, 125);
	}
	
	public String getResource() {
		return "B";
	}

}
