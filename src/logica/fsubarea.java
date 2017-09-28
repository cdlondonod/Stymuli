/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.frmareasubar;


import datos.vsubarea;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class fsubarea {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public DefaultTableModel mostrar(String buscar1) {
        DefaultTableModel modelo1;

        String[] titulos = {"ID", "IDárea", "SubÁrea"};

        String[] registro = new String[4];

        modelo1 = new DefaultTableModel(null, titulos);

        sSQL = "select s.idsubarea,s.idarea,"
                + "s.nombre from subarea s inner join area a on s.idarea=a.idarea "
                + "where s.nombre like '%" + buscar1 + "%' and s.idarea=" + frmareasubar.txtidarea.getText() + " order by s.nombre desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idsubarea");
                registro[1] = rs.getString("idarea");
                registro[2] = rs.getString("nombre");

                modelo1.addRow(registro);

            }
            return modelo1;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vsubarea dts) {
        sSQL = "insert into subarea (idarea, nombre)"
                + "values(?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdarea());
            pst.setString(2, dts.getNombre());

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

    public boolean editar(vsubarea dts) {
        sSQL = "update subarea set idarea=?,nombre=?"
                + " where idsubarea=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(2, dts.getNombre());
            pst.setInt(1, dts.getIdarea());

            pst.setInt(3, dts.getIdsubarea());

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

    public boolean eliminar(vsubarea dts) {
        sSQL = "delete from subarea where idsubarea=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdsubarea());

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

    public DefaultTableModel mostrarvista(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDárea", "SubÁrea", "Área"};

        String[] registro = new String[4];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select s.idsubarea,s.idarea,s.nombre,a.nombre from subarea s inner join area a on s.idarea=a.idarea "
                + "where s.nombre like '%" + buscar + "%' and s.idarea=" + conexion.formsubarea + " order by s.nombre desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("s.idsubarea");
                registro[1] = rs.getString("s.idarea");
                registro[2] = rs.getString("s.nombre");
                registro[3] = rs.getString("a.nombre");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
