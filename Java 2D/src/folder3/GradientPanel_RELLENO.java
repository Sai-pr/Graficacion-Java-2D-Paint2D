/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JColorChooser;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

/**
 * Esta clase pone el a un panel con color gradiente
 *
 * @author saipr
 */
public class GradientPanel_RELLENO extends JPanel implements MouseListener
{

    //GradientPaint gp = null;
    public GradientPanel_RELLENO()
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
        g2d.setPaint(Cnfg.CONFIG_COLOR_RELLENO_1);
        if (Cnfg.CONFIG_BUFFERED_IMAGE_RELLENO_3 != null)
        {
            g2d.setPaint(new TexturePaint(Cnfg.CONFIG_BUFFERED_IMAGE_RELLENO_3, new Rectangle(0, 0, 90, 60)));
        } else if (Cnfg.CONFIG_COLOR_RELLENO_2 != null)
        {
            g2d.setPaint(new GradientPaint(0, 0, Cnfg.CONFIG_COLOR_RELLENO_1, 0, 10, Cnfg.CONFIG_COLOR_RELLENO_2, true));
        }
        g2d.fillRect(0, 0, w, h);
    }

    @Override
    public void mouseClicked(MouseEvent e)
    {
        //if (CPnl_EDICION_FIGURAS.rdBtnTextura_RELLENO.isSelected())
        {
            //CDialogTexture n = new CDialogTexture(new javax.swing.JFrame(), true);
            //n.setVisible(true);
        } //else
        {
            Cnfg.CONFIG_COLOR_RELLENO_1 = new JColorChooser().showDialog(null, "Seleccione un color", Cnfg.CONFIG_COLOR_RELLENO_1);
            if (CPnl_EDICION_FIGURAS.rdBtnGradiente_RELLENO.isSelected()) //En caso de que este seleccionado el color solido solo se pide un color
            {
                repaint();
                Cnfg.CONFIG_COLOR_RELLENO_2 = new JColorChooser().showDialog(null, "Seleccione el color 2", (Cnfg.CONFIG_COLOR_RELLENO_2 != null) ? Cnfg.CONFIG_COLOR_RELLENO_2 : Cnfg.CONFIG_COLOR_RELLENO_1);
            }
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
        this.setBorder(new LineBorder(Color.BLACK, 1));
    }

}
