package phaseI;

import java.util.ArrayList;

public class ProcessGenerator {
	
	public static ArrayList<Process> populateReady(int limit){
		ArrayList<Process> getReady = new ArrayList<Process>(); 
		int current = 0;
		int time = 0;
		while (current <= limit) {
			Process next = generateProcess(time);
			time += RandomNumberGenerator.random(10, 810);
			current += next.getWork();
		}
		return getReady;
	}
	
	public static Process generateProcess(int timeOn) {
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
	

	public static int generatePriority() {
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
