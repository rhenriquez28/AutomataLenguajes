import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.ScrollPane;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.*;


public class Grapher extends JPanel{
		private ArrayList<String> states;
		private static final int CIRCLE_RADIUS = 50;
		private static final int CIRCLE_SEPARATION = 75;
		private static final Color CURRENT_STATE_COLOR =new Color(250,128,141);
		private static final Color NON_CURRENT_STATE_COLOR =new Color(22,160,133);
		private static final Font DEFAULT_FONT = new Font("TimesRoman", Font.PLAIN,20);
		private static final Color RECTANGLE_COLOR =new Color(0,0,133);
		public String currentState;
		public Automata nier;
		public HashMap<Node,Point> circles = new HashMap<Node,Point>();
		public HashMap<Arc,Point> arcs= new HashMap<Arc,Point>();
		public HashMap<Arc,ArrayList<Point>> lines= new HashMap<Arc,ArrayList<Point>> ();
		//250,128,141
	
	public Grapher(Automata nier)
	{
			Point cCirclePos = new Point(CIRCLE_RADIUS,200);
			this.nier = nier;
			int i = 0;
			for(Node node: nier.graph)
			{
				if(i>0)
				{
					cCirclePos = new Point((int)cCirclePos.getX()+2*CIRCLE_RADIUS+CIRCLE_SEPARATION,200);
				}
				
					circles.put(node,cCirclePos);	
				i++;
			}
			for(Node node: nier.graph)
			{
				for(Arc arc: node.outBounds)
				{
					if(node.equals(arc.Point))
					{
						Point tmpPoint = new Point(circles.get(node).getLocation());
						tmpPoint.setLocation(+tmpPoint.x-0.76*CIRCLE_RADIUS+20, +tmpPoint.y-CIRCLE_RADIUS*0.65-40);
						arcs.put(arc, tmpPoint);
					}
					else
					{
						ArrayList<Point>lineCords = new ArrayList<Point>();
						Point p1 = new Point(circles.get(node).getLocation());
						Point p2 = new Point(circles.get(arc.Point).getLocation());
						lineCords.add(p1);
						lineCords.add(p2);
						lines.put(arc,lineCords);
					}
				}
			}
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		
		for(Map.Entry<Arc,ArrayList<Point>> entry : lines.entrySet()) {
			g2.setColor(RECTANGLE_COLOR);
		    Arc key = entry.getKey();
		    ArrayList<Point> value = entry.getValue();
		    g2.drawLine(value.get(0).x, value.get(0).y, value.get(1).x, value.get(1).y);
		   
		}
		for(Map.Entry<Arc, Point> entry : arcs.entrySet()) {
			g2.setColor(RECTANGLE_COLOR);
		    Arc key = entry.getKey();
		    Point value = entry.getValue();
		    g2.drawArc(value.x, value.y, CIRCLE_RADIUS, 70, 300,260);
		    System.out.print(value.x+"x");
		    System.out.print(value.y+"y");
		    
		}
		for(Map.Entry<Node, Point> entry : circles.entrySet()) {
		    Node key = entry.getKey();
		    Point value = entry.getValue();
		    if(key.equals(nier.cNode))
		    {
		    	g2.setColor(CURRENT_STATE_COLOR);
		    }
		    else
		    {
		    	g2.setColor(NON_CURRENT_STATE_COLOR);
		    }
		    drawCenteredCircle(g2,value.x,value.y,CIRCLE_RADIUS); 
		    g2.setColor(RECTANGLE_COLOR);
		    g2.setFont(DEFAULT_FONT);
		    if(key.finalNode && key.startingNode)
		    	g2.drawString("/"+key.name, value.x, value.y);
		    else
		    {
		    	if(key.startingNode)
		    		g2.drawString("+"+key.name, value.x, value.y);
		    	else
		    	{
		    		if(key.finalNode)
				    	g2.drawString("*"+key.name, value.x, value.y);
		    		else
		    			g2.drawString(key.name, value.x, value.y);
		    	}
		    		
		    	
		    }
		    	
		}

	
	}
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(3000, 3000);
    }
	
	public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
		
		  x = x-(r/2);
		  y = y-(r/2);
		  g.fillOval(x, y, r, r);
		  
		}
	public static void main(String args[])
	{
		String input="";
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
		while(true) 
		{
			Grapher gf = new Grapher(nier);
			JFrame f = new JFrame();
			ScrollPane scroll = new ScrollPane();
	    	scroll.add(gf);
			f.add(scroll);
			f.setVisible(true);
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			input=JOptionPane.showInputDialog("");
			if(input.equals("_"))
			{
				break;
			}
			if(!nier.read(input.charAt(0)))
			{
				JOptionPane.showMessageDialog(null,"Cadena no valida");
				f.dispose();
				//break;
				return;
			}
			f.dispose();
		}
		Grapher gf = new Grapher(nier);
		JFrame f = new JFrame();
		ScrollPane scroll = new ScrollPane();
    	scroll.add(gf);
		f.add(scroll);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		if(nier.validateString())
		{
			JOptionPane.showMessageDialog(null,"Cadena Valida");
		}
		else
		{
			JOptionPane.showMessageDialog(null,"Cadena no valida");
		}
		
	}
	
	

}
