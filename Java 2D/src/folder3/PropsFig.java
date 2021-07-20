/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Color;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author saipr
 */
public class PropsFig
{

    private ArrayList<PathSegment> pathSegments;
    //Configuracion sobre el controno de la figura
    private Color color_Contorno1 = Color.BLACK; //Color por defecto del contornoStroke NEGRO
    private Color color_Contorno2 = null; //Color por defecto del contornoStroke es null puesto servirá de referenia para saber si hay un float_Contorno gradiente
    private float float_Espacio = 0;
    private float float_Lineado = 1;
    private float float_Ancho = 3;
    //Configuracion del relleno de la figura
    private Color color_Relleno1 = new Color(0f, 0f, 0, 0f);
    private Color color_Relleno2 = null;
    private BufferedImage bufferedImage_Relleno3 = null;
    //Configuracion de composicion y transformacion de la figura
    private int int_Transparencia = 100;
    private int int_Angulo = 45;
    //boolean creada = false; //Determina si ua figura fue creada por el usuario.

    public PropsFig(ArrayList<PathSegment> pathseg)
    {
        this.pathSegments = pathseg;
    }

    public PropsFig()
    {
    }

    /**
     * @return the pathSegments
     */
    public ArrayList<PathSegment> getPathSegments()
    {
        return pathSegments;
    }

    /**
     * @param pathSegments the pathSegments to set
     */
    public void setPathSegments(ArrayList<PathSegment> pathSegments)
    {
        this.pathSegments = pathSegments;
    }

    /**
     * @return the color_Contorno1
     */
    public Color getColor_Contorno1()
    {
        return color_Contorno1;
    }

    /**
     * @param color_Contorno1 the color_Contorno1 to set
     */
    public void setColor_Contorno1(Color color_Contorno1)
    {
        this.color_Contorno1 = color_Contorno1;
    }

    /**
     * @return the color_Contorno2
     */
    public Color getColor_Contorno2()
    {
        return color_Contorno2;
    }

    /**
     * @param color_Contorno2 the color_Contorno2 to set
     */
    public void setColor_Contorno2(Color color_Contorno2)
    {
        this.color_Contorno2 = color_Contorno2;
    }

    /**
     * @return the float_Espacio
     */
    public float getFloat_Espacio()
    {
        return float_Espacio;
    }

    /**
     * @param float_Espacio the float_Espacio to set
     */
    public void setFloat_Espacio(float float_Espacio)
    {
        this.float_Espacio = float_Espacio;
    }

    /**
     * @return the float_Lineado
     */
    public float getFloat_Lineado()
    {
        return float_Lineado;
    }

    /**
     * @param float_Lineado the float_Lineado to set
     */
    public void setFloat_Lineado(float float_Lineado)
    {
        this.float_Lineado = float_Lineado;
    }

    /**
     * @return the float_Ancho
     */
    public float getFloat_Ancho()
    {
        return float_Ancho;
    }

    /**
     * @param float_Ancho the float_Ancho to set
     */
    public void setFloat_Ancho(float float_Ancho)
    {
        this.float_Ancho = float_Ancho;
    }

    /**
     * @return the color_Relleno1
     */
    public Color getColor_Relleno1()
    {
        return color_Relleno1;
    }

    /**
     * @param color_Relleno1 the color_Relleno1 to set
     */
    public void setColor_Relleno1(Color color_Relleno1)
    {
        this.color_Relleno1 = color_Relleno1;
    }

    /**
     * @return the color_Relleno2
     */
    public Color getColor_Relleno2()
    {
        return color_Relleno2;
    }

    /**
     * @param color_Relleno2 the color_Relleno2 to set
     */
    public void setColor_Relleno2(Color color_Relleno2)
    {
        this.color_Relleno2 = color_Relleno2;
    }

    /**
     * @return the bufferedImage_Relleno3
     */
    public BufferedImage getBufferedImage_Relleno3()
    {
        return bufferedImage_Relleno3;
    }

    /**
     * @param bufferedImage_Relleno3 the bufferedImage_Relleno3 to set
     */
    public void setBufferedImage_Relleno3(BufferedImage bufferedImage_Relleno3)
    {
        this.bufferedImage_Relleno3 = bufferedImage_Relleno3;
    }

    /**
     * @return the int_Transparencia
     */
    public int getInt_Transparencia()
    {
        return int_Transparencia;
    }

    /**
     * @param int_Transparencia the int_Transparencia to set
     */
    public void setInt_Transparencia(int int_Transparencia)
    {
        this.int_Transparencia = int_Transparencia;
    }

    /**
     * @return the int_Angulo
     */
    public int getInt_Angulo()
    {
        return int_Angulo;
    }

    /**
     * @param int_Angulo the int_Angulo to set
     */
    public void setInt_Angulo(int int_Angulo)
    {
        this.int_Angulo = int_Angulo;
    }

}
