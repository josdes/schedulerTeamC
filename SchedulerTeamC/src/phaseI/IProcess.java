package phaseI;

import java.util.ArrayList;

public interface IProcess {
	public int getPriority();
	public int getType();
	public int getWork();
	public int getBlockTotal();
	public ArrayList<Block> getBlockList();
	public String generateReport(int id);
}
