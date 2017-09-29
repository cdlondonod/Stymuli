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
import java.text.DecimalFormat;

import javax.swing.JOptionPane;

import javax.swing.table.DefaultTableModel;

/**
 *
 * @author crist
 */
public class fanalisis {

    private conexion mysql = new conexion();
    private Connection cn = mysql.conectar();
    private String sSQL = "";
    private String sSQL2 = "";
    private String sSQL3 = "";
    private String bigquery = "SUBSTRING_INDEX(m.tipo_estimulo,'_',-1) AS kpiest,"
            + "SUBSTRING_INDEX(m.tipo_estimulo,'_',1) AS subareaest ,"
            + "@persona:=p.documento,"
            + "@mes:=r.mes,"
            + "@year:=r.year,"
            + "(CASE  "
            + " WHEN m.tipo_estimulo='Salario' "
            + " THEN ((m.estimulo/100)*p.salario)    "
            + " WHEN m.tipo_estimulo='Bono' "
            + " THEN m.estimulo    "
            + " ELSE "
            + " (((SELECT r.resultado_kpi  FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona  "
            + "INNER JOIN area a ON a.idarea=p.idarea  INNER JOIN subarea s ON s.idsubarea=p.idsubarea   "
            + "INNER JOIN modelo m ON m.idsubarea=p.idsubarea AND m.idarea=p.idarea  INNER JOIN objetivos o "
            + "ON m.idmodelo=o.idmodelo  INNER JOIN kpi k ON r.idkpi=o.idkpi AND k.idkpi=r.idkpi   "
            + "WHERE subareaest=s.nombre AND kpiest=k.nombre AND @persona=p.documento AND @mes=r.mes "
            + "AND @year=r.year)*m.estimulo)/100)"
            + "END) as estimulokpi,"
            + "(CASE  "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi>=0 AND o.valor_objetivo>0 "
            + " THEN ((r.resultado_kpi/o.valor_objetivo)*100)   "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi<0 AND o.valor_objetivo<=0 "
            + " THEN ((o.valor_objetivo/r.resultado_kpi)*100)   "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi=0 AND o.valor_objetivo<=0 "
            + " THEN 100   "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi>=0 AND o.valor_objetivo=0 "
            + " THEN 100"
            + " WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi<=0 AND o.valor_objetivo<0 "
            + " THEN ((r.resultado_kpi/o.valor_objetivo)*100)   "
            + " WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi>0 AND o.valor_objetivo>=0 "
            + " THEN ((o.valor_objetivo/r.resultado_kpi)*100)  "
            + " WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi<=0 AND o.valor_objetivo=0 "
            + " THEN 100 "
            + " WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi=0 AND o.valor_objetivo>=0 "
            + " THEN 100"
            + " WHEN o.comparacion='Igual'AND (r.resultado_kpi-o.valor_objetivo)=0 "
            + " THEN 100 "
            + " WHEN o.comparacion='Igual'AND (r.resultado_kpi-o.valor_objetivo)!=0 "
            + " THEN 0"
            + " ELSE null"
            + " END) as cumplimiento,"
            + " (CASE  "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi>=o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN ((CASE  "
            + " WHEN m.tipo_estimulo='Salario' "
            + " THEN ((m.estimulo/100)*p.salario)    "
            + " WHEN m.tipo_estimulo='Bono' "
            + " THEN m.estimulo    "
            + " ELSE "
            + " (((SELECT r.resultado_kpi  FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona  "
            + "INNER JOIN area a ON a.idarea=p.idarea  INNER JOIN subarea s ON s.idsubarea=p.idsubarea   "
            + "INNER JOIN modelo m ON m.idsubarea=p.idsubarea AND m.idarea=p.idarea  INNER JOIN objetivos o "
            + "ON m.idmodelo=o.idmodelo  INNER JOIN kpi k ON r.idkpi=o.idkpi AND k.idkpi=r.idkpi   "
            + "WHERE subareaest=s.nombre AND kpiest=k.nombre AND @persona=p.documento AND @mes=r.mes "
            + "AND @year=r.year)*m.estimulo)/100)"
            + "END)*(o.valor_ponderado/100))  "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi<o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN 0"
            + "  WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi<=o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN ((CASE  "
            + " WHEN m.tipo_estimulo='Salario' "
            + " THEN ((m.estimulo/100)*p.salario)    "
            + " WHEN m.tipo_estimulo='Bono' "
            + " THEN m.estimulo    "
            + " ELSE "
            + " (((SELECT r.resultado_kpi  FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona  "
            + "INNER JOIN area a ON a.idarea=p.idarea  INNER JOIN subarea s ON s.idsubarea=p.idsubarea   "
            + "INNER JOIN modelo m ON m.idsubarea=p.idsubarea AND m.idarea=p.idarea  INNER JOIN objetivos o "
            + "ON m.idmodelo=o.idmodelo  INNER JOIN kpi k ON r.idkpi=o.idkpi AND k.idkpi=r.idkpi   "
            + "WHERE subareaest=s.nombre AND kpiest=k.nombre AND @persona=p.documento AND @mes=r.mes "
            + "AND @year=r.year)*m.estimulo)/100)"
            + "END)*(o.valor_ponderado/100))  "
            + "  WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi>o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN 0 "
            + "  WHEN o.comparacion='Igual'AND r.resultado_kpi=o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN ((CASE  "
            + " WHEN m.tipo_estimulo='Salario' "
            + " THEN ((m.estimulo/100)*p.salario)    "
            + " WHEN m.tipo_estimulo='Bono' "
            + " THEN m.estimulo    "
            + " ELSE "
            + " (((SELECT r.resultado_kpi  FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona  "
            + "INNER JOIN area a ON a.idarea=p.idarea  INNER JOIN subarea s ON s.idsubarea=p.idsubarea   "
            + "INNER JOIN modelo m ON m.idsubarea=p.idsubarea AND m.idarea=p.idarea  INNER JOIN objetivos o "
            + "ON m.idmodelo=o.idmodelo  INNER JOIN kpi k ON r.idkpi=o.idkpi AND k.idkpi=r.idkpi   "
            + "WHERE subareaest=s.nombre AND kpiest=k.nombre AND @persona=p.documento AND @mes=r.mes "
            + "AND @year=r.year)*m.estimulo)/100)"
            + "END)*(o.valor_ponderado/100))  "
            + "  WHEN o.comparacion='Igual'AND r.resultado_kpi!=o.valor_objetivo AND o.tipo_objetivo='Ponderado' "
            + " THEN 0"
            + " ELSE 0"
            + " END) as obtiene,"
            + " (CASE  "
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi>=o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 1"
            + " WHEN o.comparacion='Mayor/Igual'AND r.resultado_kpi<o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 0"
            + "  WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi<=o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 1"
            + "  WHEN o.comparacion='Menor/Igual'AND r.resultado_kpi>o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 0 "
            + "  WHEN o.comparacion='Igual'AND r.resultado_kpi=o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 1"
            + "  WHEN o.comparacion='Igual'AND r.resultado_kpi!=o.valor_objetivo AND o.tipo_objetivo='Habilitador' "
            + " THEN 0"
            + " ELSE 1"
            + " END) as habilita "
            + "FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona INNER JOIN area a ON a.idarea=p.idarea "
            + "INNER JOIN subarea s ON s.idsubarea=p.idsubarea INNER JOIN modelo m ON m.idsubarea=p.idsubarea "
            + "AND m.idarea=p.idarea INNER JOIN objetivos o ON m.idmodelo=o.idmodelo INNER JOIN kpi k ON r.idkpi=o.idkpi "
            + "AND k.idkpi=r.idkpi";

    Double cumpmayor;
    Double cumpmenor;
    Double otroest = 0.0;
    DecimalFormat numberFormat = new DecimalFormat("#,##0.00;(#,##0.00)");

    public DefaultTableModel mostrarcompleto(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        DefaultTableModel modelo;

        String[] titulos = {"Fecha", "Nombre", "Documento", "Área", "SubÁrea", "Tipo Stymuli", "Valor Stymuli", "KPI", "Resultado", "Relacion", "Objetivo", "Peso", "Cumplimiento", "Obtiene", "Habilitador"};

        String[] registro = new String[15];

        modelo = new DefaultTableModel(null, titulos);
        if (!INICIO.lblinicioacceso.getText().equals("Administrador")) {
            sSQL2 = " AND a.idarea=" + INICIO.lblinicioidarea.getText() + " ";
        }

        sSQL = "SELECT p.nombre,p.apaterno,p.documento,p.salario,a.nombre,s.nombre,m.tipo_estimulo,m.estimulo,"
                + "k.nombre, r.resultado_kpi,o.comparacion,o.valor_objetivo,o.tipo_objetivo,o.valor_ponderado,r.mes,r.year,\n"
                + bigquery
                + " WHERE "
                + " r.year LIKE '%" + year + "%'"
                + " AND r.mes LIKE '%" + mes + "%'"
                + " AND a.nombre LIKE '%" + area + "%'"
                + " AND s.nombre LIKE '%" + Subarea + "%'"
                + " AND p.documento LIKE '%" + Trabajador + "%'"
                + " AND k.nombre LIKE '%" + KPI + "%'"
                + sSQL2
                + " ORDER BY s.idsubarea,p.apaterno,p.nombre,k.nombre,r.mes,r.year";

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);

            while (rs.next()) {

                registro[1] = rs.getString("p.apaterno") + ", " + rs.getString("p.nombre");
                registro[2] = rs.getString("p.documento");
                registro[3] = rs.getString("a.nombre");
                registro[4] = rs.getString("s.nombre");
                registro[5] = rs.getString("m.tipo_estimulo");

                if (rs.getString("estimulokpi") != null) {
                    registro[6] = "$" + numberFormat.format(Double.parseDouble(rs.getString("estimulokpi")));
                } else {
                    registro[6] = "$0.0";
                }

                registro[7] = rs.getString("k.nombre");
                registro[8] = rs.getString("r.resultado_kpi");
                registro[9] = rs.getString("o.comparacion");
                registro[10] = rs.getString("o.valor_objetivo");
                registro[11] = numberFormat.format(Double.parseDouble(rs.getString("o.valor_ponderado"))) + "%";
                registro[12] = numberFormat.format(Double.parseDouble(rs.getString("cumplimiento"))) + "%";
                registro[13] = "$" + numberFormat.format(Double.parseDouble(rs.getString("obtiene")));
                registro[14] = rs.getString("habilita");

                registro[0] = rs.getString("r.year") + " " + rs.getString("r.mes");

                modelo.addRow(registro);

            }
            return modelo;

        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }

    }
    String habilitador;
    public static Double resultobttotal;

    public DefaultTableModel mostraragrupadopordocumento(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        DefaultTableModel modelo;
        String[] titulos = {"Fecha", "Nombre", "Documento", "Stymuli Obtenido", "Stymuli Alcanzable"};
        String[] registro = new String[5];
        modelo = new DefaultTableModel(null, titulos);
        if (!INICIO.lblinicioacceso.getText().equals("Administrador")) {
            sSQL2 = " AND tbcomp.idarea=" + INICIO.lblinicioidarea.getText() + " ";
        }
        sSQL3 = "  SELECT tbcomp.documento,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + "(IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + "AS obtreal,tbcomp.year,tbcomp.mes ,tbcomp.area,tbcomp.idarea, tbcomp.kpi,tbcomp.subarea FROM   \n"
                + " (SELECT p.nombre,p.apaterno,p.documento,r.mes,r.year,a.idarea as idarea,a.nombre AS area,k.nombre AS kpi,s.nombre "
                + "AS subarea,   \n"
                + bigquery
                + " )AS tbcomp   "
                + " WHERE "
                + " tbcomp.year LIKE '%" + year + "%'"
                + " AND tbcomp.mes LIKE '%" + mes + "%'"
                + " AND tbcomp.area LIKE '%" + area + "%'"
                + " AND tbcomp.subarea LIKE '%" + Subarea + "%'"
                + " AND tbcomp.documento LIKE '%" + Trabajador + "%'"
                + " AND tbcomp.kpi LIKE '%" + KPI + "%'"
                +sSQL2
                + " GROUP BY tbcomp.documento,tbcomp.mes,tbcomp.year"
                + " ORDER BY tbcomp.subarea,tbcomp.apaterno,tbcomp.nombre,tbcomp.kpi,tbcomp.mes,tbcomp.year";

        resultobttotal = 0.0;

        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL3);
            while (rs.next()) {

                registro[1] = rs.getString("apaterno") + ", " + rs.getString("nombre");
                registro[2] = rs.getString("documento");
                registro[3] = "$ " + numberFormat.format(Double.parseDouble(rs.getString("obtreal")));
                registro[0] = rs.getString("year") + " " + rs.getString("mes");

                if (rs.getString("estimulokpi") != null) {
                    registro[4] = "$ " + numberFormat.format(Double.parseDouble(rs.getString("estimulokpi")));
                } else {
                    registro[4] = "$0.0";
                }

                modelo.addRow(registro);
                resultobttotal = resultobttotal + Double.parseDouble(rs.getString("obtreal"));
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel graficaevolutivo(String area, String Subarea, String KPI) {
        DefaultTableModel modelo;
        String[] titulos = {"Fecha", "KPI", "Resultado Medio"};
        String[] registro = new String[3];
        modelo = new DefaultTableModel(null, titulos);
        if (!INICIO.lblinicioacceso.getText().equals("Administrador")) {
            sSQL2 = " AND a.idarea=" + INICIO.lblinicioidarea.getText() + " ";
        }
        sSQL = "SELECT a.nombre,s.nombre,k.nombre, AVG(r.resultado_kpi) AS kpimed,r.mes,r.year "
                + "FROM resultados r INNER JOIN persona p ON r.idpersona=p.idpersona INNER JOIN area a "
                + "ON a.idarea=p.idarea INNER JOIN subarea s ON s.idsubarea=p.idsubarea INNER JOIN modelo m "
                + "ON m.idsubarea=p.idsubarea AND m.idarea=p.idarea INNER JOIN objetivos o ON m.idmodelo=o.idmodelo "
                + "INNER JOIN kpi k ON r.idkpi=o.idkpi AND k.idkpi=r.idkpi "
                + "WHERE "
                + " a.nombre LIKE '%" + area + "%'"
                + " AND s.nombre LIKE '%" + Subarea + "%'"
                + " AND k.nombre LIKE '%" + KPI + "%'"
                +sSQL2
                + "GROUP BY k.nombre,r.mes,r.year "
                + " ORDER BY s.nombre,r.mes,r.year DESC";
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL);
            while (rs.next()) {

                registro[1] = rs.getString("k.nombre");
                registro[2] = rs.getString("kpimed");
                registro[0] = rs.getString("r.year") + " " + rs.getString("r.mes");
                modelo.addRow(registro);
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

    public DefaultTableModel graficodistribuciontabla(String year, String mes, String area, String Subarea, String Trabajador, String KPI) {
        DefaultTableModel modelo;
        String[] titulos = {"Fecha", "Área", "Subárea", "Valor Obtenido"};
        String[] registro = new String[4];
        modelo = new DefaultTableModel(null, titulos);
        if (!INICIO.lblinicioacceso.getText().equals("Administrador")) {
            sSQL2 = " AND tbcompfiltrada.idarea=" + INICIO.lblinicioidarea.getText() + " ";
        }
        sSQL3 = " SELECT  tbcompfiltrada.area,tbcompfiltrada.idarea,tbcompfiltrada.subarea,SUM(tbcompfiltrada.obtreal)AS obtsubarea,"
                + "tbcompfiltrada.year,tbcompfiltrada.mes\n"
                + " \n"
                + " FROM  ( SELECT tbcomp.documento,tbcomp.idarea,tbcomp.nombre,tbcomp.estimulokpi,tbcomp.apaterno,(SUM(obtiene))AS sumob, "
                + "(IF((COUNT(habilita)-SUM(habilita))=0,1,0))AS habs,(SUM(obtiene)* IF((COUNT(habilita)-SUM(habilita))=0,1,0))"
                + "AS obtreal,tbcomp.year,tbcomp.mes ,tbcomp.area, tbcomp.kpi,tbcomp.subarea FROM       \n"
                + " (SELECT p.nombre,p.apaterno,p.documento,r.mes,r.year,a.idarea AS idarea,a.nombre AS area,k.nombre AS kpi,s.nombre AS subarea, "
                + bigquery
                + " )AS tbcomp GROUP BY tbcomp.documento)AS tbcompfiltrada  "
                + " WHERE "
                + " tbcompfiltrada.year LIKE '%" + year + "%'"
                + " AND tbcompfiltrada.mes LIKE '%" + mes + "%'"
                + " AND tbcompfiltrada.area LIKE '%" + area + "%'"
                + " AND tbcompfiltrada.subarea LIKE '%" + Subarea + "%'"
                + " AND tbcompfiltrada.documento LIKE '%" + Trabajador + "%'"
                + " AND tbcompfiltrada.kpi LIKE '%" + KPI + "%'"
                +sSQL2
                + "GROUP BY tbcompfiltrada.subarea,tbcompfiltrada.mes,tbcompfiltrada.year"
                + " ORDER BY tbcompfiltrada.subarea,tbcompfiltrada.apaterno,tbcompfiltrada.nombre,tbcompfiltrada.kpi,tbcompfiltrada.mes,tbcompfiltrada.year";

        resultobttotal = 0.0;
        try {
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(sSQL3);
            while (rs.next()) {
                registro[1] = rs.getString("tbcompfiltrada.area");
                registro[2] = rs.getString("tbcompfiltrada.subarea");
                registro[3] = "$ " + numberFormat.format(Double.parseDouble(rs.getString("obtsubarea")));
                registro[0] = rs.getString("tbcompfiltrada.year") + " " + rs.getString("tbcompfiltrada.mes");
                modelo.addRow(registro);
                resultobttotal = resultobttotal + Double.parseDouble(rs.getString("obtsubarea"));
            }
            return modelo;
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
            return null;
        }
    }

}
