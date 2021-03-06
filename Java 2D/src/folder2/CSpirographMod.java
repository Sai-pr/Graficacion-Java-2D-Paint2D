/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder2;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 *
 * @author saipr
 */
public class CSpirographMod extends javax.swing.JPanel
{

    int nPoints = 1000;
    double r1 = 60;
    double r2 = 50;
    double p = 70;

    public CSpirographMod()
    {
        initComponents();
    }

    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.translate(200, 200);
        g2.setColor(Color.red);
        int x1 = (int) (r1 + r2 - p);
        int y1 = 0;
        int x2;
        int y2;
        for (int i = 0; i < nPoints; i++)
        {
            double t = i * Math.PI / 90;
            x2 = (int) ((r1 + r2) * Math.cos(t) - p * Math.cos((r1 + r2) * t / r2));
            y2 = (int) ((r1 + r2) * Math.sin(t) - p * Math.sin((r1 + r2) * t / r2));
            g2.drawLine(x1, y1, x2, y2);
            x1 = x2;
            y1 = y2;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        vPnlUp = new javax.swing.JPanel();
        vPnlCent = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout vPnlUpLayout = new javax.swing.GroupLayout(vPnlUp);
        vPnlUp.setLayout(vPnlUpLayout);
        vPnlUpLayout.setHorizontalGroup(
            vPnlUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        vPnlUpLayout.setVerticalGroup(
            vPnlUpLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        add(vPnlUp, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout vPnlCentLayout = new javax.swing.GroupLayout(vPnlCent);
        vPnlCent.setLayout(vPnlCentLayout);
        vPnlCentLayout.setHorizontalGroup(
            vPnlCentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 524, Short.MAX_VALUE)
        );
        vPnlCentLayout.setVerticalGroup(
            vPnlCentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 294, Short.MAX_VALUE)
        );

        add(vPnlCent, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel vPnlCent;
    private javax.swing.JPanel vPnlUp;
    // End of variables declaration//GEN-END:variables
}
