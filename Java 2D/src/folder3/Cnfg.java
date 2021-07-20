/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.Stroke;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

/**
 *
 * @author saipr
 */
public class Cnfg
{

    //Variables para cabiar de color a los jPanel
    public final static Color MOUSE_JPANEL_ENTERED = new Color(234, 234, 234);
    public final static Color MOUSE_JPANEL_EXITED = new Color(217, 217, 217);
    public final static Color MOUSE_JPANEL_CLICKED = new Color(0, 80, 157);

    //Variables para cambiar de color los textos
    public final static Color MOUSE_TEXTO_ENTERED = Color.RED;
    public final static Color MOUSE_TEXTO_EXITED = Color.BLACK;
    public final static Color MOUSE_TEXTO_CLICKED = Color.WHITE;

    //Variables de fuente
    public final static Font FONT_TEXTO_ENTERED = new Font("Tw Cen MT", 1, 14);
    public final static Font FONT_TEXTO_EXITED = new Font("Tw Cen MT", 1, 12);
    public final static Font FONT_TEXTO_CLICKED = new Font("Tw Cen MT", 1, 14);

    //Variables globales por defecto de las figuras
    public final static Stroke STROKE_CONTORNO_DEFAULT_FIGURAS = new BasicStroke(3);
    public final static Color COLOR_CONTORNO_1_DEFAULT_FIGURAS = Color.BLACK;
    public final static Color COLOR_CONTORNO_2_DEFAULT_FIGURAS = null;

    //Variables para la transformacion (De esta forma sé cual opcion usar xd mucho texto)
    public final static int INT_AFFINE_TRANSFORMATION_NINGUNA = 0;
    public final static int INT_AFFINE_TRANSFORMATION_TRANSLATION = 1;
    public final static int INT_AFFINE_TRANSFORMATION_ROTATION = 2;
    public final static int INT_AFFINE_TRANSFORMATION_SCALATION = 3;
    public final static int INT_AFFINE_TRANSFORMATION_SHEARING = 4;
    public final static int INT_AFFINE_TRANSFORMATION_REFLECTION = 5;

    //Variables para la interfaz dinamica, estas variables permiten ahorrar codigo 
    //puesto que se acceden desde cualquier clase sin objetos solo sirven para leer las 
    //configuraciones de la edicion de figuras 
    //  1.- Estas varioables son para armar la configuracion del contorno
    public static boolean CONFIG_IS_BORDER_CONTINUO = true; // -> Variable para saber si se debe activar la opcion GradientPanel o el Solido
    public static Color CONFIG_COLOR_CONTORNO_1 = Color.BLACK; // -> Variable para conocer el color que se debe dibujar en el JPanel de muestra del contorno
    public static Color CONFIG_COLOR_CONTORNO_2 = null; // -> En caso de que se active el gradientePanel entonces se necesitara un 2do color, para eso es esta variablE
    //public static GradientPaint CONFIG_GRADIENT_PAINT_CONTORNO = null; // - > Para dibujar mejor la muestra de color del gradient pane y usarlo tambien para la figura
    public static Stroke CONFIG_STROKE_CONTORNO = new BasicStroke(3);
    public static float CONFIG_FLOAT_ESPACIO = 0;
    public static float CONFIG_FLOAT_LINEADO = 1;
    public static float CONFIG_FLOAT_ANCHO = 3;
    //  2.- Estas variables con para la configuracion del relleno
    public static Color CONFIG_COLOR_RELLENO_1 = new Color(0, 0, 0, 0f);
    public static Color CONFIG_COLOR_RELLENO_2 = null;
    public static BufferedImage CONFIG_BUFFERED_IMAGE_RELLENO_3 = null;
    //  3.- Estas variables son para la composicion de la figura
    public static int CONFIG_INT_TRANSPARENCIA = 100;
    //  4.- Variables para las transformaciones
    public static AffineTransform CONFIG_AFFINE_TRANSFORM = new AffineTransform();
    //  5.- Variables para las operaciones booleanas
    public final static int CONFIG_INT_OPERACION_BOOLEANA_UNION = 1;
    public final static int CONFIG_INT_OPERACION_BOOLEANA_INTERSECCION = 2;
    public final static int CONFIG_INT_OPERACION_BOOLEANA_SUSTRACCION = 3;
    public final static int CONFIG_INT_OPERACION_BOOLEANA_XOR = 4;

}
