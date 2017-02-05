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
public class frmanalisiscompleto extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmanalisis
     */
    public frmanalisiscompleto() {
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        initComponents();
        mostrar("", "", "", "", "", "");
        inhabilitar();
        ocultar_col();
        conexion.frmabierto = 9;
        tablaanalisiscompleto.setShowGrid(true);
        tablaanalisiscompleto.setDefaultEditor(Object.class, null);

        txtyear.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();//To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtmes.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtnombrearea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtnombresubarea.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });

        txtpersonadocumento.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });
        txtnombrekpi.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col();  //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                mostrar(txtyear.getText(), txtmes.getText(), txtnombrearea.getText(), txtnombresubarea.getText(), txtpersonadocumento.getText(), txtnombrekpi.getText());
                ocultar_col(); //To change body of generated methods, choose Tools | Templates.
            }
        });

    }

    void inhabilitar() {

        txtpersonadocumento.setVisible(false);

        txtnombrearea.setEnabled(false);
        txtnombrekpi.setEnabled(false);
        txtnombresubarea.setEnabled(false);
        txtnombretrabajador.setEnabled(false);
        txtyear.setEnabled(false);
        txtmes.setEnabled(false);

        txtpersonadocumento.setText("");
        txtnombrearea.setText("");
        txtnombrekpi.setText("");
        txtnombresubarea.setText("");
        txtnombretrabajador.setText("");

    }

    void ocultar_col() {

        tablaanalisiscompleto.getColumnModel().getColumn(1).setMaxWidth(110);
        tablaanalisiscompleto.getColumnModel().getColumn(1).setMinWidth(110);
        tablaanalisiscompleto.getColumnModel().getColumn(1).setPreferredWidth(110);

        tablaanalisiscompleto.getColumnModel().getColumn(2).setMaxWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(2).setMinWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(2).setPreferredWidth(80);

        tablaanalisiscompleto.getColumnModel().getColumn(3).setMaxWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(3).setMinWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(3).setPreferredWidth(70);

        tablaanalisiscompleto.getColumnModel().getColumn(4).setMaxWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(4).setMinWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(4).setPreferredWidth(70);

        tablaanalisiscompleto.getColumnModel().getColumn(5).setMaxWidth(50);
        tablaanalisiscompleto.getColumnModel().getColumn(5).setMinWidth(50);
        tablaanalisiscompleto.getColumnModel().getColumn(5).setPreferredWidth(50);

        tablaanalisiscompleto.getColumnModel().getColumn(6).setMaxWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(6).setMinWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(6).setPreferredWidth(80);

        tablaanalisiscompleto.getColumnModel().getColumn(7).setMaxWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(7).setMinWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(7).setPreferredWidth(80);

        tablaanalisiscompleto.getColumnModel().getColumn(8).setMaxWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(8).setMinWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(8).setPreferredWidth(60);

        tablaanalisiscompleto.getColumnModel().getColumn(9).setMaxWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(9).setMinWidth(70);
        tablaanalisiscompleto.getColumnModel().getColumn(9).setPreferredWidth(70);

        tablaanalisiscompleto.getColumnModel().getColumn(10).setMaxWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(10).setMinWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(10).setPreferredWidth(60);

        tablaanalisiscompleto.getColumnModel().getColumn(11).setMaxWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(11).setMinWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(11).setPreferredWidth(60);

        tablaanalisiscompleto.getColumnModel().getColumn(12).setMaxWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(12).setMinWidth(60);
        tablaanalisiscompleto.getColumnModel().getColumn(12).setPreferredWidth(60);

        tablaanalisiscompleto.getColumnModel().getColumn(13).setMaxWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(13).setMinWidth(80);
        tablaanalisiscompleto.getColumnModel().getColumn(13).setPreferredWidth(80);

        tablaanalisiscompleto.getColumnModel().getColumn(14).setMaxWidth(30);
        tablaanalisiscompleto.getColumnModel().getColumn(14).setMinWidth(30);
        tablaanalisiscompleto.getColumnModel().getColumn(14).setPreferredWidth(30);

        tablaanalisiscompleto.getColumnModel().getColumn(0).setMaxWidth(100);
        tablaanalisiscompleto.getColumnModel().getColumn(0).setMinWidth(100);
        tablaanalisiscompleto.getColumnModel().getColumn(0).setPreferredWidth(100);

    }

    void mostrar(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        try {
            DefaultTableModel modelo;
            fanalisis func = new fanalisis();
            modelo = func.mostrarcompleto(year, mes, area, Subarea, Trabajador, KPI);

            tablaanalisiscompleto.setModel(modelo);

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
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        btnclearselec = new javax.swing.JButton();
        ckbenabledtabla = new javax.swing.JCheckBox();
        txtpersonadocumento = new javax.swing.JTextField();
        jPanel11 = new javax.swing.JPanel();
        lblnombrekpi8 = new javax.swing.JLabel();
        txtyear = new javax.swing.JTextField();
        btnbuscayear = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        lblnombrekpi7 = new javax.swing.JLabel();
        txtmes = new javax.swing.JTextField();
        btnbuscames = new javax.swing.JButton();
        pnlarea = new javax.swing.JPanel();
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
        jPanel13 = new javax.swing.JPanel();
        lblnombrekpi14 = new javax.swing.JLabel();
        txtnombretrabajador = new javax.swing.JTextField();
        btnbuscar_subarea_trab1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaanalisiscompleto = new javax.swing.JTable();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setPreferredSize(new java.awt.Dimension(1300, 582));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 548));

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(75, 16, 160));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Resultados Completos");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(158, 20));
        jPanel7.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        jPanel3.setOpaque(false);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        jPanel4.setPreferredSize(new java.awt.Dimension(200, 300));

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

        ckbenabledtabla.setBackground(new java.awt.Color(254, 150, 3));
        ckbenabledtabla.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        ckbenabledtabla.setForeground(new java.awt.Color(75, 16, 160));
        ckbenabledtabla.setText("Habilitar Seleccion de Tabla");
        ckbenabledtabla.setBorder(null);
        ckbenabledtabla.setOpaque(false);
        ckbenabledtabla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ckbenabledtablaActionPerformed(evt);
            }
        });

        jPanel11.setBackground(new java.awt.Color(153, 103, 198));
        jPanel11.setOpaque(false);
        jPanel11.setLayout(new javax.swing.BoxLayout(jPanel11, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi8.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi8.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi8.setText("Año:");
        lblnombrekpi8.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel11.add(lblnombrekpi8);

        txtyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtyearActionPerformed(evt);
            }
        });
        jPanel11.add(txtyear);

        btnbuscayear.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscayear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscayear.setToolTipText("Buscar subárea");
        btnbuscayear.setBorder(null);
        btnbuscayear.setBorderPainted(false);
        btnbuscayear.setContentAreaFilled(false);
        btnbuscayear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscayearActionPerformed(evt);
            }
        });
        jPanel11.add(btnbuscayear);

        jPanel14.setBackground(new java.awt.Color(153, 103, 198));
        jPanel14.setOpaque(false);
        jPanel14.setLayout(new javax.swing.BoxLayout(jPanel14, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi7.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi7.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi7.setText("Mes:");
        lblnombrekpi7.setPreferredSize(new java.awt.Dimension(55, 14));
        jPanel14.add(lblnombrekpi7);

        txtmes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmesActionPerformed(evt);
            }
        });
        jPanel14.add(txtmes);

        btnbuscames.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscames.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscames.setToolTipText("Buscar subárea");
        btnbuscames.setBorder(null);
        btnbuscames.setBorderPainted(false);
        btnbuscames.setContentAreaFilled(false);
        btnbuscames.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscamesActionPerformed(evt);
            }
        });
        jPanel14.add(btnbuscames);

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

        jPanel5.setBackground(new java.awt.Color(153, 103, 198));
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi13.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi13.setForeground(new java.awt.Color(75, 16, 160));
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
        jPanel6.setOpaque(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi9.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi9.setForeground(new java.awt.Color(75, 16, 160));
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

        jPanel13.setBackground(new java.awt.Color(153, 103, 198));
        jPanel13.setOpaque(false);
        jPanel13.setLayout(new javax.swing.BoxLayout(jPanel13, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi14.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrekpi14.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrekpi14.setText("Trabajador:");
        jPanel13.add(lblnombrekpi14);

        txtnombretrabajador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombretrabajadorActionPerformed(evt);
            }
        });
        jPanel13.add(txtnombretrabajador);

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
        jPanel13.add(btnbuscar_subarea_trab1);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnclearselec)
                    .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlarea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ckbenabledtabla, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 17, Short.MAX_VALUE))
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel11, jPanel13, jPanel14, jPanel5, jPanel6, pnlarea});

        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel13, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ckbenabledtabla, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(txtpersonadocumento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addComponent(btnclearselec)
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel11, jPanel13, jPanel14, jPanel5, jPanel6, pnlarea});

        jPanel3.add(jPanel4);

        jPanel2.setBackground(new java.awt.Color(101, 54, 193));

        tablaanalisiscompleto.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablaanalisiscompleto.setForeground(new java.awt.Color(75, 16, 160));
        tablaanalisiscompleto.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaanalisiscompleto.setEnabled(false);
        tablaanalisiscompleto.setGridColor(new java.awt.Color(75, 16, 160));
        tablaanalisiscompleto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablaanalisiscompletoFocusGained(evt);
            }
        });
        tablaanalisiscompleto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaanalisiscompletoMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablaanalisiscompletoMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablaanalisiscompleto);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1026, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel3.add(jPanel2);

        jPanel7.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1290, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 549, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablaanalisiscompletoFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablaanalisiscompletoFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_tablaanalisiscompletoFocusGained

    private void tablaanalisiscompletoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisiscompletoMouseClicked

    }//GEN-LAST:event_tablaanalisiscompletoMouseClicked

    private void tablaanalisiscompletoMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaanalisiscompletoMousePressed


    }//GEN-LAST:event_tablaanalisiscompletoMousePressed

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

    private void txtnombrekpiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrekpiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrekpiActionPerformed

    private void btnbusca_kpi_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusca_kpi_ObjActionPerformed

        if (txtnombresubarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una SubÁrea primero");
            txtnombresubarea.requestFocus();
            return;

        }
        conexion.formsubarea = frmanalisiscompleto.txtnombresubarea.getText();

        frmzfiltrokpi form = new frmzfiltrokpi();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btnbusca_kpi_ObjActionPerformed

    private void txtnombresubareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresubareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresubareaActionPerformed

    private void btnbuscar_subarea_trabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_trabActionPerformed

        if (txtnombrearea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Área primero");
            txtnombrearea.requestFocus();
            return;

        }
        conexion.formsubarea = frmanalisiscompleto.txtnombrearea.getText();
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

        conexion.formsubarea = frmanalisiscompleto.txtnombresubarea.getText();

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
        txtnombrekpi.setText("");
        txtpersonadocumento.setText("");
        txtnombretrabajador.setText("");

        // TODO add your handling code here:
    }//GEN-LAST:event_btnclearselecActionPerformed
    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    private void ckbenabledtablaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ckbenabledtablaActionPerformed

        if (ckbenabledtabla.isSelected()) {

            tablaanalisiscompleto.setEnabled(true);

        } else {

            tablaanalisiscompleto.setEnabled(false);

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_ckbenabledtablaActionPerformed

    private void btnbuscamesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscamesActionPerformed
        frmzfiltromes form = new frmzfiltromes();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);        // TODO add your handling code here:
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
            java.util.logging.Logger.getLogger(frmanalisiscompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmanalisiscompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmanalisiscompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmanalisiscompleto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmanalisiscompleto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbusca_kpi_Obj;
    private javax.swing.JButton btnbuscaarea;
    private javax.swing.JButton btnbuscames;
    private javax.swing.JButton btnbuscar_subarea_trab;
    private javax.swing.JButton btnbuscar_subarea_trab1;
    private javax.swing.JButton btnbuscayear;
    private javax.swing.JButton btnclearselec;
    private javax.swing.JCheckBox ckbenabledtabla;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblnombrekpi13;
    private javax.swing.JLabel lblnombrekpi14;
    private javax.swing.JLabel lblnombrekpi6;
    private javax.swing.JLabel lblnombrekpi7;
    private javax.swing.JLabel lblnombrekpi8;
    private javax.swing.JLabel lblnombrekpi9;
    public static javax.swing.JPanel pnlarea;
    public static javax.swing.JTable tablaanalisiscompleto;
    public static javax.swing.JTextField txtmes;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombrekpi;
    public static javax.swing.JTextField txtnombresubarea;
    public static javax.swing.JTextField txtnombretrabajador;
    public static javax.swing.JTextField txtpersonadocumento;
    public static javax.swing.JTextField txtyear;
    // End of variables declaration//GEN-END:variables
}
