package phaseI;

import java.util.ArrayList;

public class Copy {
	public static ArrayList<Process> copyProcesses(ArrayList<Process> pList) {
		ArrayList<Process> pListCopy = new ArrayList<Process>();
		for (int i = 0; i <pList.size(); i++) {
			Process p = pList.get(i);
			System.out.println("Process Type: " + p.getType());
			int type = p.getType();
			Process pCopy;
			if(type == 1) {
				pCopy = new Process1(p.getPriority(), p.getTimeOn());
			}
			else if(type == 2) {
				pCopy = new Process2(p.getPriority(), p.getTimeOn());
			}
			else if(type == 3) {
				pCopy = new Process3(p.getPriority(), p.getTimeOn());
			}
			else {
				pCopy = new Process4(p.getPriority(), p.getTimeOn());
			}
			pCopy.blockList = copyBlockList(p.getBlockList());
			pCopy.work = p.getWork();
			pListCopy.add(pCopy);
		}
		return pListCopy;
	}
	
	public static ArrayList<Block> copyBlockList(ArrayList<Block> bList){
		ArrayList<Block> bListCopy = new ArrayList<Block>();
		for(int i = 0; i<bList.size(); i++) {
			Block bCopy;
			Block b = bList.get(i);
			String type = b.getResource();
			if(type == "A") {
				bCopy = new BlockA(b.getStart());
			}
			if(type == "B") {
				bCopy = new BlockB(b.getStart());
			}
			else {
				bCopy = new BlockC(b.getStart());
			}
			bCopy.work = b.getWork();
			bListCopy.add(bCopy);
		}
		return bListCopy;
	}
}
