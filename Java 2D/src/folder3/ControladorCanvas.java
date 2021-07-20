/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.util.ArrayList;

/**
 *
 * @author saipr
 */
public class ControladorCanvas
{

    private ArrayList<CMisFiguras> shapes;

    public ControladorCanvas()
    {
    }

    public ArrayList<CMisFiguras> getSavedProject()
    {
        return shapes;
    }

    public void setShapes(ArrayList<CMisFiguras> shapes)
    {
        this.shapes = shapes;
    }
    
}
