/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import UI.frmzzcrearpass;
import datos.vtrabajador;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import org.jfree.ui.tabbedui.RootPanel;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author crist
 */
public class ftrabajador {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    private String sSQL4 = "";
    public Integer rows;
    private static int workload = 12;
    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    public DefaultTableModel mostrar(String buscar, String filtrores) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre", "1er.Apellido", "2do.Apellido", "Tipo Doc", "Documento", "Email", "Num.Contacto", "IDarea", "Área", "IDsubarea", "SubÁrea", "Cargo", "Salario", "Acceso", "Estado"};

        String[] registro = new String[16];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = " SELECT p.idpersona,p.nombre,p.apaterno,p.amaterno,p.tipo_documento,p.documento,"
                + "p.email,p.tel,p.idarea,p.idsubarea,a.nombre,s.nombre,p.cargo,p.salario,p.acceso,"
                + "p.password,p.estado "
                + "FROM persona p INNER JOIN area a ON a.idarea=p.idarea INNER JOIN subarea s "
                + "ON s.idsubarea=p.idsubarea "
                + "where " + filtrores + " like '%" + buscar + "%' order by p.apaterno";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("p.idpersona");
                registro[1] = rs.getString("p.nombre");
                registro[2] = rs.getString("p.apaterno");
                registro[3] = rs.getString("p.amaterno");
                registro[4] = rs.getString("p.tipo_documento");
                registro[5] = rs.getString("p.documento");
                registro[6] = rs.getString("p.email");
                registro[7] = rs.getString("p.tel");
                registro[8] = rs.getString("p.idarea");
                registro[9] = rs.getString("a.nombre");
                registro[10] = rs.getString("p.idsubarea");
                registro[11] = rs.getString("s.nombre");
                registro[12] = rs.getString("p.cargo");
                registro[13] = "$" + numberFormat.format(Double.parseDouble(rs.getString("p.salario")));
                registro[14] = rs.getString("p.acceso");
                registro[15] = rs.getString("p.estado");
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vtrabajador dts) {
        sSQL = "insert into persona (nombre,apaterno,amaterno,tipo_documento,documento,email,tel,idarea,idsubarea,cargo,salario,acceso,password,estado)"
                + "values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getDocumento());
            pst.setString(6, dts.getEmail());
            pst.setString(7, dts.getTel());

            pst.setInt(8, dts.getIdarea());
            pst.setInt(9, dts.getIdsubarea());
            pst.setString(10, dts.getCargo());
            pst.setDouble(11, dts.getSalario());
            pst.setString(12, dts.getAcceso());

            String salt = BCrypt.gensalt(workload);
            String hashed_password = BCrypt.hashpw(dts.getPassword(), salt);
            pst.setString(13, hashed_password);
            pst.setString(14, dts.getEstado());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean editar(vtrabajador dts) {
        sSQL = "update persona set nombre=?,apaterno=?,amaterno=?,tipo_documento=?,documento=?,"
                + " email=?,tel=?,idarea=?,idsubarea=?,cargo=?,salario=?,acceso=?,password=?,estado=? where idpersona=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getApaterno());
            pst.setString(3, dts.getAmaterno());
            pst.setString(4, dts.getTipo_documento());
            pst.setString(5, dts.getDocumento());
            pst.setString(6, dts.getEmail());
            pst.setString(7, dts.getTel());

            pst.setInt(8, dts.getIdarea());
            pst.setInt(9, dts.getIdsubarea());
            pst.setString(10, dts.getCargo());
            pst.setDouble(11, dts.getSalario());
            pst.setString(12, dts.getAcceso());

            String salt = BCrypt.gensalt(workload);
            String hashed_password = BCrypt.hashpw(dts.getPassword(), salt);
            pst.setString(13, hashed_password);
            pst.setString(14, dts.getEstado());

            pst.setInt(15, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean eliminar(vtrabajador dts) {
        sSQL = "delete from persona where idpersona=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdpersona());

            int n = pst.executeUpdate();

            if (n != 0) {

                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public boolean crearpassword(vtrabajador dts) {
        sSQL = "update persona set password=? where documento=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            String salt = BCrypt.gensalt(workload);
            String hashed_password = BCrypt.hashpw(dts.getPassword(), salt);
            pst.setString(1, hashed_password);
            pst.setString(2, dts.getDocumento());
            int n = pst.executeUpdate();
            if (n != 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }
    }

    public static String dbpasswordexist;

    public static String loginidpersona;
    public static String loginnombre;
    public static String login1erapellido;
    public static String login2doapellido;
    public static String loginemail;
    public static String loginidarea;
    public static String loginarea;
    public static String loginidsubarea;
    public static String loginsubarea;
    public static String loginacceso;

    public boolean login(String documento, String password) {
        dbpasswordexist = "na";
        loginidpersona = "";
        loginnombre = "";
        login1erapellido = "";
        login2doapellido = "";        
        loginemail = "";
        loginidarea = "";
        loginarea = "";
        loginidsubarea = "";
        loginsubarea = "";
        loginacceso = "";

        String dbpassword = "";
        boolean password_verified = false;

        sSQL = "SELECT p.idpersona,p.idarea,p.idsubarea,p.email,p.password,a.nombre,s.nombre,p.acceso,"
                + "p.apaterno,p.amaterno,p.nombre "
                + "FROM persona p INNER JOIN area a ON p.idarea=a.idarea "
                + "INNER JOIN subarea s ON s.idsubarea=p.idsubarea "
                + "WHERE p.documento='" + documento + "' AND p.estado LIKE '%A%' ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                dbpassword = rs.getString("p.password");
                dbpasswordexist = "existe";
                loginidpersona = (rs.getString("p.idpersona"));
                loginnombre = (rs.getString("p.nombre"));
                login1erapellido = (rs.getString("p.apaterno"));
                login2doapellido = (rs.getString("p.amaterno"));
                loginemail = (rs.getString("p.email"));
                loginidarea = (rs.getString("p.idarea"));
                loginarea = (rs.getString("a.nombre"));
                loginidsubarea = (rs.getString("p.idsubarea"));
                loginsubarea = (rs.getString("s.nombre"));
                loginacceso = (rs.getString("p.acceso"));

            }
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }
        if (null == dbpassword || !dbpassword.startsWith("$2a$")) {
            throw new java.lang.IllegalArgumentException("Invalid hash provided for comparison");
        }

        password_verified = BCrypt.checkpw(password, dbpassword);

        return (password_verified);

    }

    public boolean load(String filename) {

        rows = 0;

        sSQL = "CREATE TEMPORARY TABLE tempempleados (nombre VARCHAR(45),	apaterno VARCHAR(45),	"
                + "amaterno VARCHAR(45),	tipo_documento VARCHAR(45),	documento VARCHAR(45),	"
                + "email VARCHAR(45),	tel VARCHAR(45),	nombrear VARCHAR(45),	nombresuba VARCHAR(45),	"
                + "cargo VARCHAR(45),salario DECIMAL(10,2),"
                + "acceso VARCHAR(45),	password VARCHAR(45),	estado VARCHAR(45))";
        sSQL2 = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE tempempleados "
                + "FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"'\n"
                + "LINES TERMINATED BY '\n';";

        sSQL3 = "insert into persona (nombre,apaterno,amaterno,tipo_documento,documento,email,tel,idarea,idsubarea,cargo,salario,acceso,password,estado)\n"
                + "SELECT te.nombre,te.apaterno,te.amaterno,te.tipo_documento,te.documento,te.email,te.tel,a.idarea,s.idsubarea,te.cargo,te.salario,te.acceso,\n"
                + "te.password,te.estado FROM tempempleados te INNER JOIN area a ON a.nombre=te.nombrear INNER JOIN subarea s ON s.nombre=te.nombresuba ";

        sSQL4 = "DROP TABLE tempempleados";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            PreparedStatement pst3 = cn.prepareStatement(sSQL3);
            PreparedStatement pst4 = cn.prepareStatement(sSQL4);

            pst.executeUpdate();
            pst2.executeUpdate();

            int n = pst3.executeUpdate();

            if (n != 0) {
                pst4.executeUpdate();
                rows = 1;
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return false;
        }

    }

    public void download(String filename) {

        try {

            String line = "NOMBRE,APELLIDO PATERNO,APELLIDO MATERNO,TIPO DE DOCUMENTO(Cedula de Ciudadania"
                    + "Cedula de Extranjeria"
                    + "Tarjeta de identidad"
                    + "NIT),NUMERO DE DOCUMENTO,EMAIL,TELEFONO,AREA,SUBAREA,CARGO,SALARIO,"
                    + "PERMISOS DE ACCESO(Trabajador"
                    + "Administrador"
                    + "Jefe de Area"
                    + "Jefe de Subarea),"
                    + "PASSWORD(Dejar en blanco!!),ESTADO(Activo Inactivo)";
            FileWriter fw = new FileWriter(filename + "/TEMPLATE BASE DE DATOS TRABAJADORES.csv");

            fw.append(line);
            fw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
