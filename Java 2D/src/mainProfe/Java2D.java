package java2d;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

/**
 *
 * @author leand
 */
public class Java2D extends JApplet
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        JFrame f = new JFrame();
        f.setTitle("Holas");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JApplet ap = new Java2D();
        ap.init();
        f.getContentPane().add(ap);
        f.pack();
        f.setVisible(true);
    }
    
    public void init()
    {
       JPanel panel = new panel2D();
       getContentPane().add(panel);
    }
    
}

class panel2D extends JPanel
{
    public panel2D()
    {
        setPreferredSize(new Dimension(640, 480));
    }
    
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.blue);
        Ellipse2D e = new Ellipse2D.Double(-100, -50, 200, 100);
        AffineTransform tr = new AffineTransform();
        tr.rotate(Math.PI / 6.0);
        Shape sh = tr.createTransformedShape(e);
        g2.translate(300, 200);
        g2.scale(2, 2);
        g2.draw(sh);
        g2.drawString("Hola mundito", 0, 0);
        g2.setColor(Color.GREEN);
        g2.draw(e);
    }
}