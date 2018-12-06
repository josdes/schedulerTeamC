package phaseI;

public class ProcessesGenerator {
	
	public Process generateProcess() {
		double num = RandomNumberGenerator.random();
		int p = generatePriority();
		if (num < 0.50) {
			return new Type1(p);
		}
		else if (num < 0.80) {
			return new Type2(p);
		}
		else if (num < 0.97) {
			return new Type3(p);
		}
		else {
			return new Type4(p);
		}
		
	}
	

	public int generatePriority() {
		double num = RandomNumberGenerator.random();
		if (num < 0.50) {
			return 1;
		}
		else if (num < 0.70) {
			return 2;
		}
		else if (num < 0.80) {
			return 3;
		}
		else if (num < 0.90) {
			return 4;
		}
		else if (num < 0.95) {
			return 5;
		}
		else {
			return 6;
		}
	}
}
