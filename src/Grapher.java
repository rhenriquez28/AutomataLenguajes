import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.ScrollPane;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;



public class Grapher extends JPanel{
		private ArrayList<String> states;
		private static final int CIRCLE_RADIUS = 50;
		private static final int CIRCLE_SEPARATION = 75;
		private static final Color CURRENT_STATE_COLOR =new Color(250,128,141);
		private static final Color NON_CURRENT_STATE_COLOR =new Color(22,160,133);
		private static final Font DEFAULT_FONT = new Font("TimesRoman", Font.PLAIN,20);
		private static final Color RECTANGLE_COLOR =new Color(0,0,133);
		public String currentState;
		//250,128,141
	
	public Grapher(ArrayList<String> states,String cState)
	{
			this.states=states;
			 currentState=cState;
	}
	
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D)g;

		for(int i=0; i<states.size();i++)
		{
			System.out.println(i);
			if(currentState.equals(states.get(i)))
			{
				g.setColor(CURRENT_STATE_COLOR);
			}
			else
			{
				g.setColor(NON_CURRENT_STATE_COLOR);
			}
			g2.fillOval((CIRCLE_SEPARATION*u(0.0,(double)i)*2*i),100,CIRCLE_RADIUS,CIRCLE_RADIUS);
			//drawCenteredCircle(g2,,200);
			g2.setFont(DEFAULT_FONT);
			g.setColor(RECTANGLE_COLOR);
			g2.drawString(states.get(i),(CIRCLE_SEPARATION*u(0.0,(double)i)*2*i)+CIRCLE_RADIUS/2,100+CIRCLE_RADIUS/2);
			g2.drawRect((CIRCLE_SEPARATION*u(0.0,(double)i)*2*i)+CIRCLE_RADIUS, 100+CIRCLE_RADIUS/2, CIRCLE_SEPARATION+CIRCLE_RADIUS, 1);
		}
	
	}
	@Override
    public Dimension getPreferredSize() {
        return new Dimension(3000, 3000);
    }
	
	public void drawCenteredCircle(Graphics2D g, int x, int y, int r) {
		
		  x = x-(r/2);
		  y = y-(r/2);
		  
		  
		}
	public static void main(String args[])
	{
		ArrayList<String> s = new ArrayList<String>();
		s.add("a");
		s.add("b");
		s.add("c");
		s.add("d");
		s.add("f");
		Grapher gf = new Grapher(s,"b");
		JFrame f = new JFrame();
		ScrollPane scroll = new ScrollPane();
    	scroll.add(gf);
		f.add(scroll);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gf.currentState=JOptionPane.showInputDialog("");
		f.dispose();
		f.add(scroll);
		f.setVisible(true);
	}
	public static int u(double x,double val)
	{
		if(val>x)
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}

}
