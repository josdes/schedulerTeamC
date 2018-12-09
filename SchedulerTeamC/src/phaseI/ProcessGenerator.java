package phaseI;

public class ProcessGenerator {
	
	public Queue<Process> populateReady(int limit){
		Queue<Process> getReady = new Queue<Process>(); 
		int current = 0;
		while (current <= limit) {
			Process next = generateProcess(current);
			current += next.getWork();
		}
	}
	
	public Process generateProcess(int timeOn) {
		double num = RandomNumberGenerator.random();
		int p = generatePriority();
		if (num < 0.50) {
			return new Process1(p, timeOn);
		}
		else if (num < 0.80) {
			return new Process2(p, timeOn);
		}
		else if (num < 0.97) {
			return new Process3(p, timeOn);
		}
		else {
			return new Process4(p, timeOn);
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
