package phaseI;

import java.util.Random;

public class RandomNumberGenerator {
	Random rand = new Random();
	
	//Random Number within a given Range
	public double random(int floor, int ceiling) {
		return rand.nextInt((ceiling+1) - floor) + floor;
	}
	
	//Returns a random number between 0 and 1
	public double random(){
		return Math.random();
	}
	
	//Returns a random number with a non-uniform distribution
	public double random(String key) {
		if (key == "workII") {
			return nonUniform(200, 600, 5/3);
		}
		if (key == "workIII") {
			return nonUniform(150, 500, 5/2);
		}
		if (key == "processIII") {
			return nonUniform(25, 75, 7/3);
		}
		if (key == "lengthC") {
			return nonUniform(100, 400, 2);
		}
		else {
			return -1;
		}
	}
	
	public double nonUniform(int low, int high, int frac) {
		return Math.ceil((low + (high - low)* Math.pow(random(), frac)));
	}
	
	
}
