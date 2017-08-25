import java.util.ArrayList;

import javax.swing.JOptionPane;

public class Automata {
	public ArrayList<Node> graph;
	public Node cNode;
	
	public void init()
	{
		for(Node node: graph)
		{
			if(node.startingNode)
			cNode = node;
				
			
		}
	}
	public boolean read(char c)
	{
		for(Arc arc: cNode.outBounds)
		{
			if(c == arc.weight)
			{
				cNode = arc.Point;
				return true;
			}
		}
			return false;
	}
	public boolean validateString()
	{
		if(cNode.finalNode)
			return true;
		else
			return false;
	}


	public static void main(String args[])
	{
		Node s1 = new Node();
		s1.name = "s1";
		Node s2 = new Node();
		s2.name = "s2";
		s1.finalNode = true;
		s1.startingNode = true;
		Arc a = new Arc(s1,'1');
		Arc b = new Arc(s1,'0');
		Arc c = new Arc(s2,'0');
		Arc d = new Arc(s2,'1');
		s1.addOutBoundArc(a);
		s1.addOutBoundArc(c);
		s2.addOutBoundArc(d);
		s2.addOutBoundArc(b);
		ArrayList<Node> graph = new ArrayList<Node>();
		graph.add(s1);
		graph.add(s2);
		Automata nier = new Automata();
		nier.graph=graph;
		nier.init();
		System.out.println(nier.read(JOptionPane.showInputDialog("").charAt(0)));
		System.out.println(nier.cNode.name);
		
	}
}