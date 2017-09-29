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
import org.jfree.data.category.CategoryDataset;

import org.jfree.data.category.DefaultCategoryDataset;


/**
 *
 * @author crist
 */
public class frmanalisfrecuencia extends javax.swing.JInternalFrame {

    
    
    /**
     * Creates new form frmanalisis
     */
    public frmanalisfrecuencia() {
((javax.swing.plaf.basic.BasicInternalFrameUI)this.getUI()).setNorthPane(null);
this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();
        mostrar("","","","","","");
        tablaanalisischart2.setShowGrid(true);
        conexion.frmabierto=5;
        btngraficar.requestFocus();
           txtyear.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
              mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
             mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
             mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
           txtmes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
             mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
         
        
        txtnombrearea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
               mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());//To change body of generated methods, choose Tools | Templates.
            }
        });
        
        
           txtnombresubarea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
              mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
           
           
              txtnombrekpi.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
               mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
              mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText());  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
               mostrar(txtyear.getText(),txtmes.getText(),txtnombrearea.getText(),txtnombresubarea.getText(),"",txtnombrekpi.getText()); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
    }

   

 void mostrar(String year, String mes, String area, String Subarea,String Trabajador, String KPI) {
        try {
            DefaultTableModel modelo;
            fanalisis func = new fanalisis();
            modelo = func.mostrarcompleto(year, mes, area, Subarea,Trabajador, KPI);

            tablaanalisischart2.setModel(modelo);
            ocultar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }
       void ocultar() {
       
         
         txtnombrearea.setEnabled(false);
         txtnombrekpi.setEnabled(false);
         txtnombresubarea.setEnabled(false);
              txtyear.setEnabled(false);
        txtmes.setEnabled(false);
           
        

        tablaanalisischart2.getColumnModel().getColumn(1).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(1).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablaanalisischart2.getColumnModel().getColumn(2).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(2).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(2).setPreferredWidth(0);

        tablaanalisischart2.getColumnModel().getColumn(3).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(3).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(3).setPreferredWidth(0);

        tablaanalisischart2.getColumnModel().getColumn(4).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(4).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(4).setPreferredWidth(0);
        
        tablaanalisischart2.getColumnModel().getColumn(5).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(5).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(5).setPreferredWidth(0);
        
         tablaanalisischart2.getColumnModel().getColumn(6).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(6).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(6).setPreferredWidth(0);
        
         tablaanalisischart2.getColumnModel().getColumn(8).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(8).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(8).setPreferredWidth(0);
        
         tablaanalisischart2.getColumnModel().getColumn(9).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(9).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(9).setPreferredWidth(0);
        
        
        tablaanalisischart2.getColumnModel().getColumn(10).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(10).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(10).setPreferredWidth(0);
        
        tablaanalisischart2.getColumnModel().getColumn(11).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(11).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(11).setPreferredWidth(0);
        
        tablaanalisischart2.getColumnModel().getColumn(13).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(13).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(13).setPreferredWidth(0);
        
        tablaanalisischart2.getColumnModel().getColumn(14).setMaxWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(14).setMinWidth(0);
        tablaanalisischart2.getColumnModel().getColumn(14).setPreferredWidth(0);
       

        

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
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaanalisischart2 = new javax.swing.JTable();
        pnlgrafica = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btngraficar = new javax.swing.JButton();
        btnclearselec = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblnombrekpi8 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        btnbuscayear = new javax.swing.JButton();
        pnlarea = new javax.swing.JPanel();
        lblnombrekpi6 = new javax.swing.JLabel();
        txtnombrearea = new javax.swing.JTextField();
        btnbuscaarea = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblnombrekpi7 = new javax.swing.JLabel();
        txtmes = new javax.swing.JTextField();
        btnbuscames = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblnombrekpi9 = new javax.swing.JLabel();
        txtnombrekpi = new javax.swing.JTextField();
        btnbusca_kpi_Obj = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblnombrekpi13 = new javax.swing.JLabel();
        txtnombresubarea = new javax.swing.JTextField();
        btnbuscar_subarea_trab = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Frecuencia Cumplimiento");
        addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                formInputMethodTextChanged(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel9.setBackground(new java.awt.Color(53, 29, 113));

        jPanel2.setBackground(new java.awt.Color(102, 50, 159));
        jPanel2.setPreferredSize(new java.awt.Dimension(400, 400));

        tablaanalisischart2.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaanalisischart2.setCellSelectionEnabled(true);
        tablaanalisischart2.setEnabled(false);
        tablaanalisischart2.setGridColor(new java.awt.Color(102, 50, 159));
        tablaanalisischart2.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaanalisischart2FocusGained(evt);
            }
        });
        tablaanalisischart2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaanalisischart2MouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaanalisischart2MousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaanalisischart2);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 376, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        lblnombrekpi8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi8.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi8.setText("Año:");
        lblnombrekpi8.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel3.add(lblnombrekpi8);

        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });
        jPanel3.add(txtyear);

        btnbuscayear.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscayear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscayear.setToolTipText("Buscar área");
        btnbuscayear.setBorder(null);
        btnbuscayear.setBorderPainted(false);
        btnbuscayear.setContentAreaFilled(false);
        btnbuscayear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscayearActionPerformed(evt);
            }
        });
        jPanel3.add(btnbuscayear);

        pnlarea.setBackground(new java.awt.Color(153, 103, 198));
        pnlarea.setLayout(new javax.swing.BoxLayout(pnlarea, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi6.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi6.setText("Área:");
        lblnombrekpi6.setPreferredSize(new java.awt.Dimension(55, 14));
        pnlarea.add(lblnombrekpi6);

        txtnombrearea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreareaActionPerformed(evt);
            }
        });
        pnlarea.add(txtnombrearea);

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
        pnlarea.add(btnbuscaarea);

        jPanel6.setBackground(new java.awt.Color(153, 103, 198));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi7.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi7.setText("Mes:");
        lblnombrekpi7.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel6.add(lblnombrekpi7);

        txtmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesActionPerformed(evt);
            }
        });
        jPanel6.add(txtmes);

        btnbuscames.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscames.setToolTipText("Buscar área");
        btnbuscames.setBorder(null);
        btnbuscames.setBorderPainted(false);
        btnbuscames.setContentAreaFilled(false);
        btnbuscames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscamesActionPerformed(evt);
            }
        });
        jPanel6.add(btnbuscames);

        jPanel7.setBackground(new java.awt.Color(153, 103, 198));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi9.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi9.setText("KPI :");
        lblnombrekpi9.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel7.add(lblnombrekpi9);

        txtnombrekpi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrekpiActionPerformed(evt);
            }
        });
        jPanel7.add(txtnombrekpi);

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
        jPanel7.add(btnbusca_kpi_Obj);

        jPanel8.setBackground(new java.awt.Color(153, 103, 198));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi13.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi13.setText("SubÁrea:");
        lblnombrekpi13.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel8.add(lblnombrekpi13);

        txtnombresubarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresubareaActionPerformed(evt);
            }
        });
        jPanel8.add(txtnombresubarea);

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
        jPanel8.add(btnbuscar_subarea_trab);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pnlarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(btnclearselec)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                        .addComponent(btngraficar))
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(215, 215, 215)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclearselec)
                    .addComponent(btngraficar))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Frecuencia de Cumplimiento");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 610, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)
                    .addComponent(pnlgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 430, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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


fanalisis func=new fanalisis();

     ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());
        
        
DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();  
 

        TableModel tm = tablaanalisischart2.getModel();
                   Double y1=0.0;   
                   Double y2=0.0;
                   Double y3=0.0;
                   Double y4=0.0;
                   Double y5=0.0;
                   Double y6=0.0;
                   Double y7=0.0;
                   Double y8=0.0;
                   Double y9=0.0;
                   Double y10=0.0;
                   Double y11=0.0;
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre<=14.00) {
                    y1++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>14.00&&fre<=24.00) {
                    y2++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>24.00&&fre<=34.00) {
                    y3++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>34.00&&fre<=44.00) {
                    y4++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>44.00&&fre<=54.00) {
                    y5++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>54.00&&fre<=64.00) {
                    y6++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>64.00&&fre<=74.00) {
                    y7++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>74.00&&fre<=84.00) {
                    y8++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>84.00&&fre<=99.00) {
                    y9++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>99.00&&fre<=100.00) {
                    y10++;
                }                                 
            }  
            for (int j = 0; j < tm.getRowCount(); j++) {                                                       
            Double fre = Double.parseDouble(tm.getValueAt(j, 12).toString().replaceAll("[^0-9.-]", ""));
                if (fre>100.00) {
                    y11++;
                }                                 
            }  
            
            dataset1.addValue(y1, "Frecuencia", "10%");
            dataset1.addValue(y2, "Frecuencia", "20%");
            dataset1.addValue(y3, "Frecuencia", "30%");
            dataset1.addValue(y4, "Frecuencia", "40%");
            dataset1.addValue(y5, "Frecuencia", "50%");
            dataset1.addValue(y6, "Frecuencia", "60%");
            dataset1.addValue(y7, "Frecuencia", "70%");
            dataset1.addValue(y8, "Frecuencia", "80%");
            dataset1.addValue(y9, "Frecuencia", "90%");
            dataset1.addValue(y10, "Frecuencia", "100%");
            dataset1.addValue(y11, "Frecuencia", "101%++");
            
           
        
                 
       final CategoryItemRenderer renderer = new BarRenderer();
       
   
    //    renderer.setLabelGenerator(generator);
        renderer.setItemLabelsVisible(true);
       
        renderer.setBaseItemLabelsVisible(true);
        renderer.setBaseItemLabelPaint(Color.GREEN);
        
        
        
  
        renderer.setSeriesPaint(0, new Color(121,152,40));
        
        
        final CategoryPlot plot = new CategoryPlot();
        plot.setBackgroundPaint(Color.WHITE);
        plot.setForegroundAlpha(0.8f);
        plot.setRangeGridlinesVisible(true);
        plot.setRangeGridlinePaint(Color.BLACK);
        
        plot.setDataset(dataset1);
        plot.setRenderer(renderer);
   
        plot.setDomainAxis(new CategoryAxis("% de Cumplimiento"));
        
     
         
        plot.setRangeAxis(new NumberAxis("C/Trabajadores"));

        plot.setOrientation(PlotOrientation.VERTICAL);
        plot.setRangeGridlinesVisible(true);
        plot.setDomainGridlinesVisible(true);
        
        
        
       
       
                                              
        
        plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        
        plot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        final JFreeChart chart = new JFreeChart(plot);
        chart.setBackgroundPaint(new Color(53,29,113));
        chart.setTitle("Frecuencia de Cumplimiento "+txtnombrearea.getText()+" "+txtnombresubarea.getText()+" "+txtnombrekpi.getText());
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
conexion.formsubarea=frmanalisfrecuencia.txtnombrearea.getText();
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
conexion.formsubarea=frmanalisfrecuencia.txtnombresubarea.getText();






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
txtmes.setText("");
txtyear.setText("");       
txtnombrearea.setText("");
txtnombresubarea.setText("");
txtnombrekpi.setText("");




        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearselecActionPerformed

    private void tablaanalisischart2MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisischart2MousePressed

    }//GEN-LAST:event_tablaanalisischart2MousePressed

    private void tablaanalisischart2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisischart2MouseClicked

    }//GEN-LAST:event_tablaanalisischart2MouseClicked

    private void tablaanalisischart2FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaanalisischart2FocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_tablaanalisischart2FocusGained

    private void txtmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesActionPerformed

    private void txtyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearActionPerformed

    private void btnbuscayearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscayearActionPerformed
frmzfiltroyear form = new frmzfiltroyear();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop (true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscayearActionPerformed

    private void btnbuscamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscamesActionPerformed
frmzfiltromes form = new frmzfiltromes();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop (true);           // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscamesActionPerformed

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
            java.util.logging.Logger.getLogger(frmanalisfrecuencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmanalisfrecuencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmanalisfrecuencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmanalisfrecuencia.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmanalisfrecuencia().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusca_kpi_Obj;
    private javax.swing.JButton btnbuscaarea;
    private javax.swing.JButton btnbuscames;
    private javax.swing.JButton btnbuscar_subarea_trab;
    private javax.swing.JButton btnbuscayear;
    private javax.swing.JButton btnclearselec;
    private javax.swing.JButton btngraficar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombrekpi13;
    private javax.swing.JLabel lblnombrekpi6;
    private javax.swing.JLabel lblnombrekpi7;
    private javax.swing.JLabel lblnombrekpi8;
    private javax.swing.JLabel lblnombrekpi9;
    public static javax.swing.JPanel pnlarea;
    private javax.swing.JPanel pnlgrafica;
    public static javax.swing.JTable tablaanalisischart2;
    public static javax.swing.JTextField txtmes;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombrekpi;
    public static javax.swing.JTextField txtnombresubarea;
    public static javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
