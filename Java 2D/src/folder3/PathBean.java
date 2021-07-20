/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Shape;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;
import java.util.ArrayList;

/**
 *
 * @author saipr
 */
public class PathBean
{

    private ArrayList<PathSegment> pathSegments;

    public PathBean()
    {
    }

    public PathBean(ArrayList<PathSegment> pathSegments)
    {
        this.pathSegments = pathSegments;
    }

    public ArrayList<PathSegment> getPathSegments()
    {
        return pathSegments;
    }

    public void setPathSegments(ArrayList<PathSegment> pathSegments)
    {
        this.pathSegments = pathSegments;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder("{");
        for (PathSegment pathSegment : pathSegments)
        {
            sb.append(" \n\t");
            sb.append(pathSegment.toString());
        }
        sb.append("  \n");
        sb.append("}");
        return "PathSegments: " + sb.toString();
    }

    /**
     * Convierte una figura en un arreglo de Segmentos
     *
     * @param shape
     * @return
     */
    public static ArrayList<PathSegment> getSegmentsFromShape(Shape shape)
    {
        ArrayList<PathSegment> shapeSegments = new ArrayList();
        for (PathIterator pi = shape.getPathIterator(null); !pi.isDone(); pi.next())
        {
            double[] coords = new double[6];
            int pathSegmentType = pi.currentSegment(coords);
            int windingRule = pi.getWindingRule();
            PathSegment as = new PathSegment(pathSegmentType, windingRule, coords);
            shapeSegments.add(as);
        }
        return shapeSegments;
    }

    public static Shape getShapeFromSegments(PathBean shapeSegments, float x, float y, float w, float h)
    {
        GeneralPath gp = new GeneralPath();
        for (PathSegment shapeSegment : shapeSegments.getPathSegments())
        {
            double coords[] = shapeSegment.getCoords();
            int pathSegmentType = shapeSegment.getPathSegmentType();
            int windingRule = shapeSegment.getWindingRule();
            gp.setWindingRule(windingRule);
            switch (pathSegmentType)
            {
                case PathIterator.SEG_MOVETO:
                    gp.moveTo(x + (coords[0] * 0.002) * w, y + (coords[1] * 0.002) * h);
                    break;
                case PathIterator.SEG_LINETO:
                    gp.lineTo(x + (coords[0] * 0.002) * w, y + (coords[1] * 0.002) * h);
                    break;
                case PathIterator.SEG_QUADTO:
                    gp.quadTo(x + (coords[0] * 0.002) * w, y + (coords[1] * 0.002) * h, x + (coords[2] * 0.002) * w, y + (coords[3] * 0.002) * h);
                    break;
                case PathIterator.SEG_CUBICTO:
                    gp.curveTo(x + (coords[0] * 0.002) * w, y + (coords[1] * 0.002) * h, x + (coords[2] * 0.002) * w, y + (coords[3] * 0.002) * h, x + (coords[4] * 0.002) * w, y + (coords[5] * 0.002) * h);
                    break;
                case PathIterator.SEG_CLOSE:
                    gp.closePath();
                    break;

            }
        }
        return gp;
    }

    public static Shape getShapeFromSegments(PathBean shapeSegments)
    {
        GeneralPath gp = new GeneralPath();
        for (PathSegment shapeSegment : shapeSegments.getPathSegments())
        {
            double[] coords = shapeSegment.getCoords();
            int pathSegmentType = shapeSegment.getPathSegmentType();
            int windingRule = shapeSegment.getWindingRule();
            gp.setWindingRule(windingRule);
            if (pathSegmentType == PathIterator.SEG_MOVETO)
            {
                gp.moveTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_LINETO)
            {
                gp.lineTo(coords[0], coords[1]);
            } else if (pathSegmentType == PathIterator.SEG_QUADTO)
            {
                gp.quadTo(coords[0], coords[1], coords[2], coords[3]);
            } else if (pathSegmentType == PathIterator.SEG_CUBICTO)
            {
                gp.curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
            } else if (pathSegmentType == PathIterator.SEG_CLOSE)
            {
                gp.closePath();
            } else
            {
                System.err.println("Unexpected value! " + pathSegmentType);
            }
        }
        return gp;
    }

}
