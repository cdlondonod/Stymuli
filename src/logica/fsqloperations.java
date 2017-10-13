/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

import java.sql.Statement;

/**
 *
 * @author crist
 */
public class fsqloperations {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL4 = "";
    private String sSQL3 = "";

    public void limpiartabla(String tabla) {
        sSQL = "DELETE FROM " + tabla;
        sSQL2 = "ALTER TABLE " + tabla + " AUTO_INCREMENT = 1";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            PreparedStatement pst2 = cn.prepareStatement(sSQL2);
            pst.executeUpdate();
            pst2.executeUpdate();

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);

        }

    }

    public void exportarDB(String tabla, String filename) {
        Statement st;
        sSQL = "SELECT * into OUTFILE  '" + filename + ".csv"
                + "' CHARACTER SET latin1  FIELDS TERMINATED BY ',' FROM " + tabla;
        try {
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            st.executeQuery(sSQL);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            st = null;

        }

    }

    public static String tablaerrasebulk;
    public boolean eliminarenbulk(String fechaini, String fechafin) {
        if (tablaerrasebulk.equals("persona")) {
            sSQL = "select * from persona p "
                    + "WHERE p.idpersonaupdated=" + INICIO.lblinicioidpersona.toString()
                    + " AND p.timestamp BETWEEN '" + fechaini + "' AND '" + fechafin + "'";

        } else if (tablaerrasebulk.equals("resultados")) {
            sSQL = "select * from resultados r "
                    + "WHERE r.idpersonaupdated=" + INICIO.lblinicioidpersona.toString()
                    + " AND r.timestamp BETWEEN '" + fechaini + "' AND '" + fechafin + "'";
        }
        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
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
