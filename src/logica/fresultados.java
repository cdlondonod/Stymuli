/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import datos.vresultados;

import java.io.FileWriter;
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
public class fresultados {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    private String sSQL4 = "";
    public Integer rows;

    public DefaultTableModel mostrar(String buscar, String filtrores) {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "IDkpi", "idPersona", "Trabajador", "IDarea", "Área", "IDsubarea", "SubÁrea", "KPI", "Resultado KPI", "Mes", "Año"};

        String[] registro = new String[12];

        modelo = new DefaultTableModel(null, titulos);
        
         if (INICIO.lblinicioacceso.getText().equals("Jefe de Area")) {
            sSQL2=" AND a.idarea="+INICIO.lblinicioidarea.getText()+" ";
            
        } else if (INICIO.lblinicioacceso.getText().equals("Jefe de Subarea")) {
            sSQL2=" AND a.idarea="+INICIO.lblinicioidarea.getText()+" AND s.nombre like '%"+INICIO.lbliniciosubarea.getText()+"%' ";
            
        }else if (INICIO.lblinicioacceso.getText().equals("Trabajador")) {
            sSQL2=" AND a.idarea="+INICIO.lblinicioidarea.getText()+" AND s.nombre like '%"+INICIO.lbliniciosubarea.getText()+"%' AND p.documento="+INICIO.lbliniciodocumento.getText()+" ";
        }


        sSQL = "SELECT r.idresultados,r.idkpi,r.idpersona,r.mes,r.year,p.documento,p.apaterno,p.nombre, "
                + "a.nombre,s.nombre,k.nombre,r.resultado_kpi,a.idarea,s.idsubarea FROM resultados r INNER JOIN persona p "
                + "ON r.idpersona=p.idpersona INNER JOIN area a ON p.idarea=a.idarea INNER JOIN subarea s "
                + "ON s.idsubarea=p.idsubarea INNER JOIN kpi k ON k.idkpi=r.idkpi  "
                + "where " + filtrores + " like '%" + buscar + "%' "
                + sSQL2
                + "order by s.idsubarea,r.mes,r.year";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("r.idresultados");
                registro[1] = rs.getString("r.idkpi");
                registro[2] = rs.getString("r.idpersona");
                registro[3] = rs.getString("p.apaterno") + " " + rs.getString("p.nombre");
                registro[4] = rs.getString("a.idarea");
                registro[5] = rs.getString("a.nombre");
                registro[6] = rs.getString("s.idsubarea");
                registro[7] = rs.getString("s.nombre");
                registro[8] = rs.getString("k.nombre");
                registro[9] = rs.getString("r.resultado_kpi");
                registro[10] = rs.getString("r.mes");
                registro[11] = rs.getString("r.year");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public boolean insertar(vresultados dts) {
        sSQL = "insert into resultados (idkpi,idpersona,resultado_kpi,mes,year)"
                + "values(?,?,?,?,?)";

        try {

            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdkpi());
            pst.setInt(2, dts.getIdpersona());
            pst.setDouble(3, dts.getResultado_kpi());
            pst.setString(4, dts.getMes());
            pst.setInt(5, dts.getYear());

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

    public boolean editar(vresultados dts) {
        sSQL = "update resultados set idkpi=?,idpersona=?,resultado_kpi=?,mes=?,year=?"
                + " where idresultados=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdkpi());
            pst.setInt(2, dts.getIdpersona());
            pst.setDouble(3, dts.getResultado_kpi());
            pst.setString(4, dts.getMes());
            pst.setInt(5, dts.getYear());

            pst.setInt(6, dts.getIdresultados());

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

    public boolean eliminar(vresultados dts) {
        sSQL = "delete from resultados where idresultados=?";

        try {
            PreparedStatement pst = cn.prepareStatement(sSQL);
            pst.setInt(1, dts.getIdresultados());

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

    public boolean load(String filename) {

        rows = 0;

        sSQL = "CREATE TEMPORARY TABLE tempresultados (kpi VARCHAR(45),	documento VARCHAR(45),	"
                + "resultado_kpi VARCHAR(45),	mes VARCHAR(45),	year VARCHAR(45))";
        sSQL2 = "LOAD DATA LOCAL INFILE '" + filename + "' INTO TABLE tempresultados "
                + "FIELDS TERMINATED BY ',' OPTIONALLY ENCLOSED BY '\"'\n"
                + "LINES TERMINATED BY '\n';";

        sSQL3 = "insert into resultados (idkpi,idpersona,resultado_kpi,mes,year)\n"
                + "SELECT k.idkpi,p.idpersona,te.resultado_kpi,te.mes,te.year FROM tempresultados te INNER JOIN kpi k ON k.nombre=te.kpi INNER JOIN persona p ON p.documento=te.documento ";

        sSQL4 = "DROP TABLE tempresultados";

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

            String line = "KPI,CEDULA DEL TRABAJADOR,RESULTADO DEL KPI (NUMEROS DECIMALES SEPARADOS POR PUNTOS),MES (EN EL FORMATO 01_Enero 02_Febrero 12_Diciembre etc), YEAR ";
            FileWriter fw = new FileWriter(filename + "/TEMPLATE BASE DE DATOS RESULTADOS.csv");

            fw.append(line);
            fw.flush();
            fw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
