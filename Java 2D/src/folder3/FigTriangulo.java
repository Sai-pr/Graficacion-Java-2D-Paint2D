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
public class FigTriangulo implements Shape
{

    Polygon triangulo = new Polygon();
    int esqInfIzqX, esqInfIzqY, esqInfDerX, esqInfDerY, puntoSuperiorX, puntoSuperiorY;
    double x, y, width, height;

    public FigTriangulo(double x1, double y1, double width, double height)
    {
        //triangulo.translate((int) x1, (int) y1);
        x = Math.min(x1, y1);
        y = Math.min(y1, height);
        width = Math.abs(x1 + width);
        height = Math.abs(y1 + height);
        esqInfIzqX = (int) x1;
        esqInfIzqY = (int) height;
        esqInfDerX = (int) width;
        esqInfDerY = (int) height;
        puntoSuperiorX = (int) (x1 + width) / 2;
        puntoSuperiorY = (int) y1;
        triangulo = new Polygon();
      
        triangulo.addPoint(puntoSuperiorX, puntoSuperiorY);
        triangulo.addPoint(esqInfIzqX, esqInfIzqY);
        triangulo.addPoint(esqInfDerX, esqInfDerY);
        
    }

    @Override
    public boolean contains(Rectangle2D rect)
    {
        return triangulo.contains(rect);
    }

    @Override
    public boolean contains(Point2D pd)
    {
        return triangulo.contains(pd);
    }

    @Override
    public boolean contains(double x, double y)
    {
        return triangulo.contains(x, y);
    }

    @Override
    public boolean contains(double x, double y, double w, double h)
    {
        return triangulo.contains(x, y, w, h);
    }

    @Override
    public Rectangle getBounds()
    {
        return triangulo.getBounds();
    }

    @Override
    public Rectangle2D getBounds2D()
    {
        return triangulo.getBounds2D();
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at)
    {
        return triangulo.getPathIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness)
    {
        return triangulo.getPathIterator(at, flatness);
    }

    @Override
    public boolean intersects(Rectangle2D rd)
    {
        return triangulo.intersects(rd);
    }

    @Override
    public boolean intersects(double x, double y, double w, double h)
    {
        return triangulo.intersects(x, y, w, h);
    }

}
