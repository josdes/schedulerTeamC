package phaseI;

public class BlockA extends Block {

	public BlockA(int start) {
		super(start);
		work = RandomNumberGenerator.random(60,100);
	}
 
	public String getResource() {
		return "A";
	}

}
