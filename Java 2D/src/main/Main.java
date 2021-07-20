/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import javax.swing.JSlider;

/**
 *
 * @author saipr
 */
public class Main extends javax.swing.JFrame
{
    
    public Main()
    {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        vTbbdPnlCarpetas = new javax.swing.JTabbedPane();
        vPnlFolder1 = new javax.swing.JPanel();
        vTbbdPnlSubCarpeta1 = new javax.swing.JTabbedPane();
        vTbbdPnlFolder1Subcarpeta1 = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        cPnlHello2D1 = new folder1.CPnlHello2D();
        vTbbdPnlFolder1Subcarpeta3 = new javax.swing.JPanel();
        cPnlDrawShapes1 = new folder1.CPnlDrawShapes();
        vTbbdPnlFolder1Subcarpeta4 = new javax.swing.JPanel();
        cPnlAreaGeometry2 = new folder1.CPnlAreaGeometry();
        jPanel2 = new javax.swing.JPanel();
        cSpirograph1 = new folder1.CSpirograph();
        jPanel8 = new javax.swing.JPanel();
        cMainTextColorPanel1 = new folder1.CMainTestColorPanel();
        vPnlFolder2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel4 = new javax.swing.JPanel();
        cPnlHello2D2 = new folder2.CPnlHello2DMod();
        jPanel5 = new javax.swing.JPanel();
        cPnlDrawShapes2 = new folder2.CPnlDrawShapesMod();
        jPanel6 = new javax.swing.JPanel();
        cPnlAreaGeometryMod1 = new folder2.CPnlAreaGeometryMod();
        jPanel7 = new javax.swing.JPanel();
        cSpirographMod1 = new folder2.CSpirographMod();
        jPanel9 = new javax.swing.JPanel();
        cMainTestColorPanel1 = new folder2.CMainTestColorPanel();
        vPnlFolder3 = new javax.swing.JPanel();
        cPnlMainAll1 = new folder3.CPnlMainAll();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Proyecto");
        setMinimumSize(new java.awt.Dimension(1280, 720));

        vPnlFolder1.setLayout(new java.awt.BorderLayout());

        vTbbdPnlFolder1Subcarpeta1.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout cPnlHello2D1Layout = new javax.swing.GroupLayout(cPnlHello2D1);
        cPnlHello2D1.setLayout(cPnlHello2D1Layout);
        cPnlHello2D1Layout.setHorizontalGroup(
            cPnlHello2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        cPnlHello2D1Layout.setVerticalGroup(
            cPnlHello2D1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cPnlHello2D1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cPnlHello2D1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        vTbbdPnlFolder1Subcarpeta1.add(jPanel1, java.awt.BorderLayout.CENTER);

        vTbbdPnlSubCarpeta1.addTab("Hello2D", vTbbdPnlFolder1Subcarpeta1);

        vTbbdPnlFolder1Subcarpeta3.setLayout(new java.awt.BorderLayout());
        vTbbdPnlFolder1Subcarpeta3.add(cPnlDrawShapes1, java.awt.BorderLayout.CENTER);

        vTbbdPnlSubCarpeta1.addTab("DrawShapes", vTbbdPnlFolder1Subcarpeta3);

        vTbbdPnlFolder1Subcarpeta4.setLayout(new java.awt.BorderLayout());

        cPnlAreaGeometry2.setOpaque(false);

        javax.swing.GroupLayout cPnlAreaGeometry2Layout = new javax.swing.GroupLayout(cPnlAreaGeometry2);
        cPnlAreaGeometry2.setLayout(cPnlAreaGeometry2Layout);
        cPnlAreaGeometry2Layout.setHorizontalGroup(
            cPnlAreaGeometry2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        cPnlAreaGeometry2Layout.setVerticalGroup(
            cPnlAreaGeometry2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        vTbbdPnlFolder1Subcarpeta4.add(cPnlAreaGeometry2, java.awt.BorderLayout.CENTER);

        vTbbdPnlSubCarpeta1.addTab("AreaGeometry", vTbbdPnlFolder1Subcarpeta4);

        jPanel2.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout cSpirograph1Layout = new javax.swing.GroupLayout(cSpirograph1);
        cSpirograph1.setLayout(cSpirograph1Layout);
        cSpirograph1Layout.setHorizontalGroup(
            cSpirograph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        cSpirograph1Layout.setVerticalGroup(
            cSpirograph1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jPanel2.add(cSpirograph1, java.awt.BorderLayout.CENTER);

        vTbbdPnlSubCarpeta1.addTab("Spirografo", jPanel2);

        jPanel8.setLayout(new java.awt.BorderLayout());
        jPanel8.add(cMainTextColorPanel1, java.awt.BorderLayout.CENTER);

        vTbbdPnlSubCarpeta1.addTab("Test Color", jPanel8);

        vPnlFolder1.add(vTbbdPnlSubCarpeta1, java.awt.BorderLayout.CENTER);

        vTbbdPnlCarpetas.addTab("Carpeta 1", vPnlFolder1);

        vPnlFolder2.setLayout(new java.awt.BorderLayout());

        jPanel3.setLayout(new java.awt.BorderLayout());

        jPanel4.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout cPnlHello2D2Layout = new javax.swing.GroupLayout(cPnlHello2D2);
        cPnlHello2D2.setLayout(cPnlHello2D2Layout);
        cPnlHello2D2Layout.setHorizontalGroup(
            cPnlHello2D2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        cPnlHello2D2Layout.setVerticalGroup(
            cPnlHello2D2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jPanel4.add(cPnlHello2D2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Hello2D Mod", jPanel4);

        jPanel5.setLayout(new java.awt.BorderLayout());
        jPanel5.add(cPnlDrawShapes2, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("DrawShapes Mod", jPanel5);

        jPanel6.setLayout(new java.awt.BorderLayout());

        cPnlAreaGeometryMod1.setOpaque(false);

        javax.swing.GroupLayout cPnlAreaGeometryMod1Layout = new javax.swing.GroupLayout(cPnlAreaGeometryMod1);
        cPnlAreaGeometryMod1.setLayout(cPnlAreaGeometryMod1Layout);
        cPnlAreaGeometryMod1Layout.setHorizontalGroup(
            cPnlAreaGeometryMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1275, Short.MAX_VALUE)
        );
        cPnlAreaGeometryMod1Layout.setVerticalGroup(
            cPnlAreaGeometryMod1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 692, Short.MAX_VALUE)
        );

        jPanel6.add(cPnlAreaGeometryMod1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("AreaGeometry Mod", jPanel6);

        cSpirographMod1.setOpaque(false);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cSpirographMod1, javax.swing.GroupLayout.DEFAULT_SIZE, 1275, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(cSpirographMod1, javax.swing.GroupLayout.DEFAULT_SIZE, 692, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Espirografo Mod", jPanel7);

        jPanel9.setLayout(new java.awt.BorderLayout());

        cMainTestColorPanel1.addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                cMainTestColorPanel1KeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                cMainTestColorPanel1KeyTyped(evt);
            }
        });
        jPanel9.add(cMainTestColorPanel1, java.awt.BorderLayout.CENTER);

        jTabbedPane1.addTab("Test Color Mod", jPanel9);

        jPanel3.add(jTabbedPane1, java.awt.BorderLayout.CENTER);

        vPnlFolder2.add(jPanel3, java.awt.BorderLayout.CENTER);

        vTbbdPnlCarpetas.addTab("Carpeta 2", vPnlFolder2);

        vPnlFolder3.setLayout(new java.awt.BorderLayout());
        vPnlFolder3.add(cPnlMainAll1, java.awt.BorderLayout.CENTER);

        vTbbdPnlCarpetas.addTab("Carpeta 3 (Paint 2D)", vPnlFolder3);

        getContentPane().add(vTbbdPnlCarpetas, java.awt.BorderLayout.CENTER);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void cMainTestColorPanel1KeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_cMainTestColorPanel1KeyPressed
    {//GEN-HEADEREND:event_cMainTestColorPanel1KeyPressed
        
    }//GEN-LAST:event_cMainTestColorPanel1KeyPressed

    private void cMainTestColorPanel1KeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_cMainTestColorPanel1KeyTyped
    {//GEN-HEADEREND:event_cMainTestColorPanel1KeyTyped
        
    }//GEN-LAST:event_cMainTestColorPanel1KeyTyped

    public static void main(String args[])
    {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try
        {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels())
            {
                if ("Nimbus".equals(info.getName()))
                {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex)
        {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private folder2.CMainTestColorPanel cMainTestColorPanel1;
    private folder1.CMainTestColorPanel cMainTextColorPanel1;
    private folder1.CPnlAreaGeometry cPnlAreaGeometry2;
    private folder2.CPnlAreaGeometryMod cPnlAreaGeometryMod1;
    private folder1.CPnlDrawShapes cPnlDrawShapes1;
    private folder2.CPnlDrawShapesMod cPnlDrawShapes2;
    private folder1.CPnlHello2D cPnlHello2D1;
    private folder2.CPnlHello2DMod cPnlHello2D2;
    private folder3.CPnlMainAll cPnlMainAll1;
    private folder1.CSpirograph cSpirograph1;
    private folder2.CSpirographMod cSpirographMod1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JPanel vPnlFolder1;
    private javax.swing.JPanel vPnlFolder2;
    private javax.swing.JPanel vPnlFolder3;
    private javax.swing.JTabbedPane vTbbdPnlCarpetas;
    private javax.swing.JPanel vTbbdPnlFolder1Subcarpeta1;
    private javax.swing.JPanel vTbbdPnlFolder1Subcarpeta3;
    private javax.swing.JPanel vTbbdPnlFolder1Subcarpeta4;
    private javax.swing.JTabbedPane vTbbdPnlSubCarpeta1;
    // End of variables declaration//GEN-END:variables
}
