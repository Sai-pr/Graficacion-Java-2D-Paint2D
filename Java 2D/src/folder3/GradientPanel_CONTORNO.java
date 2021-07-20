/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Esta clase pone el a un panel con color gradiente
 *
 * @author saipr
 */
public class GradientPanel_CONTORNO extends JPanel implements MouseListener
{
    
    //GradientPaint gp = null;
    public GradientPanel_CONTORNO()
    {
        addMouseListener(this);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        int w = getWidth();
        int h = getHeight();
        g2d.setPaint(Cnfg.CONFIG_COLOR_CONTORNO_1);
        if (Cnfg.CONFIG_COLOR_CONTORNO_2 != null)
        {
            g2d.setPaint(new GradientPaint(0, 0, Cnfg.CONFIG_COLOR_CONTORNO_1, 0, 10, Cnfg.CONFIG_COLOR_CONTORNO_2, true));
        }
        g2d.fillRect(0, 0, w, h);
    }

    private BufferedImage getImage(String filename)
    {
        // This time, you can use an InputStream to load
        try
        {
            // Grab the InputStream for the image.
            InputStream in = getClass().getResourceAsStream(filename);
            // Then read it.
            return ImageIO.read(in);
        } catch (IOException e)
        {
            System.out.println("The image was not loaded.");
            //System.exit(1);
        }

        return null;
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        Cnfg.CONFIG_COLOR_CONTORNO_1 = new JColorChooser().showDialog(null, "Seleccione un color", Cnfg.CONFIG_COLOR_CONTORNO_1);
        if (CPnl_EDICION_FIGURAS.getRdBtnGradiente_CONTORNO().isSelected()) //En caso de que este seleccionado el color solido solo se pide un color
        {
            repaint();
            Cnfg.CONFIG_COLOR_CONTORNO_2 = new JColorChooser().showDialog(null, "Seleccione el color 2", (Cnfg.CONFIG_COLOR_CONTORNO_2 != null) ? Cnfg.CONFIG_COLOR_CONTORNO_2 : Cnfg.CONFIG_COLOR_CONTORNO_1);
        }
        repaint();
    }

    @Override
    public void mousePressed(MouseEvent e)
    {
    }

    @Override
    public void mouseReleased(MouseEvent e)
    {
    }

    @Override
    public void mouseEntered(MouseEvent e)
    {
        this.setBorder(new LineBorder(Cnfg.MOUSE_JPANEL_CLICKED, 2));
    }

    @Override
    public void mouseExited(MouseEvent e)
    {
        this.setBorder(null);
    }

}
