/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

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
public class FigBandera implements Shape
{

    GeneralPath path;

    public FigBandera(float x, float y, float w, float h)
    {
        path = new GeneralPath();
        //Polygon p = new Polygon();
        //p.addPoint(x + ((width * 3) / 3), y + ((2 * (height * 3)) / 3));
        //p.addPoint(x + ((width * 3) / 2), y + ((height * 3) / 3));
        //p.addPoint(x + ((2 * (width * 3)) / 3), y + ((2 * (height * 3)) / 3));
        path.moveTo(x, y);
        path.lineTo(x + ((w * 3) / 3), y + ((2 * (h * 3)) / 3));
        path.lineTo(x + ((w * 3) / 2), y + ((h * 3) / 3));
        path.lineTo(x + ((2 * (w * 3)) / 3), y + ((2 * (h * 3)) / 3));
        
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
