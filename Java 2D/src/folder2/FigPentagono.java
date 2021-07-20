/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder2;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author saipr
 */
public class FigPentagono implements Shape
{

    GeneralPath path;

    public FigPentagono(float x, float y, float w, float h)
    {
        float x0 = x + 1f * w; //BASE
        float y0 = y; //BASE
        float x1 = x + 1f * w; //PARED DER
        float y1 = y + 1f * h; //PARED DER
        float x2 = x + .5f * w; //TECHO DERECHO
        System.out.println("x2 = " + x2);
        System.out.println("w = " + w);
        float y2 = y + 2f * h; //TECHO DERECHO
        float x3 = x;
        float y3 = y + 1f * h;
        path = new GeneralPath();
        path.moveTo(x, y);
        path.lineTo(x0, y0); //x0 y0 ///BASE
        path.lineTo(x1, y1); //x1 y y1 //PARED DERECHA
        path.lineTo(x2, y2); //x2 y y2 TECHO DERECHO
        path.lineTo(x3, y3); //x3 y y3
        path.lineTo(x, y);
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
