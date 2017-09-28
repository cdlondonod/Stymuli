/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.frmanalisis.form1chart;
import static UI.frmanalisis.form2chart;
import static UI.frmanalisis.form3chart;
import static UI.frmanalisis.form4chart;
import static UI.frmanalisis.form4chartkpi;
import static UI.frmanalisis.form5chart;
import static UI.frmresultados.formcompchart;
import static UI.frmresultados.formobtpe;
import java.awt.BorderLayout;

import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author crist
 */
public class INICIO extends javax.swing.JFrame {

    frmareasubar forms;
    frmanalisis forma;
    frmkpi formk;
    frmmodelo formm;
    frmresultados formr;
    frmtrabajador formt;
    frmsimulacion formsim;
    frmperfil formpe;

    /**
     * Creates new form INICIO
     */
    public INICIO() {
        initComponents();

        /* lblinicioidpersona.setVisible(false);
        lblinicionombre.setVisible(false);
        lblinicio1erapellido.setVisible(false);
        lblinicio2doapellido.setVisible(false);
        lbliniciodocumento.setVisible(false);
        lblinicioemail.setVisible(false);
        lblinicioidarea.setVisible(false);
        lblinicioarea.setVisible(false);
        lblinicioidsubarea.setVisible(false);
        lbliniciosubarea.setVisible(false);
        lblinicioacceso.setVisible(false);*/
        this.setExtendedState(INICIO.MAXIMIZED_BOTH);
        this.setTitle("STYMULI");

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        escritorio = new javax.swing.JDesktopPane();
        pnlmain = new javax.swing.JPanel();
        pnlmenulistbuttons = new javax.swing.JPanel();
        btnperfil = new javax.swing.JButton();
        btnanalisis = new javax.swing.JButton();
        btnresultados = new javax.swing.JButton();
        btnmodelos = new javax.swing.JButton();
        btnkpi = new javax.swing.JButton();
        btnusuarios = new javax.swing.JButton();
        btnareas = new javax.swing.JButton();
        btnsimulac = new javax.swing.JButton();
        lblinicionombre = new javax.swing.JLabel();
        lblinicioidpersona = new javax.swing.JLabel();
        lblinicio1erapellido = new javax.swing.JLabel();
        lblinicio2doapellido = new javax.swing.JLabel();
        lbliniciodocumento = new javax.swing.JLabel();
        lblinicioemail = new javax.swing.JLabel();
        lblinicioidarea = new javax.swing.JLabel();
        lblinicioarea = new javax.swing.JLabel();
        lblinicioidsubarea = new javax.swing.JLabel();
        lbliniciosubarea = new javax.swing.JLabel();
        lblinicioacceso = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        escritorio.setBackground(new java.awt.Color(153, 255, 51));

        pnlmain.setBackground(new java.awt.Color(255, 255, 255));

        pnlmenulistbuttons.setBackground(new java.awt.Color(54, 29, 120));
        pnlmenulistbuttons.setPreferredSize(new java.awt.Dimension(400, 400));
        pnlmenulistbuttons.setLayout(new javax.swing.BoxLayout(pnlmenulistbuttons, javax.swing.BoxLayout.X_AXIS));

        btnperfil.setBackground(new java.awt.Color(0, 0, 0));
        btnperfil.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnperfil.setForeground(new java.awt.Color(255, 255, 255));
        btnperfil.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/miperfil.png"))); // NOI18N
        btnperfil.setText("Mi Perfil");
        btnperfil.setToolTipText("Mi Perfil");
        btnperfil.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnperfil.setBorderPainted(false);
        btnperfil.setContentAreaFilled(false);
        btnperfil.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnperfil.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnperfil.setMaximumSize(new java.awt.Dimension(140, 53));
        btnperfil.setMinimumSize(new java.awt.Dimension(140, 53));
        btnperfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnperfilActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnperfil);

        btnanalisis.setBackground(new java.awt.Color(0, 0, 0));
        btnanalisis.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnanalisis.setForeground(new java.awt.Color(255, 255, 255));
        btnanalisis.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/analisis.png"))); // NOI18N
        btnanalisis.setText("Análisis Resultados");
        btnanalisis.setToolTipText("Análisis de Resultados");
        btnanalisis.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnanalisis.setBorderPainted(false);
        btnanalisis.setContentAreaFilled(false);
        btnanalisis.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnanalisis.setMaximumSize(new java.awt.Dimension(165, 53));
        btnanalisis.setMinimumSize(new java.awt.Dimension(165, 53));
        btnanalisis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnanalisisActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnanalisis);

        btnresultados.setBackground(new java.awt.Color(0, 0, 0));
        btnresultados.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnresultados.setForeground(new java.awt.Color(255, 255, 255));
        btnresultados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resultados.png"))); // NOI18N
        btnresultados.setText("Resultados");
        btnresultados.setToolTipText("Ingreso y Edición de Resultados");
        btnresultados.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnresultados.setBorderPainted(false);
        btnresultados.setContentAreaFilled(false);
        btnresultados.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnresultados.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnresultados.setMaximumSize(new java.awt.Dimension(151, 53));
        btnresultados.setMinimumSize(new java.awt.Dimension(151, 53));
        btnresultados.setPreferredSize(new java.awt.Dimension(151, 53));
        btnresultados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresultadosActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnresultados);

        btnmodelos.setBackground(new java.awt.Color(0, 0, 0));
        btnmodelos.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnmodelos.setForeground(new java.awt.Color(255, 255, 255));
        btnmodelos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/modelo.png"))); // NOI18N
        btnmodelos.setText("Modélos");
        btnmodelos.setToolTipText("Creación y Edición de Modélos");
        btnmodelos.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnmodelos.setBorderPainted(false);
        btnmodelos.setContentAreaFilled(false);
        btnmodelos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnmodelos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnmodelos.setMaximumSize(new java.awt.Dimension(151, 53));
        btnmodelos.setMinimumSize(new java.awt.Dimension(151, 53));
        btnmodelos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnmodelosActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnmodelos);

        btnkpi.setBackground(new java.awt.Color(0, 0, 0));
        btnkpi.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnkpi.setForeground(new java.awt.Color(255, 255, 255));
        btnkpi.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/kpi.png"))); // NOI18N
        btnkpi.setText("KPI");
        btnkpi.setToolTipText("Creación y Edición de KPI");
        btnkpi.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnkpi.setBorderPainted(false);
        btnkpi.setContentAreaFilled(false);
        btnkpi.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnkpi.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnkpi.setMaximumSize(new java.awt.Dimension(151, 53));
        btnkpi.setMinimumSize(new java.awt.Dimension(151, 53));
        btnkpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnkpiActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnkpi);

        btnusuarios.setBackground(new java.awt.Color(0, 0, 0));
        btnusuarios.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnusuarios.setForeground(new java.awt.Color(255, 255, 255));
        btnusuarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trabajadores.png"))); // NOI18N
        btnusuarios.setText("Usuarios");
        btnusuarios.setToolTipText("Creación y Edición de Usuarios");
        btnusuarios.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnusuarios.setBorderPainted(false);
        btnusuarios.setContentAreaFilled(false);
        btnusuarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnusuarios.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnusuarios.setMaximumSize(new java.awt.Dimension(151, 53));
        btnusuarios.setMinimumSize(new java.awt.Dimension(151, 53));
        btnusuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusuariosActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnusuarios);

        btnareas.setBackground(new java.awt.Color(0, 0, 0));
        btnareas.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnareas.setForeground(new java.awt.Color(255, 255, 255));
        btnareas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/area.png"))); // NOI18N
        btnareas.setText("Áreas");
        btnareas.setToolTipText("Creación y Edición de Áreas y SubÁreas");
        btnareas.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnareas.setBorderPainted(false);
        btnareas.setContentAreaFilled(false);
        btnareas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnareas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnareas.setMaximumSize(new java.awt.Dimension(151, 53));
        btnareas.setMinimumSize(new java.awt.Dimension(151, 53));
        btnareas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnareasActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnareas);

        btnsimulac.setBackground(new java.awt.Color(0, 0, 0));
        btnsimulac.setFont(new java.awt.Font("Calibri", 1, 12)); // NOI18N
        btnsimulac.setForeground(new java.awt.Color(255, 255, 255));
        btnsimulac.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/resultado.png"))); // NOI18N
        btnsimulac.setText("Simulación");
        btnsimulac.setToolTipText("Simulación");
        btnsimulac.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        btnsimulac.setBorderPainted(false);
        btnsimulac.setContentAreaFilled(false);
        btnsimulac.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnsimulac.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnsimulac.setMaximumSize(new java.awt.Dimension(151, 53));
        btnsimulac.setMinimumSize(new java.awt.Dimension(151, 53));
        btnsimulac.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimulacActionPerformed(evt);
            }
        });
        pnlmenulistbuttons.add(btnsimulac);

        lblinicionombre.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicionombre.setForeground(new java.awt.Color(53, 29, 113));
        lblinicionombre.setText("nombre");

        lblinicioidpersona.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioidpersona.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioidpersona.setText("idpersona");

        lblinicio1erapellido.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicio1erapellido.setForeground(new java.awt.Color(53, 29, 113));
        lblinicio1erapellido.setText("1erapellido");

        lblinicio2doapellido.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicio2doapellido.setForeground(new java.awt.Color(53, 29, 113));
        lblinicio2doapellido.setText("2doapellido");

        lbliniciodocumento.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lbliniciodocumento.setForeground(new java.awt.Color(53, 29, 113));
        lbliniciodocumento.setText("documento");

        lblinicioemail.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioemail.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioemail.setText("email");

        lblinicioidarea.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioidarea.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioidarea.setText("idarea");

        lblinicioarea.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioarea.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioarea.setText("Área");

        lblinicioidsubarea.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioidsubarea.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioidsubarea.setText("idsubarea");

        lbliniciosubarea.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lbliniciosubarea.setForeground(new java.awt.Color(53, 29, 113));
        lbliniciosubarea.setText("SubÁrea");

        lblinicioacceso.setFont(new java.awt.Font("Arial", 3, 14)); // NOI18N
        lblinicioacceso.setForeground(new java.awt.Color(53, 29, 113));
        lblinicioacceso.setText("Acceso");

        javax.swing.GroupLayout pnlmainLayout = new javax.swing.GroupLayout(pnlmain);
        pnlmain.setLayout(pnlmainLayout);
        pnlmainLayout.setHorizontalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlmenulistbuttons, javax.swing.GroupLayout.DEFAULT_SIZE, 1267, Short.MAX_VALUE)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblinicioidpersona)
                    .addComponent(lblinicionombre)
                    .addComponent(lblinicio1erapellido)
                    .addComponent(lblinicio2doapellido)
                    .addComponent(lbliniciodocumento)
                    .addComponent(lblinicioemail)
                    .addComponent(lblinicioidarea)
                    .addComponent(lblinicioarea)
                    .addComponent(lblinicioidsubarea)
                    .addComponent(lbliniciosubarea)
                    .addComponent(lblinicioacceso))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlmainLayout.setVerticalGroup(
            pnlmainLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlmainLayout.createSequentialGroup()
                .addComponent(pnlmenulistbuttons, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioidpersona)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicionombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicio1erapellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicio2doapellido)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbliniciodocumento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioemail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioidarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioidsubarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbliniciosubarea)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblinicioacceso)
                .addContainerGap(349, Short.MAX_VALUE))
        );

        escritorio.setLayer(pnlmain, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout escritorioLayout = new javax.swing.GroupLayout(escritorio);
        escritorio.setLayout(escritorioLayout);
        escritorioLayout.setHorizontalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlmain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        escritorioLayout.setVerticalGroup(
            escritorioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlmain, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        menuBar.setBorder(null);

        jMenu1.setText("jMenu1");
        menuBar.add(jMenu1);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(escritorio)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnanalisisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnanalisisActionPerformed
        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        forma = new frmanalisis();

        if (!forma.isVisible()) {
            escritorio.add(forma);
            forma.setVisible(true);
            forma.toFront();

            Dimension desktopSize = escritorio.getSize();
            Dimension jInternalFrameSize = forma.getSize();
            forma.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                    (desktopSize.height - jInternalFrameSize.height) / 2);

        }
        
              if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Administrador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {

        } else {

            JOptionPane.showMessageDialog(null, "No tiene un perfil válido Asignado, "
                    + "Por favor comuniquese con el administrador");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnanalisisActionPerformed


    private void btnareasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnareasActionPerformed

        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }
        forms = new frmareasubar();
        escritorio.add(forms);
        forms.toFront();
        forms.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = forms.getSize();
        forms.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

// TODO add your handling code here:
    }//GEN-LAST:event_btnareasActionPerformed

    private void btnusuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusuariosActionPerformed
        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formt = new frmtrabajador();
        escritorio.add(formt);
        formt.toFront();
        formt.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formt.getSize();
        formt.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        if (INICIO.lblinicioacceso.equals("Trabajador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Administrador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {

        } else {

            JOptionPane.showMessageDialog(null, "No tiene un perfil válido Asignado, "
                    + "Por favor comuniquese con el administrador");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnusuariosActionPerformed

    private void btnkpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnkpiActionPerformed
        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formk = new frmkpi();
        escritorio.add(formk);
        formk.toFront();
        formk.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formk.getSize();
        formk.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnkpiActionPerformed

    private void btnmodelosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnmodelosActionPerformed
        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formm = new frmmodelo();
        escritorio.add(formm);
        formm.toFront();
        formm.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formm.getSize();
        formm.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        
        
              if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Administrador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {

        } else {

            JOptionPane.showMessageDialog(null, "No tiene un perfil válido Asignado, "
                    + "Por favor comuniquese con el administrador");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnmodelosActionPerformed

    private void btnresultadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresultadosActionPerformed

        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formr = new frmresultados();
        escritorio.add(formr);
        formr.toFront();
        formr.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formr.getSize();
        formr.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);
        
        
              if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Administrador")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {

        } else {

            JOptionPane.showMessageDialog(null, "No tiene un perfil válido Asignado, "
                    + "Por favor comuniquese con el administrador");
        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnresultadosActionPerformed

    private void btnsimulacActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimulacActionPerformed
        if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formsim = new frmsimulacion();
        escritorio.add(formsim);
        formsim.toFront();
        formsim.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formsim.getSize();
        formsim.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);               // TODO add your handling code here:
    }//GEN-LAST:event_btnsimulacActionPerformed

    private void btnperfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnperfilActionPerformed

         if (form1chart != null) {
            form1chart.dispose();
        }
        if (form2chart != null) {
            form2chart.dispose();
        }
        if (form3chart != null) {
            form3chart.dispose();
        }
        if (form4chart != null) {
            form4chart.dispose();
        }
        if (form5chart != null) {
            form5chart.dispose();
        }
        if (formcompchart != null) {
            formcompchart.dispose();
        }
        if (form4chartkpi != null) {
            form4chartkpi.dispose();
        }
        if (formobtpe != null) {
            formobtpe.dispose();
        }

        if (forma != null) {
            forma.dispose();
        }
        if (forms != null) {
            forms.dispose();
        }
        if (formk != null) {
            formk.dispose();
        }
        if (formm != null) {
            formm.dispose();
        }
        if (formr != null) {
            formr.dispose();
        }
        if (formt != null) {
            formt.dispose();
        }
        if (formsim != null) {
            formsim.dispose();
        }
        if (formpe != null) {
            formpe.dispose();
        }

        formpe = new frmperfil();
        escritorio.add(formpe);
        formpe.toFront();
        formpe.setVisible(true);
        Dimension desktopSize = escritorio.getSize();
        Dimension jInternalFrameSize = formpe.getSize();
        formpe.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
                (desktopSize.height - jInternalFrameSize.height) / 2);  
        
        
        JOptionPane.showMessageDialog(null, "bienvenido a tu perfil");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnperfilActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(INICIO.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new INICIO().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnanalisis;
    public static javax.swing.JButton btnareas;
    public static javax.swing.JButton btnkpi;
    public static javax.swing.JButton btnmodelos;
    public static javax.swing.JButton btnperfil;
    public static javax.swing.JButton btnresultados;
    public static javax.swing.JButton btnsimulac;
    public static javax.swing.JButton btnusuarios;
    public static javax.swing.JDesktopPane escritorio;
    private javax.swing.JMenu jMenu1;
    public static javax.swing.JLabel lblinicio1erapellido;
    public static javax.swing.JLabel lblinicio2doapellido;
    public static javax.swing.JLabel lblinicioacceso;
    public static javax.swing.JLabel lblinicioarea;
    public static javax.swing.JLabel lbliniciodocumento;
    public static javax.swing.JLabel lblinicioemail;
    public static javax.swing.JLabel lblinicioidarea;
    public static javax.swing.JLabel lblinicioidpersona;
    public static javax.swing.JLabel lblinicioidsubarea;
    public static javax.swing.JLabel lblinicionombre;
    public static javax.swing.JLabel lbliniciosubarea;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JPanel pnlmain;
    private javax.swing.JPanel pnlmenulistbuttons;
    // End of variables declaration//GEN-END:variables

}
