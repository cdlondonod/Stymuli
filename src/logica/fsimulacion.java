/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import UI.INICIO;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.Statement;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class fsimulacion {
    
    fconfiguration con=new fconfiguration();

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    public Double obtenidopersonasim;     
    private String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    private String year = timeStamp.substring(0, 4);
    private String mes = timeStamp.substring(4, 6);

    public DefaultTableModel mostrarmodelo(String buscar) {
        DefaultTableModel modelo;

        String[] titulos = {"Tipo Stymuli", "Stymuli", "Nombre KPI", "Tipo KPI", "Peso", "Relación", "Objetivo"};

        String[] registro = new String[7];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT p.salario,m.descripcion,m.estimulo,m.tipo_estimulo,k.nombre,"
                + "o.comparacion,o.valor_objetivo,o.tipo_objetivo,o.valor_ponderado "
                + "FROM modelo m "
                + "INNER JOIN objetivos o ON m.idmodelo=o.idmodelo "
                + "INNER JOIN kpi k ON k.idkpi=o.idkpi "
                + "INNER JOIN subarea s ON m.idsubarea=s.idsubarea "
                + "INNER JOIN persona p ON s.idsubarea=p.idsubarea "
                + " WHERE s.idsubarea=" + INICIO.lblinicioidsubarea.getText()
                + " AND p.documento=" + INICIO.lbliniciodocumento.getText()
                + " AND SUBSTR(m.mes_modelo,1,4)="+year
                + " AND SUBSTR(m.mes_modelo,5,2)="+mes
                + " ORDER BY m.tipo_estimulo DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                Double sal = (Double.parseDouble(rs.getString("p.salario")));
                Double est = (Double.parseDouble(rs.getString("m.estimulo")));

                String tipom = (rs.getString("m.tipo_estimulo"));
                String tipoo = (rs.getString("o.tipo_objetivo"));

                registro[0] = rs.getString("m.tipo_estimulo");
                if (tipom.equals("Salario")) {
                    String text = con.numberFormatDisplay((sal * (est / 100)));
                    registro[1] = "$" + text;

                } else if (tipom.equals("Bono")) {
                    String text = con.numberFormatDisplay(est);
                    registro[1] = "$" + text;

                } else {

                    registro[1] = con.numberFormatDisplay(est / 100);

                }

                registro[2] = rs.getString("k.nombre");
                registro[5] = rs.getString("o.comparacion");
                registro[6] = con.numberFormatDisplay(Double.parseDouble(rs.getString("o.valor_objetivo")));

                if (tipoo.equals("Habilitador")) {
                    registro[3] = "Hab.";
                } else {
                    registro[3] = "Pon.";
                }
                registro[4] = con.numberFormatDisplay(Double.parseDouble(rs.getString("o.valor_ponderado"))) + "%";

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

    public DefaultTableModel mostrarvistakpi() {
        DefaultTableModel modelo;

        String[] titulos = {"ID", "KPI", "Resultado"};

        String[] registro = new String[3];

        modelo = new DefaultTableModel(null, titulos);

        sSQL = "SELECT o.idkpi,k.nombre,k.descripcion FROM objetivos o INNER JOIN kpi k ON o.idkpi=k.idkpi"
                + " INNER JOIN modelo m ON o.idmodelo=m.idmodelo INNER JOIN subarea s ON m.idsubarea=s.idsubarea"
                + " INNER JOIN persona p ON p.idsubarea=s.idsubarea WHERE "
                + " p.idpersona=" + INICIO.lblinicioidpersona.getText()
                + " AND SUBSTR(m.mes_modelo,1,4)="+year
                + " AND SUBSTR(m.mes_modelo,5,2)="+mes
                 + " ORDER BY m.tipo_estimulo DESC";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {
                registro[0] = rs.getString("o.idkpi");
                registro[1] = rs.getString("k.nombre");
                registro[2] = "";
                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }

}
