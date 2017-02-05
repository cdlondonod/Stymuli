/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import logica.conexion;

import logica.fanalisis;

/**
 *
 * @author crist
 */
public class frmanalisisobtpersona extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmanalisis
     */
    public frmanalisisobtpersona() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();
        mostrar("", "", "", "", "", "");
        tablalistporpersona.setDefaultEditor(Object.class, null);
        inhabilitar();
tablalistporpersona.setShowGrid(true);
        conexion.frmabierto = 10;

        txtyear.getDocument().addDocumentListener(new DocumentListener() {
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
        txtmes.getDocument().addDocumentListener(new DocumentListener() {
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

        txtnombrearea.getDocument().addDocumentListener(new DocumentListener() {
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
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), "");
                //To change body of generated methods, choose Tools | Templates.
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

    void inhabilitar() {

        txtpersonadocumento.setVisible(false);

        txtnombrearea.setEnabled(false);

        txtnombresubarea.setEnabled(false);
        txtnombretrabajador.setEnabled(false);
        txtyear.setEnabled(false);
        txtmes.setEnabled(false);

        txtpersonadocumento.setText("");
        txtnombrearea.setText("");

        txtnombresubarea.setText("");
        txtnombretrabajador.setText("");

    }

    void ocultar_col() {

        tablalistporpersona.getColumnModel().getColumn(4).setMaxWidth(0);
        tablalistporpersona.getColumnModel().getColumn(4).setMinWidth(0);
        tablalistporpersona.getColumnModel().getColumn(4).setPreferredWidth(0);
    }

    void mostrar(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        try {
            DefaultTableModel modelo;
            fanalisis func = new fanalisis();
            modelo = func.mostraragrupadopordocumento(year, mes, area, Subarea, Trabajador, KPI);

            tablalistporpersona.setModel(modelo);
            ocultar_col();
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
        jPanel3 = new javax.swing.JPanel();
        lblresultadosobtenidos = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnclearselec = new javax.swing.JButton();
        txtpersonadocumento = new javax.swing.JTextField();
        jPanel5 = new javax.swing.JPanel();
        lblnombrekpi14 = new javax.swing.JLabel();
        txtnombretrabajador = new javax.swing.JTextField();
        btnbuscar_subarea_trab1 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblnombrekpi13 = new javax.swing.JLabel();
        txtnombresubarea = new javax.swing.JTextField();
        btnbuscar_subarea_trab = new javax.swing.JButton();
        pnlarea = new javax.swing.JPanel();
        lblnombrekpi6 = new javax.swing.JLabel();
        txtnombrearea = new javax.swing.JTextField();
        btnbuscaarea = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        lblnombrekpi7 = new javax.swing.JLabel();
        txtmes = new javax.swing.JTextField();
        btnbuscames = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        lblnombrekpi8 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        btnbuscayear = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistporpersona = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(700, 582));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 548));

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setLayout(new java.awt.BorderLayout());

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));

        lblresultadosobtenidos.setBackground(new java.awt.Color(53, 29, 113));
        lblresultadosobtenidos.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        lblresultadosobtenidos.setForeground(new java.awt.Color(75, 16, 160));
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

        jPanel10.add(jPanel3, java.awt.BorderLayout.PAGE_END);

        jLabel1.setBackground(new java.awt.Color(75, 16, 160));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Obtenido por Persona");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(155, 20));
        jPanel10.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel7.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 300));

        btnclearselec.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/errasesel.png"))); // NOI18N
        btnclearselec.setToolTipText("Borrar las selecciones");
        btnclearselec.setBorder(null);
        btnclearselec.setBorderPainted(false);
        btnclearselec.setContentAreaFilled(false);
        btnclearselec.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnclearselecActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(153, 103, 198));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi14.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi14.setText("Trabajador:");
        jPanel5.add(lblnombrekpi14);

        txtnombretrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombretrabajadorActionPerformed(evt);
            }
        });
        jPanel5.add(txtnombretrabajador);

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
        jPanel5.add(btnbuscar_subarea_trab1);

        jPanel6.setBackground(new java.awt.Color(153, 103, 198));
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi13.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi13.setText("SubÁrea:");
        lblnombrekpi13.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel6.add(lblnombrekpi13);

        txtnombresubarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresubareaActionPerformed(evt);
            }
        });
        jPanel6.add(txtnombresubarea);

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
        jPanel6.add(btnbuscar_subarea_trab);

        pnlarea.setBackground(new java.awt.Color(153, 103, 198));
        pnlarea.setOpaque(false);
        pnlarea.setLayout(new javax.swing.BoxLayout(pnlarea, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi6.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi6.setForeground(new java.awt.Color(75, 16, 160));
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

        jPanel8.setBackground(new java.awt.Color(153, 103, 198));
        jPanel8.setOpaque(false);
        jPanel8.setLayout(new javax.swing.BoxLayout(jPanel8, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi7.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi7.setText("Mes:");
        lblnombrekpi7.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel8.add(lblnombrekpi7);

        txtmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesActionPerformed(evt);
            }
        });
        jPanel8.add(txtmes);

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
        jPanel8.add(btnbuscames);

        jPanel9.setBackground(new java.awt.Color(153, 103, 198));
        jPanel9.setOpaque(false);
        jPanel9.setLayout(new javax.swing.BoxLayout(jPanel9, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi8.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi8.setText("Año:");
        lblnombrekpi8.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel9.add(lblnombrekpi8);

        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });
        jPanel9.add(txtyear);

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
        jPanel9.add(btnbuscayear);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnclearselec))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, 166, Short.MAX_VALUE)
                            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(pnlarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel5, jPanel6, jPanel8, jPanel9, pnlarea});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(btnclearselec)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel5, jPanel6, jPanel8, jPanel9, pnlarea});

        jPanel7.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(101, 54, 193));

        tablalistporpersona.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablalistporpersona.setForeground(new java.awt.Color(75, 16, 160));
        tablalistporpersona.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistporpersona.setGridColor(new java.awt.Color(75, 16, 160));
        jScrollPane2.setViewportView(tablalistporpersona);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 422, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel7.add(jPanel2);

        jPanel10.add(jPanel7, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 690, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtnombreareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreareaActionPerformed
        // TODO add your handling code here:

        txtnombrearea.transferFocus();
    }//GEN-LAST:event_txtnombreareaActionPerformed

    private void btnbuscaareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscaareaActionPerformed
        // TODO add your handling code here:

        frmzfiltroarea form = new frmzfiltroarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
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
        conexion.formsubarea = frmanalisisobtpersona.txtnombrearea.getText();
        frmzfiltrosubarea form = new frmzfiltrosubarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_trabActionPerformed

    private void txtmesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmesActionPerformed

    private void txtyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtyearActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtyearActionPerformed

    private void txtnombretrabajadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombretrabajadorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombretrabajadorActionPerformed

    private void btnbuscar_subarea_trab1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_trab1ActionPerformed

        if (txtnombresubarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubÁrea primero");
            txtnombresubarea.requestFocus();
            return;

        }

        conexion.formsubarea = frmanalisisobtpersona.txtnombresubarea.getText();

        frmzfiltrotrabajador form = new frmzfiltrotrabajador();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);

// TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_trab1ActionPerformed

    private void btnclearselecActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnclearselecActionPerformed
        txtmes.setText("");
        txtyear.setText("");
        txtnombrearea.setText("");
        txtnombresubarea.setText("");

        txtpersonadocumento.setText("");
        txtnombretrabajador.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearselecActionPerformed
    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    private void btnbuscamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscamesActionPerformed
        frmzfiltromes form = new frmzfiltromes();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscamesActionPerformed

    private void btnbuscayearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscayearActionPerformed
        frmzfiltroyear form = new frmzfiltroyear();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscayearActionPerformed

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
            java.util.logging.Logger.getLogger(frmanalisisobtpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmanalisisobtpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmanalisisobtpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmanalisisobtpersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new frmanalisisobtpersona().setVisible(true);
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
    public static javax.swing.JPanel pnlarea;
    private javax.swing.JTable tablalistporpersona;
    public static javax.swing.JTextField txtmes;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombresubarea;
    public static javax.swing.JTextField txtnombretrabajador;
    public static javax.swing.JTextField txtpersonadocumento;
    public static javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
