/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.util.Arrays;

/**
 *
 * @author saipr
 */
public class PathSegment
{

    private int pathSegmentType;
    private int windingRule;
    private double[] coords;

    public PathSegment()
    {
    }

    public PathSegment(int pathSegmentType, int windingRule, double[] coords)
    {
        this.pathSegmentType = pathSegmentType;
        this.windingRule = windingRule;
        this.coords = coords;
    }

    public double[] getCoords()
    {
        return coords;
    }

    public void setCoords(double[] coords)
    {
        this.coords = coords;
    }

    public int getPathSegmentType()
    {
        return pathSegmentType;
    }

    public void setPathSegmentType(int pathSegmentType)
    {
        this.pathSegmentType = pathSegmentType;
    }

    public int getWindingRule()
    {
        return windingRule;
    }

    public void setWindingRule(int windingRule)
    {
        this.windingRule = windingRule;
    }

    @Override
    public String toString()
    {
        String sC = (coords != null ? "" : Arrays.toString(coords));
        String s = String.format(
                "PathSegment: Path Segment Type:- %d \t" + "Winding Rule:- %d \tcoords:- %s", getPathSegmentType(), getWindingRule(), sC);
        return s;
    }
}
