package phaseI;

import java.util.Random;

public class RandomNumberGenerator {
	static Random rand = new Random();
	
	//Random Number within a given Range
	public static int random(int floor, int ceiling) {
		return rand.nextInt((ceiling+1) - floor) + floor;
	}
	
	//Returns a random number between 0 and 1
	public static double random(){
		return Math.random();
	}
	
	//Returns a random number with a non-uniform distribution
	public static int random(String key) {
		if (key == "workII") {
			return nonUniform(200, 600, 5/3);
		}
		if (key == "workIII") {
			return nonUniform(150, 500, 5/2);
		}
		if (key == "blockIII") {
			return nonUniform(25, 75, 7/3);
		}
		if (key == "lengthC") {
			return nonUniform(100, 400, 2);
		}
		else {
			return -1;
		}
	}
	
	public static int nonUniform(int low, int high, int frac) {
		return (int) Math.ceil((low + (high - low)* Math.pow(random(), frac)));
	}
	
}
