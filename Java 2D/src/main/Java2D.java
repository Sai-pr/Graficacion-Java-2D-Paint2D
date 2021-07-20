/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

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

        //Serie 1
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.blue);
        Ellipse2D e = new Ellipse2D.Double(-50, -25, 100, 50);
        AffineTransform tr = new AffineTransform();
        g2.translate(125, 125);
        g2.scale(2, 2);
        for (int i = 0; i < 9; i++)
        {
            tr.rotate(Math.toRadians(20));
            Shape sh = tr.createTransformedShape(e);
            g2.draw(sh);
        }

        //Serie 2
        g2.translate(125, 0);

        float alto = 0.3f;
        for (int i = 0; i < 36; i++)
        {
            e = new Ellipse2D.Double(0, 0, 60 - i, 20 - alto);
            tr.rotate(Math.toRadians(20));
            Shape sh = tr.createTransformedShape(e);
            g2.draw(sh);
            if (i % 2 == 0)
            {
                g2.setColor(Color.magenta);
            } else
            {
                g2.setColor(Color.blue);
            }
        }

        //Reloj de arena
        g2.translate(-100, 75);
        g2.setColor(Color.DARK_GRAY);
        Polygon poly = new Polygon();
        poly.addPoint(-70, 24);
        poly.addPoint(-54, 24);
        poly.addPoint(-61, 16);
        poly.addPoint(-70, 6);
        poly.addPoint(-54, 6);
        poly.addPoint(-63, 16);
        g2.draw(poly);

        //Espiral de rectangulo
        g2.translate(7, 23);
        for (int i = 0; i < 8; i++)
        {
            Rectangle2D r2d = new Rectangle2D.Double(0, 0, 40 - (i * 5), 7);
            tr.rotate(Math.toRadians(20));
            Shape sh = tr.createTransformedShape(r2d);
            g2.draw(sh);
        }

        //Estrella furulada
        g2.translate(15, -60);
        int xPoints[] =
        {
            55, 67, 109, 73, 83, 55, 27, 37, 1, 43
        };
        int yPoints[] =
        {
            0, 36, 36, 54, 96, 72, 96, 54, 36, 36
        };
        GeneralPath star = new GeneralPath();
        star.moveTo(xPoints[0], yPoints[0]);

        for (int k = 1; k < xPoints.length; k++)
        {
            star.lineTo(xPoints[k], yPoints[k]);
        }
        star.closePath();
        g2.fill(star);

        //Estrella 2
        g2.translate(130, 30);
        poly = new Polygon();
        poly.addPoint(-20, 60);
        poly.addPoint(20, -20);
        poly.addPoint(60, 60);
        g2.draw(poly);

        //Escalerita
        g2.translate(-300, 23);
        for (int i = 0; i < 5; i++)
        {
            g2.drawRect(110 - 10 * i, 20 + 10 * i, 10 + 10 * i, 10);
        }
        
        //Rectangulo
        g2.translate(125, 23);
        Rectangle2D r2d = new Rectangle2D.Double(0, 0, 40, 40);
        g2.draw(r2d);
    }
}
