/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package UI;

import datos.vtrabajador;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.JOptionPane;
import logica.fconfiguration;
import logica.ftrabajador;
import static logica.ftrabajador.dbpasswordexist;

/**
 *
 * @author crist
 */
public class frmconfiguracion extends javax.swing.JFrame {

    fconfiguration con = new fconfiguration();

    public frmconfiguracion() {
        initComponents();
        this.setLocationRelativeTo(null);

        File f = new File("conf\\config.txt");//revisa que el archivo config existe ya
        if (f.exists() && !f.isDirectory()) {
            defaultvalues();
        }

    }

    void defaultvalues() {

        txtnomdb.setText(con.GetProp("database"));
        txtipdb.setText(con.GetProp("ipdatabase"));
        txtuserdb.setText(con.GetProp("userdatabase"));
        txtpassdb.setText(con.GetProp("passworddatabase"));
        cbodecimal.setSelectedItem(con.GetProp("separadordec"));
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
        btninter = new javax.swing.JButton();
        btngenera = new javax.swing.JButton();
        btncuenta = new javax.swing.JButton();
        pnlcardla = new javax.swing.JPanel();
        pnlbtn = new javax.swing.JPanel();
        btndefault = new javax.swing.JButton();
        btnaceptar = new javax.swing.JButton();
        btncancelar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        pnlinterfaz = new javax.swing.JPanel();
        pnlgeneral = new javax.swing.JPanel();
        pnldbconect = new javax.swing.JPanel();
        txtipdb = new javax.swing.JTextField();
        txtpassdb = new javax.swing.JPasswordField();
        txtnomdb = new javax.swing.JTextField();
        txtuserdb = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        cbodecimal = new javax.swing.JComboBox<>();
        pnlcuent = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtpassnu = new javax.swing.JPasswordField();
        txtpassant = new javax.swing.JPasswordField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtpassnu1 = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        jPanel5.setLayout(new javax.swing.BoxLayout(jPanel5, javax.swing.BoxLayout.PAGE_AXIS));

        btninter.setBackground(new java.awt.Color(255, 255, 255));
        btninter.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btninter.setForeground(new java.awt.Color(75, 16, 160));
        btninter.setText("Interfaz");
        btninter.setBorder(null);
        btninter.setContentAreaFilled(false);
        btninter.setMaximumSize(new java.awt.Dimension(102, 26));
        btninter.setMinimumSize(new java.awt.Dimension(102, 26));
        btninter.setPreferredSize(new java.awt.Dimension(102, 26));
        btninter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btninterActionPerformed(evt);
            }
        });
        jPanel5.add(btninter);

        btngenera.setBackground(new java.awt.Color(255, 255, 255));
        btngenera.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btngenera.setForeground(new java.awt.Color(75, 16, 160));
        btngenera.setText("General");
        btngenera.setBorder(null);
        btngenera.setContentAreaFilled(false);
        btngenera.setMaximumSize(new java.awt.Dimension(102, 26));
        btngenera.setMinimumSize(new java.awt.Dimension(102, 26));
        btngenera.setPreferredSize(new java.awt.Dimension(102, 26));
        btngenera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btngeneraActionPerformed(evt);
            }
        });
        jPanel5.add(btngenera);

        btncuenta.setBackground(new java.awt.Color(255, 255, 255));
        btncuenta.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btncuenta.setForeground(new java.awt.Color(75, 16, 160));
        btncuenta.setText("Cuenta");
        btncuenta.setBorder(null);
        btncuenta.setContentAreaFilled(false);
        btncuenta.setMaximumSize(new java.awt.Dimension(102, 26));
        btncuenta.setMinimumSize(new java.awt.Dimension(102, 26));
        btncuenta.setPreferredSize(new java.awt.Dimension(102, 26));
        btncuenta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncuentaActionPerformed(evt);
            }
        });
        jPanel5.add(btncuenta);

        pnlcardla.setBackground(new java.awt.Color(255, 255, 255));
        pnlcardla.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(101, 54, 193)));
        pnlcardla.setLayout(new java.awt.BorderLayout());

        pnlbtn.setBackground(new java.awt.Color(255, 255, 255));
        pnlbtn.setPreferredSize(new java.awt.Dimension(494, 45));

        btndefault.setBackground(new java.awt.Color(255, 255, 255));
        btndefault.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btndefault.setForeground(new java.awt.Color(75, 16, 160));
        btndefault.setText("Por Defecto");
        btndefault.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btndefault.setContentAreaFilled(false);
        btndefault.setMaximumSize(new java.awt.Dimension(140, 26));
        btndefault.setMinimumSize(new java.awt.Dimension(140, 26));
        btndefault.setPreferredSize(new java.awt.Dimension(140, 26));
        btndefault.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndefaultActionPerformed(evt);
            }
        });

        btnaceptar.setBackground(new java.awt.Color(255, 255, 255));
        btnaceptar.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btnaceptar.setForeground(new java.awt.Color(75, 16, 160));
        btnaceptar.setText("Aceptar");
        btnaceptar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btnaceptar.setContentAreaFilled(false);
        btnaceptar.setMaximumSize(new java.awt.Dimension(102, 26));
        btnaceptar.setMinimumSize(new java.awt.Dimension(102, 26));
        btnaceptar.setPreferredSize(new java.awt.Dimension(102, 26));
        btnaceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaceptarActionPerformed(evt);
            }
        });

        btncancelar.setBackground(new java.awt.Color(255, 255, 255));
        btncancelar.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        btncancelar.setForeground(new java.awt.Color(75, 16, 160));
        btncancelar.setText("Cancelar");
        btncancelar.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        btncancelar.setContentAreaFilled(false);
        btncancelar.setMaximumSize(new java.awt.Dimension(102, 26));
        btncancelar.setMinimumSize(new java.awt.Dimension(102, 26));
        btncancelar.setPreferredSize(new java.awt.Dimension(102, 26));
        btncancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlbtnLayout = new javax.swing.GroupLayout(pnlbtn);
        pnlbtn.setLayout(pnlbtnLayout);
        pnlbtnLayout.setHorizontalGroup(
            pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btndefault, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 127, Short.MAX_VALUE)
                .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        pnlbtnLayout.setVerticalGroup(
            pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlbtnLayout.createSequentialGroup()
                .addGroup(pnlbtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btndefault, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnaceptar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btncancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        pnlcardla.add(pnlbtn, java.awt.BorderLayout.PAGE_END);

        jPanel3.setLayout(new java.awt.CardLayout());

        pnlinterfaz.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout pnlinterfazLayout = new javax.swing.GroupLayout(pnlinterfaz);
        pnlinterfaz.setLayout(pnlinterfazLayout);
        pnlinterfazLayout.setHorizontalGroup(
            pnlinterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        pnlinterfazLayout.setVerticalGroup(
            pnlinterfazLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 373, Short.MAX_VALUE)
        );

        jPanel3.add(pnlinterfaz, "card3");

        pnlgeneral.setBackground(new java.awt.Color(255, 255, 255));

        pnldbconect.setBackground(new java.awt.Color(255, 255, 255));

        txtipdb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtipdb.setForeground(new java.awt.Color(75, 16, 160));

        txtpassdb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtpassdb.setForeground(new java.awt.Color(75, 16, 160));
        txtpassdb.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassdbActionPerformed(evt);
            }
        });

        txtnomdb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtnomdb.setForeground(new java.awt.Color(75, 16, 160));

        txtuserdb.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        txtuserdb.setForeground(new java.awt.Color(75, 16, 160));

        jLabel5.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(75, 16, 160));
        jLabel5.setText("IP Base de Datos:");

        jLabel6.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(75, 16, 160));
        jLabel6.setText("Password Base de Datos:");
        jLabel6.setToolTipText("");

        jLabel7.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(75, 16, 160));
        jLabel7.setText("Usuario Base de Datos:");
        jLabel7.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(75, 16, 160));
        jLabel4.setText("Nombre Base de Datos:");

        javax.swing.GroupLayout pnldbconectLayout = new javax.swing.GroupLayout(pnldbconect);
        pnldbconect.setLayout(pnldbconectLayout);
        pnldbconectLayout.setHorizontalGroup(
            pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldbconectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6))
                .addGap(16, 16, 16)
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtnomdb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
                    .addComponent(txtipdb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuserdb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassdb, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnldbconectLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel4, jLabel5, jLabel6, jLabel7, txtipdb, txtnomdb, txtpassdb, txtuserdb});

        pnldbconectLayout.setVerticalGroup(
            pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnldbconectLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnomdb))
                .addGap(6, 6, 6)
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtipdb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtuserdb, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnldbconectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassdb, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnldbconectLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel4, txtnomdb});

        pnldbconectLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel7, txtuserdb});

        pnldbconectLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, txtpassdb});

        pnldbconectLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel5, txtipdb});

        jPanel2.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(75, 16, 160));
        jLabel8.setText("Separador Decimales:");
        jLabel8.setToolTipText("");

        cbodecimal.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        cbodecimal.setForeground(new java.awt.Color(75, 16, 160));
        cbodecimal.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { ",", "." }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addGap(47, 47, 47)
                .addComponent(cbodecimal, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbodecimal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {cbodecimal, jLabel8});

        javax.swing.GroupLayout pnlgeneralLayout = new javax.swing.GroupLayout(pnlgeneral);
        pnlgeneral.setLayout(pnlgeneralLayout);
        pnlgeneralLayout.setHorizontalGroup(
            pnlgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pnldbconect, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlgeneralLayout.setVerticalGroup(
            pnlgeneralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlgeneralLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnldbconect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(150, Short.MAX_VALUE))
        );

        jPanel3.add(pnlgeneral, "card1");

        pnlcuent.setBackground(new java.awt.Color(255, 255, 255));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Modificar Password", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 0, 12), new java.awt.Color(75, 16, 160))); // NOI18N
        jPanel4.setOpaque(false);

        jLabel1.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(75, 16, 160));
        jLabel1.setText("Nuevo Password:");

        txtpassant.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtpassantActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(75, 16, 160));
        jLabel2.setText("Antiguo Password:");

        jLabel3.setFont(new java.awt.Font("abeatbyKai", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(75, 16, 160));
        jLabel3.setText("Confirmar Password:");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtpassnu, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpassant, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtpassnu1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtpassant)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 26, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassnu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtpassnu1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel1, txtpassnu});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel2, txtpassant});

        jPanel4Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel3, txtpassnu1});

        javax.swing.GroupLayout pnlcuentLayout = new javax.swing.GroupLayout(pnlcuent);
        pnlcuent.setLayout(pnlcuentLayout);
        pnlcuentLayout.setHorizontalGroup(
            pnlcuentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcuentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(125, Short.MAX_VALUE))
        );
        pnlcuentLayout.setVerticalGroup(
            pnlcuentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlcuentLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );

        jPanel3.add(pnlcuent, "Card2");

        pnlcardla.add(jPanel3, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(6, 6, 6)
                .addComponent(pnlcardla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnlcardla, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btncancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncancelarActionPerformed
        this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_btncancelarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowOpened

    private void btngeneraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btngeneraActionPerformed
        pnlcuent.setVisible(false);
        pnlgeneral.setVisible(true);
        pnlinterfaz.setVisible(false);

// TODO add your handling code here:
    }//GEN-LAST:event_btngeneraActionPerformed

    private void btncuentaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncuentaActionPerformed
        pnlcuent.setVisible(true);
        pnlgeneral.setVisible(false);
        pnlinterfaz.setVisible(false);        // TODO add your handling code here:
    }//GEN-LAST:event_btncuentaActionPerformed

    private void btninterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btninterActionPerformed
        pnlcuent.setVisible(false);
        pnlgeneral.setVisible(false);
        pnlinterfaz.setVisible(true);         // TODO add your handling code here:
    }//GEN-LAST:event_btninterActionPerformed

    private void txtpassantActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassantActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassantActionPerformed
    private void reseteotxtpass() {
        txtpassant.setText("");
        txtpassnu.setText("");
        txtpassnu1.setText("");

    }
    private void btnaceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaceptarActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(rootPane, "Esta seguro de Realizar los Cambios?", "Confirmar", 2);

        if (confirmacion == 0) {
            //inicia cambio de password
            if (!txtpassant.getText().equals("") && !txtpassnu.getText().equals("")) {
                if (txtpassnu.getText().equals(txtpassnu1.getText())) {
                    try {
                        ftrabajador func = new ftrabajador();
                        vtrabajador dts = new vtrabajador();
                        dts.setDocumento(INICIO.lbliniciodocumento.getText());
                        dts.setPassword(txtpassant.getText());

                        if (func.login(INICIO.lbliniciodocumento.getText(), txtpassant.getText())) {

                            dts.setPassword(txtpassnu.getText());
                            dts.setDocumento((INICIO.lbliniciodocumento.getText()));
                            if (func.crearpassword(dts)) {
                                JOptionPane.showMessageDialog(rootPane, "El Password fue cambiado satisfactoriamente");
                                this.dispose();
                            }

                        } else {
                            JOptionPane.showMessageDialog(rootPane, "Contraseña Anterior incorrecta", "Acceso al Sistema", JOptionPane.ERROR_MESSAGE);
                            reseteotxtpass();
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(rootPane, "Contraseña Anterior incorrecta", "Acceso al Sistema " + e, JOptionPane.ERROR_MESSAGE);
                        reseteotxtpass();
                    }
                } else {
                    JOptionPane.showMessageDialog(rootPane, "La contraseña nueva no coincide");
                    reseteotxtpass();
                }
            }//termina cambio de password

            //inicia cambio de config file, conexion db
            if (!txtnomdb.getText().equals("") && !txtuserdb.getText().equals("") && !txtipdb.getText().equals("")) {

                con.SaveProp("database", txtnomdb.getText());
                con.SaveProp("userdatabase", txtuserdb.getText());
                con.SaveProp("ipdatabase", txtipdb.getText());
                con.SaveProp("passworddatabase", txtpassdb.getText());
                con.SaveProp("separadordec", cbodecimal.getSelectedItem().toString());

                this.dispose();

            } else if (txtnomdb.getText().equals("") || txtuserdb.getText().equals("") || txtipdb.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Debe Ingresar Todos los Datos para establecer la conexion a la Base de Datos");
            }//termina cambio de config file, conexion db

        }

// TODO add your handling code here:
    }//GEN-LAST:event_btnaceptarActionPerformed

    private void txtpassdbActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtpassdbActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtpassdbActionPerformed

    private void btndefaultActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndefaultActionPerformed
        File f = new File("config.txt");//revisa que el archivo config existe ya
        if (f.exists() && !f.isDirectory()) {
            defaultvalues();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_btndefaultActionPerformed

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
            java.util.logging.Logger.getLogger(frmconfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmconfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmconfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmconfiguracion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frmconfiguracion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnaceptar;
    private javax.swing.JButton btncancelar;
    public static javax.swing.JButton btncuenta;
    private javax.swing.JButton btndefault;
    private javax.swing.JButton btngenera;
    public static javax.swing.JButton btninter;
    private javax.swing.JComboBox<String> cbodecimal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel pnlbtn;
    private javax.swing.JPanel pnlcardla;
    private javax.swing.JPanel pnlcuent;
    public static javax.swing.JPanel pnldbconect;
    private javax.swing.JPanel pnlgeneral;
    private javax.swing.JPanel pnlinterfaz;
    private javax.swing.JTextField txtipdb;
    private javax.swing.JTextField txtnomdb;
    private javax.swing.JPasswordField txtpassant;
    private javax.swing.JPasswordField txtpassdb;
    private javax.swing.JPasswordField txtpassnu;
    private javax.swing.JPasswordField txtpassnu1;
    private javax.swing.JTextField txtuserdb;
    // End of variables declaration//GEN-END:variables
}
