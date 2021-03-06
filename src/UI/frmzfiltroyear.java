/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.Color;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import logica.conexion;
import logica.farea;
import logica.ffiltros;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.SwingWorker;
import logica.fconfiguration;
/**
 *
 * @author crist
 */
public class frmzfiltroyear extends javax.swing.JFrame {

    /**
     * Creates new form frmvistaarea
     */
    public frmzfiltroyear() {
        initComponents();
        mostrar("");
        this.setLocationRelativeTo(null);
        Tablafiltrado.setDefaultEditor(Object.class, null);
        rootPane.setDefaultButton(btnaceptar);
        jScrollPane1.getViewport().setBackground(new Color(101,54,193));
        Tablafiltrado.setShowHorizontalLines(true);
       jScrollPane1.getColumnHeader().setVisible(false);
        txtfiltrar.requestFocus();
      Action buscar = new AbstractAction()
{   
            @Override
            public void actionPerformed(ActionEvent e) {
                btnbuscar.doClick();
            //To change body of generated methods, choose Tools | Templates.
            }
        };
        txtfiltrar.addActionListener(buscar);

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            ffiltros func = new ffiltros();
            modelo = func.mostraryear(buscar);
            Tablafiltrado.setModel(modelo);
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

        jPanel2 = new javax.swing.JPanel();
        btncancelar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        btnaceptar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Tablafiltrado = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        txtfiltrar = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(75, 16, 160));

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

        jPanel1.setBackground(new java.awt.Color(101, 54, 193));
        jPanel1.setPreferredSize(new java.awt.Dimension(546, 214));

        btnaceptar.setBackground(new java.awt.Color(0, 51, 0));
        btnaceptar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnaceptar.setForeground(new java.awt.Color(255, 255, 255));
        btnaceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnaceptar.setToolTipText("Aceptar y guardar");
        btnaceptar.setBorder(null);
        btnaceptar.setBorderPainted(false);
        btnaceptar.setContentAreaFilled(false);
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        jScrollPane1.setBorder(null);

        Tablafiltrado.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        Tablafiltrado.setForeground(new java.awt.Color(75, 16, 160));
        Tablafiltrado.setModel(new javax.swing.table.DefaultTableModel(
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
        Tablafiltrado.setGridColor(new java.awt.Color(75, 16, 160));
        Tablafiltrado.setMaximumSize(new java.awt.Dimension(2147483647, 2147483647));
        Tablafiltrado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TablafiltradoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                TablafiltradoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(Tablafiltrado);

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        txtfiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtfiltrarActionPerformed(evt);
            }
        });
        txtfiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtfiltrarKeyPressed(evt);
            }
        });
        jPanel3.add(txtfiltrar);

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnbuscar.setBorder(null);
        btnbuscar.setBorderPainted(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscar);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 555, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnaceptar)
                .addContainerGap(102, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(363, Short.MAX_VALUE)))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Año");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(btncancelar)
                .addContainerGap())
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 399, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 338, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    private void TablafiltradoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablafiltradoMousePressed
        // TODO add your handling code here:

        if (evt.getClickCount() == 2) {
            int fila = Tablafiltrado.getSelectedRow();
            String filtro;
            filtro = Tablafiltrado.getValueAt(fila, 0).toString();
            txtfiltrar.setText(filtro);
            btnaceptar.doClick();
        }

        

    }//GEN-LAST:event_TablafiltradoMousePressed

    private void TablafiltradoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TablafiltradoMouseClicked

    }//GEN-LAST:event_TablafiltradoMouseClicked

    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        if (conexion.frmabierto == 1) {
            frmanalisdistrikpi.txtyear.setText(txtfiltrar.getText());
        } else if (conexion.frmabierto == 5) {
            frmanalisfrecuencia.txtyear.setText(txtfiltrar.getText());
        }  else if (conexion.frmabierto == 7) {
            frmanalisdistriestim.txtyear.setText(txtfiltrar.getText());
        } else if (conexion.frmabierto == 8) {
            frmanalisproyeccion.txtyear.setText(txtfiltrar.getText());
        } else if (conexion.frmabierto == 9) {
            frmanalisiscompleto.txtyear.setText(txtfiltrar.getText());
        } else if (conexion.frmabierto == 10) {
            frmanalisisobtpersona.txtyear.setText(txtfiltrar.getText());
        } else if (conexion.frmabierto == 11) {
            frmanalisisminmaxmid.txtyear.setText(txtfiltrar.getText());
        }

        this.dispose();

        // TODO add your handling code here:
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void txtfiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtfiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiltrarActionPerformed

    private void txtfiltrarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtfiltrarKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtfiltrarKeyPressed

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        fconfiguration con = new fconfiguration();
        con.loadingscreen();
        SwingWorker swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {

                mostrar(txtfiltrar.getText());

                con.hideloading();
                return null;
            }
        };
        swingWorker.execute();// TODO add your handling code here:
    }//GEN-LAST:event_btnbuscarActionPerformed

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
            java.util.logging.Logger.getLogger(frmzfiltroyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmzfiltroyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmzfiltroyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmzfiltroyear.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmzfiltroyear().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tablafiltrado;
    private javax.swing.JButton btnaceptar;
    public static javax.swing.JButton btnbuscar;
    private javax.swing.JButton btncancelar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtfiltrar;
    // End of variables declaration//GEN-END:variables
}
