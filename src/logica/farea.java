/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.varea;

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
public class farea {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre del Área"};

        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from area where nombre like '%" + buscar + "%' order by idarea ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idarea");
                registro[1] = rs.getString("nombre");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(varea dts) {
        sSQL = "insert into area (nombre)"
                + "values(?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());

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

    public boolean editar(varea dts) {
        sSQL = "update area set nombre=?"
                + " where idarea=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setInt(2, dts.getIdarea());

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

    public boolean eliminar(varea dts) {

        sSQL = "delete from area where idarea=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);

            pst.setInt(1, dts.getIdarea());

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

        String[] titulos = {"ID", "Nombre del Área"};

        String[] registro = new String[2];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from area where nombre like '%" + buscar + "%' order by nombre desc";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idarea");
                registro[1] = rs.getString("nombre");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
