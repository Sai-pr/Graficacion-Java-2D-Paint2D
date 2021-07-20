/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.TexturePaint;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * Esta clase dibuja una imagen dentro del panel
 *
 * @author saipr
 */
public class ImagePanel extends JPanel
{

    public static String ruta_Img = "FUEGO";

    public void paintComponent(Graphics g)
    {
        int w = getWidth();
        int h = getHeight();
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        TexturePaint tP = new TexturePaint(loadImage(), new Rectangle(0, 0, 200, 200));
        g2d.setPaint(tP);
        g2d.drawImage(loadImage(), 0, 0, 200, 200, this
        );
    }

    public BufferedImage loadImage()
    {
        BufferedImage img = null;
        try
        {
            img = ImageIO.read(getClass().getResource("/media/TEXTURA_" + ruta_Img + ".jpg"));
            Cnfg.CONFIG_BUFFERED_IMAGE_RELLENO_3 = img;
            //repaint();
            return img;
        } catch (IOException e)
        {
        }
        return img;
    }

}
