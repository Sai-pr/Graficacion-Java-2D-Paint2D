/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import static folder3.JavaDraw2DPanel.getShapes;
import java.awt.GradientPaint;
import java.beans.ExceptionListener;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author saipr
 */
public class SalvarCargarProyecto
{

    public static void serializeToXML(ControladorCanvas settings) throws IOException
    {
        FileOutputStream fos = new FileOutputStream(JOptionPane.showInputDialog(null, "Ingrese nombre del proyecto") + ".xml");
        XMLEncoder encoder = new XMLEncoder(fos);
        encoder.setExceptionListener(new ExceptionListener()
        {
            public void exceptionThrown(Exception e)
            {
                System.out.println("Exception! :" + e.toString());
            }
        });
        encoder.writeObject(settings);
        encoder.close();
        fos.close();
    }

    public static ControladorCanvas deserializeFromXML(File file) throws IOException
    {
        // muestra el cuadro de diálogo de archivos, para que el usuario pueda elegir el archivo a abrir
        if ((file == null) || (file.getName().equals("")))
        {
            JOptionPane.showMessageDialog(null, "Nombre de archivo inválido", "Nombre de archivo inválido", JOptionPane.ERROR_MESSAGE);
        } else
        {
            FileInputStream fis = new FileInputStream(file);
            XMLDecoder decoder = new XMLDecoder(fis);
            ControladorCanvas decodedSettings = (ControladorCanvas) decoder.readObject();
            decoder.close();
            fis.close();
            return decodedSettings;
        }
        return null;
    }

    public static void serializeShapes(ArrayList<CMisFiguras> cf) throws FileNotFoundException
    {
        FileOutputStream fos = new FileOutputStream(JOptionPane.showInputDialog(null, "Ingrese nombre del proyecto") + ".xml");
        XMLEncoder xmle = new XMLEncoder(fos);
        ArrayList pathSegmentsCollection = new ArrayList<>();
        for (int i = 0; i < cf.size(); i++)
        {
            ArrayList pathSegments = PathBean.getSegmentsFromShape(cf.get(i).getFigura());

            PropsFig props = new PropsFig(pathSegments);
            //Props contorno
            props.setColor_Contorno1(cf.get(i).getColor_Contorno1());
            props.setColor_Contorno2(cf.get(i).getColor_Contorno2());
            props.setFloat_Espacio(cf.get(i).getFloat_Espacio());
            props.setFloat_Ancho(cf.get(i).getFloat_Ancho());
            props.setFloat_Lineado(cf.get(i).getFloat_Lineado());
            //Props relleno
            props.setColor_Relleno1(cf.get(i).getColor_Relleno1());
            props.setColor_Relleno2(cf.get(i).getColor_Relleno2());
            //Props tranformacion
            props.setInt_Transparencia(cf.get(i).getInt_Transparencia());
            props.setInt_Angulo(cf.get(i).getInt_Angulo());
            //PathBean as = new PathBean(pathSegments);
            pathSegmentsCollection.add(props);
        }
        xmle.writeObject(pathSegmentsCollection);
        xmle.flush();
        xmle.close();
    }

    /**
     * Load the list of shapes from the file system.
     */
    public static ArrayList<CMisFiguras> deserializeShapes(File file) throws FileNotFoundException
    {
        XMLDecoder xmld = new XMLDecoder(new FileInputStream(file));
        ArrayList pathSegProps = (ArrayList) xmld.readObject();
        ArrayList<CMisFiguras> shapes = new ArrayList();
        for (int i = 0; i < pathSegProps.size(); i++)
        {
            PropsFig setProps = (PropsFig) pathSegProps.get(i);
            PathBean pathsegments = new PathBean(setProps.getPathSegments());
            CMisFiguras figInv = new CMisFiguras(PathBean.getShapeFromSegments(pathsegments));
            //Props contorno
            figInv.setColor_Contorno1(setProps.getColor_Contorno1());
            figInv.setColor_Contorno2(setProps.getColor_Contorno2());
            figInv.setFloat_Espacio(setProps.getFloat_Espacio());
            figInv.setFloat_Ancho(setProps.getFloat_Ancho());
            figInv.setFloat_Lineado(setProps.getFloat_Lineado());
            //Props relleno
            figInv.setColor_Relleno1(setProps.getColor_Relleno1());
            figInv.setColor_Relleno2(setProps.getColor_Relleno2());
            //Props tranformacion
            figInv.setInt_Transparencia(setProps.getInt_Transparencia());
            figInv.setInt_Angulo(setProps.getInt_Angulo());
            shapes.add(figInv);
        }
        return shapes;
    }

}
