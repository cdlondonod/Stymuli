/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.vkpi;
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
public class fkpi {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public DefaultTableModel mostrar(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre del KPI", "Descripción del KPI"};

        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "select * from kpi where nombre like '%" + buscar + "%' order by nombre ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idkpi");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vkpi dts) {
        sSQL = "insert into kpi (nombre,descripcion)"
                + "values(?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());

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

    public boolean editar(vkpi dts) {
        sSQL = "update kpi set nombre=?,descripcion=? "
                + " where idkpi=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setString(1, dts.getNombre());
            pst.setString(2, dts.getDescripcion());
            pst.setInt(3, dts.getIdkpi());

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

    public boolean eliminar(vkpi dts) {
        sSQL = "delete from kpi where idkpi=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdkpi());

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

        String[] titulos = {"ID", "Nombre del KPI", "Descripción del KPI"};

        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT DISTINCT o.idkpi,k.nombre,k.descripcion FROM objetivos o INNER JOIN kpi k ON o.idkpi=k.idkpi"
                + " INNER JOIN modelo m ON o.idmodelo=m.idmodelo INNER JOIN subarea s ON m.idsubarea=s.idsubarea"
                + " INNER JOIN persona p ON p.idsubarea=s.idsubarea WHERE k.nombre like '%" + buscar + "%' and p.idpersona=" + conexion.formsubarea + " ORDER BY k.nombre ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("idkpi");
                registro[1] = rs.getString("nombre");
                registro[2] = rs.getString("descripcion");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrarvistagraficas(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "Nombre del KPI", "Descripción del KPI"};

        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT DISTINCT o.idkpi,k.nombre,k.descripcion FROM objetivos o INNER JOIN kpi k ON o.idkpi=k.idkpi "
                + "INNER JOIN modelo m ON o.idmodelo=m.idmodelo INNER JOIN subarea s ON m.idsubarea=s.idsubarea "
                + "WHERE k.nombre like '%" + buscar + "%' and s.idsubarea=" + conexion.formsubarea + " ORDER BY k.nombre  ";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("o.idkpi");
                registro[1] = rs.getString("k.nombre");
                registro[2] = rs.getString("k.descripcion");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
