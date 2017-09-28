/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;


import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JOptionPane;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import logica.conexion;

import logica.fanalisis;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.CategoryLabelPositions;
import org.jfree.chart.axis.NumberAxis;

import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.DatasetRenderingOrder;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;

import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author crist
 */
public class frmanalisevolutivo extends javax.swing.JInternalFrame {

    
    
    /**
     * Creates new form frmanalisis
     */
    public frmanalisevolutivo() {
((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();
        mostrar("","","");
        tablaanalisis.setShowGrid(true);
        conexion.frmabierto=6;
        btngraficar.requestFocus();
              
         
        
        txtnombrearea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                 mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                 mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText());//To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
           txtnombresubarea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
             mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText());//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
           
           
              txtnombrekpi.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               mostrar(txtnombrearea.getText(),txtnombresubarea.getText(),txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }

   

    public void mostrar(String area, String Subarea, String KPI) {
        try {
            DefaultTableModel modelo;
            fanalisis func = new fanalisis();
            modelo = func.graficaevolutivo(area,Subarea,KPI);

            tablaanalisis.setModel(modelo);
            ocultar();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }
       void ocultar() {
        
         txtnombrearea.setEnabled(false);
         txtnombrekpi.setEnabled(false);
         txtnombresubarea.setEnabled(false);
           
           
       

        

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
        jPanel7 = new javax.swing.JPanel();
        pnlgrafica = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btngraficar = new javax.swing.JButton();
        btnclearselec = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblnombrekpi6 = new javax.swing.JLabel();
        txtnombrearea = new javax.swing.JTextField();
        btnbuscaarea = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblnombrekpi13 = new javax.swing.JLabel();
        txtnombresubarea = new javax.swing.JTextField();
        btnbuscar_subarea_trab = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblnombrekpi9 = new javax.swing.JLabel();
        txtnombrekpi = new javax.swing.JTextField();
        btnbusca_kpi_Obj = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaanalisis = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Evolutivo Mensual");
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(53, 29, 113));

        pnlgrafica.setBackground(new java.awt.Color(102, 50, 159));
        pnlgrafica.setMinimumSize(new java.awt.Dimension(600, 0));
        pnlgrafica.setPreferredSize(new java.awt.Dimension(600, 400));

        javax.swing.GroupLayout pnlgraficaLayout = new javax.swing.GroupLayout(pnlgrafica);
        pnlgrafica.setLayout(pnlgraficaLayout);
        pnlgraficaLayout.setHorizontalGroup(
            pnlgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
        );
        pnlgraficaLayout.setVerticalGroup(
            pnlgraficaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel4.setBackground(new java.awt.Color(153, 103, 198));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));

        btngraficar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/graficar.png"))); // NOI18N
        btngraficar.setToolTipText("Gráficar resultados");
        btngraficar.setBorder(null);
        btngraficar.setBorderPainted(false);
        btngraficar.setContentAreaFilled(false);
        btngraficar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngraficarActionPerformed(evt);
            }
        });

        btnclearselec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/errasesel.png"))); // NOI18N
        btnclearselec.setToolTipText("Borrar seleccionados");
        btnclearselec.setBorder(null);
        btnclearselec.setBorderPainted(false);
        btnclearselec.setContentAreaFilled(false);
        btnclearselec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearselecActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(153, 103, 198));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi6.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi6.setText("Área:");
        lblnombrekpi6.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel3.add(lblnombrekpi6);

        txtnombrearea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreareaActionPerformed(evt);
            }
        });
        jPanel3.add(txtnombrearea);

        btnbuscaarea.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscaarea.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscaarea.setToolTipText("Buscar área");
        btnbuscaarea.setBorder(null);
        btnbuscaarea.setBorderPainted(false);
        btnbuscaarea.setContentAreaFilled(false);
        btnbuscaarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscaareaActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscaarea);

        jPanel5.setBackground(new java.awt.Color(153, 103, 198));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi13.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi13.setText("SubÁrea:");
        lblnombrekpi13.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel5.add(lblnombrekpi13);

        txtnombresubarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresubareaActionPerformed(evt);
            }
        });
        jPanel5.add(txtnombresubarea);

        btnbuscar_subarea_trab.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscar_subarea_trab.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscar_subarea_trab.setToolTipText("Buscar subárea");
        btnbuscar_subarea_trab.setBorder(null);
        btnbuscar_subarea_trab.setBorderPainted(false);
        btnbuscar_subarea_trab.setContentAreaFilled(false);
        btnbuscar_subarea_trab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_subarea_trabActionPerformed(evt);
            }
        });
        jPanel5.add(btnbuscar_subarea_trab);

        jPanel6.setBackground(new java.awt.Color(153, 103, 198));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi9.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi9.setText("KPI :");
        lblnombrekpi9.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel6.add(lblnombrekpi9);

        txtnombrekpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrekpiActionPerformed(evt);
            }
        });
        jPanel6.add(txtnombrekpi);

        btnbusca_kpi_Obj.setBackground(new java.awt.Color(0, 51, 0));
        btnbusca_kpi_Obj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbusca_kpi_Obj.setToolTipText("Buscar KPI");
        btnbusca_kpi_Obj.setBorder(null);
        btnbusca_kpi_Obj.setBorderPainted(false);
        btnbusca_kpi_Obj.setContentAreaFilled(false);
        btnbusca_kpi_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusca_kpi_ObjActionPerformed(evt);
            }
        });
        jPanel6.add(btnbusca_kpi_Obj);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnclearselec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 108, Short.MAX_VALUE)
                        .addComponent(btngraficar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(263, 263, 263)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclearselec)
                    .addComponent(btngraficar))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(102, 50, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        tablaanalisis.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaanalisis.setCellSelectionEnabled(true);
        tablaanalisis.setEnabled(false);
        tablaanalisis.setGridColor(new java.awt.Color(102, 50, 159));
        tablaanalisis.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaanalisisFocusGained(evt);
            }
        });
        tablaanalisis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaanalisisMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaanalisisMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaanalisis);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Evolutivo Mensual del KPI");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)
                    .addComponent(pnlgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 424, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void btngraficarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngraficarActionPerformed

        if (txtnombrekpi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un KPI");
            txtnombrekpi.requestFocus();
            return;

        }  
        
        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());        
     
        
        
DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();  
 

        TableModel tm = tablaanalisis.getModel();
                        
            for (int j = 0; j < tm.getRowCount(); j++) {
             Double x = Double.parseDouble(tm.getValueAt(j, 2).toString().replaceAll("[^0-9.-]", ""));
             String y = (tm.getValueAt(j, 0).toString());        
            dataset1.addValue(x, "Resultado Promedio", y);
        }          
                                
                 
       final CategoryItemRenderer renderer = new BarRenderer();
    //    renderer.setLabelGenerator(generator);
        renderer.setItemLabelsVisible(true);
        
        renderer.setSeriesPaint(0, new Color(121,152,40));
        
        
        final CategoryPlot plot = new CategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setForegroundAlpha(0.8f);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
   
        plot.setDomainAxis(new CategoryAxis("Fecha"));
        plot.setRangeAxis(new NumberAxis("Res. Promedio"));

        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);
        
          
                                                     
        
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        final JFreeChart chart = new JFreeChart(plot);
        chart.setBackgroundPaint(new Color(53,29,113));
        chart.setTitle("Evolutivo "+txtnombrearea.getText()+", "+txtnombresubarea.getText()+", "+txtnombrekpi.getText());
     chart.getTitle().setPaint(Color.WHITE);
     
     plot.getDomainAxis().setTickLabelPaint(Color.WHITE);
     plot.getRangeAxis().setTickLabelPaint(Color.WHITE);
      plot.getRangeAxis().setLabelPaint(Color.WHITE);
    plot.getDomainAxis().setLabelPaint(Color.WHITE);
    
    
        final ChartPanel chartPanel = new ChartPanel(chart);
        
        
          pnlgrafica.setLayout(new java.awt.BorderLayout());

        
       
        
        pnlgrafica.add(chartPanel, BorderLayout.CENTER);
      
        pnlgrafica.validate();













// TODO add your handling code here:
    }//GEN-LAST:event_btngraficarActionPerformed

    private void txtnombreareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreareaActionPerformed
        // TODO add your handling code here:

        txtnombrearea.transferFocus();
    }//GEN-LAST:event_txtnombreareaActionPerformed

    private void btnbuscaareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaareaActionPerformed
        // TODO add your handling code here:

        frmzfiltroarea form = new frmzfiltroarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop (true);
    }//GEN-LAST:event_btnbuscaareaActionPerformed

    private void txtnombresubareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresubareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresubareaActionPerformed

    private void btnbuscar_subarea_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_trabActionPerformed

      if (txtnombrearea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Área primero");
            txtnombrearea.requestFocus();
            return;

        }
conexion.formsubarea=frmanalisevolutivo.txtnombrearea.getText();
        frmzfiltrosubarea form = new frmzfiltrosubarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop (true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_trabActionPerformed

    private void txtnombrekpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrekpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrekpiActionPerformed

    private void btnbusca_kpi_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusca_kpi_ObjActionPerformed

  if (txtnombresubarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubÁrea primero");
            txtnombresubarea.requestFocus();
            return;

        }
conexion.formsubarea=frmanalisevolutivo.txtnombresubarea.getText();






        frmzfiltrokpi form = new frmzfiltrokpi();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop (true);   
       // TODO add your handling code here:
    }//GEN-LAST:event_btnbusca_kpi_ObjActionPerformed

    private void formInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_formInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_formInputMethodTextChanged

    private void btnclearselecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearselecActionPerformed
     
txtnombrearea.setText("");
txtnombresubarea.setText("");
txtnombrekpi.setText("");




        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearselecActionPerformed

    private void tablaanalisisMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisisMousePressed

    }//GEN-LAST:event_tablaanalisisMousePressed

    private void tablaanalisisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisisMouseClicked

    }//GEN-LAST:event_tablaanalisisMouseClicked

    private void tablaanalisisFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaanalisisFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_tablaanalisisFocusGained

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
            java.util.logging.Logger.getLogger(frmanalisevolutivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmanalisevolutivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmanalisevolutivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmanalisevolutivo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmanalisevolutivo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusca_kpi_Obj;
    private javax.swing.JButton btnbuscaarea;
    private javax.swing.JButton btnbuscar_subarea_trab;
    private javax.swing.JButton btnclearselec;
    private javax.swing.JButton btngraficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombrekpi13;
    private javax.swing.JLabel lblnombrekpi6;
    private javax.swing.JLabel lblnombrekpi9;
    private javax.swing.JPanel pnlgrafica;
    private javax.swing.JTable tablaanalisis;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombrekpi;
    public static javax.swing.JTextField txtnombresubarea;
    // End of variables declaration//GEN-END:variables
}
