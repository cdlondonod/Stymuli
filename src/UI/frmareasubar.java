/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import datos.varea;
import datos.vsubarea;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import logica.farea;
import logica.fconfiguration;

import logica.fsubarea;

/**
 *
 * @author crist
 */
public class frmareasubar extends javax.swing.JInternalFrame {

    fconfiguration con = new fconfiguration();

    /**
     * Creates new form frmareasubar
     */
    public frmareasubar() {
        initComponents();
        inhabilitar_area();
        inhabilitar_sub();
        mostrar_area("");
        tablalistado_area.setShowGrid(true);
        tablalistado_sub.setShowGrid(true);

        tablalistado_area.setDefaultEditor(Object.class, null);
        tablalistado_sub.setDefaultEditor(Object.class, null);
        pnllistado_sub.setVisible(false);
        lblsuba.setVisible(false);
        pnlprincipal.layout();
        btnguardar_area.setIcon(new ImageIcon(frmareasubar.class.getResource("/img/guardar.png")));
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        
        Action buscararea = new AbstractAction()
{   
            @Override
            public void actionPerformed(ActionEvent e) {
                btnbuscar.doClick();
            }
        };
        txtbuscar_area.addActionListener(buscararea);
         Action buscarsubarea = new AbstractAction()
{   
            @Override
            public void actionPerformed(ActionEvent e) {
                btnbuscar1.doClick();
            }
        };
        txtbuscar_sub.addActionListener(buscarsubarea);

    }

    private String accion = "guardar";
    private String accionsub = "guardar";

    void ocultar_columnas_area() {
        tablalistado_area.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado_area.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado_area.getColumnModel().getColumn(0).setPreferredWidth(0);
    }

    void inhabilitar_area() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);

        pnlregistro_area.setVisible(false);
        btneliminar_area.setEnabled(false);
        btneditar.setEnabled(false);

        txtbuscar_area.setText("");
        txtbuscar_area.requestFocus();
        txtnombre_area.setText("");

    }

    void habilitar_area() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);
        pnlregistro_area.setVisible(true);
        txtnombre_area.requestFocus();

        txtbuscar_area.setText("");
        txtbuscar_area.requestFocus();
        txtnombre_area.setText("");

    }

    void habilitar_btnareapr() {
        btneliminar_area.setEnabled(true);
        btneditar.setEnabled(true);

    }

    void mostrar_area(String buscar) {
        try {
            DefaultTableModel modelo;
            farea func = new farea();
            modelo = func.mostrar(buscar);

            tablalistado_area.setModel(modelo);
            ocultar_columnas_area();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void ocultar_columnas_sub() {
        tablalistado_sub.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado_sub.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado_sub.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado_sub.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado_sub.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado_sub.getColumnModel().getColumn(1).setPreferredWidth(0);
    }

    void inhabilitar_sub() {

        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);

        pnlregistro_sub.setVisible(false);

        btneliminar_sub.setEnabled(false);
        btneditar1.setEnabled(false);

        txtbuscar_sub.setText("");
        txtnombre_sub.setText("");
    }

    void habilitar_sub() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);

        pnlregistro_sub.setVisible(true);

        txtnombre_sub.setText("");
        txtbuscar_sub.setText("");
        txtnombre_sub.requestFocus();

    }

    void habilitar_btnsubapri() {

        btneliminar_sub.setEnabled(true);
        btneditar1.setEnabled(true);

    }

    void mostrar_sub(String buscar) {
        try {
            DefaultTableModel modelo;
            fsubarea func = new fsubarea();
            modelo = func.mostrar(buscar);

            tablalistado_sub.setModel(modelo);
            ocultar_columnas_sub();

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

        pnlprincipal = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        pnlregistro_area = new javax.swing.JPanel();
        txtnombre_area = new javax.swing.JTextField();
        lblnombrearea = new javax.swing.JLabel();
        btnguardar_area = new javax.swing.JButton();
        btncancelar_area = new javax.swing.JButton();
        txtidarea = new javax.swing.JTextField();
        pnllistado_area = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado_area = new javax.swing.JTable();
        btneliminar_area = new javax.swing.JButton();
        btnnuevo_area = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        txtbuscar_area = new javax.swing.JTextField();
        btnbuscar = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        pnlregistro_sub = new javax.swing.JPanel();
        txtnombre_sub = new javax.swing.JTextField();
        lblnombrearea3 = new javax.swing.JLabel();
        btnguardar_sub = new javax.swing.JButton();
        btncancelar_sub = new javax.swing.JButton();
        txtidsubarea = new javax.swing.JTextField();
        lblsuba = new javax.swing.JLabel();
        pnllistado_sub = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablalistado_sub = new javax.swing.JTable();
        btneliminar_sub = new javax.swing.JButton();
        btnnuevo_sub = new javax.swing.JButton();
        btneditar1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        txtbuscar_sub = new javax.swing.JTextField();
        btnbuscar1 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(102, 102, 0));
        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Áreas y SubÁreas");

        pnlprincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlprincipal.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        pnlprincipal.setLayout(new java.awt.BorderLayout());

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setOpaque(false);
        jPanel3.setLayout(new java.awt.BorderLayout());

        jLabel1.setBackground(new java.awt.Color(75, 16, 160));
        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Área");
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(32, 25));
        jPanel3.add(jLabel1, java.awt.BorderLayout.PAGE_START);

        pnlregistro_area.setBackground(new java.awt.Color(255, 255, 255));
        pnlregistro_area.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        pnlregistro_area.setPreferredSize(new java.awt.Dimension(272, 108));

        txtnombre_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombre_areaActionPerformed(evt);
            }
        });

        lblnombrearea.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrearea.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrearea.setText("Nombre Área:");

        btnguardar_area.setBackground(new java.awt.Color(0, 102, 0));
        btnguardar_area.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnguardar_area.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnguardar_area.setToolTipText("Aceptar y guardar");
        btnguardar_area.setBorder(null);
        btnguardar_area.setBorderPainted(false);
        btnguardar_area.setContentAreaFilled(false);
        btnguardar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_areaActionPerformed(evt);
            }
        });

        btncancelar_area.setBackground(new java.awt.Color(0, 102, 0));
        btncancelar_area.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar_area.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelar_area.setToolTipText("Cancelar");
        btncancelar_area.setBorder(null);
        btncancelar_area.setBorderPainted(false);
        btncancelar_area.setContentAreaFilled(false);
        btncancelar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar_areaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlregistro_areaLayout = new javax.swing.GroupLayout(pnlregistro_area);
        pnlregistro_area.setLayout(pnlregistro_areaLayout);
        pnlregistro_areaLayout.setHorizontalGroup(
            pnlregistro_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlregistro_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_areaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnguardar_area, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar_area, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlregistro_areaLayout.createSequentialGroup()
                        .addComponent(lblnombrearea)
                        .addGap(6, 6, 6)
                        .addComponent(txtnombre_area)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_areaLayout.createSequentialGroup()
                .addGap(0, 149, Short.MAX_VALUE)
                .addComponent(txtidarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(91, 91, 91))
        );
        pnlregistro_areaLayout.setVerticalGroup(
            pnlregistro_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(2, 2, 2)
                .addGroup(pnlregistro_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre_area, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombrearea))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlregistro_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btncancelar_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnguardar_area, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.add(pnlregistro_area, java.awt.BorderLayout.PAGE_END);

        pnllistado_area.setBackground(new java.awt.Color(101, 54, 193));
        pnllistado_area.setPreferredSize(new java.awt.Dimension(276, 396));

        tablalistado_area.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablalistado_area.setForeground(new java.awt.Color(75, 16, 160));
        tablalistado_area.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado_area.setGridColor(new java.awt.Color(75, 16, 160));
        tablalistado_area.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                tablalistado_areaFocusGained(evt);
            }
        });
        tablalistado_area.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistado_areaMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistado_areaMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado_area);

        btneliminar_area.setBackground(new java.awt.Color(153, 51, 0));
        btneliminar_area.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneliminar_area.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btneliminar_area.setToolTipText("Eliminar seleccionado");
        btneliminar_area.setBorder(null);
        btneliminar_area.setBorderPainted(false);
        btneliminar_area.setContentAreaFilled(false);
        btneliminar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_areaActionPerformed(evt);
            }
        });

        btnnuevo_area.setBackground(new java.awt.Color(0, 102, 0));
        btnnuevo_area.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnnuevo_area.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo_area.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnuevo_area.setToolTipText("Crear nuevo");
        btnnuevo_area.setBorder(null);
        btnnuevo_area.setBorderPainted(false);
        btnnuevo_area.setContentAreaFilled(false);
        btnnuevo_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo_areaActionPerformed(evt);
            }
        });

        btneditar.setBackground(new java.awt.Color(0, 51, 0));
        btneditar.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneditar.setForeground(new java.awt.Color(255, 255, 255));
        btneditar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btneditar.setToolTipText("Editar seleccionado");
        btneditar.setBorder(null);
        btneditar.setBorderPainted(false);
        btneditar.setContentAreaFilled(false);
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        jPanel1.setOpaque(false);
        jPanel1.setLayout(new javax.swing.BoxLayout(jPanel1, javax.swing.BoxLayout.LINE_AXIS));

        txtbuscar_area.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_areaActionPerformed(evt);
            }
        });
        txtbuscar_area.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscar_areaKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar_areaKeyReleased(evt);
            }
        });
        jPanel1.add(txtbuscar_area);

        btnbuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnbuscar.setBorder(null);
        btnbuscar.setBorderPainted(false);
        btnbuscar.setContentAreaFilled(false);
        btnbuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscarActionPerformed(evt);
            }
        });
        jPanel1.add(btnbuscar);

        javax.swing.GroupLayout pnllistado_areaLayout = new javax.swing.GroupLayout(pnllistado_area);
        pnllistado_area.setLayout(pnllistado_areaLayout);
        pnllistado_areaLayout.setHorizontalGroup(
            pnllistado_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistado_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnllistado_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnllistado_areaLayout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 129, Short.MAX_VALUE))
                    .addGroup(pnllistado_areaLayout.createSequentialGroup()
                        .addGroup(pnllistado_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnllistado_areaLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnnuevo_area, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar_area))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        pnllistado_areaLayout.setVerticalGroup(
            pnllistado_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnllistado_areaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 304, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnllistado_areaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar_area, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneditar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo_area, javax.swing.GroupLayout.Alignment.TRAILING))
                .addContainerGap())
        );

        jPanel3.add(pnllistado_area, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel3);

        jPanel4.setOpaque(false);
        jPanel4.setLayout(new java.awt.BorderLayout());

        pnlregistro_sub.setBackground(new java.awt.Color(255, 255, 255));
        pnlregistro_sub.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        pnlregistro_sub.setPreferredSize(new java.awt.Dimension(272, 108));

        txtnombre_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombre_subActionPerformed(evt);
            }
        });
        txtnombre_sub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtnombre_subKeyTyped(evt);
            }
        });

        lblnombrearea3.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        lblnombrearea3.setForeground(new java.awt.Color(75, 16, 160));
        lblnombrearea3.setText("Nombre SubÁrea:");

        btnguardar_sub.setBackground(new java.awt.Color(0, 102, 0));
        btnguardar_sub.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnguardar_sub.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnguardar_sub.setToolTipText("Aceptar y guardar");
        btnguardar_sub.setBorder(null);
        btnguardar_sub.setBorderPainted(false);
        btnguardar_sub.setContentAreaFilled(false);
        btnguardar_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_subActionPerformed(evt);
            }
        });

        btncancelar_sub.setBackground(new java.awt.Color(0, 102, 0));
        btncancelar_sub.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar_sub.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelar_sub.setToolTipText("Cancelar");
        btncancelar_sub.setBorder(null);
        btncancelar_sub.setBorderPainted(false);
        btncancelar_sub.setContentAreaFilled(false);
        btncancelar_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar_subActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlregistro_subLayout = new javax.swing.GroupLayout(pnlregistro_sub);
        pnlregistro_sub.setLayout(pnlregistro_subLayout);
        pnlregistro_subLayout.setHorizontalGroup(
            pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_subLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_subLayout.createSequentialGroup()
                        .addComponent(lblnombrearea3)
                        .addGap(6, 6, 6)
                        .addComponent(txtnombre_sub)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_subLayout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addGroup(pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_subLayout.createSequentialGroup()
                                .addComponent(btnguardar_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btncancelar_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_subLayout.createSequentialGroup()
                                .addComponent(txtidsubarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(95, 95, 95))))))
        );
        pnlregistro_subLayout.setVerticalGroup(
            pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_subLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtidsubarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtnombre_sub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblnombrearea3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlregistro_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btncancelar_sub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnguardar_sub, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.add(pnlregistro_sub, java.awt.BorderLayout.PAGE_END);

        lblsuba.setBackground(new java.awt.Color(75, 16, 160));
        lblsuba.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblsuba.setForeground(new java.awt.Color(255, 255, 255));
        lblsuba.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblsuba.setText("SubÁrea");
        lblsuba.setOpaque(true);
        lblsuba.setPreferredSize(new java.awt.Dimension(59, 25));
        jPanel4.add(lblsuba, java.awt.BorderLayout.PAGE_START);

        pnllistado_sub.setBackground(new java.awt.Color(101, 54, 193));
        pnllistado_sub.setPreferredSize(new java.awt.Dimension(276, 396));

        tablalistado_sub.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tablalistado_sub.setForeground(new java.awt.Color(75, 16, 160));
        tablalistado_sub.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado_sub.setGridColor(new java.awt.Color(75, 16, 160));
        tablalistado_sub.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistado_subMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistado_subMousePressed(evt);
            }
        });
        jScrollPane2.setViewportView(tablalistado_sub);

        btneliminar_sub.setBackground(new java.awt.Color(153, 51, 0));
        btneliminar_sub.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneliminar_sub.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btneliminar_sub.setToolTipText("Eliminar seleccionado");
        btneliminar_sub.setBorder(null);
        btneliminar_sub.setBorderPainted(false);
        btneliminar_sub.setContentAreaFilled(false);
        btneliminar_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_subActionPerformed(evt);
            }
        });

        btnnuevo_sub.setBackground(new java.awt.Color(0, 102, 0));
        btnnuevo_sub.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnnuevo_sub.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo_sub.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnuevo_sub.setToolTipText("Crear nuevo");
        btnnuevo_sub.setBorder(null);
        btnnuevo_sub.setBorderPainted(false);
        btnnuevo_sub.setContentAreaFilled(false);
        btnnuevo_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo_subActionPerformed(evt);
            }
        });

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

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        txtbuscar_sub.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_subActionPerformed(evt);
            }
        });
        txtbuscar_sub.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscar_subKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar_subKeyReleased(evt);
            }
        });
        jPanel2.add(txtbuscar_sub);

        btnbuscar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N
        btnbuscar1.setBorder(null);
        btnbuscar1.setBorderPainted(false);
        btnbuscar1.setContentAreaFilled(false);
        btnbuscar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar1ActionPerformed(evt);
            }
        });
        jPanel2.add(btnbuscar1);

        javax.swing.GroupLayout pnllistado_subLayout = new javax.swing.GroupLayout(pnllistado_sub);
        pnllistado_sub.setLayout(pnllistado_subLayout);
        pnllistado_subLayout.setHorizontalGroup(
            pnllistado_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistado_subLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnllistado_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnllistado_subLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 127, Short.MAX_VALUE))
                    .addGroup(pnllistado_subLayout.createSequentialGroup()
                        .addGroup(pnllistado_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(pnllistado_subLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnnuevo_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneditar1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btneliminar_sub, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        pnllistado_subLayout.setVerticalGroup(
            pnllistado_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnllistado_subLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 305, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnllistado_subLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar_sub, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneditar1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo_sub, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(22, 22, 22))
        );

        jPanel4.add(pnllistado_sub, java.awt.BorderLayout.CENTER);

        jPanel5.add(jPanel4);

        pnlprincipal.add(jPanel5, java.awt.BorderLayout.CENTER);

        jLabel4.setBackground(new java.awt.Color(75, 16, 160));
        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Creación de Áreas y SubÁreas");
        jLabel4.setOpaque(true);
        jLabel4.setPreferredSize(new java.awt.Dimension(32, 20));
        pnlprincipal.add(jLabel4, java.awt.BorderLayout.PAGE_START);

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/isotipo-1-fondo-transparente91x77.png"))); // NOI18N
        jLabel5.setText("  ");
        jLabel5.setPreferredSize(new java.awt.Dimension(91, 85));
        pnlprincipal.add(jLabel5, java.awt.BorderLayout.PAGE_END);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlprincipal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 635, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tablalistado_areaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_areaMouseClicked
        // TODO add your handling code here:

    }//GEN-LAST:event_tablalistado_areaMouseClicked

    private void tablalistado_areaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_areaMousePressed

        con.loadingscreen();
        SwingWorker swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                int fila = tablalistado_area.getSelectedRow();
                txtidarea.setText(tablalistado_area.getValueAt(fila, 0).toString());
                habilitar_btnareapr();
                pnllistado_sub.setVisible(true);
                lblsuba.setVisible(true);
                mostrar_sub("");
                con.hideloading();
                return null;
            }
        };
        swingWorker.execute();
    }//GEN-LAST:event_tablalistado_areaMousePressed

    private void txtbuscar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_areaActionPerformed
        txtbuscar_area.transferFocus();        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_areaActionPerformed

    private void txtbuscar_areaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_areaKeyPressed

        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_areaKeyPressed

    private void btneliminar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_areaActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado_area.getSelectedRow();
        txtidarea.setText(tablalistado_area.getValueAt(fila, 0).toString());
        if (!txtidarea.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el Área, recuerde que si tiene trabajadores asignados al Área no podra borrarla", "Confirmar", 2);

            if (confirmacion == 0) {
                varea dts = new varea();
                farea func = new farea();

                dts.setIdarea(Integer.parseInt(txtidarea.getText()));
                func.eliminar(dts);
                mostrar_area("");
                mostrar_sub("");
                inhabilitar_area();
                inhabilitar_sub();

            }

        }
    }//GEN-LAST:event_btneliminar_areaActionPerformed

    private void btnnuevo_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo_areaActionPerformed

        habilitar_area();
        pnlregistro_area.setVisible(true);
        btnguardar_area.setIcon(new ImageIcon(frmareasubar.class.getResource("/img/guardar.png")));
        accion = "guardar";
        txtnombre_area.requestFocus();
    }//GEN-LAST:event_btnnuevo_areaActionPerformed

    private void tablalistado_subMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_subMouseClicked

        // TODO add your handling code here:        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado_subMouseClicked

    private void tablalistado_subMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_subMousePressed
        habilitar_btnsubapri();


    }//GEN-LAST:event_tablalistado_subMousePressed

    private void txtbuscar_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_subActionPerformed

    private void txtbuscar_subKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_subKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_subKeyPressed

    private void btneliminar_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_subActionPerformed
        int fila = tablalistado_sub.getSelectedRow();
        txtidsubarea.setText(tablalistado_sub.getValueAt(fila, 0).toString());

        if (!txtidsubarea.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el subÁrea, recuerde que si tiene trabajadores asignados al subÁrea no podra borrarla.", "Confirmar", 2);

            if (confirmacion == 0) {
                vsubarea dts = new vsubarea();
                fsubarea func = new fsubarea();

                dts.setIdsubarea(Integer.parseInt(txtidsubarea.getText()));
                func.eliminar(dts);
                mostrar_sub("");
                inhabilitar_area();
                inhabilitar_sub();

            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminar_subActionPerformed

    private void btnnuevo_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo_subActionPerformed
        habilitar_sub();

        txtnombre_sub.requestFocus();
        txtnombre_sub.setText("");

        btnguardar_sub.setIcon(new ImageIcon(frmareasubar.class.getResource("/img/guardar.png")));
        accionsub = "guardar";        // TODO add your handling code here:
    }//GEN-LAST:event_btnnuevo_subActionPerformed

    private void txtnombre_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombre_areaActionPerformed
        // TODO add your handling code here:
        txtnombre_area.transferFocus();
    }//GEN-LAST:event_txtnombre_areaActionPerformed

    private void btnguardar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_areaActionPerformed
        // TODO add your handling code here:
        if (txtnombre_area.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del Área");
            txtnombre_area.requestFocus();
            return;

        }
        varea dts = new varea();
        farea func = new farea();

        dts.setNombre(txtnombre_area.getText());

        if (accion.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Área fue registrada satisfactoriamente");
                mostrar_area("");
                inhabilitar_area();

                int lastRow = tablalistado_area.convertRowIndexToView(tablalistado_area.getRowCount() - 1);
                tablalistado_area.setRowSelectionInterval(lastRow, lastRow);
                pnllistado_sub.setVisible(true);
                lblsuba.setVisible(true);
                pnlregistro_sub.setVisible(true);
                txtnombre_sub.setText(txtnombre_area.getText());
                txtnombre_sub.requestFocus();
                txtidarea.setText(tablalistado_area.getValueAt(tablalistado_area.getRowCount() - 1, 0).toString());

                JOptionPane.showMessageDialog(rootPane, "Ahora registre una SubÁrea");
                mostrar_sub("");
            }

        } else if (accion.equals("editar")) {
            dts.setIdarea(Integer.parseInt(txtidarea.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Área fue editada satisfactoriamente");
                mostrar_area("");
                inhabilitar_area();
                inhabilitar_sub();
            }

        }

        pnlregistro_area.setVisible(false);
    }//GEN-LAST:event_btnguardar_areaActionPerformed

    private void btncancelar_areaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_areaActionPerformed
        // TODO add your handling code here:

        inhabilitar_area();
        inhabilitar_sub();
    }//GEN-LAST:event_btncancelar_areaActionPerformed

    private void txtnombre_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombre_subActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre_subActionPerformed

    private void btnguardar_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_subActionPerformed
        if (txtnombre_sub.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el nombre del subÁrea");
            txtnombre_area.requestFocus();
            return;
        }

        vsubarea dts = new vsubarea();
        fsubarea func = new fsubarea();

        dts.setNombre(txtnombre_sub.getText());
        dts.setIdarea(Integer.parseInt(txtidarea.getText()));

        if (accionsub.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El subÁrea fue registrada satisfactoriamente");
                mostrar_sub("");
                inhabilitar_sub();
                inhabilitar_area();

            }

        } else if (accionsub.equals("editar")) {
            dts.setIdsubarea(Integer.parseInt(txtidsubarea.getText()));

            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El subÁrea fue editada satisfactoriamente");
                mostrar_sub("");
                inhabilitar_sub();
                inhabilitar_area();
            }

        }

        // TODO add your handling code here:
    }//GEN-LAST:event_btnguardar_subActionPerformed

    private void btncancelar_subActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_subActionPerformed
        inhabilitar_sub();
        inhabilitar_area();// TODO add your handling code here:
    }//GEN-LAST:event_btncancelar_subActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        btnguardar_area.setIcon(new ImageIcon(frmareasubar.class.getResource("/img/editar.png")));
        habilitar_area();
        btneliminar_area.setEnabled(true);
        accion = "editar";

        int fila = tablalistado_area.getSelectedRow();
        txtidarea.setText(tablalistado_area.getValueAt(fila, 0).toString());
        txtnombre_area.setText(tablalistado_area.getValueAt(fila, 1).toString());

        txtnombre_area.requestFocus();// TODO add your handling code here:
    }//GEN-LAST:event_btneditarActionPerformed

    private void btneditar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditar1ActionPerformed

        btnguardar_sub.setIcon(new ImageIcon(frmareasubar.class.getResource("/img/editar.png")));
        habilitar_sub();

        accionsub = "editar";

        int fila = tablalistado_sub.getSelectedRow();
        txtidsubarea.setText(tablalistado_sub.getValueAt(fila, 0).toString());

        txtnombre_sub.setText(tablalistado_sub.getValueAt(fila, 2).toString());

        txtnombre_sub.requestFocus();
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditar1ActionPerformed

    private void tablalistado_areaFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tablalistado_areaFocusGained

        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado_areaFocusGained

    private void txtbuscar_areaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_areaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_areaKeyReleased

    private void txtbuscar_subKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_subKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_subKeyReleased

    private void txtnombre_subKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtnombre_subKeyTyped
        char keychar = evt.getKeyChar();
        if (keychar == '_') {
            evt.setKeyChar('-');
        }        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombre_subKeyTyped

    private void btnbuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscarActionPerformed
        con.loadingscreen();
        SwingWorker swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                mostrar_area(txtbuscar_area.getText());
                con.hideloading();
                return null;
            }
        };
        swingWorker.execute();
    }//GEN-LAST:event_btnbuscarActionPerformed

    private void btnbuscar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar1ActionPerformed

        con.loadingscreen();
        SwingWorker swingWorker = new SwingWorker<Void, Void>() {
            @Override
            protected Void doInBackground() throws Exception {
                mostrar_sub(txtbuscar_sub.getText());
                con.hideloading();
                return null;
            }
        };
        swingWorker.execute();
    }//GEN-LAST:event_btnbuscar1ActionPerformed

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
            java.util.logging.Logger.getLogger(frmareasubar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmareasubar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmareasubar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmareasubar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmareasubar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnbuscar;
    private javax.swing.JButton btnbuscar1;
    private javax.swing.JButton btncancelar_area;
    private javax.swing.JButton btncancelar_sub;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btneditar1;
    private javax.swing.JButton btneliminar_area;
    private javax.swing.JButton btneliminar_sub;
    private javax.swing.JButton btnguardar_area;
    private javax.swing.JButton btnguardar_sub;
    private javax.swing.JButton btnnuevo_area;
    private javax.swing.JButton btnnuevo_sub;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblnombrearea;
    private javax.swing.JLabel lblnombrearea3;
    private javax.swing.JLabel lblsuba;
    private javax.swing.JPanel pnllistado_area;
    private javax.swing.JPanel pnllistado_sub;
    private javax.swing.JPanel pnlprincipal;
    private javax.swing.JPanel pnlregistro_area;
    private javax.swing.JPanel pnlregistro_sub;
    private javax.swing.JTable tablalistado_area;
    private javax.swing.JTable tablalistado_sub;
    private javax.swing.JTextField txtbuscar_area;
    private javax.swing.JTextField txtbuscar_sub;
    public static javax.swing.JTextField txtidarea;
    private javax.swing.JTextField txtidsubarea;
    private javax.swing.JTextField txtnombre_area;
    private javax.swing.JTextField txtnombre_sub;
    // End of variables declaration//GEN-END:variables
}
