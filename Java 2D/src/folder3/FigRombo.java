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
public class FigRombo implements Shape
{

    Polygon Rombo;

    public FigRombo(double x, double y, double w, double h)
    {
        //A
        int x0 = (int) (x + 0.5f * w);
        int y0 = (int) (y + 0.0f * h);
        //B
        int x1 = (int) (x + 1.0f * w);
        int y1 = (int) (y + 0.5f * h);
        //D
        int x2 = (int) (x + 0.5f * w);
        int y2 = (int) (y + 1.0f * h);
        //C
        int x3 = (int) (x + 0.0f * w);
        int y3 = (int) (y + 0.5f * h);

        int[] puntosX =
        {
            x0, x1, x2, x3
        };
        int[] puntosY =
        {
            y0, y1, y2, y3
        };
        Rombo = new Polygon(puntosX, puntosY, 4);
    }

    @Override
    public boolean contains(Rectangle2D rect)
    {
        return Rombo.contains(rect);
    }

    @Override
    public boolean contains(Point2D pd)
    {
        return Rombo.contains(pd);
    }

    @Override
    public boolean contains(double x, double y)
    {
        return Rombo.contains(x, y);
    }

    @Override
    public boolean contains(double x, double y, double w, double h)
    {
        return Rombo.contains(x, y, w, h);
    }

    @Override
    public Rectangle getBounds()
    {
        return Rombo.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D()
    {
        return Rombo.getBounds2D();
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at)
    {
        return Rombo.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness)
    {
        return Rombo.getPathIterator(at, flatness);
    }

    @Override
    public boolean intersects(Rectangle2D rd)
    {
        return Rombo.intersects(rd);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h)
    {
        return Rombo.intersects(x, y, w, h);
    }

}
