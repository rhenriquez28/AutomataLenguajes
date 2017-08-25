import java.util.ArrayList;

public class Node {
	public String name;
	public boolean finalNode=false;
	public boolean startingNode=false;
	public ArrayList<Arc> outBounds = new ArrayList<Arc>();
	
	public void addOutBoundArc(Arc arc)
	{
		outBounds.add(arc);
	}
}
