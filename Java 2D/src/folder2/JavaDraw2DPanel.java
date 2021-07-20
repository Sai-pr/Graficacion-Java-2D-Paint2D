/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author saipr
 */
public class JavaDraw2DPanel extends JPanel implements MouseListener, MouseMotionListener
{

    private Vector shapes = new Vector();
    static final int RECTANGLE = 0;
    static final int ROUNDRECTANGLE2D = 1;
    static final int ELLIPSE2D = 2;
    static final int ARC2D = 3;
    static final int LINE2D = 4;
    static final int QUADCURVE2D = 5;
    static final int CUBICCURVE2D = 6;
    static final int POLYGON = 7;
    static final int GENERAL = 8;
    static final int AREA = 9;
    static final int HEARTH = 10;
    static final int HOUSE = 11;
    static final int FLAG = 12;

    int shapeType = RECTANGLE;
    // vector of input points
    Vector points = new Vector();
    int pointIndex = 0;
    Shape partialShape = null;
    Point p = null;

    private Color vColorDibujado = null;

    public void limpiaPanel()
    {
        shapes = new Vector();
        repaint();
    }

    public JavaDraw2DPanel()
    {
        super();
        setBackground(Color.white);
        setPreferredSize(new Dimension(640, 480));
        addMouseListener(this);
        addMouseMotionListener(this);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        if (vColorDibujado != null)
        {
            g2.setColor(vColorDibujado);
        }
        for (int i = 0; i < shapes.size(); i++)
        {
            Shape s = (Shape) shapes.get(i);
            g2.draw(s);
        }
    }

    public void mouseClicked(MouseEvent ev)
    {
    }

    public void mouseEntered(MouseEvent ev)
    {
    }

    public void mouseExited(MouseEvent ev)
    {
    }

    public void mousePressed(MouseEvent ev)
    {
        points.add(ev.getPoint());
        pointIndex++;
        p = null;
    }

    public void mouseReleased(MouseEvent ev)
    {
        Graphics g = getGraphics();
        Point p1 = (Point) (points.get(pointIndex - 1));
        p = ev.getPoint();
        Shape s = null;
        switch (shapeType)
        {
            case RECTANGLE:
                s = new Rectangle(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case ROUNDRECTANGLE2D:
                s = new RoundRectangle2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                break;
            case ELLIPSE2D:
                s = new Ellipse2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case ARC2D:
                s = new Arc2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120, Arc2D.OPEN);
                break;
            case LINE2D:
                s = new Line2D.Float(p1.x, p1.y, p.x, p.y);
                break;
            case QUADCURVE2D:
                if (pointIndex > 1)
                {
                    Point p2 = (Point) points.get(0);
                    s = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                }
                break;
            case CUBICCURVE2D:
                if (pointIndex > 2)
                {
                    Point p2 = (Point) points.get(pointIndex - 2);
                    Point p3 = (Point) points.get(pointIndex - 3);
                    s = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                }
                break;
            case POLYGON:
                if (ev.isShiftDown())
                {
                    s = new Polygon();
                    for (int i = 0; i < pointIndex; i++)
                    {
                        ((Polygon) s).addPoint(((Point) points.get(i)).x, ((Point) points.get(i)).y);
                    }
                    ((Polygon) s).addPoint(p.x, p.y);
                }
                break;
            case HEARTH:
                s = new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case HOUSE:
                s = new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case FLAG:
                s = new FigBandera(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
        }
        if (s != null)
        {
            shapes.add(s);
            points.clear();
            pointIndex = 0;
            p = null;
            repaint();
        }
    }

    public void mouseMoved(MouseEvent ev)
    {
    }

    public void mouseDragged(MouseEvent ev)
    {
        Graphics2D g = (Graphics2D) getGraphics();
        g.setXORMode(Color.white);
        Point p1 = (Point) points.get(pointIndex - 1);
        switch (shapeType)
        {
            case RECTANGLE:
                if (p != null)
                {
                    g.drawRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                }
                p = ev.getPoint();
                g.drawRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case ROUNDRECTANGLE2D:
                if (p != null)
                {
                    g.drawRoundRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                }
                p = ev.getPoint();
                g.drawRoundRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                break;
            case ELLIPSE2D:
                if (p != null)
                {
                    g.drawOval(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                }
                p = ev.getPoint();
                g.drawOval(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                break;
            case ARC2D:
                if (p != null)
                {
                    g.drawArc(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120);
                }
                p = ev.getPoint();
                g.drawArc(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120);
                break;
            case LINE2D:
            case POLYGON:
                if (p != null)
                {
                    g.drawLine(p1.x, p1.y, p.x, p.y);
                }
                p = ev.getPoint();
                g.drawLine(p1.x, p1.y, p.x, p.y);
                break;
            case QUADCURVE2D:
                if (pointIndex == 1)
                {
                    if (p != null)
                    {
                        g.drawLine(p1.x, p1.y, p.x, p.y);
                    }
                    p = ev.getPoint();
                    g.drawLine(p1.x, p1.y, p.x, p.y);
                } else
                {
                    Point p2 = (Point) points.get(pointIndex - 2);
                    if (p != null)
                    {
                        g.draw(partialShape);
                    }
                    p = ev.getPoint();
                    partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                    g.draw(partialShape);
                }
                break;
            case CUBICCURVE2D:
                if (pointIndex == 1)
                {
                    if (p != null)
                    {
                        g.drawLine(p1.x, p1.y, p.x, p.y);
                    }
                    p = ev.getPoint();
                    g.drawLine(p1.x, p1.y, p.x, p.y);
                } else if (pointIndex == 2)
                {
                    Point p2 = (Point) points.get(pointIndex - 2);
                    if (p != null)
                    {
                        g.draw(partialShape);
                    }
                    p = ev.getPoint();
                    partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                    g.draw(partialShape);
                } else
                {
                    Point p2 = (Point) points.get(pointIndex - 2);
                    Point p3 = (Point) points.get(pointIndex - 3);
                    if (p != null)
                    {
                        g.draw(partialShape);
                    }
                    p = ev.getPoint();
                    partialShape = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                    g.draw(partialShape);
                }
                break;
            case HEARTH:
                if (p != null)
                {
                    g.draw(new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
            case HOUSE:
                if (p != null)
                {
                    g.draw(new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
            case FLAG:
                if (p != null)
                {
                    g.draw(new FigBandera(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(new FigBandera(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                break;
        }
    }

    /**
     * @return the vColorDibujado
     */
    public Color getvColorDibujado()
    {
        return vColorDibujado;
    }

    /**
     * @param vColorDibujado the vColorDibujado to set
     */
    public void setvColorDibujado(Color vColorDibujado)
    {
        this.vColorDibujado = vColorDibujado;
    }

}
