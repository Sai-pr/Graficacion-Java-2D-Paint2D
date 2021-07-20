package Pruebas;

import folder3.FigEstrellaNinja;
import folder3.FigMurcielago;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class WriteImageType
{

    static public void main(String args[]) throws Exception
    {
        try
        {
            int width = 512, height = 512;

            // TYPE_INT_ARGB specifies the image format: 8-bit RGBA packed
            // into integer pixels
            BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

            Graphics2D g2d = bi.createGraphics();
            FigEstrellaNinja bat = new FigEstrellaNinja(0, 0, width, height);

            AffineTransform tr = new AffineTransform();
            g2d.translate(85, 200);
            //g2d.scale(2, 2);
            tr.rotate(Math.toRadians(330));
            g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
            g2d.setStroke(new BasicStroke(20));
            g2d.setPaint(Color.black);

            Shape shape = tr.createTransformedShape(bat);
            g2d.draw(shape);
            /*Font font = new Font("TimesRoman", Font.BOLD, 20);
            g2d.setFont(font);
            String message = "www.java2s.com!";
            FontMetrics fontMetrics = g2d.getFontMetrics();
            int stringWidth = fontMetrics.stringWidth(message);
            int stringHeight = fontMetrics.getAscent();
            g2d.setPaint(Color.black);
            g2d.drawString(message, (width - stringWidth) / 2, height / 2 + stringHeight / 4);*/

            ImageIO.write(bi, "PNG", new File("C:\\Users\\saipr\\Desktop\\ninja_Ico.png"));
            //ImageIO.write(bi, "JPEG", new File("c:\\yourImageName.JPG"));
            //ImageIO.write(bi, "gif", new File("c:\\yourImageName.GIF"));
            //ImageIO.write(bi, "BMP", new File("c:\\yourImageName.BMP"));

        } catch (IOException ie)
        {
            ie.printStackTrace();
        }

    }
}
