/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.awt.BorderLayout;
import java.awt.Color;

import java.text.DecimalFormat;

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

import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

import org.jfree.chart.plot.PiePlot;

import org.jfree.data.general.DefaultPieDataset;

/**
 *
 * @author crist
 */
public class frmanalisproyeccion extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmanalisis
     */
    public frmanalisproyeccion() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();

        

        mostrar("", "", "", "", "", "");

        conexion.frmabierto = 8;

        txtyear.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }
        });
        txtmes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }
        });
        txtnombrearea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");

            }
        });
        txtnombresubarea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), ""); //To change body of generated methods, choose Tools | Templates.

            }
        });

        txtpersonadocumento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    void ocultar() {

        txtpersonadocumento.setVisible(false);
        
        txtnombretrabajador.setEnabled(false);
        txtnombrearea.setEnabled(false);
        txtnombresubarea.setEnabled(false);
        txtyear.setEnabled(false);
        txtmes.setEnabled(false);
        
         tablalistproyeccion.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistproyeccion.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistproyeccion.getColumnModel().getColumn(1).setPreferredWidth(0);
        
         tablalistproyeccion.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistproyeccion.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistproyeccion.getColumnModel().getColumn(2).setPreferredWidth(0);

    }
 DecimalFormat numberFormat = new DecimalFormat("#,##0;(#,##0)");
    void mostrar(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        try {
            DefaultTableModel modelo;
            fanalisis func = new fanalisis();
            modelo = func.mostraragrupadopordocumento(year, mes, area, Subarea, Trabajador, KPI);

            tablalistproyeccion.setModel(modelo);
            ocultar();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }
        
        String valorobtenidoreal;
        valorobtenidoreal = numberFormat.format(fanalisis.resultobttotal);
        lblresultadosobtenidos.setText("Resultado Obtenido Total: $ " + valorobtenidoreal);
       
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
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnclearselec = new javax.swing.JButton();
        btnresultado = new javax.swing.JButton();
        txtpersonadocumento = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        lblnombrekpi8 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        btnbuscayear = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lblnombrekpi7 = new javax.swing.JLabel();
        txtmes = new javax.swing.JTextField();
        btnbuscames = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblnombrekpi6 = new javax.swing.JLabel();
        txtnombrearea = new javax.swing.JTextField();
        btnbuscaarea = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        lblnombrekpi13 = new javax.swing.JLabel();
        txtnombresubarea = new javax.swing.JTextField();
        btnbuscar_subarea_trab = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        lblnombrekpi14 = new javax.swing.JLabel();
        txtnombretrabajador = new javax.swing.JTextField();
        btnbuscar_subarea_trab1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblresultadosobtenidos = new javax.swing.JLabel();
        pnlgrafica = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistproyeccion = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1261, 468));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 548));

        jPanel10.setBackground(new java.awt.Color(53, 29, 113));

        jPanel4.setBackground(new java.awt.Color(153, 103, 198));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 100));

        btnclearselec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/errasesel.png"))); // NOI18N
        btnclearselec.setToolTipText("Borrar selecciones");
        btnclearselec.setBorder(null);
        btnclearselec.setBorderPainted(false);
        btnclearselec.setContentAreaFilled(false);
        btnclearselec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearselecActionPerformed(evt);
            }
        });

        btnresultado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/graficar.png"))); // NOI18N
        btnresultado.setToolTipText("Gráficar y mostrar resultados en la tabla");
        btnresultado.setBorder(null);
        btnresultado.setBorderPainted(false);
        btnresultado.setContentAreaFilled(false);
        btnresultado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnresultadoActionPerformed(evt);
            }
        });

        jPanel8.setBackground(new java.awt.Color(153, 103, 198));
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi8.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi8.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi8.setText("Año:");
        lblnombrekpi8.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel8.add(lblnombrekpi8);

        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });
        jPanel8.add(txtyear);

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
        jPanel8.add(btnbuscayear);

        jPanel9.setBackground(new java.awt.Color(153, 103, 198));
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi7.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi7.setText("Mes:");
        lblnombrekpi7.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel9.add(lblnombrekpi7);

        txtmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesActionPerformed(evt);
            }
        });
        jPanel9.add(txtmes);

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
        jPanel9.add(btnbuscames);

        jPanel6.setBackground(new java.awt.Color(153, 103, 198));
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi6.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi6.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi6.setText("Área:");
        lblnombrekpi6.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel6.add(lblnombrekpi6);

        txtnombrearea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreareaActionPerformed(evt);
            }
        });
        jPanel6.add(txtnombrearea);

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
        jPanel6.add(btnbuscaarea);

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

        jPanel7.setBackground(new java.awt.Color(153, 103, 198));
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi14.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi14.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi14.setText("Trabajador:");
        jPanel7.add(lblnombrekpi14);

        txtnombretrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombretrabajadorActionPerformed(evt);
            }
        });
        jPanel7.add(txtnombretrabajador);

        btnbuscar_subarea_trab1.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscar_subarea_trab1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscar_subarea_trab1.setToolTipText("Buscar trabajador");
        btnbuscar_subarea_trab1.setBorder(null);
        btnbuscar_subarea_trab1.setBorderPainted(false);
        btnbuscar_subarea_trab1.setContentAreaFilled(false);
        btnbuscar_subarea_trab1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_subarea_trab1ActionPerformed(evt);
            }
        });
        jPanel7.add(btnbuscar_subarea_trab1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnclearselec)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 110, Short.MAX_VALUE)
                                .addComponent(btnresultado))
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnresultado))
                    .addComponent(btnclearselec))
                .addGap(38, 38, 38))
        );

        jPanel3.setBackground(new java.awt.Color(53, 29, 113));

        lblresultadosobtenidos.setBackground(new java.awt.Color(255, 255, 255));
        lblresultadosobtenidos.setFont(new java.awt.Font("Calibri", 1, 24)); // NOI18N
        lblresultadosobtenidos.setForeground(new java.awt.Color(255, 255, 255));
        lblresultadosobtenidos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblresultadosobtenidos.setText("Resultado Obtenido");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblresultadosobtenidos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(lblresultadosobtenidos, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pnlgrafica.setBackground(new java.awt.Color(102, 50, 159));
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
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel2.setBackground(new java.awt.Color(102, 50, 159));

        tablalistproyeccion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(tablalistproyeccion);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 370, Short.MAX_VALUE)
                .addContainerGap())
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Proyección Stymuli");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(188, 188, 188)
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlgrafica, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnlgrafica, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 392, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1245, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 468, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesActionPerformed

    private void txtyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearActionPerformed

    private void btnclearselecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearselecActionPerformed
        txtmes.setText("");
        txtyear.setText("");
        txtnombrearea.setText("");

        txtpersonadocumento.setText("");
        txtnombresubarea.setText("");
        txtnombretrabajador.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearselecActionPerformed
   

    private void btnresultadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnresultadoActionPerformed

        ChartFactory.setChartTheme(StandardChartTheme.createLegacyTheme());

        TableModel tm = tablalistproyeccion.getModel();

        Double sumpos = 0.0;
        Double sumres = 0.0;

        DefaultPieDataset dataset1 = new DefaultPieDataset();

        for (int j = 0; j < tm.getRowCount(); j++) {
            Double r = Double.parseDouble(tm.getValueAt(j, 3).toString().replaceAll("[^0-9.-]", ""));
            Double p = Double.parseDouble(tm.getValueAt(j, 4).toString().replaceAll("[^0-9.-]", ""));
            sumpos = sumpos + p - r;
            dataset1.setValue("No Obtenido", sumpos);
        }

        for (int j = 0; j < tm.getRowCount(); j++) {

            Double r = Double.parseDouble(tm.getValueAt(j, 3).toString().replaceAll("[^0-9.-]", ""));
            sumres = sumres + r;
            dataset1.setValue("Obtenido", sumres);
        }

        JFreeChart chart = ChartFactory.createPieChart(
                "Proyección " + txtnombrearea.getText() + " " + txtnombresubarea.getText() + " " + txtnombretrabajador.getText(), // chart title 
                dataset1, // data    
                true, // include legend   
                true,
                false);
        chart.getTitle().setPaint(Color.WHITE);
        PiePlot plot = (PiePlot) chart.getPlot();

        PieSectionLabelGenerator gen = new StandardPieSectionLabelGenerator(
                "{0}: {1} ({2})", new DecimalFormat("$" + "#,##0;(#,##0)"), new DecimalFormat("0%"));
        plot.setLabelGenerator(gen);
        plot.setBackgroundPaint(Color.WHITE);
        chart.setBackgroundPaint(new Color(53, 29, 113));
        plot.setSectionPaint(0, new Color(121, 152, 40));
        plot.setSectionPaint(1, new Color(49, 95, 118));
        final ChartPanel chartPanel = new ChartPanel(chart);
        pnlgrafica.setLayout(new java.awt.BorderLayout());
        pnlgrafica.add(chartPanel, BorderLayout.CENTER);
        pnlgrafica.validate();


    }//GEN-LAST:event_btnresultadoActionPerformed

    private void btnbuscaareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaareaActionPerformed
        // TODO add your handling code here:

        frmzfiltroarea form = new frmzfiltroarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
    }//GEN-LAST:event_btnbuscaareaActionPerformed

    private void txtnombreareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreareaActionPerformed
        // TODO add your handling code here:

        txtnombrearea.transferFocus();
    }//GEN-LAST:event_txtnombreareaActionPerformed

    private void txtnombresubareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresubareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresubareaActionPerformed

    private void btnbuscar_subarea_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_trabActionPerformed

        if (txtnombrearea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Área primero");
            txtnombrearea.requestFocus();
            return;

        }
        conexion.formsubarea = frmanalisproyeccion.txtnombrearea.getText();
        frmzfiltrosubarea form = new frmzfiltrosubarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_trabActionPerformed

    private void txtnombretrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombretrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombretrabajadorActionPerformed

    private void btnbuscar_subarea_trab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_trab1ActionPerformed

        if (txtnombresubarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubÁrea primero");
            txtnombresubarea.requestFocus();
            return;

        }

        conexion.formsubarea = frmanalisproyeccion.txtnombresubarea.getText();

        frmzfiltrotrabajador form = new frmzfiltrotrabajador();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_trab1ActionPerformed

    private void btnbuscayearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscayearActionPerformed
        frmzfiltroyear form = new frmzfiltroyear();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscayearActionPerformed

    private void btnbuscamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscamesActionPerformed
        frmzfiltromes form = new frmzfiltromes();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(frmanalisproyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmanalisproyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmanalisproyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmanalisproyeccion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmanalisproyeccion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscaarea;
    private javax.swing.JButton btnbuscames;
    private javax.swing.JButton btnbuscar_subarea_trab;
    private javax.swing.JButton btnbuscar_subarea_trab1;
    private javax.swing.JButton btnbuscayear;
    private javax.swing.JButton btnclearselec;
    private javax.swing.JButton btnresultado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblnombrekpi13;
    private javax.swing.JLabel lblnombrekpi14;
    private javax.swing.JLabel lblnombrekpi6;
    private javax.swing.JLabel lblnombrekpi7;
    private javax.swing.JLabel lblnombrekpi8;
    private javax.swing.JLabel lblresultadosobtenidos;
    private javax.swing.JPanel pnlgrafica;
    private javax.swing.JTable tablalistproyeccion;
    public static javax.swing.JTextField txtmes;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombresubarea;
    public static javax.swing.JTextField txtnombretrabajador;
    public static javax.swing.JTextField txtpersonadocumento;
    public static javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
