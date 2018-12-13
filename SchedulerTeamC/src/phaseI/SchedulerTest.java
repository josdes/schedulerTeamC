package phaseI;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SchedulerTest {
	
	Pred<Process> aFalse = new alwaysFalse();
	Pred<Process> lWork = new leastWork();
	Pred<Process> lDone = new leastDone();
	Pred<Process> lLeft = new leastLeft();
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
