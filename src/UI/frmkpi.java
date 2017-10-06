/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import datos.vkpi;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.farea;
import logica.fkpi;

/**
 *
 * @author crist
 */
public class frmkpi extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmkpi
     */
    public frmkpi() {
        initComponents();
        mostrar("");
        inhabilitar();
        tablalistado.setDefaultEditor(Object.class, null);
        tablalistado.setShowGrid(true);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));

    }
    private String accion = "guardar";

    void ocultar_columnas() {
        tablalistado.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar() {

        txtidkpi.setVisible(false);
        pnlregistro.setVisible(false);

        btneliminar.setEnabled(false);
        btneditar1.setEnabled(false);

        txtidkpi.setText("");
        txtnom_kpi.setText("");
        txtdesc_kpi.setText("");

    }

    void habilitar() {

        txtidkpi.setVisible(false);
        pnlregistro.setVisible(true);
        txtidkpi.setText("");
        txtnom_kpi.setText("");
        txtdesc_kpi.setText("");

    }

    void habilitarbtnprin() {

        txtidkpi.setVisible(false);
        btneliminar.setEnabled(true);
        btneditar1.setEnabled(true);

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fkpi func = new fkpi();
            modelo = func.mostrar(buscar);

            tablalistado.setModel(modelo);
            ocultar_columnas();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        pnllistado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado = new javax.swing.JTable();
        txtbuscar = new javax.swing.JTextField();
        btneliminar = new javax.swing.JButton();
        btnnuevo = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        btneditar1 = new javax.swing.JButton();
        pnlregistro = new javax.swing.JPanel();
        txtnom_kpi = new javax.swing.JTextField();
        lblnombrekpi = new javax.swing.JLabel();
        btnguardar = new javax.swing.JButton();
        txtidkpi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtdesc_kpi = new javax.swing.JTextArea();
        lbldesc_kpi = new javax.swing.JLabel();
        btncancelar = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setBorder(null);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(75, 16, 160));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("KPI");
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(23, 20));
        jPanel1.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        pnllistado.setBackground(new java.awt.Color(101, 54, 193));
        pnllistado.setPreferredSize(new java.awt.Dimension(260, 400));

        tablalistado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablalistado.setForeground(new java.awt.Color(75, 16, 160));
        tablalistado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablalistado.setGridColor(new java.awt.Color(75, 16, 160));
        tablalistado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistadoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistadoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado);

        txtbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscarActionPerformed(evt);
            }
        });
        txtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscarKeyReleased(evt);
            }
        });

        btneliminar.setBackground(new java.awt.Color(153, 51, 0));
        btneliminar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneliminar.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btneliminar.setToolTipText("Eliminar seleccionado");
        btneliminar.setBorder(null);
        btneliminar.setBorderPainted(false);
        btneliminar.setContentAreaFilled(false);
        btneliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminarActionPerformed(evt);
            }
        });

        btnnuevo.setBackground(new java.awt.Color(0, 51, 0));
        btnnuevo.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnnuevo.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnuevo.setToolTipText("Crear nuevo");
        btnnuevo.setBorder(null);
        btnnuevo.setBorderPainted(false);
        btnnuevo.setContentAreaFilled(false);
        btnnuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevoActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N

        btneditar1.setBackground(new java.awt.Color(0, 51, 0));
        btneditar1.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneditar1.setForeground(new java.awt.Color(255, 255, 255));
        btneditar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btneditar1.setToolTipText("Editar seleccionado");
        btneditar1.setBorder(null);
        btneditar1.setBorderPainted(false);
        btneditar1.setContentAreaFilled(false);
        btneditar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnllistadoLayout = new javax.swing.GroupLayout(pnllistado);
        pnllistado.setLayout(pnllistadoLayout);
        pnllistadoLayout.setHorizontalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistadoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnllistadoLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnnuevo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneditar1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btneliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnllistadoLayout.createSequentialGroup()
                        .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel2)
                        .addGap(0, 70, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnllistadoLayout.setVerticalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistadoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(btneditar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnnuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel3.add(pnllistado);

        pnlregistro.setBackground(new java.awt.Color(255, 255, 255));
        pnlregistro.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        pnlregistro.setPreferredSize(new java.awt.Dimension(230, 170));

        txtnom_kpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnom_kpiActionPerformed(evt);
            }
        });
        txtnom_kpi.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnom_kpiKeyTyped(evt);
            }
        });

        lblnombrekpi.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi.setText("Nombre nuevo KPI :");

        btnguardar.setBackground(new java.awt.Color(0, 51, 0));
        btnguardar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnguardar.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnguardar.setToolTipText("Aceptar y guardar");
        btnguardar.setBorder(null);
        btnguardar.setBorderPainted(false);
        btnguardar.setContentAreaFilled(false);
        btnguardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardarActionPerformed(evt);
            }
        });

        jScrollPane2.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        jScrollPane2.setMinimumSize(new java.awt.Dimension(7, 50));

        txtdesc_kpi.setColumns(20);
        txtdesc_kpi.setRows(5);
        txtdesc_kpi.setMinimumSize(new java.awt.Dimension(40, 40));
        jScrollPane2.setViewportView(txtdesc_kpi);

        lbldesc_kpi.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lbldesc_kpi.setForeground(new java.awt.Color(75, 16, 160));
        lbldesc_kpi.setText("Descripcion Nuevo KPI :");

        btncancelar.setBackground(new java.awt.Color(0, 51, 0));
        btncancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelar.setToolTipText("Cancelar");
        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlregistroLayout = new javax.swing.GroupLayout(pnlregistro);
        pnlregistro.setLayout(pnlregistroLayout);
        pnlregistroLayout.setHorizontalGroup(
            pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistroLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(txtidkpi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(btnguardar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlregistroLayout.createSequentialGroup()
                        .addComponent(lbldesc_kpi)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlregistroLayout.createSequentialGroup()
                        .addComponent(lblnombrekpi)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtnom_kpi)))
                .addContainerGap())
        );
        pnlregistroLayout.setVerticalGroup(
            pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombrekpi)
                    .addComponent(txtnom_kpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbldesc_kpi)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 55, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnguardar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistroLayout.createSequentialGroup()
                        .addComponent(txtidkpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(17, 17, 17))
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel3.add(pnlregistro);

        jPanel1.add(jPanel3, java.awt.BorderLayout.CENTER);

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipo-1-fondo-transparente91x77.png"))); // NOI18N
        jLabel3.setText("  ");
        jLabel3.setPreferredSize(new java.awt.Dimension(91, 85));
        jPanel1.add(jLabel3, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnom_kpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnom_kpiActionPerformed
        // TODO add your handling code here:
        txtnom_kpi.transferFocus();
    }//GEN-LAST:event_txtnom_kpiActionPerformed

    private void btnnuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevoActionPerformed

        pnlregistro.setVisible(true);
        txtnom_kpi.requestFocus();
        btnguardar.setIcon(new ImageIcon(frmkpi.class.getResource("/img/guardar.png")));
        accion = "guardar";
        habilitar();
    }//GEN-LAST:event_btnnuevoActionPerformed

    private void btnguardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardarActionPerformed
        // TODO add your handling code here:
        if (txtnom_kpi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del KPI");
            txtnom_kpi.requestFocus();
            return;

        }
        if (txtdesc_kpi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar una descripción del KPI");
            txtdesc_kpi.requestFocus();
            return;

        }

        vkpi dts = new vkpi();
        fkpi func = new fkpi();

        dts.setNombre(txtnom_kpi.getText());
        dts.setDescripcion(txtdesc_kpi.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El KPI fue registrado satisfactoriamente");
                mostrar("");
                inhabilitar();

            }

        } else if (accion.equals("editar")) {
            dts.setIdkpi(Integer.parseInt(txtidkpi.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El KPI fue editado satisfactoriamente");
                mostrar("");
                inhabilitar();

            }

        }

    }//GEN-LAST:event_btnguardarActionPerformed

    private void tablalistadoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tablalistadoMouseClicked

    private void btneliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminarActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado.getSelectedRow();
        txtidkpi.setText(tablalistado.getValueAt(fila, 0).toString());
        if (!txtidkpi.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el KPI", "Confirmar", 2);

            if (confirmacion == 0) {
                vkpi dts = new vkpi();
                fkpi func = new fkpi();

                dts.setIdkpi(Integer.parseInt(txtidkpi.getText()));
                func.eliminar(dts);
                mostrar("");
                inhabilitar();

            }

        }
    }//GEN-LAST:event_btneliminarActionPerformed

    private void txtbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscarActionPerformed
        txtbuscar.transferFocus();          // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        // TODO add your handling code here:

        inhabilitar();
    }//GEN-LAST:event_btncancelarActionPerformed

    private void tablalistadoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistadoMousePressed
        habilitarbtnprin();        // TODO add your handling code here:


    }//GEN-LAST:event_tablalistadoMousePressed

    private void txtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyPressed

    private void btneditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar1ActionPerformed

        habilitar();
        pnlregistro.setVisible(true);
        txtnom_kpi.requestFocus();
        btnguardar.setIcon(new ImageIcon(frmkpi.class.getResource("/img/editar.png")));

        btneliminar.setEnabled(true);
        accion = "editar";

        int fila = tablalistado.getSelectedRow();
        txtidkpi.setText(tablalistado.getValueAt(fila, 0).toString());
        txtnom_kpi.setText(tablalistado.getValueAt(fila, 1).toString());
        txtdesc_kpi.setText(tablalistado.getValueAt(fila, 2).toString());

// TODO add your handling code here:
    }//GEN-LAST:event_btneditar1ActionPerformed

    private void txtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscarKeyReleased
        mostrar(txtbuscar.getText());         // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscarKeyReleased

    private void txtnom_kpiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnom_kpiKeyTyped
        char keychar = evt.getKeyChar();
        if (keychar == '_') {
            evt.setKeyChar('-');
        }           // TODO add your handling code here:
    }//GEN-LAST:event_txtnom_kpiKeyTyped

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
            java.util.logging.Logger.getLogger(frmkpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmkpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmkpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmkpi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmkpi().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    private javax.swing.JButton btneditar1;
    private javax.swing.JButton btneliminar;
    private javax.swing.JButton btnguardar;
    private javax.swing.JButton btnnuevo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbldesc_kpi;
    private javax.swing.JLabel lblnombrekpi;
    private javax.swing.JPanel pnllistado;
    private javax.swing.JPanel pnlregistro;
    private javax.swing.JTable tablalistado;
    private javax.swing.JTextField txtbuscar;
    private javax.swing.JTextArea txtdesc_kpi;
    private javax.swing.JTextField txtidkpi;
    private javax.swing.JTextField txtnom_kpi;
    // End of variables declaration//GEN-END:variables
}
