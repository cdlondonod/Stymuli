/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class ffiltros {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";

    public DefaultTableModel mostraryear(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Año"};
        String[] registro = new String[1];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select DISTINCT year from resultados where year like '%" + buscar + "%' order by year";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("year");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarmes(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Mes"};
        String[] registro = new String[1];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select DISTINCT mes from resultados where mes like '%" + buscar + "%' order by mes";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("mes");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrararea(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Área"};
        String[] registro = new String[1];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "select nombre from area where nombre like '%" + buscar + "%' order by nombre desc";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("nombre");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarsubarea(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"SubÁrea"};
        String[] registro = new String[1];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT s.nombre FROM subarea s INNER JOIN area a ON s.idarea=a.idarea "
                + "WHERE s.nombre LIKE '%" + buscar + "%' and a.nombre LIKE '%" + conexion.formsubarea + "%' "
                + "ORDER BY s.nombre DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("nombre");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarkpi(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"KPI"};
        String[] registro = new String[1];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT o.idkpi,k.nombre,k.descripcion FROM objetivos o INNER JOIN kpi k ON o.idkpi=k.idkpi \n"
                + "INNER JOIN modelo m ON o.idmodelo=m.idmodelo INNER JOIN subarea s ON m.idsubarea=s.idsubarea \n"
                + "WHERE k.nombre LIKE '%" + buscar + "%' and s.nombre LIKE '%" + conexion.formsubarea + "%' "
                + "ORDER BY k.nombre DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("nombre");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel mostrarpersona(String buscar) {
        DefaultTableModel modelo;
        String[] titulos = {"Nombre", "Documento", "Subárea"};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        sSQL = "SELECT p.documento,p.nombre,p.apaterno,p.amaterno,s.nombre FROM persona p "
                + "INNER JOIN subarea s ON p.idsubarea=s.idsubarea WHERE s.nombre LIKE '%" + conexion.formsubarea + "%' AND "
                + "(p.documento LIKE '%" + buscar + "%' OR p.nombre LIKE '%" + buscar + "%' "
                + "OR p.apaterno LIKE '%" + buscar + "%' OR p.amaterno LIKE '%" + buscar + "%') ORDER BY p.apaterno ";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {
                registro[0] = rs.getString("p.apaterno") + rs.getString("p.nombre") + rs.getString("p.amaterno");
                registro[1] = rs.getString("p.documento");
                registro[2] = rs.getString("s.nombre");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
