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
        f.setSize(400,400);
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
