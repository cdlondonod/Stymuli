/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import static UI.frmareasubar.txtidarea;
import datos.vmodelo;
import datos.vobjetivos;
import java.util.stream.Collector;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.conexion;

import logica.fmodelo;
import logica.fobjetivos;
import logica.fsubarea;

/**
 *
 * @author crist
 */
public class frmmodelo extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmmodelo
     */
    public frmmodelo() {

        initComponents();
        inhabilitar_s();
        inhabilitar_o();
        mostrar_stymuli("");
        pnllistado_Obj.setVisible(false);
        lblobjetivos.setVisible(false);
        conexion.frmabierto = 3;

        tablalistado_Obj.setDefaultEditor(Object.class, null);
        tablalistado_stymuli.setDefaultEditor(Object.class, null);
        ((javax.swing.plaf.basic.BasicInternalFrameUI) this.getUI()).setNorthPane(null);
        this.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
        tablalistado_Obj.setShowGrid(true);
        tablalistado_stymuli.setShowGrid(true);
    }

    private String accion_stymuli = "guardar";
    private String accion_Obj = "guardar";

    void inhabilitar_s() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);
        txtidmodelo.setVisible(false);
        txtidkpi.setVisible(false);
        txtidobjetivos.setVisible(false);
        
        
        pnlregistro_stymuli.setVisible(false);
        btneliminar_stymuli.setEnabled(false);
        btneditarsty.setEnabled(false);
        
        txtnombrearea.setEnabled(false);
        txtnombresubarea.setEnabled(false);
        txtnombrekpiestim.setEnabled(false);
        
        txtbuscar_stymuli.setText("");
        txtbuscar_stymuli.requestFocus();
        txtstymuli.setText("");
        txtdescripcion.setText("");
        txtnombrearea.setText("");
        txtnombresubarea.setText("");
        txtnombrekpi_Obj.setText("");
        txtnombrekpiestim.setText("");

    }

    void habilitar_s() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);
        txtidmodelo.setVisible(false);
        txtidkpi.setVisible(false);
        txtidobjetivos.setVisible(false);

        pnlregistro_stymuli.setVisible(true);
        txtstymuli.requestFocus();

        txtbuscar_stymuli.setText("");
        txtstymuli.requestFocus();
        txtstymuli.setText("");
        txtdescripcion.setText("");
          txtnombrearea.setText("");
        txtnombresubarea.setText("");
        
        txtnombrekpiestim.setText("");

    }

    void habilitar_btnspr() {
        btneliminar_stymuli.setEnabled(true);
        btneditarsty.setEnabled(true);

    }

    void inhabilitar_o() {

        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);
        txtidmodelo.setVisible(false);
        txtidkpi.setVisible(false);
        txtidobjetivos.setVisible(false);
        txtnombrekpi_Obj.setEnabled(false);

        pnlregistro_Obj.setVisible(false);

        btneliminar_Obj.setEnabled(false);
        btneditarobj.setEnabled(false);

        txtbuscar_Obj.setText("");
        txtvalor_Obj.setText("");
        txtvalor_pon_Obj.setText("");
    }

    void habilitar_o() {
        txtidarea.setVisible(false);
        txtidsubarea.setVisible(false);
        txtidmodelo.setVisible(false);
        txtidkpi.setVisible(false);
        txtidobjetivos.setVisible(false);

        pnlregistro_Obj.setVisible(true);

        txtbuscar_Obj.setText("");
        txtvalor_Obj.setText("");
        txtvalor_pon_Obj.setText("");
        txtvalor_Obj.requestFocus();
txtnombrekpi_Obj.setText("");
    }

    void habilitar_btnopri() {

        btneliminar_Obj.setEnabled(true);
        btneditarobj.setEnabled(true);

    }

    void ocultar_columnas_stymuli() {
        tablalistado_stymuli.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado_stymuli.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado_stymuli.getColumnModel().getColumn(3).setMaxWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(3).setMinWidth(0);
        tablalistado_stymuli.getColumnModel().getColumn(3).setPreferredWidth(0);
    }

    void checkinput() {

        String str = txtstymuli.getText();
        str = str.replaceAll("[^0-9.-]", "");
        txtstymuli.setText(str);

        String str1 = txtvalor_Obj.getText();
        str1 = str1.replaceAll("[^0-9.-]", "");
        txtvalor_Obj.setText(str1);

        String str2 = txtvalor_pon_Obj.getText();
        str2 = str2.replaceAll("[^0-9.-]", "");
        txtvalor_pon_Obj.setText(str2);

    }

    void mostrar_stymuli(String buscar) {
        try {
            DefaultTableModel modelo;
            fmodelo func = new fmodelo();
            modelo = func.mostrar(buscar);

            tablalistado_stymuli.setModel(modelo);
            ocultar_columnas_stymuli();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(rootPane, e);
        }

    }

    void ocultar_columnas_Obj() {
        tablalistado_Obj.getColumnModel().getColumn(0).setMaxWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(0).setMinWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(0).setPreferredWidth(0);

        tablalistado_Obj.getColumnModel().getColumn(1).setMaxWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(1).setMinWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(1).setPreferredWidth(0);

        tablalistado_Obj.getColumnModel().getColumn(2).setMaxWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(2).setMinWidth(0);
        tablalistado_Obj.getColumnModel().getColumn(2).setPreferredWidth(0);
    }

    void mostrar_Obj(String buscar) {
        try {
            DefaultTableModel modelo;
            fobjetivos func = new fobjetivos();
            modelo = func.mostrar(buscar);

            tablalistado_Obj.setModel(modelo);
            ocultar_columnas_Obj();

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
        jPanel5 = new javax.swing.JPanel();
        pnllistado_stymuli = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablalistado_stymuli = new javax.swing.JTable();
        txtbuscar_stymuli = new javax.swing.JTextField();
        btneliminar_stymuli = new javax.swing.JButton();
        lblbuscstym = new javax.swing.JLabel();
        btnnuevo_stymuli = new javax.swing.JButton();
        txtidmodelo = new javax.swing.JTextField();
        txtidsubarea = new javax.swing.JTextField();
        txtidarea = new javax.swing.JTextField();
        btneditarsty = new javax.swing.JButton();
        pnllistado_Obj = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tablalistado_Obj = new javax.swing.JTable();
        txtbuscar_Obj = new javax.swing.JTextField();
        btneliminar_Obj = new javax.swing.JButton();
        lblbuscarobj = new javax.swing.JLabel();
        btnnuevo_Obj = new javax.swing.JButton();
        txtidkpi = new javax.swing.JTextField();
        txtidobjetivos = new javax.swing.JTextField();
        btneditarobj = new javax.swing.JButton();
        pnlregistro_Obj = new javax.swing.JPanel();
        btncancelar_Obj = new javax.swing.JButton();
        txtvalor_pon_Obj = new javax.swing.JTextField();
        cbocomparacion_Obj = new javax.swing.JComboBox<>();
        txtvalor_Obj = new javax.swing.JTextField();
        lblvaponderado = new javax.swing.JLabel();
        lblnombrekpi16 = new javax.swing.JLabel();
        lblnombrekpi17 = new javax.swing.JLabel();
        btnguardar_Obj = new javax.swing.JButton();
        cbotipo_Obj = new javax.swing.JComboBox<>();
        lblpondperc = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        lblnombrekpi9 = new javax.swing.JLabel();
        txtnombrekpi_Obj = new javax.swing.JTextField();
        btnbusca_kpi_Obj = new javax.swing.JButton();
        pnlregistro_stymuli = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtdescripcion = new javax.swing.JTextArea();
        btncancelar_stymuli = new javax.swing.JButton();
        btnguardar_stymuli = new javax.swing.JButton();
        lblnombrekpi7 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        lblnombrekpi13 = new javax.swing.JLabel();
        txtnombresubarea = new javax.swing.JTextField();
        btnbuscar_subarea_stym = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        lblnombrearea = new javax.swing.JLabel();
        txtnombrearea = new javax.swing.JTextField();
        btnbusca_area_stym = new javax.swing.JButton();
        pnlkpiestimulo = new javax.swing.JPanel();
        lblnombrekpi12 = new javax.swing.JLabel();
        txtnombrekpiestim = new javax.swing.JTextField();
        btnbusca_kpi_estim = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        lblnombrekpi11 = new javax.swing.JLabel();
        cbotipo_stymuli = new javax.swing.JComboBox<>();
        jPanel7 = new javax.swing.JPanel();
        lblnombrekpi10 = new javax.swing.JLabel();
        txtstymuli = new javax.swing.JTextField();
        lblstymuli = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        lblobjetivos = new javax.swing.JLabel();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setIconifiable(true);
        setTitle("Modelos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(53, 29, 113));

        pnllistado_stymuli.setBackground(new java.awt.Color(102, 50, 159));

        tablalistado_stymuli.setFont(new java.awt.Font("Arial Narrow", 0, 11)); // NOI18N
        tablalistado_stymuli.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado_stymuli.setGridColor(new java.awt.Color(102, 50, 159));
        tablalistado_stymuli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistado_stymuliMouseClicked(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistado_stymuliMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tablalistado_stymuli);

        txtbuscar_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_stymuliActionPerformed(evt);
            }
        });
        txtbuscar_stymuli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscar_stymuliKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar_stymuliKeyReleased(evt);
            }
        });

        btneliminar_stymuli.setBackground(new java.awt.Color(153, 51, 0));
        btneliminar_stymuli.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneliminar_stymuli.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar_stymuli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btneliminar_stymuli.setToolTipText("Eliminar seleccionado");
        btneliminar_stymuli.setBorder(null);
        btneliminar_stymuli.setBorderPainted(false);
        btneliminar_stymuli.setContentAreaFilled(false);
        btneliminar_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_stymuliActionPerformed(evt);
            }
        });

        lblbuscstym.setBackground(new java.awt.Color(255, 255, 255));
        lblbuscstym.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N

        btnnuevo_stymuli.setBackground(new java.awt.Color(0, 51, 0));
        btnnuevo_stymuli.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnnuevo_stymuli.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo_stymuli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnuevo_stymuli.setToolTipText("Crear nuevo");
        btnnuevo_stymuli.setBorder(null);
        btnnuevo_stymuli.setBorderPainted(false);
        btnnuevo_stymuli.setContentAreaFilled(false);
        btnnuevo_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo_stymuliActionPerformed(evt);
            }
        });

        txtidmodelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtidmodeloActionPerformed(evt);
            }
        });

        btneditarsty.setBackground(new java.awt.Color(0, 51, 0));
        btneditarsty.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneditarsty.setForeground(new java.awt.Color(255, 255, 255));
        btneditarsty.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btneditarsty.setToolTipText("Editar seleccionado");
        btneditarsty.setBorder(null);
        btneditarsty.setBorderPainted(false);
        btneditarsty.setContentAreaFilled(false);
        btneditarsty.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarstyActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnllistado_stymuliLayout = new javax.swing.GroupLayout(pnllistado_stymuli);
        pnllistado_stymuli.setLayout(pnllistado_stymuliLayout);
        pnllistado_stymuliLayout.setHorizontalGroup(
            pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(pnllistado_stymuliLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnnuevo_stymuli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditarsty)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar_stymuli, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(pnllistado_stymuliLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscar_stymuli, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblbuscstym)
                .addGap(105, 105, 105)
                .addComponent(txtidarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtidsubarea, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnllistado_stymuliLayout.setVerticalGroup(
            pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnllistado_stymuliLayout.createSequentialGroup()
                .addGroup(pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(lblbuscstym)
                        .addGroup(pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtidarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidmodelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtidsubarea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnllistado_stymuliLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(txtbuscar_stymuli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnllistado_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar_stymuli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo_stymuli, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneditarsty, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11))
        );

        pnllistado_Obj.setBackground(new java.awt.Color(102, 50, 159));
        pnllistado_Obj.setPreferredSize(new java.awt.Dimension(505, 400));

        tablalistado_Obj.setFont(new java.awt.Font("Arial Narrow", 0, 11)); // NOI18N
        tablalistado_Obj.setModel(new javax.swing.table.DefaultTableModel(
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
        tablalistado_Obj.setGridColor(new java.awt.Color(102, 50, 159));
        tablalistado_Obj.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablalistado_ObjMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tablalistado_ObjMouseEntered(evt);
            }
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tablalistado_ObjMousePressed(evt);
            }
        });
        jScrollPane4.setViewportView(tablalistado_Obj);

        txtbuscar_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtbuscar_ObjActionPerformed(evt);
            }
        });
        txtbuscar_Obj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtbuscar_ObjKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtbuscar_ObjKeyReleased(evt);
            }
        });

        btneliminar_Obj.setBackground(new java.awt.Color(153, 51, 0));
        btneliminar_Obj.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneliminar_Obj.setForeground(new java.awt.Color(255, 255, 255));
        btneliminar_Obj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/trash.png"))); // NOI18N
        btneliminar_Obj.setToolTipText("Eliminar seleccionado");
        btneliminar_Obj.setBorder(null);
        btneliminar_Obj.setBorderPainted(false);
        btneliminar_Obj.setContentAreaFilled(false);
        btneliminar_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneliminar_ObjActionPerformed(evt);
            }
        });

        lblbuscarobj.setBackground(new java.awt.Color(255, 255, 255));
        lblbuscarobj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscar.png"))); // NOI18N

        btnnuevo_Obj.setBackground(new java.awt.Color(0, 51, 0));
        btnnuevo_Obj.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnnuevo_Obj.setForeground(new java.awt.Color(255, 255, 255));
        btnnuevo_Obj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/nuevo.png"))); // NOI18N
        btnnuevo_Obj.setToolTipText("Crear nuevo");
        btnnuevo_Obj.setBorder(null);
        btnnuevo_Obj.setBorderPainted(false);
        btnnuevo_Obj.setContentAreaFilled(false);
        btnnuevo_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnnuevo_ObjActionPerformed(evt);
            }
        });

        btneditarobj.setBackground(new java.awt.Color(0, 51, 0));
        btneditarobj.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btneditarobj.setForeground(new java.awt.Color(255, 255, 255));
        btneditarobj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/editar.png"))); // NOI18N
        btneditarobj.setToolTipText("Editar seleccionado");
        btneditarobj.setBorder(null);
        btneditarobj.setBorderPainted(false);
        btneditarobj.setContentAreaFilled(false);
        btneditarobj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarobjActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnllistado_ObjLayout = new javax.swing.GroupLayout(pnllistado_Obj);
        pnllistado_Obj.setLayout(pnllistado_ObjLayout);
        pnllistado_ObjLayout.setHorizontalGroup(
            pnllistado_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnllistado_ObjLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtbuscar_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblbuscarobj)
                .addGap(95, 95, 95)
                .addComponent(txtidobjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(54, 54, 54)
                .addComponent(txtidkpi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnllistado_ObjLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(btnnuevo_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneditarobj)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btneliminar_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jScrollPane4)
        );
        pnllistado_ObjLayout.setVerticalGroup(
            pnllistado_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnllistado_ObjLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnllistado_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblbuscarobj)
                    .addComponent(txtbuscar_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnllistado_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtidobjetivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtidkpi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnllistado_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btneliminar_Obj, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnnuevo_Obj, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btneditarobj, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(11, 11, 11))
        );

        pnlregistro_Obj.setBackground(new java.awt.Color(153, 103, 198));

        btncancelar_Obj.setBackground(new java.awt.Color(0, 51, 0));
        btncancelar_Obj.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar_Obj.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_Obj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelar_Obj.setToolTipText("Cancelar");
        btncancelar_Obj.setBorder(null);
        btncancelar_Obj.setBorderPainted(false);
        btncancelar_Obj.setContentAreaFilled(false);
        btncancelar_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar_ObjActionPerformed(evt);
            }
        });

        txtvalor_pon_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor_pon_ObjActionPerformed(evt);
            }
        });
        txtvalor_pon_Obj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalor_pon_ObjKeyTyped(evt);
            }
        });

        cbocomparacion_Obj.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        cbocomparacion_Obj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mayor/Igual", "Menor/Igual", "Igual" }));

        txtvalor_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtvalor_ObjActionPerformed(evt);
            }
        });
        txtvalor_Obj.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtvalor_ObjKeyTyped(evt);
            }
        });

        lblvaponderado.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblvaponderado.setForeground(new java.awt.Color(255, 255, 255));
        lblvaponderado.setText("Valor Ponderado:");

        lblnombrekpi16.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi16.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi16.setText("Tipo de Objetivo: ");

        lblnombrekpi17.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi17.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi17.setText(":Valor Objetivo");

        btnguardar_Obj.setBackground(new java.awt.Color(0, 51, 0));
        btnguardar_Obj.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnguardar_Obj.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar_Obj.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnguardar_Obj.setToolTipText("Aceptar y guardar");
        btnguardar_Obj.setBorder(null);
        btnguardar_Obj.setBorderPainted(false);
        btnguardar_Obj.setContentAreaFilled(false);
        btnguardar_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_ObjActionPerformed(evt);
            }
        });

        cbotipo_Obj.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ponderado", "Habilitador" }));
        cbotipo_Obj.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipo_ObjItemStateChanged(evt);
            }
        });

        lblpondperc.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblpondperc.setForeground(new java.awt.Color(255, 255, 255));
        lblpondperc.setText("%");

        jPanel2.setBackground(new java.awt.Color(153, 103, 198));
        jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi9.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi9.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi9.setText("KPI :");
        lblnombrekpi9.setPreferredSize(new java.awt.Dimension(50, 14));
        jPanel2.add(lblnombrekpi9);

        txtnombrekpi_Obj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombrekpi_ObjActionPerformed(evt);
            }
        });
        jPanel2.add(txtnombrekpi_Obj);

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
        jPanel2.add(btnbusca_kpi_Obj);

        javax.swing.GroupLayout pnlregistro_ObjLayout = new javax.swing.GroupLayout(pnlregistro_Obj);
        pnlregistro_Obj.setLayout(pnlregistro_ObjLayout);
        pnlregistro_ObjLayout.setHorizontalGroup(
            pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                        .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblnombrekpi16)
                            .addComponent(lblvaponderado))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cbotipo_Obj, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtvalor_pon_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblpondperc))
                    .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(cbocomparacion_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtvalor_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnguardar_Obj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btncancelar_Obj))
                    .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblnombrekpi17)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlregistro_ObjLayout.setVerticalGroup(
            pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_ObjLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtvalor_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblnombrekpi17)
                        .addComponent(cbocomparacion_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblnombrekpi16)
                    .addComponent(cbotipo_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(btncancelar_Obj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnguardar_Obj, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnlregistro_ObjLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lblvaponderado)
                        .addComponent(txtvalor_pon_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblpondperc)))
                .addGap(8, 8, 8))
        );

        pnlregistro_stymuli.setBackground(new java.awt.Color(153, 103, 198));

        jScrollPane3.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane3.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        txtdescripcion.setColumns(20);
        txtdescripcion.setRows(5);
        jScrollPane3.setViewportView(txtdescripcion);

        btncancelar_stymuli.setBackground(new java.awt.Color(0, 51, 0));
        btncancelar_stymuli.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btncancelar_stymuli.setForeground(new java.awt.Color(255, 255, 255));
        btncancelar_stymuli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cancelar.png"))); // NOI18N
        btncancelar_stymuli.setToolTipText("Cancelar");
        btncancelar_stymuli.setBorder(null);
        btncancelar_stymuli.setBorderPainted(false);
        btncancelar_stymuli.setContentAreaFilled(false);
        btncancelar_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelar_stymuliActionPerformed(evt);
            }
        });

        btnguardar_stymuli.setBackground(new java.awt.Color(0, 51, 0));
        btnguardar_stymuli.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        btnguardar_stymuli.setForeground(new java.awt.Color(255, 255, 255));
        btnguardar_stymuli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/guardar.png"))); // NOI18N
        btnguardar_stymuli.setToolTipText("Aceptar y guardar");
        btnguardar_stymuli.setBorder(null);
        btnguardar_stymuli.setBorderPainted(false);
        btnguardar_stymuli.setContentAreaFilled(false);
        btnguardar_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnguardar_stymuliActionPerformed(evt);
            }
        });

        lblnombrekpi7.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi7.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi7.setText("Descripción:");

        jPanel4.setBackground(new java.awt.Color(153, 103, 198));
        jPanel4.setLayout(new javax.swing.BoxLayout(jPanel4, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi13.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi13.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi13.setText("SubÁrea:");
        lblnombrekpi13.setPreferredSize(new java.awt.Dimension(83, 14));
        jPanel4.add(lblnombrekpi13);

        txtnombresubarea.setPreferredSize(new java.awt.Dimension(55, 20));
        txtnombresubarea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombresubareaActionPerformed(evt);
            }
        });
        jPanel4.add(txtnombresubarea);

        btnbuscar_subarea_stym.setBackground(new java.awt.Color(0, 51, 0));
        btnbuscar_subarea_stym.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbuscar_subarea_stym.setToolTipText("Buscar subárea");
        btnbuscar_subarea_stym.setBorder(null);
        btnbuscar_subarea_stym.setBorderPainted(false);
        btnbuscar_subarea_stym.setContentAreaFilled(false);
        btnbuscar_subarea_stym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbuscar_subarea_stymActionPerformed(evt);
            }
        });
        jPanel4.add(btnbuscar_subarea_stym);

        jPanel3.setBackground(new java.awt.Color(153, 103, 198));
        jPanel3.setLayout(new javax.swing.BoxLayout(jPanel3, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrearea.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrearea.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrearea.setText("Área:");
        lblnombrearea.setPreferredSize(new java.awt.Dimension(83, 14));
        jPanel3.add(lblnombrearea);

        txtnombrearea.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtnombreareaActionPerformed(evt);
            }
        });
        jPanel3.add(txtnombrearea);

        btnbusca_area_stym.setBackground(new java.awt.Color(0, 51, 0));
        btnbusca_area_stym.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbusca_area_stym.setToolTipText("Buscar área");
        btnbusca_area_stym.setBorder(null);
        btnbusca_area_stym.setBorderPainted(false);
        btnbusca_area_stym.setContentAreaFilled(false);
        btnbusca_area_stym.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusca_area_stymActionPerformed(evt);
            }
        });
        jPanel3.add(btnbusca_area_stym);

        pnlkpiestimulo.setBackground(new java.awt.Color(153, 103, 198));
        pnlkpiestimulo.setLayout(new javax.swing.BoxLayout(pnlkpiestimulo, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi12.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi12.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi12.setText("KPI objetivo:");
        lblnombrekpi12.setPreferredSize(new java.awt.Dimension(83, 14));
        pnlkpiestimulo.add(lblnombrekpi12);
        pnlkpiestimulo.add(txtnombrekpiestim);

        btnbusca_kpi_estim.setBackground(new java.awt.Color(0, 51, 0));
        btnbusca_kpi_estim.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/buscarlista.png"))); // NOI18N
        btnbusca_kpi_estim.setToolTipText("Buscar KPI");
        btnbusca_kpi_estim.setBorder(null);
        btnbusca_kpi_estim.setBorderPainted(false);
        btnbusca_kpi_estim.setContentAreaFilled(false);
        btnbusca_kpi_estim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnbusca_kpi_estimActionPerformed(evt);
            }
        });
        pnlkpiestimulo.add(btnbusca_kpi_estim);

        jPanel6.setOpaque(false);
        jPanel6.setLayout(new javax.swing.BoxLayout(jPanel6, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi11.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi11.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi11.setText("Tipo de Symuli:");
        lblnombrekpi11.setPreferredSize(new java.awt.Dimension(83, 14));
        jPanel6.add(lblnombrekpi11);

        cbotipo_stymuli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bono", "Salario", "Otro" }));
        cbotipo_stymuli.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbotipo_stymuliItemStateChanged(evt);
            }
        });
        cbotipo_stymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbotipo_stymuliActionPerformed(evt);
            }
        });
        jPanel6.add(cbotipo_stymuli);

        jPanel7.setOpaque(false);
        jPanel7.setLayout(new javax.swing.BoxLayout(jPanel7, javax.swing.BoxLayout.LINE_AXIS));

        lblnombrekpi10.setFont(new java.awt.Font("Arial", 0, 11)); // NOI18N
        lblnombrekpi10.setForeground(new java.awt.Color(255, 255, 255));
        lblnombrekpi10.setText("Stymuli:");
        lblnombrekpi10.setPreferredSize(new java.awt.Dimension(83, 14));
        jPanel7.add(lblnombrekpi10);

        txtstymuli.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
                txtstymuliInputMethodTextChanged(evt);
            }
        });
        txtstymuli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtstymuliActionPerformed(evt);
            }
        });
        txtstymuli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtstymuliKeyTyped(evt);
            }
        });
        jPanel7.add(txtstymuli);

        lblstymuli.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        lblstymuli.setForeground(new java.awt.Color(255, 255, 255));
        lblstymuli.setText("$");
        jPanel7.add(lblstymuli);

        javax.swing.GroupLayout pnlregistro_stymuliLayout = new javax.swing.GroupLayout(pnlregistro_stymuli);
        pnlregistro_stymuli.setLayout(pnlregistro_stymuliLayout);
        pnlregistro_stymuliLayout.setHorizontalGroup(
            pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlregistro_stymuliLayout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlkpiestimulo, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnlregistro_stymuliLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnguardar_stymuli)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btncancelar_stymuli))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlregistro_stymuliLayout.createSequentialGroup()
                        .addComponent(lblnombrekpi7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.LEADING))
                .addContainerGap())
        );

        pnlregistro_stymuliLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel6, jPanel7, pnlkpiestimulo});

        pnlregistro_stymuliLayout.setVerticalGroup(
            pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_stymuliLayout.createSequentialGroup()
                .addGroup(pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_stymuliLayout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlregistro_stymuliLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblnombrekpi7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlregistro_stymuliLayout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(pnlkpiestimulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlregistro_stymuliLayout.createSequentialGroup()
                        .addComponent(jScrollPane3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlregistro_stymuliLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnguardar_stymuli, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btncancelar_stymuli, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addGap(10, 10, 10))
        );

        pnlregistro_stymuliLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jPanel3, jPanel4, jPanel6, jPanel7, pnlkpiestimulo});

        jLabel1.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Modelo");

        lblobjetivos.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lblobjetivos.setForeground(new java.awt.Color(255, 255, 255));
        lblobjetivos.setText("Objetivos");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1))
                    .addComponent(pnlregistro_stymuli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnllistado_stymuli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(17, 17, 17)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(lblobjetivos)
                        .addContainerGap())
                    .addComponent(pnlregistro_Obj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnllistado_Obj, javax.swing.GroupLayout.DEFAULT_SIZE, 536, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(lblobjetivos))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnllistado_Obj, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnllistado_stymuli, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlregistro_stymuli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlregistro_Obj, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jPanel5Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {pnllistado_Obj, pnllistado_stymuli});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void tablalistado_stymuliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_stymuliMouseClicked


    }//GEN-LAST:event_tablalistado_stymuliMouseClicked

    private void tablalistado_stymuliMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_stymuliMousePressed
        int fila = tablalistado_stymuli.getSelectedRow();

        txtidmodelo.setText(tablalistado_stymuli.getValueAt(fila, 0).toString());

        habilitar_btnspr();
        pnllistado_Obj.setVisible(true);
        lblobjetivos.setVisible(true);
        mostrar_Obj("");

        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado_stymuliMousePressed

    private void txtbuscar_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_stymuliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_stymuliActionPerformed

    private void txtbuscar_stymuliKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_stymuliKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_stymuliKeyPressed

    private void btneliminar_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_stymuliActionPerformed
        // TODO add your handling code here:
        int fila = tablalistado_stymuli.getSelectedRow();

        txtidmodelo.setText(tablalistado_stymuli.getValueAt(fila, 0).toString());
        if (!txtidmodelo.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el Modelo", "Confirmar", 2);

            if (confirmacion == 0) {
                vmodelo dts = new vmodelo();
                fmodelo func = new fmodelo();

                dts.setIdmodelo(Integer.parseInt(txtidmodelo.getText()));
                func.eliminar(dts);
                mostrar_stymuli("");
                mostrar_Obj("");
                inhabilitar_o();
                inhabilitar_s();

            }

        }
    }//GEN-LAST:event_btneliminar_stymuliActionPerformed

    private void btnnuevo_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo_stymuliActionPerformed

        habilitar_s();
        pnlregistro_stymuli.setVisible(true);
        btnguardar_stymuli.setIcon(new ImageIcon(frmmodelo.class.getResource("/img/guardar.png")));
        accion_stymuli = "guardar";
        cbotipo_stymuli.setSelectedItem("Bono");
        pnlkpiestimulo.setVisible(false);

    }//GEN-LAST:event_btnnuevo_stymuliActionPerformed

    private void btncancelar_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_stymuliActionPerformed
        // TODO add your handling code here:
        inhabilitar_o();
        inhabilitar_s();

    }//GEN-LAST:event_btncancelar_stymuliActionPerformed

    private void txtnombresubareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombresubareaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombresubareaActionPerformed

    private void txtnombreareaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombreareaActionPerformed
        // TODO add your handling code here:

        txtnombrearea.transferFocus();
    }//GEN-LAST:event_txtnombreareaActionPerformed

    private void btnbusca_area_stymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusca_area_stymActionPerformed
        // TODO add your handling code here:
         txtidsubarea.setText("");
         txtnombresubarea.setText("");
        frmvistaarea form = new frmvistaarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
        form.setLocationRelativeTo(btnbusca_area_stym);
    }//GEN-LAST:event_btnbusca_area_stymActionPerformed

    private void btnbuscar_subarea_stymActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbuscar_subarea_stymActionPerformed

        if (txtidarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Área primero");
            txtidarea.requestFocus();
            return;

        }
        conexion.formsubarea = frmmodelo.txtidarea.getText();

        frmvistasubarea form = new frmvistasubarea();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
        form.setLocationRelativeTo(btnbuscar_subarea_stym);

        // TODO add your handling code here:
    }//GEN-LAST:event_btnbuscar_subarea_stymActionPerformed

    private void btnguardar_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_stymuliActionPerformed
        // TODO add your handling code here:

        if (txtidarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un área");
            txtidarea.requestFocus();
            return;

        }
        if (txtidsubarea.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un Subárea");
            txtidarea.requestFocus();
            return;

        }

        if (txtstymuli.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe ingresar el valor del Stymuli");
            txtstymuli.requestFocus();
            return;

        }

        vmodelo dts = new vmodelo();
        fmodelo func = new fmodelo();

        dts.setIdarea(Integer.parseInt(txtidarea.getText()));
        dts.setIdsubarea(Integer.parseInt(txtidsubarea.getText()));
        
        int seleccionado = cbotipo_stymuli.getSelectedIndex();        
        if (((String) cbotipo_stymuli.getItemAt(seleccionado)).equals("Otro")) {
        dts.setTipo_estimulo(txtnombresubarea.getText()+"_"+txtnombrekpiestim.getText());    
        }else{               
        dts.setTipo_estimulo((String) cbotipo_stymuli.getItemAt(seleccionado));
        }
        dts.setEstimulo(Double.parseDouble(txtstymuli.getText()));
        dts.setDescripcion(txtdescripcion.getText());

        if (accion_stymuli.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Modelo fue registrado satisfactoriamente");
                mostrar_stymuli("");
                inhabilitar_s();
                checkinput();

                int lastRow = tablalistado_stymuli.convertRowIndexToView(tablalistado_stymuli.getRowCount() - 1);
                tablalistado_stymuli.setRowSelectionInterval(lastRow, lastRow);
                pnllistado_Obj.setVisible(true);
                lblobjetivos.setVisible(true);
                pnlregistro_Obj.setVisible(true);

                txtvalor_Obj.requestFocus();
                txtidmodelo.setText(tablalistado_stymuli.getValueAt(tablalistado_stymuli.getRowCount() - 1, 0).toString());

                JOptionPane.showMessageDialog(rootPane, "Ahora registre un Objetivo");
                mostrar_Obj("");

            }

        } else if (accion_stymuli.equals("editar")) {
            dts.setIdmodelo(Integer.parseInt(txtidmodelo.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Modelo fue editado satisfactoriamente");
                mostrar_stymuli("");
                inhabilitar_o();
                inhabilitar_s();
                checkinput();
            }

        }
    }//GEN-LAST:event_btnguardar_stymuliActionPerformed

    private void tablalistado_ObjMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_ObjMouseClicked
        // TODO add your handling code here:


    }//GEN-LAST:event_tablalistado_ObjMouseClicked

    private void tablalistado_ObjMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_ObjMousePressed
        habilitar_btnopri();

// TODO add your handling code here:

    }//GEN-LAST:event_tablalistado_ObjMousePressed

    private void txtbuscar_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtbuscar_ObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_ObjActionPerformed

    private void txtbuscar_ObjKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_ObjKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_ObjKeyPressed

    private void btneliminar_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneliminar_ObjActionPerformed

        int fila = tablalistado_Obj.getSelectedRow();

        txtidobjetivos.setText(tablalistado_Obj.getValueAt(fila, 0).toString());

        if (!txtidobjetivos.getText().equals("")) {
            int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de eliminar el Objetivo", "Confirmar", 2);

            if (confirmacion == 0) {
                vobjetivos dts = new vobjetivos();
                fobjetivos func = new fobjetivos();

                dts.setIdobjetivos(Integer.parseInt(txtidobjetivos.getText()));
                func.eliminar(dts);
                mostrar_Obj("");
                
                     if (fobjetivos.totalponderado < 100) {
                    JOptionPane.showMessageDialog(rootPane, "El valor ponderado total del modelo, debe ser minimo el 100% del Stymuli a recibir");
                    habilitar_o();
                   inhabilitar_s();
                    checkinput();
                    txtvalor_Obj.requestFocus();
                } else {
                
                
                inhabilitar_o();
                inhabilitar_s();}

            }

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btneliminar_ObjActionPerformed

    private void btnnuevo_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnnuevo_ObjActionPerformed

        habilitar_o();
        cbotipo_Obj.setSelectedIndex(0);

        btnguardar_Obj.setIcon(new ImageIcon(frmmodelo.class.getResource("/img/guardar.png")));
        accion_Obj = "guardar";        // TODO add your handling code here:
    }//GEN-LAST:event_btnnuevo_ObjActionPerformed

    private void btncancelar_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelar_ObjActionPerformed
        inhabilitar_o();
        inhabilitar_s();      // TODO add your handling code here:
    }//GEN-LAST:event_btncancelar_ObjActionPerformed

    private void txtvalor_pon_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor_pon_ObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor_pon_ObjActionPerformed

    private void txtvalor_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtvalor_ObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor_ObjActionPerformed

    private void txtnombrekpi_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtnombrekpi_ObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtnombrekpi_ObjActionPerformed

    private void btnbusca_kpi_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusca_kpi_ObjActionPerformed
        frmvistakpiobjetivos form = new frmvistakpiobjetivos();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true); 
        form.setLocationRelativeTo(btnbusca_kpi_Obj);// TODO add your handling code here:
    }//GEN-LAST:event_btnbusca_kpi_ObjActionPerformed

    private void btnguardar_ObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnguardar_ObjActionPerformed
        // TODO add your handling code here:
        if (txtidkpi.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un KPI");
            txtidkpi.requestFocus();
            return;

        }
        if (txtvalor_Obj.getText().length() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un valor Objetivo");
            txtvalor_Obj.requestFocus();
            return;

        }

        vobjetivos dts = new vobjetivos();
        fobjetivos func = new fobjetivos();

        dts.setIdmodelo(Integer.parseInt(txtidmodelo.getText()));
        dts.setIdkpi(Integer.parseInt(txtidkpi.getText()));

        int seleccionado = cbocomparacion_Obj.getSelectedIndex();
        dts.setComparacion((String) cbocomparacion_Obj.getItemAt(seleccionado));

        dts.setValor_objetivo(Double.parseDouble(txtvalor_Obj.getText()));
        seleccionado = cbotipo_Obj.getSelectedIndex();
        dts.setTipo_objetivo((String) cbotipo_Obj.getItemAt(seleccionado));

        if (txtvalor_pon_Obj.getText().length() != 0) {
            dts.setValor_ponderado(Double.parseDouble(txtvalor_pon_Obj.getText()));
        }

        if (accion_Obj.equals("guardar")) {
            if (func.insertar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Objetivo fue registrado satisfactoriamente");
                mostrar_Obj("");
                
                if ( fobjetivos.totalponderado< 100) {
                    JOptionPane.showMessageDialog(rootPane, "El valor ponderado total del modelo, debe ser minimo el 100% del Stymuli a recibir");
                    habilitar_o();
                  inhabilitar_s();
                    checkinput();
                    txtvalor_Obj.requestFocus();
                } else {
                    inhabilitar_o();
                    inhabilitar_s();
                    checkinput();
                }
            }

        } else if (accion_Obj.equals("editar")) {
            dts.setIdobjetivos(Integer.parseInt(txtidobjetivos.getText()));
            if (func.editar(dts)) {
                JOptionPane.showMessageDialog(rootPane, "El Objetivo fue editado satisfactoriamente");
                mostrar_Obj("");

                   if (fobjetivos.totalponderado < 100) {
                    JOptionPane.showMessageDialog(rootPane, "El valor ponderado total del modelo, debe ser minimo el 100% del Stymuli a recibir");
                    habilitar_o();
                   inhabilitar_s();
                    checkinput();
                    txtvalor_Obj.requestFocus();
                } else {

                    inhabilitar_o();
                    inhabilitar_s();
                    checkinput();
                   }
            }

        }


    }//GEN-LAST:event_btnguardar_ObjActionPerformed

    private void tablalistado_ObjMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablalistado_ObjMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_tablalistado_ObjMouseEntered

    private void txtidmodeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtidmodeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtidmodeloActionPerformed

    private void btneditarstyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarstyActionPerformed
        habilitar_s();
        pnlkpiestimulo.setVisible(false);
        btnguardar_stymuli.setIcon(new ImageIcon(frmmodelo.class.getResource("/img/editar.png")));

        btneliminar_stymuli.setEnabled(true);
        accion_stymuli = "editar";

        int fila = tablalistado_stymuli.getSelectedRow();

        txtidmodelo.setText(tablalistado_stymuli.getValueAt(fila, 0).toString());

        txtidarea.setText(tablalistado_stymuli.getValueAt(fila, 1).toString());
        txtnombrearea.setText(tablalistado_stymuli.getValueAt(fila, 2).toString());
        txtidsubarea.setText(tablalistado_stymuli.getValueAt(fila, 3).toString());
        txtnombresubarea.setText(tablalistado_stymuli.getValueAt(fila, 4).toString());
        
        String tipoestim=tablalistado_stymuli.getValueAt(fila, 5).toString();
        
        if (tipoestim.indexOf("_")>=0) {
        pnlkpiestimulo.setVisible(true);
        String[] parte = tipoestim.split("_");
        String primera = parte[0];
        String segunda = parte[1];
        txtnombrekpiestim.setText(segunda);
        cbotipo_stymuli.setSelectedItem("Otro");
        }else{
        cbotipo_stymuli.setSelectedItem(tablalistado_stymuli.getValueAt(fila, 5).toString());
       }
        
        txtstymuli.setText(tablalistado_stymuli.getValueAt(fila, 6).toString());
        txtdescripcion.setText(tablalistado_stymuli.getValueAt(fila, 7).toString());
        txtstymuli.requestFocus();
        checkinput();
        

// TODO add your handling code here:
    }//GEN-LAST:event_btneditarstyActionPerformed

    private void btneditarobjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarobjActionPerformed

        btnguardar_Obj.setIcon(new ImageIcon(frmmodelo.class.getResource("/img/editar.png")));

        btneliminar_Obj.setEnabled(true);
        accion_Obj = "editar";

        int fila = tablalistado_Obj.getSelectedRow();

        txtidobjetivos.setText(tablalistado_Obj.getValueAt(fila, 0).toString());

        txtidkpi.setText(tablalistado_Obj.getValueAt(fila, 2).toString());

        txtnombrekpi_Obj.setText(tablalistado_Obj.getValueAt(fila, 3).toString());

        cbocomparacion_Obj.setSelectedItem(tablalistado_Obj.getValueAt(fila, 4).toString());

        txtvalor_Obj.setText(tablalistado_Obj.getValueAt(fila, 5).toString());

        cbotipo_Obj.setSelectedItem(tablalistado_Obj.getValueAt(fila, 6).toString());

        txtvalor_pon_Obj.setText(tablalistado_Obj.getValueAt(fila, 7).toString());
        checkinput();

        pnlregistro_Obj.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_btneditarobjActionPerformed

    private void txtbuscar_stymuliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_stymuliKeyReleased
        mostrar_stymuli(txtbuscar_stymuli.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_stymuliKeyReleased

    private void txtbuscar_ObjKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtbuscar_ObjKeyReleased
        mostrar_Obj(txtbuscar_Obj.getText());        // TODO add your handling code here:
    }//GEN-LAST:event_txtbuscar_ObjKeyReleased

    private void txtvalor_ObjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalor_ObjKeyTyped
        char keychar = evt.getKeyChar();

        if (Character.isAlphabetic(keychar)) {
            evt.consume();
        }
        if (keychar == ',') {
            evt.setKeyChar('.');
        }
        if (keychar == '%' || keychar == '$') {
            evt.consume();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_txtvalor_ObjKeyTyped

    private void txtvalor_pon_ObjKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtvalor_pon_ObjKeyTyped
        char keychar = evt.getKeyChar();

        if (Character.isAlphabetic(keychar)) {
            evt.consume();
        }
        if (keychar == ',') {
            evt.setKeyChar('.');
        }
        if (keychar == '%' || keychar == '$') {
            evt.consume();
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_txtvalor_pon_ObjKeyTyped

    private void cbotipo_stymuliItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipo_stymuliItemStateChanged

        int seleccionado = cbotipo_stymuli.getSelectedIndex();
        if (((String) cbotipo_stymuli.getItemAt(seleccionado)).equals("Bono")) {
            lblstymuli.setText("$");
            pnlkpiestimulo.setVisible(false);
        } else if (((String) cbotipo_stymuli.getItemAt(seleccionado)).equals("Salario")) {
            lblstymuli.setText("%");
            pnlkpiestimulo.setVisible(false);
        }else if (((String) cbotipo_stymuli.getItemAt(seleccionado)).equals("Otro")) {
            pnlkpiestimulo.setVisible(true);
            lblstymuli.setText("%");
        }
 

            

        

        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipo_stymuliItemStateChanged

    private void cbotipo_ObjItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbotipo_ObjItemStateChanged
        int seleccionado = cbotipo_Obj.getSelectedIndex();
        if (((String) cbotipo_Obj.getItemAt(seleccionado)).equals("Ponderado")) {

            lblvaponderado.setVisible(true);
            txtvalor_pon_Obj.setVisible(true);
            lblpondperc.setVisible(true);

        } else {

            lblvaponderado.setVisible(false);
            txtvalor_pon_Obj.setVisible(false);
            lblpondperc.setVisible(false);

        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipo_ObjItemStateChanged

    private void txtstymuliKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtstymuliKeyTyped
        char keychar = evt.getKeyChar();

        if (Character.isAlphabetic(keychar)) {
            evt.consume();
        }
        if (keychar == ',') {
            evt.setKeyChar('.');
        }
        if (keychar == '%' || keychar == '$') {
            evt.consume();
        }
    }//GEN-LAST:event_txtstymuliKeyTyped

    private void txtstymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtstymuliActionPerformed
        // TODO add your handling code here:
        txtstymuli.transferFocus();
    }//GEN-LAST:event_txtstymuliActionPerformed

    private void txtstymuliInputMethodTextChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_txtstymuliInputMethodTextChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_txtstymuliInputMethodTextChanged

    private void btnbusca_kpi_estimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnbusca_kpi_estimActionPerformed
  
        conexion.frmabierto = 1;
        frmvistakpiobjetivos form = new frmvistakpiobjetivos();
        form.toFront();
        form.setVisible(true);
        form.setAlwaysOnTop(true);
        form.setLocationRelativeTo(btnbusca_kpi_estim);
// TODO add your handling code here:
    }//GEN-LAST:event_btnbusca_kpi_estimActionPerformed

    private void cbotipo_stymuliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbotipo_stymuliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbotipo_stymuliActionPerformed

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
            java.util.logging.Logger.getLogger(frmmodelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmmodelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmmodelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmmodelo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmmodelo().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JButton btnbusca_area_stym;
    private javax.swing.JButton btnbusca_kpi_Obj;
    private javax.swing.JButton btnbusca_kpi_estim;
    private javax.swing.JButton btnbuscar_subarea_stym;
    private javax.swing.JButton btncancelar_Obj;
    private javax.swing.JButton btncancelar_stymuli;
    private javax.swing.JButton btneditarobj;
    private javax.swing.JButton btneditarsty;
    private javax.swing.JButton btneliminar_Obj;
    private javax.swing.JButton btneliminar_stymuli;
    private javax.swing.JButton btnguardar_Obj;
    private javax.swing.JButton btnguardar_stymuli;
    private javax.swing.JButton btnnuevo_Obj;
    private javax.swing.JButton btnnuevo_stymuli;
    private javax.swing.JComboBox<String> cbocomparacion_Obj;
    private javax.swing.JComboBox<String> cbotipo_Obj;
    private javax.swing.JComboBox<String> cbotipo_stymuli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    public static javax.swing.JLabel lblbuscarobj;
    public static javax.swing.JLabel lblbuscstym;
    public static javax.swing.JLabel lblnombrearea;
    private javax.swing.JLabel lblnombrekpi10;
    private javax.swing.JLabel lblnombrekpi11;
    private javax.swing.JLabel lblnombrekpi12;
    private javax.swing.JLabel lblnombrekpi13;
    private javax.swing.JLabel lblnombrekpi16;
    private javax.swing.JLabel lblnombrekpi17;
    private javax.swing.JLabel lblnombrekpi7;
    private javax.swing.JLabel lblnombrekpi9;
    private javax.swing.JLabel lblobjetivos;
    private javax.swing.JLabel lblpondperc;
    private javax.swing.JLabel lblstymuli;
    private javax.swing.JLabel lblvaponderado;
    private javax.swing.JPanel pnlkpiestimulo;
    private javax.swing.JPanel pnllistado_Obj;
    private javax.swing.JPanel pnllistado_stymuli;
    private javax.swing.JPanel pnlregistro_Obj;
    private javax.swing.JPanel pnlregistro_stymuli;
    private javax.swing.JTable tablalistado_Obj;
    private javax.swing.JTable tablalistado_stymuli;
    public static javax.swing.JTextField txtbuscar_Obj;
    public static javax.swing.JTextField txtbuscar_stymuli;
    private javax.swing.JTextArea txtdescripcion;
    public static javax.swing.JTextField txtidarea;
    public static javax.swing.JTextField txtidkpi;
    public static javax.swing.JTextField txtidmodelo;
    public static javax.swing.JTextField txtidobjetivos;
    public static javax.swing.JTextField txtidsubarea;
    public static javax.swing.JTextField txtnombrearea;
    public static javax.swing.JTextField txtnombrekpi_Obj;
    public static javax.swing.JTextField txtnombrekpiestim;
    public static javax.swing.JTextField txtnombresubarea;
    private javax.swing.JTextField txtstymuli;
    public static javax.swing.JTextField txtvalor_Obj;
    private javax.swing.JTextField txtvalor_pon_Obj;
    // End of variables declaration//GEN-END:variables
}
