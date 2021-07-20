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
public class CustomF
{

    private PathBean segmentos;
    private String nombre = "";
    private int identificador;

    public CustomF(ArrayList<PathSegment> s, String name, int n)
    {
        this.segmentos = new PathBean(s);
        this.nombre = name;
        this.identificador = n;
    }

    public PathBean getSegmentos()
    {
        return segmentos;
    }

    public void setSegmentos(PathBean segmentos)
    {
        this.segmentos = segmentos;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public int getIdentificador()
    {
        return identificador;
    }

    public void setIdentificador(int identificador)
    {
        this.identificador = identificador;
    }

}
