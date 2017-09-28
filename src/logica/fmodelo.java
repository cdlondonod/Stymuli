/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.vmodelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.DecimalFormat;
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

    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDarea", "Área", "IDsubarea", "SubÁrea", "Tipo Bolsa", "Stymuli", "Descripción"};

        String[] registro = new String[8];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select m.idmodelo,m.idarea,a.nombre,m.idsubarea,s.nombre,m.tipo_estimulo, m.estimulo, "
                + "m.descripcion from modelo m INNER JOIN area a ON a.idarea=m.idarea INNER JOIN subarea s "
                + "ON s.idsubarea=m.idsubarea where a.nombre like '%"
                + buscar + "%' or s.nombre like '%" + buscar + "%' order by s.nombre";

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

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vmodelo dts) {
        sSQL = "insert into modelo (idarea,idsubarea,tipo_estimulo,estimulo,descripcion)"
                + "values (?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdarea());
            pst.setInt(2, dts.getIdsubarea());
            pst.setString(3, dts.getTipo_estimulo());
            pst.setDouble(4, dts.getEstimulo());
            pst.setString(5, dts.getDescripcion());

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

    public boolean editar(vmodelo dts) {
        sSQL = "update modelo set idarea=?,idsubarea=?,tipo_estimulo=?,estimulo=?,descripcion=?"
                + " where idmodelo=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdarea());
            pst.setInt(2, dts.getIdsubarea());
            pst.setString(3, dts.getTipo_estimulo());
            pst.setDouble(4, dts.getEstimulo());
            pst.setString(5, dts.getDescripcion());

            pst.setInt(6, dts.getIdmodelo());

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
