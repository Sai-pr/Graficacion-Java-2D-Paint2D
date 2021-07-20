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
public class FigBandera implements Shape
{

    GeneralPath path;

    public FigBandera(float x, float y, float w, float h)
    {
        path = new GeneralPath();
        float c = 0.0002f;
        float x0 = x + 0.5f * w;
        float y0 = y + 0.3f * h;
        System.out.println("x0 = " + x0);
        System.out.println("y0 = " + y0);
        //Punto 1 curva 240, 130, 280, 160, 300, 140
        float x1 = (x + (240 * c)) * w;
        float y1 = (y + (130 * c)) * h;
        float x2 = (x + (280 * c)) * w;
        float y2 = (y + (160 * c)) * h;
        float x3 = (x + (300 * c)) * w;
        float y3 = (y + (140 * c)) * h;
        float x4 = x + 1f * w;
        float y4 = y + 0.6f * h;
        float x5 = x + 0.9f * w;
        float y5 = y + 0f * h;

        path.moveTo(x0, y0);
        path.curveTo(x1, y1, x2, y2, x3, y3);
        //path.lineTo(300, 180);
        //path.quadTo(260, 160, 220, 180);
        //path.closePath();
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
