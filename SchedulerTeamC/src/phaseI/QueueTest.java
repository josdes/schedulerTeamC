package phaseI;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class QueueTest { 
	
	Process p1 = new Process1(1, 0);
	Process p2 = new Process2(1, 0);
	Process p3 = new Process3(1, 0);
	Process p4 = new Process4(1, 0);
	
	public void prepTest() {
		//p1 has the least work
		//       the 2nd least work done
		//       the least work remaining
		p1.setWork(10);
		p1.setWorkDone(10); 
		//p2 has the second least work
		//       the 3rd least work done
		//       the 3rd least work remaining
		p2.setWork(15);
		p2.setWorkDone(11);
		//p3 has the 3rd least work
		//       the 4th least work done
		//       the 2nd least work remaining
		p3.setWork(20);
		p3.setWorkDone(17);
		//p4 has the 4th least work
		//       the least work done
		//       the 4th least work remaining
		p4.setWork(25);
		p4.setWorkDone(5);
	}
	
	public Boolean typesEqual(Queue<Process> q1, Queue<Process> q2) {
		ArrayList<Process> q1List = q1.queue;
		ArrayList<Process> q2List = q2.queue;
		for(int i = 0; i<q1List.size(); i++) {
			int type1 = q1List.get(i).getType();
			int type2 = q2List.get(i).getType();
			System.out.println("Type 1 = " + type1 + "  Type2 = " + type2);
			if (type1 == type2) {
				
			}
			else {
				return false;
			}
		}
		return true;
	}

	public void printQueue(ArrayList<Process> q) {
		System.out.println("");
		for(int i = 0; i<q.size(); i++) {
			System.out.print(q.get(i).getType());
		}
	}
	
	@Test
	void testAlwaysFalse() {
		prepTest();
		Queue<Process> Q = new Queue<Process>(new alwaysFalse<Process>());
		Queue<Process> QTest = new Queue<Process>(new alwaysFalse<Process>());
		QTest.addFront(p4);
		QTest.addFront(p3);
		QTest.addFront(p2);
		QTest.addFront(p1);
		Q.addIn(p1);
		Q.addIn(p2);
		Q.addIn(p3);
		Q.addIn(p4);
		System.out.print("Should be: ");
		printQueue(QTest.queue);
		System.out.print("\nIs: ");
		printQueue(Q.queue);
		System.out.println("");
		assertTrue(typesEqual(Q, QTest));
	}
	
	@Test
	void testLeastDone() {
		prepTest();
		Queue<Process> Q = new Queue<Process>(new leastDone());
		Queue<Process> QTest = new Queue<Process>(new alwaysFalse<Process>());
		QTest.addFront(p3);
		QTest.addFront(p2);
		QTest.addFront(p1);
		QTest.addFront(p4);
		Q.addIn(p1);
		Q.addIn(p2);
		Q.addIn(p3);
		Q.addIn(p4);
		System.out.print("Should be: ");
		printQueue(QTest.queue);
		System.out.print("\nIs: ");
		printQueue(Q.queue);
		System.out.println("");
		assertTrue(typesEqual(Q, QTest));
	}
	
	@Test
	void testLeastLeft() {
		prepTest();
		Queue<Process> Q = new Queue<Process>(new leastLeft());
		Queue<Process> QTest = new Queue<Process>(new alwaysFalse<Process>());
		QTest.addFront(p4);
		QTest.addFront(p2);
		QTest.addFront(p3);
		QTest.addFront(p1);
		Q.addIn(p1);
		Q.addIn(p2);
		Q.addIn(p3);
		Q.addIn(p4);
		System.out.print("Should be: ");
		printQueue(QTest.queue);
		System.out.print("\nIs: ");
		printQueue(Q.queue);
		System.out.println("");
		assertTrue(typesEqual(Q, QTest));

	}
	
	@Test
	void testLeastWork() {
		prepTest();
		Queue<Process> Q = new Queue<Process>(new leastWork());
		Queue<Process> QTest = new Queue<Process>(new alwaysFalse<Process>());
		QTest.addFront(p4);
		QTest.addFront(p3);
		QTest.addFront(p2);
		QTest.addFront(p1);
		Q.addIn(p1);
		Q.addIn(p2);
		Q.addIn(p3);
		Q.addIn(p4);
		System.out.print("Should be: ");
		printQueue(QTest.queue);
		System.out.print("\nIs: ");
		printQueue(Q.queue);
		System.out.println("");
		assertTrue(typesEqual(Q, QTest));

	}
	

}
