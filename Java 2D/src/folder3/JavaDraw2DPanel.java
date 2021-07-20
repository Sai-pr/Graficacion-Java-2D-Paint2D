/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.AlphaComposite;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.TexturePaint;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Arc2D;
import java.awt.geom.CubicCurve2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.QuadCurve2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 *
 * @author saipr
 */
public class JavaDraw2DPanel extends JPanel implements MouseListener, MouseMotionListener, KeyListener
{

    public static ArrayList<CMisFiguras> shapes = new ArrayList<>();

    //Figuras de Java 2D
    static final int RECTANGLE = 0;
    static final int ROUNDRECTANGLE2D = 1;
    static final int ELLIPSE2D = 2;
    static final int ARC2D = 3;
    static final int LINE2D = 4;
    static final int QUADCURVE2D = 5;
    static final int CUBICCURVE2D = 6;
    static final int POLYGON = 7;
    static final int GENERAL = 8;
    static final int AREA = 9;

    //Figuras modificadas mias
    static final int HEARTH = 10;
    static final int PENTAGON = 11;
    static final int STAR6P = 12;
    static final int CURSOR = 13;
    static final int SHURIKEN = 14;
    static final int BAT = 15;
    static final int STAIRS = 16;
    static final int HOUSE = 17;
    static final int TRIANGLE = 18;
    static final int RHOMB = 19;

    public int shapeType = RECTANGLE;
    // vector of input points
    Vector points = new Vector();
    int pointIndex = 0;
    Shape partialShape = null;
    Point p = null;

    //Variables para cinfugrar a las figuras
    boolean primeraVez = false; //Esta variable ayuda a que no se sobrescriba a cada rato el valor del shape
    boolean primeraVez_SCALE = false; //Esta variable ayuda a que los SCALE no se pasen de mezcla y se muevan a lo loco
    Point p_E = null;

    public void limpiaPanel()
    {
        setShapes(new ArrayList<CMisFiguras>());
        repaint();
    }

    public JavaDraw2DPanel()
    {
        super();
        setPreferredSize(new Dimension(1270, 620));
        setBackground(Color.white);
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
        setFocusable(true);
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for (int i = 0; i < getShapes().size(); i++)
        {
            if (getShapes().get(i).isSeleccion()) //Si la figura esta seleccionada entonces...
            {
                //Primero se dibuja el rectangulo de seleccion
                float dash1[] =
                {
                    15
                };//la cantidad de largo de las lineas que se puntean
                BasicStroke dashed = new BasicStroke(3.0f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
                g2.setStroke(dashed);
                Rectangle rec = getShapes().get(i).getFigura().getBounds();
                rec.setBounds((int) rec.getX() - 10, (int) rec.getY() - 10, (int) rec.getWidth() + 20, (int) rec.getHeight() + 20);
                g2.setColor(Cnfg.MOUSE_JPANEL_CLICKED);
                AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 0.75f);
                g2.setComposite(ac);
                g2.draw(rec);
                //Fin del dibujado del rectangulo de seleccion

                //Actualizamos  el Panel edicion para que tenga las opciones de la figura
                // -> Primero extraemos las configuraciones de la figura
                if (primeraVez) //Es la primera vez que se selecciona una figura entonces que ponga la configuracion inicial de la figura
                {
                    primeraVez = false;
                    //Configuracion del contorno
                    Cnfg.CONFIG_COLOR_CONTORNO_1 = getShapes().get(i).getColor_Contorno1();
                    Cnfg.CONFIG_COLOR_CONTORNO_2 = getShapes().get(i).getColor_Contorno2();
                    Cnfg.CONFIG_FLOAT_ESPACIO = getShapes().get(i).getFloat_Espacio();
                    Cnfg.CONFIG_FLOAT_LINEADO = getShapes().get(i).getFloat_Lineado();
                    Cnfg.CONFIG_FLOAT_ANCHO = getShapes().get(i).getFloat_Ancho();
                    //Configuracion de relleno
                    Cnfg.CONFIG_COLOR_RELLENO_1 = getShapes().get(i).getColor_Relleno1();
                    Cnfg.CONFIG_COLOR_RELLENO_2 = getShapes().get(i).getColor_Relleno2();
                    Cnfg.CONFIG_BUFFERED_IMAGE_RELLENO_3 = getShapes().get(i).getBufferedImage_Relleno3();
                    //Configuracion de transparencia
                    Cnfg.CONFIG_INT_TRANSPARENCIA = getShapes().get(i).getInt_Transparencia();
                }
                //Se actualiza el Panel
                CPnlMainAll.vjPnlEdicionMenu.actualizarPanel();
                //Fin de actualizar el panel de edicion

                //Aqui se toman las configuraciones que se aplicarán en la figura
                //  1.- Color del contorno
                getShapes().get(i).setColor_Contorno1(Cnfg.CONFIG_COLOR_CONTORNO_1);
                //  2.- GradientPane (solo si lo tiene xD)
                getShapes().get(i).setColor_Contorno2(Cnfg.CONFIG_COLOR_CONTORNO_2);
                //  3.- Tipo de borde 
                getShapes().get(i).setFloat_Espacio(Cnfg.CONFIG_FLOAT_ESPACIO);
                getShapes().get(i).setFloat_Lineado(Cnfg.CONFIG_FLOAT_LINEADO);
                getShapes().get(i).setFloat_Ancho(Cnfg.CONFIG_FLOAT_ANCHO);
                //  4.- Color del relleno
                getShapes().get(i).setColor_Relleno1(Cnfg.CONFIG_COLOR_RELLENO_1);
                getShapes().get(i).setColor_Relleno2(Cnfg.CONFIG_COLOR_RELLENO_2);
                getShapes().get(i).setBufferedImage_Relleno3(Cnfg.CONFIG_BUFFERED_IMAGE_RELLENO_3);
                //  5.- Composicion de la figura 
                //      Transparencia
                getShapes().get(i).setInt_Transparencia(Cnfg.CONFIG_INT_TRANSPARENCIA);
            }
            //g2.translate(0, 0);
            Shape s = getShapes().get(i).getFigura();
            //Primero, Transparencia de la figura
            AlphaComposite aC = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, ((float) getShapes().get(i).getInt_Transparencia() / 100));
            g2.setComposite(aC);
            //Segundo, transformaciones de la figura

            //Primero coloreamos el contorno
            g2.setColor(getShapes().get(i).getColor_Contorno1());
            if (getShapes().get(i).getColor_Contorno2() != null)//En caso de que tenga un gradientPanel
            {
                g2.setPaint((Paint) new GradientPaint(0, 0, getShapes().get(i).getColor_Contorno1(), 0, 10, getShapes().get(i).getColor_Contorno2(), true));
            }
            float dash[] =
            {
                getShapes().get(i).getFloat_Lineado(), getShapes().get(i).getFloat_Espacio()
            };
            g2.setStroke(new BasicStroke(getShapes().get(i).getFloat_Ancho(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_BEVEL, 10.0f, dash, 0.0f));
            g2.draw(s);
            //Fin de sibujado del contorno

            //Segundo, coloreamos el relleno
            g2.setPaint(getShapes().get(i).getColor_Relleno1());
            if (getShapes().get(i).getBufferedImage_Relleno3() != null)
            {
                g2.setPaint(new TexturePaint(getShapes().get(i).getBufferedImage_Relleno3(), new Rectangle(0, 0, 90, 60)));
            } else if (getShapes().get(i).getColor_Relleno2() != null)//En caso de que tenga un gradientPanel el relleno
            {
                g2.setPaint((Paint) new GradientPaint(0, 0, getShapes().get(i).getColor_Relleno1(), 0, 10, getShapes().get(i).getColor_Relleno2(), true));
            }
            g2.fill(s);

            //mImprimeConfiguracionActual(shapes.get(i));
        }
        g2.dispose();
        setFocusable(true);
    }

    public void mImprimeConfiguracionActual(CMisFiguras shapeActual)
    {
        System.out.println("Configuracion general:");
        System.out.println("    Configuracion de contorno");
        System.out.println("    - Color 1: " + Cnfg.CONFIG_COLOR_CONTORNO_1);
        System.out.println("    - Color 2: " + Cnfg.CONFIG_COLOR_CONTORNO_2);
        System.out.println("    - Espaciado: " + Cnfg.CONFIG_FLOAT_ESPACIO);
        System.out.println("    - Contorno: " + Cnfg.CONFIG_FLOAT_LINEADO);
        System.out.println("    - Grosor " + Cnfg.CONFIG_FLOAT_ANCHO);
        System.out.println("");
        System.out.println("Configuracion de la figura:");
        System.out.println("    Configuracion de contorno");
        System.out.println("    - Color 1: " + shapeActual.getColor_Contorno1());
        System.out.println("    - Color 2: " + shapeActual.getColor_Contorno2());
        System.out.println("    - Espaciado: " + shapeActual.getFloat_Espacio());
        System.out.println("    - Lineado: " + shapeActual.getFloat_Lineado());
        System.out.println("    - Grosor " + shapeActual.getFloat_Ancho());
        System.out.println("");
    }

    public void mouseClicked(MouseEvent ev)
    {

    }

    public void mouseEntered(MouseEvent ev)
    {
        this.setBorder(new LineBorder(Cnfg.MOUSE_JPANEL_CLICKED, 1));//Para indicar que puede dibujar, pura decoracion nada mas
        //this.requestFocus();
    }

    public void mouseExited(MouseEvent ev)
    {
        this.setBorder(null);

    }

    public static void reiniciaFigurasSeleccionadas()
    {
        Cnfg.CONFIG_COLOR_CONTORNO_2 = null;
        if (!CPnlMainAll.vjPnlEdicionMenu.isVisible())
        {
            CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.setSelectedIndex(Cnfg.INT_AFFINE_TRANSFORMATION_NINGUNA);
        }
        for (int i = getShapes().size() - 1; i >= 0; i--)
        {
            getShapes().get(i).setSeleccion(false);
        }
    }

    public void mousePressed(MouseEvent ev)
    {
        points.add(ev.getPoint());
        pointIndex++;
        if (CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.getSelectedIndex() == Cnfg.INT_AFFINE_TRANSFORMATION_NINGUNA)
        {
            p = null;
        } else
        {
            p = ev.getPoint();
        }
        //Reinicio las figuras antes de dibujar las seleccionadas pero solo si esta seleccionada la seleccion simple
        if (CPnlMainAll.isSELECCION_SIMPLE())
        {
            reiniciaFigurasSeleccionadas();
        }
        //Y comienza la seleccion
        boolean isSeleccion = false;
        if (CPnlMainAll.isSeleccionSimple())
        {
            for (int i = getShapes().size() - 1; i >= 0; i--)
            {
                if (getShapes().get(i).getFigura().contains(ev.getPoint()))
                {
                    getShapes().get(i).setSeleccion(true);
                    isSeleccion = true;
                    break;
                }
            }
        } else if (!CPnlMainAll.isSELECCION_SIMPLE())
        {
            for (int i = getShapes().size() - 1; i >= 0; i--)
            {
                if (getShapes().get(i).getFigura().contains(ev.getPoint()))
                {
                    isSeleccion = true;
                    getShapes().get(i).setSeleccion(true);
                }
            }
        }
        resetPnl_CpnlMainAll(); // Esto deshabilita los paneles de la derecha que estan activados para mostrar el panel de edicion
        if (isSeleccion) //Esto habilita las opciones de edicion al seleccionarse una o varias figuras
        {
            CPnlMainAll.vLblOpcionSeleccionado.setText("Editar figura");
            CPnlMainAll.vjPnlEdicionMenu.setVisible(true);
            primeraVez = true; //Aqui se reinicia siempre el boolean primera vez, lo activo para que entre al caso de primera vez y configure el panel edicion
        } else
        {
            if (CPnlMainAll.vPnlMnuFigsSeleccionado == CPnlMainAll.PNL1_MENU_FIGURAS2D_CLICKED)
            {
                CPnlMainAll.vLblOpcionSeleccionado.setText("Figuras 2D");
                CPnlMainAll.vjPnlFiguras2D.setVisible(true);
            } else if (CPnlMainAll.vPnlMnuFigsSeleccionado == CPnlMainAll.PNL2_MENU_FIGURASMOD_CLICKED)
            {
                CPnlMainAll.vLblOpcionSeleccionado.setText("Figuras Modificadas");
                CPnlMainAll.vjPnlFigurasMOD.setVisible(true);
            }// PROXIMAMENTE caso de las figuras MOD
        }
    }

    public void resetPnl_CpnlMainAll()
    {
        CPnlMainAll.vjPnlFiguras2D.setVisible(false);
        CPnlMainAll.vjPnlFigurasMOD.setVisible(false);
        CPnlMainAll.vjPnlFigurasCrd.setVisible(false);
        CPnlMainAll.vjPnlEdicionMenu.setVisible(false);
    }

    public void mouseReleased(MouseEvent ev)
    {
        primeraVez_SCALE = false;
        shapeType = CPnlMainAll.getvShapeType();
        Graphics g = getGraphics();
        Point p1 = (Point) (points.get(pointIndex - 1));
        p = ev.getPoint();
        Shape s = null;

        if (CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.getSelectedIndex() == 0)//Parte para dibujar figuras de toda la vida (Dibuja cuando no hay niguna tranformacion activa paas)
        {
            switch (shapeType)
            {
                case RECTANGLE:
                    s = new Rectangle(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case ROUNDRECTANGLE2D:
                    s = new RoundRectangle2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                    break;
                case ELLIPSE2D:
                    s = new Ellipse2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case ARC2D:
                    s = new Arc2D.Float(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120, Arc2D.OPEN);
                    break;
                case LINE2D:
                    s = new Line2D.Float(p1.x, p1.y, p.x, p.y);
                    break;
                case QUADCURVE2D:
                    if (pointIndex > 1)
                    {
                        Point p2 = (Point) points.get(0);
                        s = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                    }
                    break;
                case CUBICCURVE2D:
                    if (pointIndex > 2)
                    {
                        Point p2 = (Point) points.get(pointIndex - 2);
                        Point p3 = (Point) points.get(pointIndex - 3);
                        s = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                    }
                    break;
                case POLYGON:
                    if (ev.isShiftDown())
                    {
                        s = new Polygon();
                        for (int i = 0; i < pointIndex; i++)
                        {
                            ((Polygon) s).addPoint(((Point) points.get(i)).x, ((Point) points.get(i)).y);
                        }
                        ((Polygon) s).addPoint(p.x, p.y);
                    }
                    break;
                case HEARTH:
                    s = new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case PENTAGON:
                    s = new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case STAR6P:
                    s = new FigEstrella6P(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case CURSOR:
                    s = new FigCursor(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case SHURIKEN:
                    s = new FigEstrellaNinja(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case BAT:
                    s = new FigMurcielago(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case STAIRS:
                    s = new FigEscaleras(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case HOUSE:
                    s = new FigCasa(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case TRIANGLE:
                    s = new FigTriangulo(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case RHOMB:
                    s = new FigRombo(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
            }
            if (shapeType >= 25)
            {
                s = CPnlMainAll.getRareObject(shapeType, p1.x, p1.y, p.x - p1.x, p.y - p1.y);
            }
            if (s != null && (s.getBounds().getHeight() > 5 && s.getBounds().getHeight() > 5))
            {
                reiniciaFigurasSeleccionadas();
                CMisFiguras myFigura = new CMisFiguras(s);
                getShapes().add(myFigura);
                points.clear();
                pointIndex = 0;
                p = null;
            }
        } else //Si hay alguna transformacion activa entonces...
        {
            Cnfg.CONFIG_AFFINE_TRANSFORM = new AffineTransform();

            for (int i = 0; i <= getShapes().size() - 1; i++)
            {
                if (getShapes().get(i).isSeleccion())
                {
                    double x0 = getShapes().get(i).getFigura().getBounds().x + getShapes().get(i).getFigura().getBounds().width / 2;
                    double y0 = getShapes().get(i).getFigura().getBounds().y + getShapes().get(i).getFigura().getBounds().height / 2;
                    switch (CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.getSelectedIndex())
                    {
                        case Cnfg.INT_AFFINE_TRANSFORMATION_TRANSLATION:
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToTranslation(p.x - p1.x, p.y - p1.y);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_ROTATION:
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToRotation(Math.atan2(p1.y - y0, p1.x - x0) - Math.atan2(p.y - y0, p.x - x0), x0, y0);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_SCALATION:
                            //getGraphics().translate(0, 0);
                            double sx = Math.abs((double) (0 - p.x) / (0 - p1.x));
                            double sy = Math.abs((double) (0 - p.y) / (0 - p1.y));
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToScale(sx, sy);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_SHEARING:
                            double shx = ((double) (p1.x) / (p.x)) - 1;
                            double shy = ((double) (p1.y) / (p.y)) - 1;
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToShear(shx, shy);
                            break;
                    }
                    getShapes().get(i).setFigura(Cnfg.CONFIG_AFFINE_TRANSFORM.createTransformedShape(getShapes().get(i).getFigura()));
                }
            }
        }
        repaint();
    }

    public void mouseMoved(MouseEvent ev)
    {
    }

    public void mouseDragged(MouseEvent ev)
    {
        shapeType = CPnlMainAll.getvShapeType();
        Graphics2D g = (Graphics2D) getGraphics();
        g.setXORMode(Color.white);
        Point p1 = (Point) points.get(pointIndex - 1);
        if (CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.getSelectedIndex() == Cnfg.INT_AFFINE_TRANSFORMATION_NINGUNA) //Si no hay una tranformacion en curso entonces solo dibuja segun tu cursor la nueva figura
        {
            switch (shapeType)
            {
                case RECTANGLE:
                    if (p != null)
                    {
                        g.drawRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    }
                    p = ev.getPoint();
                    g.drawRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case ROUNDRECTANGLE2D:
                    if (p != null)
                    {
                        g.drawRoundRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                    }
                    p = ev.getPoint();
                    g.drawRoundRect(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 10, 10);
                    break;
                case ELLIPSE2D:
                    if (p != null)
                    {
                        g.drawOval(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    }
                    p = ev.getPoint();
                    g.drawOval(p1.x, p1.y, p.x - p1.x, p.y - p1.y);
                    break;
                case ARC2D:
                    if (p != null)
                    {
                        g.drawArc(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120);
                    }
                    p = ev.getPoint();
                    g.drawArc(p1.x, p1.y, p.x - p1.x, p.y - p1.y, 30, 120);
                    break;
                case LINE2D:
                case POLYGON:
                    if (p != null)
                    {
                        g.drawLine(p1.x, p1.y, p.x, p.y);
                    }
                    p = ev.getPoint();
                    g.drawLine(p1.x, p1.y, p.x, p.y);
                    break;
                case QUADCURVE2D:
                    if (pointIndex == 1)
                    {
                        if (p != null)
                        {
                            g.drawLine(p1.x, p1.y, p.x, p.y);
                        }
                        p = ev.getPoint();
                        g.drawLine(p1.x, p1.y, p.x, p.y);
                    } else
                    {
                        Point p2 = (Point) points.get(pointIndex - 2);
                        if (p != null)
                        {
                            g.draw(partialShape);
                        }
                        p = ev.getPoint();
                        partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                        g.draw(partialShape);
                    }
                    break;
                case CUBICCURVE2D:
                    if (pointIndex == 1)
                    {
                        if (p != null)
                        {
                            g.drawLine(p1.x, p1.y, p.x, p.y);
                        }
                        p = ev.getPoint();
                        g.drawLine(p1.x, p1.y, p.x, p.y);
                    } else if (pointIndex == 2)
                    {
                        Point p2 = (Point) points.get(pointIndex - 2);
                        if (p != null)
                        {
                            g.draw(partialShape);
                        }
                        p = ev.getPoint();
                        partialShape = new QuadCurve2D.Float(p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                        g.draw(partialShape);
                    } else
                    {
                        Point p2 = (Point) points.get(pointIndex - 2);
                        Point p3 = (Point) points.get(pointIndex - 3);
                        if (p != null)
                        {
                            g.draw(partialShape);
                        }
                        p = ev.getPoint();
                        partialShape = new CubicCurve2D.Float(p3.x, p3.y, p2.x, p2.y, p1.x, p1.y, p.x, p.y);
                        g.draw(partialShape);
                    }
                    break;
                case HEARTH:
                    if (p != null)
                    {
                        g.draw(new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigCorazon(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case PENTAGON:
                    if (p != null)
                    {
                        g.draw(new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigPentagono(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case STAR6P:
                    if (p != null)
                    {
                        g.draw(new FigEstrella6P(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigEstrella6P(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case CURSOR:
                    if (p != null)
                    {
                        g.draw(new FigCursor(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigCursor(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case SHURIKEN:
                    if (p != null)
                    {
                        g.draw(new FigEstrellaNinja(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigEstrellaNinja(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case BAT:
                    if (p != null)
                    {
                        g.draw(new FigMurcielago(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigMurcielago(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case STAIRS:
                    if (p != null)
                    {
                        g.draw(new FigEscaleras(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigEscaleras(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case HOUSE:
                    if (p != null)
                    {
                        g.draw(new FigCasa(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigCasa(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case TRIANGLE:
                    if (p != null)
                    {
                        g.draw(new FigTriangulo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigTriangulo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
                case RHOMB:
                    if (p != null)
                    {
                        g.draw(new FigRombo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    }
                    p = ev.getPoint();
                    g.draw(new FigRombo(p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                    break;
            }
            if (shapeType >= 25)
            {
                if (p != null)
                {
                    g.draw(CPnlMainAll.getRareObject(shapeType, p1.x, p1.y, p.x - p1.x, p.y - p1.y));
                }
                p = ev.getPoint();
                g.draw(CPnlMainAll.getRareObject(shapeType, p1.x, p1.y, p.x - p1.x, p.y - p1.y));
            }
        } else
        {
            for (int i = 0; i <= getShapes().size() - 1; i++)
            {
                if (getShapes().get(i).isSeleccion())
                {
                    double x0 = getShapes().get(i).getFigura().getBounds().x + getShapes().get(i).getFigura().getBounds().width / 2;
                    double y0 = getShapes().get(i).getFigura().getBounds().y + getShapes().get(i).getFigura().getBounds().height / 2;
                    p = ev.getPoint();
                    switch (CPnlMainAll.vjPnlEdicionMenu.vCBox_AFFINE_TRANFORMATIONS.getSelectedIndex())
                    {
                        case Cnfg.INT_AFFINE_TRANSFORMATION_TRANSLATION:
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToTranslation(p.x - p1.x, p.y - p1.y);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_ROTATION:
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToRotation(Math.atan2(p1.y - y0, p1.x - x0) - Math.atan2(p.y - y0, p.x - x0), x0, y0);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_SCALATION:

                            double sx = Math.abs((double) (0 - p.x) / (0 - p1.x));
                            double sy = Math.abs((double) (0 - p.y) / (0 - p1.y));
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToScale(sx, sy);
                            break;
                        case Cnfg.INT_AFFINE_TRANSFORMATION_SHEARING:
                            double shx = ((double) (p1.x - 0) / (p.x - 0)) - 1;
                            double shy = ((double) (p1.y - 0) / (p.y - 0)) - 1;
                            Cnfg.CONFIG_AFFINE_TRANSFORM.setToShear(shx, shy);
                            break;
                    }
                    if (p != null)
                    {
                        g.draw(Cnfg.CONFIG_AFFINE_TRANSFORM.createTransformedShape(getShapes().get(i).getFigura()));
                    }
                    g.draw(Cnfg.CONFIG_AFFINE_TRANSFORM.createTransformedShape(getShapes().get(i).getFigura()));
                }
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e)
    {

    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        //Este metodo permite que al presionar Ctrl se selecciones muchas figuras 
        if (e.getKeyCode() == KeyEvent.VK_CONTROL)
        {
            CPnlMainAll.setSELECCION_SIMPLE(false);
            CPnlMainAll.vLblSleccionMultiple.setText("Seleccion: Multiple");
        }
        setFocusable(true);
        requestFocusInWindow();
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        //Este metodo permite que al presionar Ctrl se coloque de nuevo la seleccion simple
        if (e.getKeyCode() == KeyEvent.VK_CONTROL)
        {
            CPnlMainAll.setSELECCION_SIMPLE(true);
            CPnlMainAll.vLblSleccionMultiple.setText("Seleccion: Simple");
        }
        setFocusable(true);
        requestFocusInWindow();
    }

    /**
     * @return the shapes
     */
    public static ArrayList<CMisFiguras> getShapes()
    {
        return shapes;
    }

    /**
     * @param aShapes the shapes to set
     */
    public static void setShapes(ArrayList<CMisFiguras> aShapes)
    {
        shapes = aShapes;
    }

}
