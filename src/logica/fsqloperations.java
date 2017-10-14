/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;

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

    fconfiguration con = new fconfiguration();

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";

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

        switch (tabla) {
            case "resultados":
                sSQL2 = "SELECT 'ID Resultados', 'ID KPI', 'ID Persona' , 'Resultado de KPI' , 'Mes' , 'Año' , 'Ultima Modificación' , 'ID Persona que modifico'"
                        + " UNION ALL ";
                break;
            case "area":
                sSQL2 = "SELECT 'ID Area', 'Nombre Area', 'Ultima Modificación' "
                        + " UNION ALL ";
                break;
            case "kpi":
                sSQL2 = "SELECT 'ID KPI', 'Nombre KPI', 'Descripcion' , 'Ultima Modificación' "
                        + " UNION ALL ";
                break;
            case "modelo":
                sSQL2 = "SELECT 'ID Modelo', 'ID Area', 'ID Subarea' , 'Tipo de Estimulo' , 'Estimulo' , 'Descripcion' , 'Mes del Modelo y ID subarea' , 'Ultima Modificación'  "
                        + " UNION ALL ";
                break;
            case "objetivos":
                sSQL2 = "SELECT 'ID Objetivos', 'ID Modelo', 'ID KPI' , 'Comparacion logica' , 'Valor Objetivo KPI' , 'Tipo de Objetivo' , 'Ponderado del Estimulo' , 'Ultima Modificación' "
                        + " UNION ALL ";
                break;
            case "persona":
                sSQL2 = "SELECT 'ID Persona', 'Nombre', 'Primer Apellido' , 'Segundo Apellido' , 'Tipo de Documento' , 'Documento' , 'Email' , 'Tel' , 'ID Area' , 'ID SubArea' , 'Cargo' , 'Salario' , 'Acceso' , 'Password encriptada' , 'Estado' , 'Ultima Modificación' , 'ID Persona que modifico' "
                        + " UNION ALL ";
                break;
            case "subarea":
                sSQL2 = "SELECT 'ID SubArea', 'ID Area', 'Nombre Subarea'  , 'Ultima Modificación' "
                        + " UNION ALL ";
                break;

        }
        if (con.GetProp("separadordec").equals(".")) {
            sSQL = sSQL2 + " SELECT * into OUTFILE  '" + filename + ".csv"
                    + "' CHARACTER SET latin1  FIELDS TERMINATED BY ',' "
                    + " OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\n'"
                    + "FROM " + tabla;
        } else if (con.GetProp("separadordec").equals(",")) {
            sSQL = sSQL2 + " SELECT * into OUTFILE  '" + filename + ".csv"
                    + "' CHARACTER SET latin1  FIELDS TERMINATED BY ';' "
                    + " OPTIONALLY ENCLOSED BY '\"' LINES TERMINATED BY '\n'"
                    + " FROM " + tabla;
        }

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

    /*public void importDB(String tabla, String filename) {
        Statement st;

        if (con.GetProp("separadordec").equals(".")) {
            
            sSQL = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+tabla+" "
                    + "FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"'"
                    + "LINES TERMINATED BY '\n'";
            
        } else if (con.GetProp("separadordec").equals(",")) {
            
            sSQL = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE "+tabla+" "
                    + "FIELDS TERMINATED BY ';' OPTIONALLY ENCLOSED BY '\"'"
                    + "LINES TERMINATED BY '\n'";
        }

        try {
            st = cn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
            st.executeQuery(sSQL);

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            e.printStackTrace();
            st = null;

        }

    }*/
    public static String tablaerrasebulk;

    public boolean eliminarenbulk(String fechaini, String fechafin) {
        if (tablaerrasebulk.equals("persona")) {
            sSQL = "delete from persona "
                    + "WHERE idpersonaupdated=" + INICIO.lblinicioidpersona.getText()
                    + " AND timestamp BETWEEN '" + fechaini + "' AND '" + fechafin + "'";

        } else if (tablaerrasebulk.equals("resultados")) {
            sSQL = "delete from resultados "
                    + "WHERE idpersonaupdated=" + INICIO.lblinicioidpersona.getText()
                    + " AND timestamp BETWEEN '" + fechaini + "' AND '" + fechafin + "'";
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
