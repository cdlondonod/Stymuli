/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import logica.fsqloperations;

/**
 *
 * @author crist
 */
public class frmzzdatabase extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmzzemptydatabase
     */
    public frmzzdatabase() {
        initComponents();
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lbladverten = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        btneliminardb = new javax.swing.JButton();
        btnexportardb = new javax.swing.JButton();
        btnimportardb = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblchosse = new javax.swing.JLabel();
        cboemptydatabase = new javax.swing.JComboBox<>();
        btncancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));

        lbladverten.setBackground(new java.awt.Color(255, 255, 255));
        lbladverten.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        lbladverten.setForeground(new java.awt.Color(255, 0, 0));
        lbladverten.setText("<html>*Debe recordar que al eliminar una tabla:\n-Los datos se perderan sin recuperación\n-Si elimina personas, sus datos de ingreso no podran ser utilizados nuevamente para entrar a la aplicación, debe crear una nueva persona con permisos de administrador antes de cerrar la aplicación\n-Puede eliminar las tablas en este orden: Resultados, Objetivos, Modelo, Kpi, Persona, Area, Subarea.</html>");
        lbladverten.setMaximumSize(new java.awt.Dimension(300, 50));
        lbladverten.setMinimumSize(new java.awt.Dimension(300, 50));
        lbladverten.setPreferredSize(new java.awt.Dimension(300, 150));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btneliminardb.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btneliminardb.setForeground(new java.awt.Color(75, 16, 160));
        btneliminardb.setText("Eliminar");
        btneliminardb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        btneliminardb.setContentAreaFilled(false);
        btneliminardb.setPreferredSize(new java.awt.Dimension(80, 25));
        btneliminardb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminardbActionPerformed(evt);
            }
        });
        jPanel2.add(btneliminardb);

        btnexportardb.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btnexportardb.setForeground(new java.awt.Color(75, 16, 160));
        btnexportardb.setText("Exportar");
        btnexportardb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        btnexportardb.setContentAreaFilled(false);
        btnexportardb.setPreferredSize(new java.awt.Dimension(80, 25));
        btnexportardb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnexportardbActionPerformed(evt);
            }
        });
        jPanel2.add(btnexportardb);

        btnimportardb.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btnimportardb.setForeground(new java.awt.Color(75, 16, 160));
        btnimportardb.setText("Importar");
        btnimportardb.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        btnimportardb.setContentAreaFilled(false);
        btnimportardb.setPreferredSize(new java.awt.Dimension(80, 25));
        btnimportardb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimportardbActionPerformed(evt);
            }
        });
        jPanel2.add(btnimportardb);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblchosse.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        lblchosse.setForeground(new java.awt.Color(75, 16, 160));
        lblchosse.setText("Escoja La tabla que desea Exportar: ");

        cboemptydatabase.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "area", "kpi", "modelo", "objetivos", "persona", "resultados", "subarea" }));

        btncancelar.setBackground(new java.awt.Color(0, 51, 0));
        btncancelar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/CANCELARCITO.png"))); // NOI18N
        btncancelar.setToolTipText("Cancelar");
        btncancelar.setBorder(null);
        btncancelar.setBorderPainted(false);
        btncancelar.setContentAreaFilled(false);
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblchosse)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboemptydatabase, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(btncancelar)
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cboemptydatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblchosse))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbladverten, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lbladverten, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lbladverten.getAccessibleContext().setAccessibleName("*Debe recordar que al eliminar una tabla:\n-Los datos se perderan sin recuperación\n-Si elimina personas, sus datos de ingreso no podran ser utilizados nuevamente para entrar a la aplicación, debe crear una nueva persona con permisos de administrador antes de cerrar la aplicación\n-Puede eliminar las tablas en este orden: Resultados, Objetivos, Modelo, Kpi, Persona, Area, Subarea.");

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        jPanel1.add(jPanel4, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 529, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btneliminardbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminardbActionPerformed

        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar los "
                + "datos de la tabla " + cboemptydatabase.getSelectedItem().toString(), "Confirmar", 2, JOptionPane.WARNING_MESSAGE);

        if (confirmacion == 0) {

            fsqloperations func = new fsqloperations();

            func.limpiartabla(cboemptydatabase.getSelectedItem().toString());

            this.dispose();

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btneliminardbActionPerformed

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed
    private String path2;
    private void btnexportardbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnexportardbActionPerformed
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
                "csv files", "csv");
        chooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        chooser.setDialogTitle("Descargar de Tabla" + cboemptydatabase.getSelectedItem().toString());

        chooser.setSelectedFile(new File(cboemptydatabase.getSelectedItem().toString()));
        chooser.setFileFilter(filter);
        if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
            String tabla = cboemptydatabase.getSelectedItem().toString();
                path2 = chooser.getSelectedFile().getAbsolutePath();
                File csvfile=new File(path2.toString()+".csv");
            if (csvfile.exists()) {
                JOptionPane.showMessageDialog(rootPane, "Un archivo con ese nombre ya existe, Seleccion un nombre diferente");
            } else {
                fsqloperations descarga = new fsqloperations();                
                path2 = path2.replaceAll("\\\\", "\\/");
                descarga.exportarDB(tabla, path2);
                JOptionPane.showMessageDialog(rootPane, "La Tabla Fue descargada Exitosamente  " + path2);
                this.dispose();
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "No se selecciono un lugar para guardarla Tabla");
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnexportardbActionPerformed

    private void btnimportardbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimportardbActionPerformed

// TODO add your handling code here:
    }//GEN-LAST:event_btnimportardbActionPerformed

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
            java.util.logging.Logger.getLogger(frmzzdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmzzdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmzzdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmzzdatabase.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmzzdatabase().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btneliminardb;
    public static javax.swing.JButton btnexportardb;
    public static javax.swing.JButton btnimportardb;
    private javax.swing.JComboBox<String> cboemptydatabase;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    public static javax.swing.JLabel lbladverten;
    public static javax.swing.JLabel lblchosse;
    // End of variables declaration//GEN-END:variables
}
