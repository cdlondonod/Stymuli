/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import UI.frmmodelo;
import datos.vmodelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class fmodelo {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    private String sSQL4 = "";
    private String sSQL5 = "";
    private String sSQL6 = "";
    private String sSQL7 = "";
    private String sSQL8 = "";
    private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    private String year = timeStamp.substring(0, 4);
    private String mes = timeStamp.substring(4, 6);

    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDarea", "Área", "IDsubarea", "SubÁrea", "Tipo Bolsa", "Stymuli", "Descripción", "Fecha Valida"};

        String[] registro = new String[9];

        modelo = new DefaultTableModel(null, titulos);

        if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {

            sSQL2 = "a.idarea=" + INICIO.lblinicioidarea.getText() + " AND";

        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {

            sSQL2 = "a.idarea=" + INICIO.lblinicioidarea.getText() + " AND s.nombre like '%" + INICIO.lbliniciosubarea.getText() + "%' AND";

        }

        if (!frmmodelo.checkmostrar.isSelected()) {
            sSQL3 = " AND SUBSTR(m.mes_modelo,1,4)=" + year
                    + " AND SUBSTR(m.mes_modelo,5,2)=" + mes;
        }

        sSQL = "select m.idmodelo,m.idarea,a.nombre,m.idsubarea,s.nombre,m.tipo_estimulo, m.estimulo, "
                + "SUBSTR(m.mes_modelo,1,4) as myear, SUBSTR(m.mes_modelo,5,2) as mmes, "
                + "m.descripcion from modelo m INNER JOIN area a ON a.idarea=m.idarea INNER JOIN subarea s "
                + "ON s.idsubarea=m.idsubarea where "
                + sSQL2
                + " (a.nombre like '%"
                + buscar + "%' or s.nombre like '%" + buscar + "%') "
                + sSQL3
                + " order by m.idmodelo";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                String tipom = (rs.getString("m.tipo_estimulo"));

                registro[0] = rs.getString("m.idmodelo");
                registro[1] = rs.getString("m.idarea");
                registro[2] = rs.getString("a.nombre");
                registro[3] = rs.getString("m.idsubarea");
                registro[4] = rs.getString("s.nombre");
                registro[5] = rs.getString("m.tipo_estimulo");
                if (tipom.equals("Salario")) {

                    registro[6] = rs.getString("m.estimulo") + "%";

                } else if (tipom.equals("Bono")) {

                    registro[6] = "$" + numberFormat.format(Double.parseDouble(rs.getString("m.estimulo")));

                } else {

                    registro[6] = rs.getString("m.estimulo") + "%";

                }

                registro[7] = rs.getString("m.descripcion");
                registro[8] = rs.getString("myear") + "/" + rs.getString("mmes");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vmodelo dts) {
        sSQL = "insert into modelo (idarea,idsubarea,tipo_estimulo,estimulo,descripcion,mes_modelo)"
                + "values (?,?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdarea());
            pst.setInt(2, dts.getIdsubarea());
            pst.setString(3, dts.getTipo_estimulo());
            pst.setDouble(4, dts.getEstimulo());
            pst.setString(5, dts.getDescripcion());
            pst.setString(6, dts.getMes_modelo());

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

    public boolean copiarobj() {

        String timeStamp2 = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
        String year2 = timeStamp2.substring(0, 4);
        String mes2 = Integer.toString(Integer.parseInt(timeStamp2.substring(4, 6)) - 1);
        String messtring2;
        if (mes2.equals("0")) {
            messtring2 = "12";
            year2 = Integer.toString(Integer.parseInt(timeStamp2.substring(0, 4)) - 1);
        } else if (mes2.equals("11") || mes2.equals("10")) {
            messtring2 = mes2;
        } else {
            messtring2 = "0" + mes2;
        }
        sSQL6 = "SET @area=(SELECT idarea FROM modelo WHERE idmodelo=" + frmmodelo.modeloactual + ")";
        sSQL7 = "SET @subarea=(SELECT idsubarea FROM modelo  WHERE idmodelo=" + frmmodelo.modeloactual + ")";
        sSQL8 = "SET @idmodelo=(SELECT m.idmodelo FROM modelo m  WHERE "
                + "SUBSTR(m.mes_modelo,1,4)=" + year2 + " AND "
                + "SUBSTR(m.mes_modelo,5,2)=" + messtring2 + " AND "
                + "m.idarea=@area AND "
                + "m.idsubarea=@subarea)";
        sSQL = "CREATE TEMPORARY TABLE temporary_table AS SELECT * FROM objetivos WHERE idmodelo=@idmodelo";
        sSQL2 = "UPDATE temporary_table SET idmodelo=" + frmmodelo.modeloactual;
        sSQL4 = "INSERT INTO objetivos (idmodelo,idkpi,comparacion,valor_objetivo,tipo_objetivo,valor_ponderado) "
                + "SELECT idmodelo,idkpi,comparacion,valor_objetivo,tipo_objetivo,valor_ponderado FROM temporary_table";
        sSQL5 = "DROP TABLE temporary_table";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            PreparedStatement pst4 = cn.prepareStatement(sSQL4);
            PreparedStatement pst5 = cn.prepareStatement(sSQL5);
            PreparedStatement pst6 = cn.prepareStatement(sSQL6);
            PreparedStatement pst7 = cn.prepareStatement(sSQL7);
            PreparedStatement pst8 = cn.prepareStatement(sSQL8);
            pst6.executeUpdate();
            pst7.executeUpdate();
            pst8.executeUpdate();
            pst.executeUpdate();
            pst2.executeUpdate();
            int n = pst4.executeUpdate();
            pst5.executeUpdate();
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

    public boolean editar(vmodelo dts) {
        sSQL = "update modelo set idarea=?,idsubarea=?,tipo_estimulo=?,estimulo=?,descripcion=?,mes_modelo=?"
                + " where idmodelo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdarea());
            pst.setInt(2, dts.getIdsubarea());
            pst.setString(3, dts.getTipo_estimulo());
            pst.setDouble(4, dts.getEstimulo());
            pst.setString(5, dts.getDescripcion());
            pst.setString(6, dts.getMes_modelo());

            pst.setInt(7, dts.getIdmodelo());

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

    public boolean eliminar(vmodelo dts) {
        sSQL = "delete from modelo where idmodelo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdmodelo());

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
}
