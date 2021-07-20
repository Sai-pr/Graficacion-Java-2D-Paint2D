/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package folder3;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author saipr
 */
public class CPnlMainAll extends javax.swing.JPanel
{

    // Variables globables
    //-> Boleanos para la interfaz responsiva
    public static final int PNL1_MENU_FIGURAS2D_CLICKED = 1; //Para saber si está seleccionado el panel 1
    public static final int PNL2_MENU_FIGURASMOD_CLICKED = 2; //Para saber si está seleccionado el panel 2
    public static final int PNL3_MENU_FIGURASPROPIAS_CLICKED = 3; //Para saber si está seleccionado el panel 3
    public static final int PNL4_MENU_EDICIONGFIGURAS_CLICKED = 4; //Para saber si está seleccionado el panel 3
    public static final int PNL5_GUARDAR_PROYECTO_CLICKED = 5; //Para saber si está seleccionado el panel 4
    public static final int PNL6_GUARDAR_FIGURA_CLICKED = 6; //Para saber si está seleccionado el panel 5
    private static boolean SELECCION_SIMPLE = true; //Para indicar que se seleccione la figura
    //private static boolean SELECCION_MULTIPLE = false; //Para indicar que se seleccione multiples figuras
    //-> Enteros que indican que ayudan con la interfaz dinamica
    public static int vPnlMnuFigsSeleccionado; //Este entero es para saber que opcion se escoje de las figuras
    public static int vPnlMnuOpcsSeleccionado; //Este entero ayuda a saber que opcion se escoje para guardar proyecto o figura
    private static int vShapeType = JavaDraw2DPanel.LINE2D; //Esta variable dice que figura se dibujará y por defecto siempre dibuja una linea2D    
    //-> jPanel en este caso son los que aparecen a la derecha de la interfaz
    public static CPnl_FIGURAS_2D vjPnlFiguras2D; //Este panel es para seleccionar a las figuras clasicas
    public static CPnl_FIGURAS_MOD vjPnlFigurasMOD; //Este panel es para seleccionar las figuras creadas por mi
    public static Cpnl_FIGURAS_CREADAS vjPnlFigurasCrd; //Este panel es para desplegar los botones de cada figura creadas
    public static CPnl_EDICION_FIGURAS vjPnlEdicionMenu; //Este panel contiene las opciones de edicion de las figuras
    // Fin de la declaracion de las variables globales
    private Object e;
    // Identificador de las figuras creadas
    public int id_Figura_Creada = 25;
    public static ArrayList<CustomF> arr_Figuras_Creadas = new ArrayList<>();
    public int ybutton = 5;
    public ArrayList<JButton> btns_Figuras = new ArrayList<>();

    public CPnlMainAll()
    {
        initComponents();
        vPnlMnuFigsSeleccionado = PNL1_MENU_FIGURAS2D_CLICKED;
        vjPnlFiguras2D = new CPnl_FIGURAS_2D();
        vjPnlFigurasMOD = new CPnl_FIGURAS_MOD();
        vjPnlFigurasCrd = new Cpnl_FIGURAS_CREADAS();
        vjPnlEdicionMenu = new CPnl_EDICION_FIGURAS();

        vPnlDer.add(vjPnlFiguras2D);
        vPnlDer.add(vjPnlFigurasMOD);
        vPnlDer.add(vjPnlFigurasCrd);
        vPnlDer.add(vjPnlEdicionMenu);

        mBtnPnlDibujos_CLICKED();
    }

    private void mBtnPnlOpcs_CLICKED()
    {
        switch (vPnlMnuOpcsSeleccionado)
        {
            case PNL5_GUARDAR_PROYECTO_CLICKED:
                vBtnGuargarProyecto.setBackground(Cnfg.MOUSE_JPANEL_CLICKED);
                vLblTxt4.setForeground(Cnfg.MOUSE_TEXTO_CLICKED);
                break;
            case PNL6_GUARDAR_FIGURA_CLICKED:
                vBtnGuargarFigura.setBackground(Cnfg.MOUSE_JPANEL_CLICKED);
                vLblTxt5.setForeground(Cnfg.MOUSE_TEXTO_CLICKED);
                break;
        }
    }

    public static void resetPnl()
    {
        vjPnlFiguras2D.setVisible(false);
        vjPnlFigurasMOD.setVisible(false);
        vjPnlFigurasCrd.setVisible(false);
        vjPnlEdicionMenu.setVisible(false);
    }

    //Este metodo dice que paneles quedan presionados y cuales no del menu de DIBUJOS
    public void mBtnPnlDibujos_CLICKED()
    {
        javaDraw2DPanel1.reiniciaFigurasSeleccionadas();
        javaDraw2DPanel1.repaint();
        vBtnFiguras2DMouseExited(null);
        vBtnFigurasMMouseExited(null);
        vBtnFigurasCMouseExited(null);
        resetPnl();
        switch (vPnlMnuFigsSeleccionado)
        {
            case PNL1_MENU_FIGURAS2D_CLICKED: // Cuando seleccionas las figuras principales
                vBtnFiguras2D.setBackground(Cnfg.MOUSE_JPANEL_CLICKED);
                vLblTxt1.setForeground(Cnfg.MOUSE_TEXTO_CLICKED);
                vjPnlFiguras2D.setVisible(true);
                break;

            case PNL2_MENU_FIGURASMOD_CLICKED:
                vBtnFigurasM.setBackground(Cnfg.MOUSE_JPANEL_CLICKED);
                vLblTxt2.setForeground(Cnfg.MOUSE_TEXTO_CLICKED);
                vjPnlFigurasMOD.setVisible(true);
                break;

            case PNL3_MENU_FIGURASPROPIAS_CLICKED:
                vBtnFigurasC.setBackground(Cnfg.MOUSE_JPANEL_CLICKED);
                vLblTxt3.setForeground(Cnfg.MOUSE_TEXTO_CLICKED);
                vjPnlFigurasCrd.setVisible(true);
                break;

            case PNL4_MENU_EDICIONGFIGURAS_CLICKED:
                vjPnlFigurasMOD.setVisible(true);
                break;
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
        java.awt.GridBagConstraints gridBagConstraints;

        vBtnGrpSup = new javax.swing.ButtonGroup();
        vPnlDer = new javax.swing.JPanel();
        vPnlCent = new javax.swing.JPanel();
        javaDraw2DPanel1 = new folder3.JavaDraw2DPanel();
        vPnlSup = new javax.swing.JPanel();
        vPnlBtnOpcs = new javax.swing.JPanel();
        vBtnGuargarProyecto = new javax.swing.JPanel();
        vLblTxt4 = new javax.swing.JLabel();
        vLblImg4 = new javax.swing.JLabel();
        vBtnGuargarFigura = new javax.swing.JPanel();
        vLblTxt5 = new javax.swing.JLabel();
        vLblImg5 = new javax.swing.JLabel();
        vPnlBtnsDibujos = new javax.swing.JPanel();
        vBtnFiguras2D = new javax.swing.JPanel();
        vLblTxt1 = new javax.swing.JLabel();
        vLblImg1 = new javax.swing.JLabel();
        vBtnFigurasM = new javax.swing.JPanel();
        vLblTxt2 = new javax.swing.JLabel();
        vLblImg2 = new javax.swing.JLabel();
        vBtnFigurasC = new javax.swing.JPanel();
        vLblTxt3 = new javax.swing.JLabel();
        vLblImg3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        vLblOpcionSeleccionado = new javax.swing.JLabel();
        vLblSleccionMultiple = new javax.swing.JLabel();
        vRdBtn_SELECCION_SIMPLE = new javax.swing.JRadioButton();
        vRdBtn_SELECCION_MULTIPLE = new javax.swing.JRadioButton();

        setFocusable(false);
        setMaximumSize(new java.awt.Dimension(1280, 720));
        setMinimumSize(new java.awt.Dimension(1280, 720));
        addKeyListener(new java.awt.event.KeyAdapter()
        {
            public void keyPressed(java.awt.event.KeyEvent evt)
            {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt)
            {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt)
            {
                formKeyTyped(evt);
            }
        });
        setLayout(new java.awt.BorderLayout());

        vPnlDer.setForeground(new java.awt.Color(204, 255, 204));
        add(vPnlDer, java.awt.BorderLayout.LINE_END);

        vPnlCent.setBackground(new java.awt.Color(204, 204, 255));
        vPnlCent.setLayout(new java.awt.BorderLayout());

        javaDraw2DPanel1.setMaximumSize(new java.awt.Dimension(1270, 620));
        javaDraw2DPanel1.setMinimumSize(new java.awt.Dimension(1270, 620));

        javax.swing.GroupLayout javaDraw2DPanel1Layout = new javax.swing.GroupLayout(javaDraw2DPanel1);
        javaDraw2DPanel1.setLayout(javaDraw2DPanel1Layout);
        javaDraw2DPanel1Layout.setHorizontalGroup(
            javaDraw2DPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1298, Short.MAX_VALUE)
        );
        javaDraw2DPanel1Layout.setVerticalGroup(
            javaDraw2DPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 654, Short.MAX_VALUE)
        );

        vPnlCent.add(javaDraw2DPanel1, java.awt.BorderLayout.CENTER);

        add(vPnlCent, java.awt.BorderLayout.CENTER);

        vPnlSup.setBackground(new java.awt.Color(220, 220, 220));
        vPnlSup.setFocusable(false);
        vPnlSup.setLayout(new javax.swing.BoxLayout(vPnlSup, javax.swing.BoxLayout.LINE_AXIS));

        vPnlBtnOpcs.setMinimumSize(new java.awt.Dimension(178, 68));
        vPnlBtnOpcs.setPreferredSize(new java.awt.Dimension(178, 100));
        vPnlBtnOpcs.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 0, 5));

        vBtnGuargarProyecto.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vBtnGuargarProyecto.setMinimumSize(new java.awt.Dimension(70, 58));
        vBtnGuargarProyecto.setPreferredSize(new java.awt.Dimension(89, 90));
        vBtnGuargarProyecto.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarProyectoMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarProyectoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarProyectoMouseExited(evt);
            }
        });
        vBtnGuargarProyecto.setLayout(new java.awt.BorderLayout());

        vLblTxt4.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        vLblTxt4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblTxt4.setText("G/C Proyecto");
        vBtnGuargarProyecto.add(vLblTxt4, java.awt.BorderLayout.SOUTH);

        vLblImg4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblImg4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/GuardarProyecto_Ico.png"))); // NOI18N
        vBtnGuargarProyecto.add(vLblImg4, java.awt.BorderLayout.CENTER);

        vPnlBtnOpcs.add(vBtnGuargarProyecto);

        vBtnGuargarFigura.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vBtnGuargarFigura.setMinimumSize(new java.awt.Dimension(70, 58));
        vBtnGuargarFigura.setPreferredSize(new java.awt.Dimension(89, 90));
        vBtnGuargarFigura.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarFiguraMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarFiguraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                vBtnGuargarFiguraMouseExited(evt);
            }
        });
        vBtnGuargarFigura.setLayout(new java.awt.BorderLayout());

        vLblTxt5.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        vLblTxt5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblTxt5.setText("G. Figura");
        vBtnGuargarFigura.add(vLblTxt5, java.awt.BorderLayout.SOUTH);

        vLblImg5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblImg5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/GuardarFigura_Ico.png"))); // NOI18N
        vBtnGuargarFigura.add(vLblImg5, java.awt.BorderLayout.CENTER);

        vPnlBtnOpcs.add(vBtnGuargarFigura);

        vPnlSup.add(vPnlBtnOpcs);

        vPnlBtnsDibujos.setLayout(new java.awt.GridBagLayout());

        vBtnFiguras2D.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vBtnFiguras2D.setMaximumSize(new java.awt.Dimension(61, 58));
        vBtnFiguras2D.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                vBtnFiguras2DMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                vBtnFiguras2DMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                vBtnFiguras2DMouseExited(evt);
            }
        });
        vBtnFiguras2D.setLayout(new java.awt.BorderLayout());

        vLblTxt1.setFont(new java.awt.Font("Tw Cen MT", 1, 14)); // NOI18N
        vLblTxt1.setForeground(new java.awt.Color(255, 0, 51));
        vLblTxt1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblTxt1.setText("Figuras 2D");
        vBtnFiguras2D.add(vLblTxt1, java.awt.BorderLayout.SOUTH);

        vLblImg1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblImg1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Figuras_Ico.png"))); // NOI18N
        vBtnFiguras2D.add(vLblImg1, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 30;
        vPnlBtnsDibujos.add(vBtnFiguras2D, gridBagConstraints);

        vBtnFigurasM.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vBtnFigurasM.setMaximumSize(new java.awt.Dimension(61, 58));
        vBtnFigurasM.setMinimumSize(new java.awt.Dimension(61, 58));
        vBtnFigurasM.setPreferredSize(new java.awt.Dimension(61, 58));
        vBtnFigurasM.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasMMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasMMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasMMouseExited(evt);
            }
        });
        vBtnFigurasM.setLayout(new java.awt.BorderLayout());

        vLblTxt2.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        vLblTxt2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblTxt2.setText("Figuras M");
        vBtnFigurasM.add(vLblTxt2, java.awt.BorderLayout.SOUTH);

        vLblImg2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblImg2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Figuras2_Ico.png"))); // NOI18N
        vBtnFigurasM.add(vLblImg2, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 30;
        vPnlBtnsDibujos.add(vBtnFigurasM, gridBagConstraints);

        vBtnFigurasC.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        vBtnFigurasC.setMaximumSize(new java.awt.Dimension(61, 58));
        vBtnFigurasC.setMinimumSize(new java.awt.Dimension(61, 58));
        vBtnFigurasC.setPreferredSize(new java.awt.Dimension(61, 58));
        vBtnFigurasC.addMouseListener(new java.awt.event.MouseAdapter()
        {
            public void mouseClicked(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasCMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasCMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt)
            {
                vBtnFigurasCMouseExited(evt);
            }
        });
        vBtnFigurasC.setLayout(new java.awt.BorderLayout());

        vLblTxt3.setFont(new java.awt.Font("Tw Cen MT", 0, 14)); // NOI18N
        vLblTxt3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblTxt3.setText("Figuras C");
        vBtnFigurasC.add(vLblTxt3, java.awt.BorderLayout.SOUTH);

        vLblImg3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        vLblImg3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Media/Figuras3_Ico.png"))); // NOI18N
        vBtnFigurasC.add(vLblImg3, java.awt.BorderLayout.CENTER);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 30;
        gridBagConstraints.ipady = 30;
        vPnlBtnsDibujos.add(vBtnFigurasC, gridBagConstraints);

        vPnlSup.add(vPnlBtnsDibujos);

        jPanel1.setForeground(new java.awt.Color(204, 255, 204));
        jPanel1.setMaximumSize(new java.awt.Dimension(193, 100));
        jPanel1.setMinimumSize(new java.awt.Dimension(193, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(193, 100));

        vLblOpcionSeleccionado.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        vLblOpcionSeleccionado.setText("Figuras 2D");

        vLblSleccionMultiple.setFont(new java.awt.Font("Tw Cen MT", 1, 18)); // NOI18N
        vLblSleccionMultiple.setText("Seleccion: Simple");

        vBtnGrpSup.add(vRdBtn_SELECCION_SIMPLE);
        vRdBtn_SELECCION_SIMPLE.setSelected(true);
        vRdBtn_SELECCION_SIMPLE.setText("Simple");
        vRdBtn_SELECCION_SIMPLE.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vRdBtn_SELECCION_SIMPLEActionPerformed(evt);
            }
        });

        vBtnGrpSup.add(vRdBtn_SELECCION_MULTIPLE);
        vRdBtn_SELECCION_MULTIPLE.setText("Multiple");
        vRdBtn_SELECCION_MULTIPLE.addActionListener(new java.awt.event.ActionListener()
        {
            public void actionPerformed(java.awt.event.ActionEvent evt)
            {
                vRdBtn_SELECCION_MULTIPLEActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vLblOpcionSeleccionado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(vRdBtn_SELECCION_SIMPLE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(vRdBtn_SELECCION_MULTIPLE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(vLblSleccionMultiple, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(vLblSleccionMultiple, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vRdBtn_SELECCION_SIMPLE)
                    .addComponent(vRdBtn_SELECCION_MULTIPLE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(vLblOpcionSeleccionado, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        vPnlSup.add(jPanel1);

        add(vPnlSup, java.awt.BorderLayout.PAGE_START);
    }// </editor-fold>//GEN-END:initComponents

    private void vBtnFiguras2DMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFiguras2DMouseEntered
    {//GEN-HEADEREND:event_vBtnFiguras2DMouseEntered
        if (vPnlMnuFigsSeleccionado != PNL1_MENU_FIGURAS2D_CLICKED)
        {
            vBtnFiguras2D.setBackground(Cnfg.MOUSE_JPANEL_ENTERED);
            vLblTxt1.setForeground(Cnfg.MOUSE_TEXTO_ENTERED);
            vLblTxt1.setFont(Cnfg.FONT_TEXTO_ENTERED);
        }
    }//GEN-LAST:event_vBtnFiguras2DMouseEntered

    private void vBtnFiguras2DMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFiguras2DMouseExited
    {//GEN-HEADEREND:event_vBtnFiguras2DMouseExited
        if (vPnlMnuFigsSeleccionado != PNL1_MENU_FIGURAS2D_CLICKED)
        {
            vBtnFiguras2D.setBackground(Cnfg.MOUSE_JPANEL_EXITED);
            vLblTxt1.setForeground(Cnfg.MOUSE_TEXTO_EXITED);
            vLblTxt1.setFont(Cnfg.FONT_TEXTO_EXITED);
        }
    }//GEN-LAST:event_vBtnFiguras2DMouseExited

    private void vBtnFigurasMMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasMMouseExited
    {//GEN-HEADEREND:event_vBtnFigurasMMouseExited
        if (vPnlMnuFigsSeleccionado != PNL2_MENU_FIGURASMOD_CLICKED)
        {
            vBtnFigurasM.setBackground(Cnfg.MOUSE_JPANEL_EXITED);
            vLblTxt2.setForeground(Cnfg.MOUSE_TEXTO_EXITED);
            vLblTxt2.setFont(Cnfg.FONT_TEXTO_EXITED);
        }
    }//GEN-LAST:event_vBtnFigurasMMouseExited

    private void vBtnFigurasMMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasMMouseEntered
    {//GEN-HEADEREND:event_vBtnFigurasMMouseEntered
        if (vPnlMnuFigsSeleccionado != PNL2_MENU_FIGURASMOD_CLICKED)
        {
            vBtnFigurasM.setBackground(Cnfg.MOUSE_JPANEL_ENTERED);
            vLblTxt2.setForeground(Cnfg.MOUSE_TEXTO_ENTERED);
            vLblTxt2.setFont(Cnfg.FONT_TEXTO_ENTERED);
        }
    }//GEN-LAST:event_vBtnFigurasMMouseEntered

    private void vBtnFigurasCMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasCMouseEntered
    {//GEN-HEADEREND:event_vBtnFigurasCMouseEntered
        if (vPnlMnuFigsSeleccionado != PNL4_MENU_EDICIONGFIGURAS_CLICKED)
        {
            vBtnFigurasC.setBackground(Cnfg.MOUSE_JPANEL_ENTERED);
            vLblTxt3.setForeground(Cnfg.MOUSE_TEXTO_ENTERED);
            vLblTxt3.setFont(Cnfg.FONT_TEXTO_ENTERED);
        }
    }//GEN-LAST:event_vBtnFigurasCMouseEntered

    private void vBtnFigurasCMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasCMouseExited
    {//GEN-HEADEREND:event_vBtnFigurasCMouseExited
        if (vPnlMnuFigsSeleccionado != PNL4_MENU_EDICIONGFIGURAS_CLICKED)
        {
            vBtnFigurasC.setBackground(Cnfg.MOUSE_JPANEL_EXITED);
            vLblTxt3.setForeground(Cnfg.MOUSE_TEXTO_EXITED);
            vLblTxt3.setFont(Cnfg.FONT_TEXTO_EXITED);
        }
    }//GEN-LAST:event_vBtnFigurasCMouseExited

    private void vBtnFiguras2DMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFiguras2DMouseClicked
    {//GEN-HEADEREND:event_vBtnFiguras2DMouseClicked
        vShapeType = vjPnlFiguras2D.vShapeType;
        vPnlMnuFigsSeleccionado = PNL1_MENU_FIGURAS2D_CLICKED;
        vLblOpcionSeleccionado.setText("Figuras 2D");
        mBtnPnlDibujos_CLICKED();
    }//GEN-LAST:event_vBtnFiguras2DMouseClicked

    private void vBtnFigurasMMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasMMouseClicked
    {//GEN-HEADEREND:event_vBtnFigurasMMouseClicked
        vShapeType = vjPnlFigurasMOD.vShapeType;
        vPnlMnuFigsSeleccionado = PNL2_MENU_FIGURASMOD_CLICKED;
        vLblOpcionSeleccionado.setText("Figuras Modificadas");
        mBtnPnlDibujos_CLICKED();
    }//GEN-LAST:event_vBtnFigurasMMouseClicked

    private void vBtnFigurasCMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnFigurasCMouseClicked
    {//GEN-HEADEREND:event_vBtnFigurasCMouseClicked
        vPnlMnuFigsSeleccionado = PNL3_MENU_FIGURASPROPIAS_CLICKED;
        vLblOpcionSeleccionado.setText("Figuras Creadas");
        mBtnPnlDibujos_CLICKED();
    }//GEN-LAST:event_vBtnFigurasCMouseClicked

    private void vBtnGuargarProyectoMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarProyectoMouseClicked
    {//GEN-HEADEREND:event_vBtnGuargarProyectoMouseClicked
        vPnlMnuOpcsSeleccionado = PNL5_GUARDAR_PROYECTO_CLICKED;
        mBtnPnlOpcs_CLICKED();

        String arr[] =
        {
            "Guardar proyecto", "Cargar Proyecto", "Cancelar"
        };

        switch (JOptionPane.showOptionDialog(this, "¿Que desea hacer con el proyecto?", "Guardar/Cargar Proyecto",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon("src/media/GuardarProyecto_Ico.png"),
                arr, "Option"))
        {
            case 0: //Guardar proyecto

                try
                {
                    //ControladorCanvas cc = new ControladorCanvas();
                    //cc.setShapes(panelPaint.shapes);
                    SalvarCargarProyecto.serializeShapes(JavaDraw2DPanel.getShapes());

                    JOptionPane.showMessageDialog(this, "Proyecto guardado con éxito");
                } catch (IOException ex)
                {
                    System.out.println("Error al guardar proyecto: " + ex.toString());
                }

                break;
            case 1: //Cargar proyecto

                FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivo de Canvas", "xml");
                JFileChooser selectorArchivos = new JFileChooser();
                selectorArchivos.setFileSelectionMode(JFileChooser.FILES_ONLY);
                selectorArchivos.setFileFilter(filtro);

                try
                {
                    // indica cual fue la accion de usuario sobre el jfilechooser
                    int resultado = resultado = selectorArchivos.showOpenDialog(null);
                    if (resultado == JFileChooser.APPROVE_OPTION)
                    {
                        File archivo = selectorArchivos.getSelectedFile(); // obtiene el archivo seleccionado

                        //ControladorCanvas loadedSettings = SalvarCargarProyecto.deserializeFromXML(archivo);
                        //System.out.println(loadedSettings.getSavedProject().size());
                        javaDraw2DPanel1.shapes = SalvarCargarProyecto.deserializeShapes(archivo);
                        javaDraw2DPanel1.repaint();
                    }
                } catch (HeadlessException | IOException e)
                {
                    System.out.println("Error al cargar proyecto: " + e);
                }

                break;
            case 2: //Cancelar

                break;

        }
    }//GEN-LAST:event_vBtnGuargarProyectoMouseClicked

    private void vBtnGuargarProyectoMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarProyectoMouseEntered
    {//GEN-HEADEREND:event_vBtnGuargarProyectoMouseEntered
        vBtnGuargarProyecto.setBackground(Cnfg.MOUSE_JPANEL_ENTERED);
        vLblTxt4.setForeground(Cnfg.MOUSE_TEXTO_ENTERED);
        vLblTxt4.setFont(Cnfg.FONT_TEXTO_ENTERED);
    }//GEN-LAST:event_vBtnGuargarProyectoMouseEntered

    private void vBtnGuargarProyectoMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarProyectoMouseExited
    {//GEN-HEADEREND:event_vBtnGuargarProyectoMouseExited
        vBtnGuargarProyecto.setBackground(Cnfg.MOUSE_JPANEL_EXITED);
        vLblTxt4.setForeground(Cnfg.MOUSE_TEXTO_EXITED);
        vLblTxt4.setFont(Cnfg.FONT_TEXTO_EXITED);
    }//GEN-LAST:event_vBtnGuargarProyectoMouseExited

    private void vBtnGuargarFiguraMouseClicked(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarFiguraMouseClicked
    {//GEN-HEADEREND:event_vBtnGuargarFiguraMouseClicked
        boolean found = false;
        for (int i = JavaDraw2DPanel.getShapes().size() - 1; i >= 0; i--)
        {
            if (JavaDraw2DPanel.getShapes().get(i).isSeleccion() /*&& shape.isCreada()*/)
            {
                String nombre = JOptionPane.showInputDialog(this, "Ingrese un nombre para la figura").trim();
                //Agregamos la figura
                arr_Figuras_Creadas.add(new CustomF(PathBean.getSegmentsFromShape(JavaDraw2DPanel.getShapes().get(i).getFigura()), nombre, id_Figura_Creada));
                found = true;
                System.out.println("Tamaño del arreglo de figras: " + JavaDraw2DPanel.getShapes().size());
                //Agregamos el boton al panel
                JButton btn = new JButton(nombre);
                //setButtonStyled(btn, new Color(201, 203, 163), new Color(135, 152, 106), true); //Berde obscuro claro de fondo, Color verde mas obscuro
                btn.setBounds(5, 5, 100, 30);
                btn.setLocation(10, ybutton);
                btn.setFont(new Font("Segoe UI Semibold", Font.BOLD, 14));
                btn.setForeground(Color.BLACK);
                btns_Figuras.add(btn);
            }
        }
        //Acualizamos los botones para hacer false el nuevo agregado
        //refrescaBotones(false);

        ybutton += 35;
        id_Figura_Creada++;
        refrescaBotones();
        if (!found)
        {
            JOptionPane.showMessageDialog(this, "Porfavor selecciona un objeto");
        }
        //vPnlMnuOpcsSeleccionado = PNL6_GUARDAR_FIGURA_CLICKED;
        mBtnPnlOpcs_CLICKED();
    }//GEN-LAST:event_vBtnGuargarFiguraMouseClicked

    public void refrescaBotones(/*boolean bol*/)
    {
        for (int i = 0; i < btns_Figuras.size(); i++)
        {
            JButton j1 = btns_Figuras.get(i);
            btns_Figuras.get(i).addActionListener(new ActionListener()
            {
                @Override
                public void actionPerformed(ActionEvent ae)
                {
                    for (int j = 0; j < arr_Figuras_Creadas.size(); j++)
                    {
                        if (arr_Figuras_Creadas.get(j).getNombre().equals(j1.getText()))
                        {
                            vShapeType = arr_Figuras_Creadas.get(j).getIdentificador(); //AQUI POSIBLE HACKEO
                            //vShapeType = javaDraw2DPanel1.shapeType;
                            //System.out.println("vShapeType = " + vShapeType);
                            //System.out.println("Canvas shapeType = " + javaDraw2DPanel1.shapeType);
                        }
                    }
                }
            });
            /*j1.setEnabled(bol);*/
            Cpnl_FIGURAS_CREADAS.vPnlBotones.add(j1);
            Cpnl_FIGURAS_CREADAS.vPnlBotones.updateUI();
        }
    }

    public static Shape getRareObject(int identificador, float x, float y, float w, float h)
    {
        Shape s = null;
        for (int i = 0; i < arr_Figuras_Creadas.size(); i++)
        {
            if (arr_Figuras_Creadas.get(i).getIdentificador() == identificador)
            {
                s = PathBean.getShapeFromSegments(arr_Figuras_Creadas.get(i).getSegmentos(), x, y, w, h);
            }
        }
        return s;
    }

    private void vBtnGuargarFiguraMouseEntered(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarFiguraMouseEntered
    {//GEN-HEADEREND:event_vBtnGuargarFiguraMouseEntered
        vBtnGuargarFigura.setBackground(Cnfg.MOUSE_JPANEL_ENTERED);
        vLblTxt5.setForeground(Cnfg.MOUSE_TEXTO_ENTERED);
        vLblTxt5.setFont(Cnfg.FONT_TEXTO_ENTERED);
    }//GEN-LAST:event_vBtnGuargarFiguraMouseEntered

    private void vBtnGuargarFiguraMouseExited(java.awt.event.MouseEvent evt)//GEN-FIRST:event_vBtnGuargarFiguraMouseExited
    {//GEN-HEADEREND:event_vBtnGuargarFiguraMouseExited
        vBtnGuargarFigura.setBackground(Cnfg.MOUSE_JPANEL_EXITED);
        vLblTxt5.setForeground(Cnfg.MOUSE_TEXTO_EXITED);
        vLblTxt5.setFont(Cnfg.FONT_TEXTO_EXITED);
    }//GEN-LAST:event_vBtnGuargarFiguraMouseExited

    private void formKeyPressed(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyPressed
    {//GEN-HEADEREND:event_formKeyPressed
        System.out.println("PRESIONASTE: " + evt.getKeyChar() + "; Key Code: " + KeyEvent.getKeyText(evt.getKeyCode()));
        CPnlMainAll.setSELECCION_SIMPLE(false);
        System.out.println("");
    }//GEN-LAST:event_formKeyPressed

    private void formKeyTyped(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyTyped
    {//GEN-HEADEREND:event_formKeyTyped
        System.out.println("SOLTASTE: " + evt.getKeyChar() + "; Key Code: " + KeyEvent.getKeyText(evt.getKeyCode()));
        CPnlMainAll.setSELECCION_SIMPLE(true);
        System.out.println("");
    }//GEN-LAST:event_formKeyTyped

    private void formKeyReleased(java.awt.event.KeyEvent evt)//GEN-FIRST:event_formKeyReleased
    {//GEN-HEADEREND:event_formKeyReleased

    }//GEN-LAST:event_formKeyReleased

    private void vRdBtn_SELECCION_SIMPLEActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_vRdBtn_SELECCION_SIMPLEActionPerformed
    {//GEN-HEADEREND:event_vRdBtn_SELECCION_SIMPLEActionPerformed
        SELECCION_SIMPLE = true;
        vLblSleccionMultiple.setText("Seleccion: Simple");
    }//GEN-LAST:event_vRdBtn_SELECCION_SIMPLEActionPerformed

    private void vRdBtn_SELECCION_MULTIPLEActionPerformed(java.awt.event.ActionEvent evt)//GEN-FIRST:event_vRdBtn_SELECCION_MULTIPLEActionPerformed
    {//GEN-HEADEREND:event_vRdBtn_SELECCION_MULTIPLEActionPerformed
        SELECCION_SIMPLE = false;
        vLblSleccionMultiple.setText("Seleccion: Múltiple");
    }//GEN-LAST:event_vRdBtn_SELECCION_MULTIPLEActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JPanel jPanel1;
    public static folder3.JavaDraw2DPanel javaDraw2DPanel1;
    private static javax.swing.JPanel vBtnFiguras2D;
    private static javax.swing.JPanel vBtnFigurasC;
    private static javax.swing.JPanel vBtnFigurasM;
    private javax.swing.ButtonGroup vBtnGrpSup;
    private static javax.swing.JPanel vBtnGuargarFigura;
    private static javax.swing.JPanel vBtnGuargarProyecto;
    private javax.swing.JLabel vLblImg1;
    private javax.swing.JLabel vLblImg2;
    private javax.swing.JLabel vLblImg3;
    private javax.swing.JLabel vLblImg4;
    private javax.swing.JLabel vLblImg5;
    public static javax.swing.JLabel vLblOpcionSeleccionado;
    public static javax.swing.JLabel vLblSleccionMultiple;
    private javax.swing.JLabel vLblTxt1;
    private javax.swing.JLabel vLblTxt2;
    private javax.swing.JLabel vLblTxt3;
    private javax.swing.JLabel vLblTxt4;
    private javax.swing.JLabel vLblTxt5;
    private static javax.swing.JPanel vPnlBtnOpcs;
    private static javax.swing.JPanel vPnlBtnsDibujos;
    static javax.swing.JPanel vPnlCent;
    static javax.swing.JPanel vPnlDer;
    static javax.swing.JPanel vPnlSup;
    private javax.swing.JRadioButton vRdBtn_SELECCION_MULTIPLE;
    private javax.swing.JRadioButton vRdBtn_SELECCION_SIMPLE;
    // End of variables declaration//GEN-END:variables

    /**
     * @return the vShapeType
     */
    public static int getvShapeType()
    {
        return vShapeType;
    }

    /**
     * @param avShapeType the vShapeType to set
     */
    public static void setvShapeType(int avShapeType)
    {
        vShapeType = avShapeType;
    }

    /**
     * @return the SELECCION_SIMPLE
     */
    public static boolean isSeleccionSimple()
    {
        return isSELECCION_SIMPLE();
    }

    /**
     * @param aSeleccionSimple the SELECCION_SIMPLE to set
     */
    public static void setSeleccionSimple(boolean aSeleccionSimple)
    {
        setSELECCION_SIMPLE(aSeleccionSimple);
    }

    /**
     * @return the SELECCION_SIMPLE
     */
    public static boolean isSELECCION_SIMPLE()
    {
        return SELECCION_SIMPLE;
    }

    /**
     * @param aSELECCION_SIMPLE the SELECCION_SIMPLE to set
     */
    public static void setSELECCION_SIMPLE(boolean aSELECCION_SIMPLE)
    {
        SELECCION_SIMPLE = aSELECCION_SIMPLE;
    }

}
