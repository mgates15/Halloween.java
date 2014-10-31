import java.awt.*;

import javax.swing.*;

public class Halloween1 extends JPanel {
	public void paint(Graphics g){
		super.paintComponent(g);
		g.setColor(Color.red);
		g.fillOval(200, 100, 75, 150);
		g.setColor(Color.orange);
		g.fillOval(225, 74, 25, 25);
		int xPoints[] = {175, 210, 210};
		int yPoints[] = {175, 125, 225};
		int x1Points[] = {295, 264, 264}; 
		int y1Points[] = {175, 125, 225};
		int numPoint = 3;
		g.fillPolygon(xPoints, yPoints, numPoint);
		g.fillPolygon(x1Points, y1Points, numPoint);
		g.drawLine(240, 245, 240, 400);
		g.drawString("Happy Halloween!!", 30, 40);
		g.drawString("This is dirtyfrazzers, the low key, spooky bat!", 150, 300 );
	}
	
	
	
public static void main(String[] args)
	{
	  JFrame window = new JFrame("Scary");

    
      window.setBounds(500, 500, 500, 500);
	  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	  window.setVisible(true);
	  Halloween1 panel = new Halloween1();
	  panel.setBackground(Color.black);
	  Container c = window.getContentPane();
	  c.add(panel);
	}

}



Program 2


import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
 
public class JOL extends JApplet {
    public void init() {
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(new JOLPanel());
        getContentPane().add(getLabel(), "Last");
    }
 
    private JLabel getLabel() {
        JLabel label = new JLabel("Killer Pumpkin", JLabel.CENTER);
        label.setFont(new Font("dialog", Font.BOLD, 36));
        return label;
    }
 
    public static void main(String[] args) {
        JOL applet = new JOL();
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(applet);
        f.setSize(300,300);
        f.setLocation(200,200);
        applet.init();
        f.setVisible(true);
    }
}
 
class JOLPanel extends JPanel {
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                            RenderingHints.VALUE_ANTIALIAS_ON);
        int w = getWidth();
        int h = getHeight();
        g2.setPaint(Color.orange);
        g2.draw(new Ellipse2D.Double(w/16, h/16, w*7/8, h*7/8));
        Ellipse2D.Double e = new Ellipse2D.Double(w/4, h/3, w*3/16, h*3/32);
        double x = e.getCenterX();
        double y = e.getCenterY();
        AffineTransform at = AffineTransform.getRotateInstance(Math.PI/9, x, y);
        Shape leftEye = at.createTransformedShape(e);
        at.setToTranslation(w, 0);
        at.scale(-1, 1);
        Shape rightEye = at.createTransformedShape(leftEye);
        Area mouth = new Area(new Ellipse2D.Double(w/4, h*8/16, w/2, h/3));
        Area a = new Area(new Ellipse2D.Double(w/8, h/3, w*3/4, h*5/12));
        mouth.subtract(a);
        g2.draw(mouth);
        g2.draw(leftEye);
        g2.draw(rightEye);
        g2.drawString("Happy Halloween Amigos!", 10, 20);
    }
}



Program 3


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.*;

import javax.swing.JApplet;
import javax.swing.Timer;


public class Ball extends JApplet
	implements ActionListener
	{
 
	/**
	 Data fields
	 */
	private int maxX = 400;
	private int maxY = 600;
	private int ballX = maxX / 2;
	private int ballY = maxY / 2;
	private int ballRadius = maxY / 4;
	private int ballRadius2 = maxY / 5;
	private int ballRadius3 = maxY / 9;
	
 
	private int xPos, yPos;  // hold the coordinates of the banner

	public void init()
	  {
	    Container c = getContentPane();
	    c.setBackground(Color.WHITE);
	    xPos = c.getWidth();
	    yPos = c.getHeight() / 2;
	    Timer clock = new Timer(30, this);  // fires every 30 milliseconds
	    clock.start();
	  }

	  // Called automatically after a repaint request
	  public void paint1(Graphics h)
	  {
	    super.paint(h);
	    h.drawString("/ O O \"", xPos, yPos);
	  }

	  // Called automatically when the timer fires
	  public void actionPerformed(ActionEvent e)
	  {
	    Container c = getContentPane();

	    // Adjust the horizontal position of the banner:
	    xPos--;
	    if (xPos < -100)
	    {
	      xPos = c.getWidth();
	    }

	    // Set the vertical position of the banner:
	    yPos = c.getHeight() / 2;

	    repaint();
	  }
	
	  
	//Methods
		public void paint(Graphics g){
		
		
		
	// Draw Ball
		g.drawOval(ballX - ballRadius,
				   ballY - ballRadius,
				   2 * ballRadius, 2 * ballRadius);
		g.setColor(Color.orange);
		
		
	//Draw Ball2
		g.drawOval(ballX - ballRadius2,
				   ballY - ballRadius,
				   2 * ballRadius2, 2 * ballRadius);
		g.setColor(Color.orange);
		
	//Draw Ball3
		g.drawOval(ballX - ballRadius3,
				   ballY - ballRadius,
				   2 * ballRadius3, 2 * ballRadius);
		g.setColor(Color.orange);
		
		g.drawString("Happy Halloween!!!", 50, 30);
		
				
	}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}

}
