/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author saipr
 */
public class FigCursor implements Shape
{

    Polygon path;

    public FigCursor(float x, float y, float w, float h)
    {

        //Puntos de la estrella
        //A
        int x0 = (int) (x + 0.0f * w);
        int y0 = (int) (y + 0.0f * h);
        //B
        int x1 = (int) (x + 0.5f * w);
        int y1 = (int) (y + 0.2f * h);
        //C
        int x2 = (int) (x + 0.3f * w);
        int y2 = (int) (y + 0.2f * h);
        //D
        int x3 = (int) (x + 0.75f * w);
        int y3 = (int) (y + 0.55f * h);
        //E
        int x4 = (int) (x + 0.6f * w);
        int y4 = (int) (y + 0.7f * h);
        //G
        int x5 = (int) (x + 0.2f * w);
        int y5 = (int) (y + 0.3f * h);
        //F
        int x6 = (int) (x + 0.2f * w);
        int y6 = (int) (y + 0.5f * h);

        int[] puntosX =
        {
            x0, x1, x2, x3, x4, x5, x6
        };
        int[] puntosY =
        {
            y0, y1, y2, y3, y4, y5, y6
        };
        path = new Polygon(puntosX, puntosY, 7);
    }

    @Override
    public boolean contains(Rectangle2D rect)
    {
        return path.contains(rect);
    }

    @Override
    public boolean contains(Point2D pd)
    {
        return path.contains(pd);
    }

    @Override
    public boolean contains(double x, double y)
    {
        return path.contains(x, y);
    }

    @Override
    public boolean contains(double x, double y, double w, double h)
    {
        return path.contains(x, y, w, h);
    }

    @Override
    public Rectangle getBounds()
    {
        return path.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D()
    {
        return path.getBounds2D();
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at)
    {
        return path.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness)
    {
        return path.getPathIterator(at, flatness);
    }

    @Override
    public boolean intersects(Rectangle2D rd)
    {
        return path.intersects(rd);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h)
    {
        return path.intersects(x, y, w, h);
    }
}
