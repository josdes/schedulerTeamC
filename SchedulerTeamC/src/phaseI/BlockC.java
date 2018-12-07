package phaseI;

public class BlockC extends Block {

	public BlockC(int start) {
		super(start);
		work = RandomNumberGenerator.random("workC");
	}
	
	public String getResource() {
		return "C";
	}

}
