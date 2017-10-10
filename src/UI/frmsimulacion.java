/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.text.DecimalFormat;
import javax.swing.DefaultCellEditor;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logica.conexion;
import logica.fconfiguration;

import logica.fsimulacion;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author crist
 */
public class frmsimulacion extends javax.swing.JInternalFrame {

    fconfiguration con = new fconfiguration();

    /**
     * Creates new form frmtrabajador
     */
    public frmsimulacion() {

        initComponents();
        mostrar("");
        mostrarkpi();
        inhabilitar();
        ocultar_columnas();
        conexion.frmabierto = 12;
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tablamodelo.setDefaultEditor(Object.class, null);
        tablamodelo.setShowGrid(true);
        tablasim.setDefaultEditor(Object.class, null);
        tablasim.setShowGrid(true);
        ((DefaultCellEditor) tablakpires.getDefaultEditor(Object.class)).setClickCountToStart(1);
        jScrollPane2.getViewport().setBackground(new Color(101, 54, 193));
        jScrollPane1.getViewport().setBackground(new Color(255, 255, 255));
        jScrollPane4.getViewport().setBackground(new Color(255, 255, 255));
        rootPane.setDefaultButton(btnsimular);
    }

    void ocultar_columnas() {
        /* tablakpires.getColumnModel().getColumn(0).setMaxWidth(0);
        tablakpires.getColumnModel().getColumn(0).setMinWidth(0);
        tablakpires.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablasim.getColumnModel().getColumn(4).setMaxWidth(0);
        tablasim.getColumnModel().getColumn(4).setMinWidth(0);
        tablasim.getColumnModel().getColumn(4).setPreferredWidth(0);

        tablasim.getColumnModel().getColumn(5).setMaxWidth(0);
        tablasim.getColumnModel().getColumn(5).setMinWidth(0);
        tablasim.getColumnModel().getColumn(5).setPreferredWidth(0);

        tablamodelo.getColumnModel().getColumn(0).setMaxWidth(0);
        tablamodelo.getColumnModel().getColumn(0).setMinWidth(0);
        tablamodelo.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablamodelo.getColumnModel().getColumn(1).setMaxWidth(0);
        tablamodelo.getColumnModel().getColumn(1).setMinWidth(0);
        tablamodelo.getColumnModel().getColumn(1).setPreferredWidth(0);*/

    }

    void inhabilitar() {

    }

    void habilitar() {

    }

    void mostrar(String buscar) {
        try {
            DefaultTableModel modelo;
            fsimulacion func = new fsimulacion();
            modelo = func.mostrarmodelo(buscar);
            tablamodelo.setModel(modelo);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
    }

    void mostrarkpi() {
        try {
            DefaultTableModel modelo;
            fsimulacion func = new fsimulacion();
            modelo = func.mostrarvistakpi();
            tablakpires.setModel(modelo);
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
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        pnllistado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablamodelo = new javax.swing.JTable();
        pnlregistro = new javax.swing.JPanel();
        btnsimular = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablakpires = new javax.swing.JTable();
        pnllistado3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablasim = new javax.swing.JTable();
        pnlgrafica = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Simulación");
        addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                formFocusGained(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(75, 16, 160));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Simulación");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(76, 20));
        jPanel2.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel4.setOpaque(false);

        jPanel3.setOpaque(false);

        pnllistado.setBackground(new java.awt.Color(255, 255, 255));
        pnllistado.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)), "Objetivos a Cumplir", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(75, 16, 160))); // NOI18N

        jScrollPane1.setBorder(null);

        tablamodelo.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablamodelo.setForeground(new java.awt.Color(75, 16, 160));
        tablamodelo.setModel(new javax.swing.table.DefaultTableModel(
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
        tablamodelo.setGridColor(new java.awt.Color(75, 16, 160));
        tablamodelo.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablamodeloMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablamodeloMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablamodelo);

        javax.swing.GroupLayout pnllistadoLayout = new javax.swing.GroupLayout(pnllistado);
        pnllistado.setLayout(pnllistadoLayout);
        pnllistadoLayout.setHorizontalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistadoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        pnllistadoLayout.setVerticalGroup(
            pnllistadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 162, Short.MAX_VALUE)
        );

        pnlregistro.setBackground(new java.awt.Color(101, 54, 193));

        btnsimular.setBackground(new java.awt.Color(0, 51, 0));
        btnsimular.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnsimular.setForeground(new java.awt.Color(255, 255, 255));
        btnsimular.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/obtenidores.png"))); // NOI18N
        btnsimular.setToolTipText("Aceptar y guardar");
        btnsimular.setBorder(null);
        btnsimular.setBorderPainted(false);
        btnsimular.setContentAreaFilled(false);
        btnsimular.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnsimularActionPerformed(evt);
            }
        });

        jScrollPane2.setBackground(new java.awt.Color(102, 50, 159));
        jScrollPane2.setBorder(null);
        jScrollPane2.setOpaque(false);

        tablakpires.setBackground(new java.awt.Color(101, 54, 193));
        tablakpires.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablakpires.setForeground(new java.awt.Color(255, 255, 255));
        tablakpires.setModel(new javax.swing.table.DefaultTableModel(
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
        tablakpires.setCellSelectionEnabled(true);
        tablakpires.setGridColor(new java.awt.Color(75, 16, 160));
        tablakpires.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablakpiresMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablakpires);

        javax.swing.GroupLayout pnlregistroLayout = new javax.swing.GroupLayout(pnlregistro);
        pnlregistro.setLayout(pnlregistroLayout);
        pnlregistroLayout.setHorizontalGroup(
            pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistroLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(btnsimular)
                .addContainerGap())
        );
        pnlregistroLayout.setVerticalGroup(
            pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistroLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlregistroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(pnlregistroLayout.createSequentialGroup()
                        .addGap(0, 97, Short.MAX_VALUE)
                        .addComponent(btnsimular)))
                .addContainerGap())
        );

        pnllistado3.setBackground(new java.awt.Color(255, 255, 255));
        pnllistado3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)), "Resultados Obtenidos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12), new java.awt.Color(75, 16, 160))); // NOI18N

        jScrollPane4.setBorder(null);

        tablasim.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablasim.setForeground(new java.awt.Color(75, 16, 160));
        tablasim.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "KPI", "Resultado", "Comparacion", "Objetivo", "Obtenido", "Hab."
            }
        ));
        tablasim.setGridColor(new java.awt.Color(75, 16, 160));
        tablasim.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablasimMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablasimMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablasim);

        javax.swing.GroupLayout pnllistado3Layout = new javax.swing.GroupLayout(pnllistado3);
        pnllistado3.setLayout(pnllistado3Layout);
        pnllistado3Layout.setHorizontalGroup(
            pnllistado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistado3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 335, Short.MAX_VALUE)
                .addContainerGap())
        );
        pnllistado3Layout.setVerticalGroup(
            pnllistado3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(pnlregistro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnllistado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(pnllistado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnllistado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(pnlregistro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnllistado3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jPanel4.add(jPanel3);

        pnlgrafica.setBackground(new java.awt.Color(255, 255, 255));
        pnlgrafica.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        pnlgrafica.setMinimumSize(new java.awt.Dimension(600, 0));
        pnlgrafica.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout pnlgraficaLayout = new javax.swing.GroupLayout(pnlgrafica);
        pnlgrafica.setLayout(pnlgraficaLayout);
        pnlgraficaLayout.setHorizontalGroup(
            pnlgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlgraficaLayout.setVerticalGroup(
            pnlgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 398, Short.MAX_VALUE)
        );

        jPanel4.add(pnlgrafica);

        jPanel2.add(jPanel4, java.awt.BorderLayout.CENTER);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipo-1-fondo-transparente91x77.png"))); // NOI18N
        jLabel2.setText("  ");
        jLabel2.setPreferredSize(new java.awt.Dimension(91, 85));
        jPanel2.add(jLabel2, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

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

    private void tablamodeloMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablamodeloMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tablamodeloMouseClicked

    private void tablamodeloMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablamodeloMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_tablamodeloMousePressed

    private void formFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_formFocusGained
        // TODO add your handling code here:
    }//GEN-LAST:event_formFocusGained

    private void btnsimularActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnsimularActionPerformed
        if (tablakpires.isEditing()) {
            tablakpires.getCellEditor().stopCellEditing();
        }

        Double estimulo = 0.0;

        DefaultTableModel model = (DefaultTableModel) tablasim.getModel();
        model.setRowCount(0);

        TableModel tmk = tablakpires.getModel();
        TableModel tm = tablamodelo.getModel();
        try {

            for (int x = 0; x < tmk.getRowCount(); x++) {

                String data2;
                String data1 = tmk.getValueAt(x, 1).toString();

                if (con.DBnumberFormatInput(tmk.getValueAt(x, 2).toString()).toString().length() == 0) {
                    JOptionPane.showMessageDialog(null, "Debe especificar un resultado");
                    return;
                } else {
                    data2 = con.numberFormatDisplay(con.DBnumberFormatInput(tmk.getValueAt(x, 2).toString()));
                }

                int rowkpi = 0;
                for (int i = tm.getRowCount() - 1; i >= 0; --i) {
                    for (int j = tm.getColumnCount() - 1; j >= 0; --j) {
                        if (tm.getValueAt(i, j).equals(tmk.getValueAt(x, 1).toString())) {

                            rowkpi = i;
                        }
                    }
                }
                String data3 = tm.getValueAt(rowkpi, 5).toString();
                String data4 = tm.getValueAt(rowkpi, 6).toString();
                String habilitador = tm.getValueAt(rowkpi, 3).toString();
                if (tm.getValueAt(rowkpi, 0).toString().equals("Salario") || tm.getValueAt(rowkpi, 0).toString().equals("Bono")) {
                    estimulo = con.DBnumberFormatInput(tm.getValueAt(rowkpi, 1).toString());
                } else {
                    String split = tm.getValueAt(rowkpi, 0).toString();
                    String[] parts = split.split("_");

                    String part2 = parts[1];

                    for (int i = 0; i < tmk.getRowCount(); i++) {
                        for (int j = 0; j < tmk.getColumnCount(); j++) {
                            if (tablakpires.getModel().getValueAt(i, j).equals(part2)) {

                                estimulo = con.DBnumberFormatInput(tablakpires.getModel().getValueAt(i, 2).toString())
                                        * con.DBnumberFormatInput(tm.getValueAt(rowkpi, 1).toString());
                            }
                        }
                    }

                }

                Double ponderado = con.DBnumberFormatInput(tm.getValueAt(rowkpi, 4).toString());
                String data5 = "";
                String data6 = "";
                Double resob = estimulo * (ponderado / 100);
                String obtenido = con.numberFormatDisplay(Double.parseDouble(resob.toString()));

                if (data3.equals("Mayor/Igual")) {

                    if (con.DBnumberFormatInput(data2) >= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {

                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Menor/Igual")) {

                    if (con.DBnumberFormatInput(data2) <= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Igual")) {

                    if (con.DBnumberFormatInput(data2) == con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                }

                if (data3.equals("Mayor/Igual")) {

                    if (con.DBnumberFormatInput(data2) >= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Menor/Igual")) {

                    if (con.DBnumberFormatInput(data2) <= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Igual")) {

                    if (con.DBnumberFormatInput(data2) == con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                }

                if (data3.equals("Mayor/Igual")) {

                    if (con.DBnumberFormatInput(data2) >= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Menor/Igual")) {

                    if (con.DBnumberFormatInput(data2) <= con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                } else if (data3.equals("Igual")) {

                    if (con.DBnumberFormatInput(data2) == con.DBnumberFormatInput(data4)) {

                        if (habilitador.equals("Pon.")) {
                            data5 = "$" + ((obtenido));
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "1";
                        }

                    } else {

                        if (habilitador.equals("Pon.")) {
                            data5 = "0";
                            data6 = "1";
                        } else if (habilitador.equals("Hab.")) {
                            data5 = "0";
                            data6 = "0";
                        }

                    }

                }

                Object[] row = {data1, data2, data3, data4, data5, data6};

                model.addRow(row);

            }
        } catch (Exception e) {

            JOptionPane.showMessageDialog(null, "Debe especificar un resultado");

        }

        Double sumpos = 0.0;
        Double habilita = 0.0;
        Double cant = 0.0;
        Double obtreal;
        for (int j = 0; j < model.getRowCount(); j++) {
            Double p = con.DBnumberFormatInput(model.getValueAt(j, 4).toString());
            sumpos = sumpos + p;
        }
        for (int j = 0; j < model.getRowCount(); j++) {
            Double p = con.DBnumberFormatInput(model.getValueAt(j, 5).toString());
            habilita = habilita + p;
            cant = (double) j + 1;
        }
        habilita = habilita - cant;
        if (habilita == 0) {
            obtreal = sumpos;
        } else {
            obtreal = 0.0;
        }
        Double posiblereal = estimulo - obtreal;

        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        DefaultPieDataset dataset1 = new DefaultPieDataset();

        dataset1.setValue("No Obtenido", posiblereal);
        dataset1.setValue("Obtenido", obtreal);

        JFreeChart chart = ChartFactory.createPieChart(
                "Simula tu Stymuli", // chart title 
                dataset1, // data    
                true, // include legend   
                true,
                false);

        chart.getTitle().setPaint(new Color(75, 16, 160));
        PiePlot plot = (PiePlot) chart.getPlot();
        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("$" + "#,##0.0;(#,##0.0)"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        plot.setLabelOutlinePaint(null);
        plot.setLabelShadowPaint(null);
        plot.setLabelBackgroundPaint(null);
        plot.setLabelPaint(new Color(75, 16, 160));
        plot.setBackgroundPaint(Color.WHITE);
        // plot.setSimpleLabels(true);
        plot.setOutlineVisible(false);
        chart.setBackgroundPaint(Color.WHITE);
        plot.setSectionPaint(0, new Color(20, 173, 23));
        plot.setSectionPaint(1, new Color(101, 54, 193));
        final ChartPanel chartPanel = new ChartPanel(chart);
        pnlgrafica.setLayout(new java.awt.BorderLayout());
        pnlgrafica.add(chartPanel, BorderLayout.CENTER);
        pnlgrafica.validate();


    }//GEN-LAST:event_btnsimularActionPerformed

    private void tablasimMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasimMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tablasimMouseClicked

    private void tablasimMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablasimMousePressed
        // TODO add your handling code here:
    }//GEN-LAST:event_tablasimMousePressed

    private void tablakpiresMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablakpiresMousePressed

        // TODO add your handling code here:
    }//GEN-LAST:event_tablakpiresMousePressed

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
            java.util.logging.Logger.getLogger(frmsimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmsimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmsimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmsimulacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new frmsimulacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnsimular;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JPanel pnlgrafica;
    private javax.swing.JPanel pnllistado;
    private javax.swing.JPanel pnllistado3;
    private javax.swing.JPanel pnlregistro;
    private javax.swing.JTable tablakpires;
    private javax.swing.JTable tablamodelo;
    private javax.swing.JTable tablasim;
    // End of variables declaration//GEN-END:variables
}
